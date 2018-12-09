<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <jsp:include page="../core/_header.jsp"/>
    <title>添加产品分类</title>
</head>
<body>
<div class="page-container">
    <form method="post" class="form form-horizontal" id="form-user-add" >

        <input type="text" class="input-text" value="${pId}" placeholder="" id="pId" name="parentId" style="display: none">
        <input type="text" class="input-text" value="${id}" placeholder=""  name="id" style="display: none">

        <div class="row cl">
            <c:if test="${pId != null}">
                <label class="form-label col-xs-4 col-sm-8" style="text-align:center">添加二级菜单</label>
                <input type="text" class="input-text" value="T" placeholder=""  name="level" style="display: none">
            </c:if>
            <c:if test="${pId == null}">
                <label class="form-label col-xs-4 col-sm-8" style="text-align:center">添加一级菜单</label>
                <input type="text" class="input-text" value="O" placeholder=""  name="level" style="display: none">
            </c:if>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">
                <span class="c-red">*</span>
                菜单名称：</label>
            <div class="formControls col-xs-6 col-sm-6">
                <input type="text" class="input-text" value="" placeholder="" id="name" name="name">
            </div>
        </div>
        <div class="row cl">
            <c:if test="${pId != null}">
                <label class="form-label col-xs-4 col-sm-2">
                    <span class="c-red">*</span>
                    请求地址：</label>
                <div class="formControls col-xs-6 col-sm-6">
                    <input type="text" class="input-text" value="" placeholder="" id="url" name="url">
                </div>
            </c:if>
        </div>
        <div class="row cl">
            <c:if test="${pId == null}">
                <label class="form-label col-xs-4 col-sm-2">
                    <span class="c-red">*</span>
                    菜单图标：</label>
                <div class="formControls col-xs-6 col-sm-6">
                    <input type="text" class="input-text" value="" placeholder="" id="iconClass" name="iconClass">
                </div>
            </c:if>
        </div>
        <div class="row cl">
            <div class="col-9 col-offset-2">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</div>
<jsp:include page="../core/_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    $(function(){
        $("form").submit(function () {
            if($("#name").val() == ""){
                layer.tips('请输入菜单名称',$("#name"),{
                    tips:[1,'#3595CC'],
                    time: 2000
                });
                $("#name").focus();
                return false;
            }
            if($("#pId").val() == null){
                if($("#iconClass").val() == ""){
                    layer.tips('请输入菜单图标编号',$("#iconClass"),{
                        tips:[1,'#3595CC'],
                        time: 2000
                    });
                    $("#iconClass").focus();
                    return false;
                }
            }
            if($("#pId").val() != null){
                if($("#url").val() == ""){
                    layer.tips('请输入点击菜单时跳转的地址',$("#url"),{
                        tips:[1,'#3595CC'],
                        time: 2000
                    });
                    $("#url").focus();
                    return false;
                }
            }
            $.post('add',$("form").serialize(),function (data) {
                if(data.code == "00"){
                    window.parent.location.href = "${basePath}/menu/addpage";
                }else{
                    layer.msg("添加失败");
                }
            })
            return false;
        })
    });
</script>
</body>
</html>
