<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<!--     <title>代理商列表</title> -->
    <style>
        table{
            width: 100% !important;
        }
    </style>
    <style>
        .margin-10{
            margin-top: 10px
        }
        .ac_results {background:#fff;border:1px solid #7f9db9;position: absolute;z-index: 10000;display: none;}
        .ac_results li a {white-space: nowrap;text-decoration:none;display:block;color:#05a;padding:1px 3px;}
        .ac_results li {border:1px solid #fff;}
        .ac_results li a:hover {background:#c8e3fc;}
        .ac_results li a span {float:right;}
    </style>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 通道管理
    <span class="c-gray en">&gt;</span> 通道列表
    <a class="btn btn-success radius r" id ="btn-refresh"  style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="row cl" style="margin-bottom: 20px;">
        <form action="${basePath}/qr/trade/exportExcel" method="post">
            <div class="col-xs-12 col-sm-12">
                <%--条件查询第一行--%>
                <div class="row cl">
                    <div class="col-sm-3">
                        <input type="text" name="channelNo" placeholder="代理商编号" class="input-text" />
                        <div id="channelNoSuggest" class="ac_results"></div>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="channelName" placeholder="代理商名称" class="input-text" />
                        <div id="channelNameSuggest" class="ac_results"></div>
                    </div>
                    <div class="col-sm-3">
                        <span class="select-box" >
                            <select class="select" name="subProductCode" size="1">
                                <option value="00" selected>产品列表</option>
                                <c:forEach var="p" items="${ProductList}">
                                    <option value="${p.subProductCode}">${p.productName}</option>
                                </c:forEach>
                            </select>
                        </span>
                    </div>
                    <div class="col-sm-3" >
                        <span class="select-box">
                            <select class="select" name="platformCode" size="1">
                                <option value="0" selected>上游平台</option>
                                <c:forEach var="p" items="${PlatformList}">
                                    <option value="${p.code}">${p.name}</option>
                                </c:forEach>
                            </select>
                        </span>
                    </div>
                </div>
                <%--条件查询第三行--%>
                <div class="row cl margin-10">
                    <div class="col-sm-12 text-c">
                        <button class="btn btn-success" style="height: 27px;padding: 0px 12px;border-radius: 4px;" type="button" onclick="search()"><i class="Hui-iconfont"></i> 查询</button>
                    </div>
                </div>
            </div>

        </form>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
        <a href="javascript:;" onclick="admin_add('添加通道','${basePath}/product/route/addpage','800','500')" class="btn btn-primary radius">
        <i class="Hui-iconfont">&#xe600;</i> 添加通道
        </a>
        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th>通道名称</th>
            <th>通道编码</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>

<jsp:include page="../core/_footer.jsp"/>

<script type="text/javascript" src="${basePath}/plugin/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/plugin/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${basePath}/plugin/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${basePath}/plugin/suggest/suggest.js"></script>
<script type="text/javascript">

    // 对Date的扩展，将 Date 转化为指定格式的String
    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "H+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }

    var t = $(".table-bg").dataTable({
        "ordering":false,//总开关，禁止排序
        "bFilter":false, //过滤功能
        "processing": true,
        "bStateSave": true,//状态保存
        "serverSide": true,
        "bLengthChange": false,
        "columns": [
            {"data":"plantfromName"},
            {"data":"platformCode"},
            {"data":"createDate"},
            {"data":"doMore"},
        ],
        "createdRow": function( row, data, dataIndex ) {
            $(row).children('td').attr('style', 'text-align:center;')
        },
        "ajax": {
            "url": "${basePath}/product/route/listdata",
            "type": "POST",
            "data": function (d) {
                d.channelNo = $("input[name='channelNo']").val();
                d.channelName = $("input[name='channelName']").val();
                d.subProductCode = $("select[name='subProductCode']").val();
                d.platformCode = $("select[name='platformCode']").val();
            },
            "dataSrc": function (data) {
                var dataArr = data.data;
                var html = $("#doMore").html();
                for (var i = 0; i < dataArr.length; i++) {
                    var replaceHtml = html;
                    dataArr[i].createDate = new Date(dataArr[i].createDate).Format("yyyy-MM-dd HH:mm:ss");
                    replaceHtml = replaceHtml.replace("{ID}",dataArr[i].platformCode);
                    dataArr[i].doMore = replaceHtml;
                }
                return dataArr;
            }
        }
    })
    function search(){
        t.fnDraw();
    }
</script>
<script type="text/html" id="doMore">
    <a title="修改通道" href="javascript:;" onclick="admin_edit('修改通道','${basePath}/platform/product/update','{ID}','800','500')" class="ml-5" style="text-decoration:none">
        <i class="Hui-iconfont">&#xe6df;</i>
    </a>
</script>
<script type="text/javascript">
    /*
     参数解释：
     title	标题
     url		请求的url
     id		需要操作的数据id
     w		弹出层宽度（缺省调默认值）
     h		弹出层高度（缺省调默认值）
     */
    /*管理员-编辑*/
    function admin_edit(title, url,id, w, h) {
        layer_show(title, url+"?id="+id, w, h);
    }

    /*管理员-编辑*/
    function admin_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

</script>
<%--模糊搜索相关--%>
<%--代理商名称--%>
<script type="text/javascript">
    $(function () {
        LoadChannel();
    })
    LoadChannel = function () {
        $.post('${basePath}/channel/alldata',{},function (data) {
            if(data.length == 1){
                $("input[name=channelNo]").val(data[0].channelNo);
                $("input[name=channelNo]").attr('readonly','readonly');
                $("input[name=channelName]").val(data[0].name);
                $("input[name=channelName]").attr('readonly','readonly');
            }else{
                var channelName = new Array();
                for(var i = 0;i < data.length;i++){
                    channelName[i] = new Array();
                    channelName[i][0] = data[i].channelNo;
                    channelName[i][1] = data[i].name;
                }
                $("input[name=channelName]").suggest(channelName,{attachObject:"#channelNameSuggest"});
                var channelNo = new Array();
                for(var i = 0;i < data.length;i++){
                    channelNo[i] = new Array();
                    channelNo[i][0] = data[i].name;
                    channelNo[i][1] = data[i].channelNo;
                }
                $("input[name=channelNo]").suggest(channelNo,{attachObject:"#channelNoSuggest"});
            }
        })
    }
</script>
</body>
</html>
