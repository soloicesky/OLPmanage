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
    <link href="${basePath}/plugin/typeahead/jquery.typeahead.css">
    <title>选择代理商</title>
</head>
<body>
<form id="RedirectFrom">
    <input type="text" name="channelNo" style="display: none"/>
    <div class="row cl">
        <div class="col-sm-4 text-c" style="margin-top: 20px">
            <input type="text" name="channelNo" placeholder="" class="input-text" style="width: 60%;display: none" />
        </div>
        <div class="col-sm-4 text-c">
            <input type="text" name="channelName" placeholder="代理商名称" class="input-text" style="width: 60%" />
            <div id="channelNameSuggest" class="ac_results"></div>
        </div>
        <div class="col-sm-4 text-c">
        </div>
    </div>
</form>
<jsp:include page="../core/_footer.jsp"/>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/plugin/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${basePath}/plugin/suggest/suggest.js"></script>
<script type="text/javascript">
    $(function () {
        LoadChannel();
    })
    LoadChannel = function () {
        $.post('${basePath}/channel/alldata', {}, function (data) {
                var channelName = new Array();
                for (var i = 0; i < data.length; i++) {
                    channelName[i] = new Array();
                    channelName[i][0] = data[i].channelNo;
                    channelName[i][1] = data[i].name;
                }
                $("input[name=channelName]").suggest(channelName,{
                    attachObject:"#channelNameSuggest",
                    dataContainer:"input[name=channelNo]"
                });
        })
    }

    ShowTips = function () {
        layer.tips('请输入关键字选择需要开通产品的渠道商！',$('input[name=channelName]'),{
            tips: [1, '#3595CC'],
            time: 2000
        })
    }
</script>
</body>
</html>
