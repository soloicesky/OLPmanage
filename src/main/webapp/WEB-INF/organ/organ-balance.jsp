<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<c:set var="curUser" value="${sessionScope.SESSION_LOGIN_KEY}"/>
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
    <title>添加菜单</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 商户管理
    <span class="c-gray en">&gt;</span> 机构账户余额
    <a class="btn btn-success radius r" id ="btn-refresh"  style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <c:if test="${curUser.roleType eq '0'}">
        <div class="text-c">

        </div>
    </c:if>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th>所属机构</th>
            <th>账户余额</th>
            <th>可用余额</th>
            <th>提现余额</th>
            <th>冻结余额</th>
            <th>状态</th>
            <th>更新时间</th>
            <th>备注</th>
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

<script type="text/javascript">

    Date.prototype.Format = function (fmt) {
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

    $(".table-bg").dataTable({
        "ordering":false,//总开关，禁止排序
        "bFilter":false, //过滤功能
        "processing": true,
        "bStateSave": true,//状态保存
        "serverSide": true,
        "bLengthChange": false,
        "columns": [
            {"data":"organ_id"},
            {"data":"totalAmount"},
            {"data":"useAmount"},
            {"data":"drawAmount"},
            {"data":"freezeAmount"},
            {"data":"status"},
            {"data":"update_date"},
            {"data":"remarks"},
            {"data":"doMore","className":"td-manage"}
        ],
        "createdRow": function( row, data, dataIndex ) {
            $(row).children('td').attr('style', 'text-align:center;')
        },
        "ajax": {
            "url": "${basePath}/organAccount/listBalanceData",
            "type": "POST",
            "data": function (d) {
                // d.beginTime = $("input[id='datemin']").val();
                // d.endTime = $("input[id='datemax']").val();
                // d.organ_id = $("input[name='nickName']").val();
            },
            "dataSrc": function (data) {
                var dataArr = data.data;
                var html = $("#doMore").html();
                for (var i = 0; i < dataArr.length; i++) {
                    var itemHtml = html;

                    //'状态 0:正常 1:停用 2:冻结',
                    if(dataArr[i].status === 2)
                        dataArr[i].status = '<span class="label label-default radius">已冻结</span>';
                    else if(dataArr[i].status === 1)
                        dataArr[i].status = '<span class="label label-default radius">已停用</span>';
                    else if(dataArr[i].status === 0)
                        dataArr[i].status = '<span class="label label-success radius">正常</span>';

                    dataArr[i]['doMore']= itemHtml;

                    var dateVal = new Date(dataArr[i].update_date);
                    dataArr[i].update_date = dateVal.Format("yyyy-MM-dd HH:mm:ss");
                    // dataArr[i].nickName = "<a href='javascript:void(0);' onclick='showDetail(\"" + dataArr[i].id +  "\")' >" + dataArr[i].nickName + "</a>";
                }
                return dataArr;
            }
        }
    });
</script>
<script type="text/html" id="doMore">
    <a href="javascript:;" style="color:blue;" >提现</a>
    <c:if test="${curUser.roleType eq '0'}">
        <a href="javascript:;" style="color:blue;" >差错</a>
        <a href="javascript:;" style="color:blue;" >冻结</a>
    </c:if>
</script>

</body>
</html>
