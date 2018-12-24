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
    <link rel="stylesheet" href="${basePath}/plugin/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <title>添加管理员</title>
</head>
<body>
<article class="page-container">
    <form class="form form-horizontal" id="form-admin-power">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">
                <span class="c-red">*</span>
                <c:choose>
                    <c:when test="${isOrgan}">
                        机构商户名称：
                        <input type="hidden" value="7" name="roleType" />
                    </c:when>
                    <c:otherwise>管理员名称：</c:otherwise>
                </c:choose>
            </label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${IdUser.nickName}" readonly id="nickName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">角色权限：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <c:forEach items="${Menu.oneLevelMenu}" var="menuo">
                    <dl class="permission-list">
                        <dt>
                            <label>
                                <c:if test="${menuo.isDel eq 'T'}">
                                    <input type="checkbox" value="${menuo.id}" checked="checked" name="menuIdList" id="user-Character-0">
                                </c:if>
                                <c:if test="${menuo.isDel eq 'F'}">
                                    <input type="checkbox" value="${menuo.id}" name="menuIdList" id="user-Character-0">
                                </c:if>
                                ${menuo.name}
                            </label>
                        </dt>
                        <dd>
                            <dl class="cl permission-list2">
                            <c:forEach items="${Menu.twoLevelMenu}" var="menut">
                                <c:if test="${menuo.id == menut.parentId}">
                                    <dt>
                                        <label class="">
                                            <c:if test="${menut.isDel eq 'T'}">
                                                <input type="checkbox" value="${menut.id}" checked="checked" name="menuIdList" id="user-Character-0-0">
                                            </c:if>
                                            <c:if test="${menut.isDel eq 'F'}">
                                                <input type="checkbox" value="${menut.id}" name="menuIdList" id="user-Character-0-0">
                                            </c:if>
                                                ${menut.name}
                                        </label>
                                    </dt>
                                </c:if>
                            </c:forEach>
                            </dl>
                        </dd>
                    </dl>
                </c:forEach>
            </div>
        </div>

        <input hidden value="${IdUser.id}" name="id">
        <input hidden value="${IdUser.dataVersion}" name="dataVersion">
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<jsp:include page="../core/_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/messages_zh.js"></script>

<%--菜单列表--%>

<script type="text/javascript">
    $(function(){
        $('#form-admin-power').submit(function () {
           var size = $("input[name=menuIdList]:checked").size();
           if(size == 0){
               layer.msg("请点击复选框选择角色权限");
               return false;
           }
           $.post('power/edit',$(this).serialize(),function(data){
                if(data.code == "00"){

                    var index = parent.layer.getFrameIndex(window.name);
                    parent.$("#btn-refresh").click();
                    parent.layer.close(index);
                }else{
                    layer.msg(data.msg);
                }
           })
           return false;
        })
    });
</script>
<%--菜单列表--%>
<script type="text/javascript">
    $(function(){
        $(".permission-list dt input:checkbox").click(function(){
            $(this).closest("dl").find("dd input:checkbox").prop("checked",$(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function(){
            var l =$(this).parent().parent().find("input:checked").length;
            var l2=$(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if($(this).prop("checked")){
                $(this).closest("dl").find("dt input:checkbox").prop("checked",true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",true);
            }
            else{
                if(l==0){
                    $(this).closest("dl").find("dt input:checkbox").prop("checked",false);
                }
                if(l2==0){
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked",false);
                }
            }
        });
    });
</script>

<!--/请在上方写此页面业务相关的脚本-->

</body>
</html>
