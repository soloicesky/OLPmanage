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
    <title>代理商列表</title>
    <style>
        table{
            width: 100% !important;
        }
    </style>
</head>
<body>
<!-- <nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 通道管理
    <span class="c-gray en">&gt;</span> 通道列表
    <a class="btn btn-success radius r" id ="btn-refresh"  style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav> -->
<!-- <div class="page-container">
    <div class="text-c"> 日期范围：
        <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
               class="input-text Wdate" style="width:120px;">
        -
        <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax"
               class="input-text Wdate" style="width:120px;">
        <input type="text" class="input-text" style="width:250px" placeholder="输入产品名称" id="nickName" name="nickName">
        <button type="submit" class="btn btn-success" onclick="search()"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
    </div> -->
<div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
        <a href="javascript:;" onclick="admin_edit('添加通道','${basePath}/product/route/addRoadPage','${subProductCode}','1000','500')" class="btn btn-primary radius">
        <i class="Hui-iconfont">&#xe600;</i> 添加通道
        </a>
         </span>
</div>
<table class="table table-border table-bordered table-bg">
    <thead>
    <tr class="text-c">
        <th>通道名称</th>
        <th>D0费率</th>
        <th>D0单笔固定手续费</th>
        <th>D0开始时间</th>
        <th>D0结束时间</th>
        <th>T1费率</th>
        <th>单笔最高限额</th>
        <th>单笔最低限额</th>
        <th>优先级</th>
        <th>通道状态</th>
        <th>通道创建时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="p" items="${data}">
        <tr class="text-c">
        <th>${p.platformName}</th>
        <th>${p.t0Rate}</th>
        <th>${p.fixT0Fee/100}元</th>
        <th>${p.t0BegTime}</th>
        <th>${p.t0EndTime}</th>
<%--         <th>${p.t0MinAmt/100}元</th> --%>
        <th>${p.t1Rate}</th>
            <%--<th>${p.fixT1Fee}</th>--%>
        <th>${p.maxAmt/100}元</th>
        <th>${p.minAmt/100}元</th>
        <th>${p.priority}</th>
        <c:if test="${p.enabled}">
        <th>启用</th>
        </c:if>
            <c:if test="${!p.enabled}">
            <th>禁用</th>
		</c:if>
        <th>${p.dateString}</th>
        <th><a title="修改" href="javascript:;" onclick="admin_edit1('通道管理','${basePath}/product/route/editRoad','${p.platformId}','${subProductCode}','1000','500')" class="ml-5" style="text-decoration:none">
        <i class="Hui-iconfont">&#xe6df;</i>
   		 </a>
  		  </th>
            <%--<th>${p.platformName}</th>--%>
        </tr>
    </c:forEach>


    </tbody>
</table>
</div>
<jsp:include page="../core/_footer.jsp"/>

<script type="text/javascript" src="${basePath}/plugin/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/plugin/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${basePath}/plugin/laypage/1.2/laypage.js"></script>
<script type="text/javascript">

</script>
<%--<script type="text/html" id="doMore">--%>
<%--<a title="修改" href="javascript:;" onclick="admin_edit('修改','${basePath}/product/addpage','{ID}','800','500')" class="ml-5" style="text-decoration:none">--%>
<%--<i class="Hui-iconfont">&#xe6df;</i>--%>
<%--</a>--%>
<%--</script>--%>
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
    /*
     参数解释：
     title	标题
     url		请求的url
     id		需要操作的数据id
     w		弹出层宽度（缺省调默认值）
     h		弹出层高度（缺省调默认值）
     */
    /*管理员-编辑*/
    function admin_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }
    function admin_edit(title, url,id, w, h) {
        layer_showcancallback(title, url+"?id="+id, w, h,function () {
            location.replace(location.href);
        });
    }
    function admin_edit1(title, url,platformName,id, w, h) {
        layer_showcancallback(title, url+"?id="+id+"&platformName="+platformName, w, h,function () {
            location.replace(location.href);
        });
    }
    /*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
    function layer_showcancallback(title,url,w,h,y){
        if (title == null || title == '') {
            title=false;
        };
        if (url == null || url == '') {
            url="404.html";
        };
        if (w == null || w == '') {
            w=800;
        };
        if (h == null || h == '') {
            h=($(window).height() - 50);
        };
        layer.open({
            type: 2,
            area: [w+'px', h +'px'],
            fix: false, //不固定
            maxmin: true,
            shade:0.4,
            title: title,
            content: url,
            end:function () {
                location.reload();
            }
        });
    }
</script>
</body>
</html>
