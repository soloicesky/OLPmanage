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
    <title>添加菜单</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统设置 <span
        class="c-gray en">&gt;</span> 添加菜单 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<table class="table">
    <tr>
        <td width="200" class="va-t">
            <ul id="treeDemo" class="ztree"></ul>
        </td>
        <td class="va-t">
            <iframe ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100% height=390px></iframe>
        </td>
    </tr>
</table>
<jsp:include page="../core/_footer.jsp"/>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/plugin/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
            beforeClick: function (treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree");
                console.log(treeNode.id);
                if(treeNode.id == "1101"){
                    demoIframe.attr("src", "editpage?id="+treeNode.id);
                } else if(treeNode.id == "1102"){
                    demoIframe.attr("src", "editpage?pId="+treeNode.pId+"&id="+treeNode.id);
                }else {
                    demoIframe.attr("src", "");
                }
            }
        }
    };

    var code;

    function showCode(str) {
        if (!code) code = $("#code");
        code.empty();
        code.append("<li>" + str + "</li>");
    }

    $(document).ready(function () {

        $.ajax({
            type:'get',
            url:'list',
            dataType:'json',
            success:function (data) {
                if(data.code == "00"){
                    var t = $("#treeDemo");
                    t = $.fn.zTree.init(t, setting, data.data);
                    demoIframe = $("#testIframe");
                    //demoIframe.on("load", loadReady);
                    var zTree = $.fn.zTree.getZTreeObj("tree");
                    //zTree.selectNode(zTree.getNodeByParam("id",'11'));
                }else{
                    layer.msg(data.msg);
                }

            }
        })


    });
</script>
</body>
</html>
