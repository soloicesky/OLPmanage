<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <jsp:include page="../core/_header.jsp"/>
    <title>添加代理商</title>
</head>
<body>
<div class="page-container">
    <input value="${ChannelNo}" name="channelNo" style="display: none">
    <div class="row cl">
        <div class="formControls col-sm-12">
            <c:forEach var="p" items="${ProductList}">
                <form action="" method="post" class="form form-horizontal" id="${p.id}">
                    <input value="${p.subProductCode}" name="subProductCode" style="display: none">
                    <input value="" name="channelId" style="display: none">
                    <dl class="permission-list" id="dl${p.id}">
                        <dt>
                            <label>
                                <input type="checkbox" value="${p.id}" name="productId" id="user-Character-0" data="${p.productName}">
                                    ${p.productName}
                            </label>
                        </dt>
                        <dd>
                            <div class="row cl">
                                <div class="col-sm-3">
                                </div>
                                <div class="col-sm-3">
                                    <span class="select-box">
                                        <select class="select" name="platformCode" size="1" data-subProductCode = "${p.subProductCode}" >
                                            <option value="0" selected>上游平台</option>
                                        </select>
                                    </span>
                                </div>
                                <div class="col-sm-3">

                                </div>
                            </div>
                        </dd>
                    </dl>
                </form>
            </c:forEach>
        </div>
    </div>
    <div class="row cl">
        <div class="col-sm-12 text-c">
            <input class="btn btn-primary radius" type="submit" onclick="CheckForm()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
        </div>
    </div>
</div>

<jsp:include page="../core/_footer.jsp"/>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/plugin/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${basePath}/plugin/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/html" id="AddChannelConfigHTML">
    <label class="form-label col-xs-4 col-sm-2"></label>
    <div class="formControls col-xs-8 col-sm-9" style="margin-top: 10px" JsonConfig>
        <input type="text" class="input-text" value="" placeholder="JsonKey" name="key" style="width:25%">
        =
        <input type="text" class="input-text" value="" placeholder="JsonVal" name="val" style="width:25%">
    </div>
</script>
<script type="text/javascript">
    $(function () {
        //检查渠道号是否存在
        var channelNo = $("input[name=channelNo]").val();
        if(channelNo == null || channelNo == ""){
            LoadChannelProduct();
        }else{
            RmoveNoRouteFixForm(channelNo);
        }

    })
    //选择渠道
    LoadChannelProduct =  function () {
        var channelNo = $("input[name=channelNo]").val();
        if(channelNo == null || channelNo ===""){
            layer.ready(function () {
                layer.open({
                    id:"ChoooseChannelNo",
                    type:2,
                    title:'产品路由-选择渠道商',
                    area: [600+'px', 250 +'px'],
                    shade:0.4,
                    closeBtn:0,
                    content:'${basePath}/channel/choose',
                    btnAlign:'c',
                    btn:'确定',
                    yes:function (index,layero) {
                        var childFrame = layer.getChildFrame('body',index);
                        var channelNo = childFrame.find('input[name=channelNo]').val();
                        if(channelNo == null || channelNo == ""){
                            var frameId=document.getElementById('ChoooseChannelNo').getElementsByTagName("iframe")[0].id;
                            $('#'+frameId)[0].contentWindow.ShowTips();
                            return false;
                        }
                        $("input[name=channelNo]").val(channelNo);
                        RmoveNoRouteFixForm(channelNo);
                        layer.close(index);
                    }
                })
            })
        }
    }

    RmoveNoRouteFixForm = function (channelNo) {
        //加载已路由的产品
        $.post('${basePath}/product/route/checkroutefix',{channelNo:channelNo},function (data) {
            if(data.code == "00"){
                $.each(data.listdata,function (index,item) {
                    var $Form = $("form[id="+item.productId+"]");
                    if($Form){
                        RemoveForm($Form);
                    }
                })
            }
        })
        //加载已开通的产品
        $.post('${basePath}/channel/product/selectopen',{channelNo:channelNo},function (data) {
            $.each(data,function (index,item) {
                var $Form = $("form[id="+item.productId+"]");
                if($Form) {
                    $Form.find("input[name=productId]").attr("checked",true);
                    $Form.find("input[name=channelId]").val(item.channelId);
                }
            })
            $("form").find("input[name=productId]").not("input:checked").each(function () {
                var $Form = $(this).closest("form");
                RemoveForm($Form)
            })
            //加载通道选项
            $("form").each(function () {
                $.post('${basePath}/product/route/selectchannel',{subProductCode:$(this).find("input[name=subProductCode]").val()},function (data) {
                    var $platformCode = $("form").find("select[data-subProductCode="+data.subProductCode+"]");
                    LoadSelectOption($platformCode,data.data);
                })
            })
        })
        //
    }

    LoadSelectOption = function ($Select,data) {
        var selectOptionHtml = $("#SelectOption").html();
        data = $.parseJSON(data);
        $.each(data,function (index,item) {
            var showHtml = selectOptionHtml
            showHtml = showHtml.replace("#{platformCode}",item.platformCode)
                .replace("#{platformId}",item.platformId).replace("#{platformName}",item.platformName);
            $Select.append(showHtml);
        })
    }

    RemoveForm = function ($Form) {
        $Form.remove();
        if($("form").length == 0){
            layer.msg("所有已开通产品均已选择路由通道，如需修改请在列表页选择修改！",{icon:2,time:4000},function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            })

        }
    }

    CheckForm = function () {
        var len = $("form").length;
        $("form").each(function (index) {
            var $productId = $(this).find("input[name=productId]");
            var $select = $(this).find("select");
            if($productId.attr("checked") && $select.val() != "0"){
                var data = $(this).serialize();
                data = data + "&channelNo=" + $("input[name=channelNo]").val();
                data = data + "&platformId=" + $select.find("option:selected").attr("data-paltformId");
                $.post('${basePath}/product/route/add',data,function (data) {
                    if(data.code != "00") {
                        var attr = $("input[value="+data.data+"]").attr("data");
                        layer.msg("产品【"+attr+"】数据提交失败请重新操作！")
                    }else{
                        if(index == len-1){
                            layer.msg("添加成功！",{icon:1,time:1000},function () {
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                            })
                        }

                    }
                })
            }else{
                layer.msg("请确认是否选择产品或是否选择通道！")
            }
        })
    }
</script>
<script type="text/html" id="SelectOption">
<option value="#{platformCode}" data-paltformId = "#{platformId}">#{platformName}</option>
</script>
</body>
</html>
