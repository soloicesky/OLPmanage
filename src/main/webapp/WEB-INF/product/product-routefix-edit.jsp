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
    <form action="" method="post" class="form form-horizontal" id="form-article-add">
        <input value="${ProductRouteFix.version}" name="version" style="display: none">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>产品名称：</label>
            <div class="formControls col-xs-8 col-sm-8">
                <input type="text" class="input-text" value="${ProductRouteFix.productName}" name="productName" id="productName" readonly="readonly">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>产品子编码：</label>
            <div class="formControls col-xs-8 col-sm-8">
                <input type="text" class="input-text" value="${ProductRouteFix.subProductCode}" name="subProductCode" id="subProductCode" readonly="readonly">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>选择上游通道：</label>
            <div class="formControls col-xs-8 col-sm-4">
                <span class="select-box">
                    <select class="select" name="platformCode" size="1">
                        <option value="0" selected>上游平台</option>
                        <c:forEach var="p" items="${PlatformProduct}">
                            <c:if test="${ProductRouteFix.platformCode != p.platformCode}">
                                <option value="${p.id}" data-platformCode = "${p.platformCode}" data-id = "${ProductRouteFix.id}">${p.platformName}</option>
                            </c:if>
                        </c:forEach>
                    </select>
                </span>
            </div>
        </div>
        <div class="row cl">
            <div class="col-sm-12 text-c">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;修改&nbsp;&nbsp;">
            </div>
        </div>
    </form>
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
//        $("#AddConfigBTN").click(function () {
//            AddChannelConfig();
//        })

        $("#form-article-add").validate({
            rules:{
                platformCode:{
                    required:true
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                var url = '${basePath}/product/route/edit'
                var $SelectPlatform = $("select[name=platformCode]");
                if($SelectPlatform.val() == "0") {
                    layer.tips("请选择一个路由通道！", $SelectPlatform, {
                        tips: [1, '#3595CC'],
                        time: 2000
                    })
                }else{
                    $.post(url,{version:$("input[name=version]").val(),platformId:$SelectPlatform.val(),platformCode:$SelectPlatform.find("option:selected").attr("data-platformCode"),id:$SelectPlatform.find("option:selected").attr("data-id")},function (data) {
                        if(data.code == "00"){
                            layer.msg('添加成功!',{icon:1,time:1000},function () {
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                            });
                        }else{
                            layer.msg('添加失败!',{icon:2,time:1000});
                        }
                    })
                }
            }
        })

    })

    AddChannelConfig = function () {
        var html = $("#AddChannelConfigHTML").html();
        $("#ChannelConfig").append(html);
        $("#ChannelConfig > div:last").append($("#AddConfigBTN"));
    }
</script>
</body>
</html>
