<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}" scope="page" />
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
    <jsp:include page="../core/_header.jsp" flush="true"/>
    <title>运营管理平台</title>
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="#">运营管理平台</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>

            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>${SESSION_LOGIN_KEY.nickName}</li>
                    <li class="dropDown dropDown_hover">
                        <a href="#" class="dropDown_A">${SESSION_LOGIN_KEY.loginName} <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" onClick="updatePwd()">修改密码</a></li>
                            <li><a href="${basePath}/logout" id="logout">切换账户</a></li>
                            <li><a href="${basePath}/logout">退出</a></li>
                        </ul>
                    </li>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                            <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <c:if test="${MenuMap!= null && MenuMap.oneLevelMenu != null}">
            <c:forEach var="o" items="${MenuMap.oneLevelMenu}">
                <dl id="${o.iconClass}">
                    <dt><i class="Hui-iconfont">${o.iconClass}</i> ${o.name}<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
                    <c:if test="${MenuMap.twoLevelMenu != null}">
                        <dd>
                            <ul>
                            <c:forEach items="${MenuMap.twoLevelMenu}" var="t">
                                <c:if test="${t.parentId == o.id}">
                                    <li><a data-href="${t.url}" data-title="${t.name}" href="javascript:void(0)">${t.name}</a></li>
                                </c:if>
                            </c:forEach>
                            </ul>
                        </dd>
                    </c:if>
                </dl>
            </c:forEach>
        </c:if>
    </div>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的桌面" data-href="welcome.html">我的桌面</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src=""></iframe>
        </div>
    </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前 </li>
        <li id="closeall">关闭全部 </li>
    </ul>
</div>
<jsp:include page="../core/_footer.jsp" />

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/plugin/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/messages_zh.js"></script>

<script type="text/html" id="updatepwd">
    <form class="form form-horizontal" id="form-admin-add">
        <input name="id" value="${SESSION_LOGIN_KEY.id}" style="display: none">
        <input name="dataVersion" value="${SESSION_LOGIN_KEY.dataVersion}" style="display: none">
    <div class="row cl" style="margin-right: 0px !important;">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>初始密码：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <input type="password" class="input-text" autocomplete="off" value="" placeholder="初始密码" id="loginPwd3" name="loginPwd3">
        </div>
    </div>
    <div class="row cl" style="margin-right: 0px !important;">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>新密码：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <input type="password" class="input-text" autocomplete="off" value="" placeholder="新密码" id="loginPwd" name="loginPwd">
        </div>
    </div>
    <div class="row cl" style="margin-right: 0px !important;">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>确认密码：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <input type="password" class="input-text" autocomplete="off"  placeholder="确认新密码" id="loginPwd2" name="loginPwd2">
        </div>
    </div>
    </form>
</script>
<script type="text/javascript">
    $(function(){

    });
    /*个人信息*/
    function updatePwd(){
        layer.open({
            type: 1,
            area: ['700px','400px'],
            fix: true, //不固定
            maxmin: true,
            shade:0.4,
            title: '修改密码',
            content: $("#updatepwd").html(),
            btn:'提交',
            yes:function (index,layero) {
                $("#form-admin-add").submit();
            },
            success:function (layero, index) {
                $("#form-admin-add").validate({
                    rules:{
                        loginPwd3:{
                            required:true,
                            remote:{
                                url:'${basePath}/admin/user/check',
                                type:'post',
                                dataType:'json',
                                data:{
                                    loginPwd:function () {
                                        return $("#loginPwd3").val();
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
                            equalTo: "#loginPwd"
                        }
                    },
                    onkeyup:false,
                    focusCleanup:true,
                    success:"valid",
                    submitHandler:function(form){
                        var url = '${basePath}/admin/user/update';
                        $(form).ajaxSubmit({
                            type: 'post',
                            url: url ,
                            success: function(data){
                                layer.msg('修改成功!',{icon:1,time:1000});
                                layer.close(index);
                                window.top.location.href="${basePath}/logout";
                            },
                            error: function(XmlHttpRequest, textStatus, errorThrown){
                                layer.msg('error!',{icon:2,time:1000});
                            }
                        });

                    }
                })
            }
        });
    }

    /*资讯-添加*/
    function article_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*图片-添加*/
    function picture_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*产品-添加*/
    function product_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }


</script>
</body>
</html>
