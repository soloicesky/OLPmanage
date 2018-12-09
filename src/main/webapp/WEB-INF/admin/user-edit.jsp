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
    <form class="form form-horizontal" action = "${Url}" id="form-admin-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>管理员名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${IdUser.nickName}" id="nickName" name="nickName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>邮箱(登录账号)：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="@" name="loginName" id="loginName"
                <c:if test="${IdUser != null}">
                       value="${IdUser.loginName}"
                </c:if>
                >
            </div>
        </div>
        <c:if test="${IdUser == null}">
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>初始密码：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="password" class="input-text" autocomplete="off" value="" placeholder="密码" id="loginPwd" name="loginPwd">
                </div>
            </div>
            <div class="row cl">
                <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
                <div class="formControls col-xs-8 col-sm-9">
                    <input type="password" class="input-text" autocomplete="off"  placeholder="确认新密码" id="loginPwd2" name="loginPwd2">
                </div>
            </div>
        </c:if>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>手机：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text"
                <c:if test="${IdUser != null}">
                       value="${IdUser.phone}"
                </c:if>
                       placeholder="" id="phone" name="phone">
            </div>
        </div>
        <c:if test="${IdUser != null}">
            <input hidden value="${IdUser.id}" name="id">
            <input hidden value="${IdUser.dataVersion}" name="dataVersion">
        </c:if>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<jsp:include page="../core/_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/plugin/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${basePath}/plugin/webuploader/0.1.5/webuploader.min.js"></script>

<%--菜单列表--%>

<script type="text/javascript">
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-admin-add").validate({
            rules:{
                nickName:{
                    required:true,
                    minlength:3,
                    maxlength:16,
                    remote:{
                        url:'check',
                        type:'post',
                        dataType:'json',
                        data:{
                            nickName:function () {
                                return $("#nickName").val();
                            },
                            id:function () {
                                if(${IdUser != null}){
                                   return ${IdUser.id};
                                }else{
                                    return "-1";
                                }
                            }
                        }
                    }
                },
                loginPwd:{
                    required:true,
                },
                loginPwd2:{
                    required:true,
                    equalTo: "#loginPwd",
                },
                phone:{
                    required:true,
                    isPhone:true,
                },
                loginName:{
                    required:true,
                    email:true,
                    remote:{
                        url:'check',
                        type:'post',
                        dataType:'json',
                        data:{
                            loginName:function () {
                                return $("#loginName").val();
                            },
                            id:function () {
                                if(${IdUser != null}){
                                    return ${IdUser.id};
                                }else{
                                    return "-1";
                                }
                            }
                        }
                    }
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
            	 var url = 'add';
                 if('${IdUser}' != ''){
                     url = "update";
                 }
                $(form).ajaxSubmit({
                    type: 'post',
                    url: url ,
                    success: function(data){
                    	if(url=="add"){
                            if(data.code == "00"){
                               layer.msg('添加成功!',{icon:1,time:1000},function () {
                                    var index = parent.layer.getFrameIndex(window.name);
                                    window.parent.location.reload(); 
                                    parent.layer.close(index);
                               });
                            }else{
                                layer.msg('添加失败!',{icon:2,time:1000});
                            }
                        	}
                    	if(url=="update"){
                            if(data.code == "00"){
                               layer.msg('修改成功!',{icon:1,time:1000},function () {
                                    var index = parent.layer.getFrameIndex(window.name);
                                    window.parent.location.reload(); 
                                    parent.layer.close(index);
                               });
                            }else{
                                layer.msg('修改失败!',{icon:2,time:1000});
                            }
                        	}
                        	
                    },
                    error: function(XmlHttpRequest, textStatus, errorThrown){
                        layer.msg('error!',{icon:1,time:1000});
                    }
                });

            }
        })

    })
    
           /*  onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                var url = 'add';
                if('${IdUser}' != ''){
                    url = "update";
                }

                $(form).ajaxSubmit({
                    type: 'post',
                    url: url,
                    success: function(data){
                        layer.msg('添加成功!',{icon:1,time:1000});
                    },
                    error: function(XmlHttpRequest, textStatus, errorThrown){
                        layer.msg('error!',{icon:1,time:1000});
                    }
                });
                var index = parent.layer.getFrameIndex(window.name);
                parent.$("#btn-refresh").click();
                parent.layer.close(index);
            }
        });
    }); */
</script>
<!--/请在上方写此页面业务相关的脚本-->

</body>
</html>
