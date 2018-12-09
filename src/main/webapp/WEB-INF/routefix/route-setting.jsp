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
    <title>支付通道设置</title>
</head>
<body>
<div class="page-container">
        <input value="${ChannelNo}" name="channelNo" style="display: none">
        <div class="row cl">
            <div class="formControls col-sm-12">
                <c:forEach var="p" items="${ProductList}">
                    <form action="" method="post" class="form form-horizontal" id="${p.id}">
                        <input value="${p.subProductCode}" name="subProductCode" style="display: none">
                        <input value="${p.productCode}" name="productCode" style="display: none">
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
                                    <input type="text" class="input-text" placeholder="交易手续费" name="fixT0Fee"  value="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="input-text" placeholder="DO费率" name="t0Rate"  value="">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" class="input-text" placeholder="T1费率" name="t1Rate"  value="">
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
            console.log(channelNo);
            LoadHasOpenChannel(channelNo);
        }

    })

    LoadChannelProduct =  function () {
        var channelNo = $("input[name=channelNo]").val();
        if(channelNo == null || channelNo ===""){
            layer.ready(function () {
                layer.open({
                    id:"ChoooseChannelNo",
                    type:2,
                    title:'产品开通-选择渠道商',
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
                        LoadHasOpenChannel(channelNo);
                        layer.close(index);
                    }
                })
            })
        }
    }
    //加载已开通产品
    LoadHasOpenChannel = function (channelNo) {
        $.post('${basePath}/channel/product/selectopen',{channelNo:channelNo},function (data) {
            $.each(data,function (index,iteam) {
                console.log(iteam);
                $("form").each(function () {
                    var $productId = $(this).find("dl input[name=productId]");
                    if($productId.val() == iteam.productId){
                        $productId.attr("checked",true);
                        $productId.attr("disabled","disabled");
                        $(this).find("dd input").each(function () {
                            $(this).attr("readonly","readonly");
                        })
                        $(this).find("dd input[name=fixT0Fee]").val(iteam.fixT0Fee);
                        $(this).find("dd input[name=t0Rate]").val(iteam.t0Rate);
                        $(this).find("dd input[name=t1Rate]").val(iteam.t1Rate);
                    }
                })
            })
        })
    }

    DisableFrom = function (from) {
        var $productId = from.find("dl input[name=productId]");
        $productId.attr("disabled","disabled");
        from.find("dd input").each(function () {
            $(this).attr("readonly","readonly");
        })
    }

    CheckForm = function () {
        $("form").each(function () {
            var isRead = $(this).find("dt input").attr("disabled");
            if(isRead == "disabled") return true;
            var isChecked = $(this).find("dt input").prop("checked");
            if(isChecked){
                var $Form = $(this);
                var $Document = $(this).find("dd input");
                var len  = $Document.length;
                $Document.each(function (i) {
                    var value = $(this).val();
                    if(value == null || value == ""){
                        layer.tips("请输入产品手续费或费率",$(this),{
                            tips: [1, '#3595CC'],
                            time: 2000
                        });
                        $(this).focus();
                        return false;
                    }
                    if(i == len -1){
                        SubmitFrom($Form);
                    }
                })
            }
        })
    }
    
    SubmitFrom = function (from) {
        var data = from.serialize();
        var channelNo = $("input[name=channelNo]").val();
        data = data + "&channelNo=" + channelNo;

        $.post('${basePath}/channel/product/add',data,function (data) {
            if(data.code == "00"){
                var product = from.find("dl input").attr("data");
                DisableFrom(from);
                layer.msg("产品【"+product+"】添加成功！");

            }else{
                layer.msg("产品【"+product+"】添加失败，请稍后再试！");
            }
        })
    }
    
</script>
</body>
</html>
