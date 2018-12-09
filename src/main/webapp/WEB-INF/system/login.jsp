<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${basePath}/static/platform/css/login-soft.css?Aa" rel="stylesheet" type="text/css" />
    <link href="//cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <script src="//cdn.bootcss.com/jquery/2.2.1/jquery.min.js"></script>
    <script src="${basePath}/static/platform/js/jquery.backstretch.min.js" type="text/javascript"></script>
    <script src="//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <title>运营管理平台</title>
    <style type="text/css">
        body {
            font-family: "Microsoft YaHei", "微软雅黑";
        }

        .icon-le {
            top: 0px;
            left: 0;
            color: #aaa
        }

        .btn-login {
            color: #FFFFFF;
            background-color: #91D15C;
            border-color: #91D15C;
        }

        .btn-login:hover, .btn-login:focus, .btn-login:active, .btn-login.active,
        .open .dropdown-toggle.btn-login {
            color: #FFFFFF;
            background-color: #78BD55;
            border-color: #91D15C;
        }

        .btn-login:active, .btn-login.active, .open .dropdown-toggle.btn-login {
            background-image: none;
        }

        .btn-login.disabled, .btn-login[disabled], fieldset[disabled] .btn-login,
        .btn-login.disabled:hover, .btn-login[disabled]:hover, fieldset[disabled] .btn-login:hover,
        .btn-login.disabled:focus, .btn-login[disabled]:focus, fieldset[disabled] .btn-login:focus,
        .btn-login.disabled:active, .btn-login[disabled]:active, fieldset[disabled] .btn-login:active,
        .btn-login.disabled.active, .btn-login[disabled].active, fieldset[disabled] .btn-login.active
        {
            background-color: #91D15C;
            border-color: #91D15C;
        }

        .btn-login .badge {
            color: #91D15C;
            background-color: #FFFFFF;
        }

        .errMsg {
            color: red;
            font-size: 16px;
            margin-left: 20px;
            line-height: 30px;
            height: 30px
        }
    </style>
</head>
<body class="login">
<div class="logo" style="width: 500px; padding-bottom: 50px">
    <%-- 		<img src="${basePath}/admin/script/image/logo.png" alt="" style="width: 200px" /> --%>
</div>
<div class="content" style="width: 350px">
    <h4 style="font-weight: bold; text-align: center; padding-bottom: 12px">用 户 登 录</h4>
    <form>
        <div class="form-group has-feedback" style="margin-bottom: 0px">
            <input type="text" class="form-control" id="name" name="loginName" value="" placeholder="请输入用户名" style="padding: 0 35px; background: #fff">
            <span class="glyphicon glyphicon-user form-control-feedback icon-le" aria-hidden="true"></span>
            <div id="nameMsg" class="errMsg"></div>
        </div>
        <div class="form-group has-feedback" style="margin-bottom: 0px">
            <input type="password" class="form-control" id="psw" name="loginPwd" value=""  placeholder="请输入用户密码" style="padding: 0 35px; background: #fff">
            <span class="glyphicon glyphicon-lock form-control-feedback icon-le" aria-hidden="true"></span>
            <div id="pswMsg" class="errMsg"></div>
        </div>

        <div class="form-group" style="margin-bottom: 0px">
            <input type="text" class="form-control" id="vaditCode" name="vaditCode" placeholder="请输入验证码" style="background: #fff; width: 45%; height: 34px;">
            <div style="margin-left: 50%; width: 50%; height: 34px; margin-top: -34px">
                <img id="validator" src="${basePath}/common/securityCode" style="height: 34px" />
            </div>
            <div style="float: right; margin-top: -18px; margin-right: 30px;">
                <a href='javascript:void(0)' id="codeReflsh" onclick='$("#validator").attr("src","${basePath}/common/securityCode?="+Math.random());'>刷新</a>
            </div>
            <div id="codeMsg" class="errMsg"></div>
        </div>
        <div class="form-group">
            <button type="button" class="btn btn-login" onclick="login()" style="width: 100%; font-size: 16px; font-weight: bold;">登 录</button>
        </div>
    </form>
</div>
<div class="copyright">2018 &copy; 商户后台管理系统.</div>

<script type="text/javascript">

    $(function() {
        $.backstretch([
            "${basePath}/static/platform/images/login-bg.jpg"
        ], {
            fade: 1000,
            duration: 6000
        });
    });

    //回车提交
    document.onkeydown=function(event){
        e = event ? event :(window.event ? window.event : null);
        if(e.keyCode==13){
            login();
        }
    }
    function login() {
        $("form").find(".errMsg").each(function() {
            $(this).html("");

        });

        if ($("#name").val() == "") {
            $("#nameMsg").html("请输入您的登录名！");
            return;
        }
        if ($("#psw").val() == "") {
            $("#pswMsg").html("请输入您的密码！");
            return;
        }

        if ($("#vaditCode").val() == "") {
            $("#codeMsg").html("请输入验证码")
            return;
        }

        $.post("${basePath}/login", $("form").serialize(), function(data) {
            console.log(data);
            if (data.code != '00') {
                $("#codeReflsh").click();
                $("#codeMsg").html(data.msg);
            } else {
                window.parent.location.href = "${basePath}/main";
            }
        });

    }

</script>
</body>
</html>