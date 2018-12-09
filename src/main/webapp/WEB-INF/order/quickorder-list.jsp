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
    <title>订单管理</title>
    <style>
        .margin-10{
            margin-top: 10px
        }

        #suggest {
            width:200px;
        }
        .ac_results {background:#fff;border:1px solid #7f9db9;position: absolute;z-index: 10000;display: none;}
        .ac_results li a {white-space: nowrap;text-decoration:none;display:block;color:#05a;padding:1px 3px;}
        .ac_results li {border:1px solid #fff;}
        .ac_results li a:hover {background:#c8e3fc;}
        .ac_results li a span {float:right;}
    </style>
</head>
<body class="pos-r">
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 订单管理 <span
        class="c-gray en">&gt;</span> 快捷支付订单列表
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="row cl" style="margin-bottom: 20px;">
        <form action="${basePath}/quick/trade/exportExcel" method="post" type="application/vnd.ms-excel">
            <div class="col-xs-12 col-sm-12">
                <%--条件查询第一行--%>
                <div class="row cl">
                    <div class="col-sm-3">
                         <input type="text" name="channelNo" placeholder="代理商编号" id="channelNo" class="input-text" />
                        <div id="channelNoSuggest" class="ac_results"></div>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="channelName" placeholder="代理商名称" class="input-text" />
                        <div id="channelNameSuggest" class="ac_results"></div>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="merchantNo" placeholder="商户编号" class="input-text" />
                        <div id="merchantNoSuggest" class="ac_results"></div>
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="merchantName" placeholder="商户名称" class="input-text" />
                        <div id="merchantNameSuggest" class="ac_results"></div>
                    </div>
                </div>
                <%--条件查询第二行    --%>
                <div class="row cl margin-10">
                    <div class="col-sm-3">
                        <span class="select-box" >
                            <select class="select" name="tradeType" size="1">
                                <option value="00" selected>快捷支付</option>
                            </select>
                        </span>
                    </div>
                    <div class="col-sm-3" >
                        <span class="select-box">
                            <select class="select" name="tradeStatus" size="1">
                                <option value="0" selected>交易状态</option>
                                <option value="1">初始化</option>
                                <option value="2">待支付</option>
                                <option value="3">成功</option>
                                <option value="4">失败</option>
                                <option value="45">取消</option>
                                <option value="99">未知</option>
                            </select>
                        </span>
                    </div>
                    <div class="col-sm-3" >
                        <input type="text" name="tradeNo" placeholder="系统订单号" class="input-text" >
                    </div>
                    <div class="col-sm-3">
                        <input type="text" name="outTradeNo" placeholder="商户订单号" class="input-text">
                    </div>
                </div>
                <%--条件查询第三行--%>
                <div class="row cl margin-10">
                    <div class="col-sm-4">

                    </div>
                    <div class="col-sm-4 ">
                        <div class="row cl">
                            <div class="col-sm-2" style="padding-right: 0px;padding-top: 2px;width: 79px;" >
                                交易日期:
                            </div>
                            <div class="col-sm-4" style="padding-left: 0px;padding-right: 0px;">
                                <jsp:useBean id="now" class="java.util.Date"></jsp:useBean>
                                <input type="text"
                                       onfocus="WdatePicker({isShowClear:false,readOnly:true,maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}',minDate:'{%y-1}-%M-%d'})"
                                       id="datemin" name="beginTime" class="input-text Wdate" placeholder="交易开始日期"
                                       readonly="readonly"
                                       value="<fmt:formatDate value='${now}' pattern='yyyy-MM-dd' />"/>
                            </div>
                            <div class="col-sm-1" style="padding-left: 0px;padding-right: 0px;text-align: center;width: 18px;">
                                -
                            </div>
                            <div class="col-sm-4" style="padding-left: 0px;padding-right: 0px;">
                                <input type="text"
                                       onfocus="WdatePicker({isShowClear:false,readOnly:true,minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d'})"
                                       id="datemax" name="endTime" class="input-text Wdate" placeholder="交易结束日期"
                                       readonly="readonly"
                                       value="<fmt:formatDate value='${now}' pattern='yyyy-MM-dd' />"/>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4"></div>
                </div>
                <div class="row cl margin-10">
                    <div class="col-sm-12 text-c">
                        <button class="btn btn-success" style="height: 27px;padding: 0px 12px;border-radius: 4px;" type="button" onclick="search()"><i class="Hui-iconfont"></i> 查询</button>
                        <button class="btn btn-secondary radius" style="height: 27px;padding: 0px 12px" type="button" onclick="exportExcel()">
                            <i class="Hui-iconfont Hui-iconfont-daochu"></i> 导出
                        </button>
                    </div>
                </div>
            </div>

        </form>
    </div>

    <div class="Huialert Huialert-success" style="text-align: right">
        <span class="label label-default radius" style="margin-right: 20px;">快捷支付：<strong
                id="total_10">0</strong>元(共 <font id='count_10'>0</font>笔)</span>
        <span class="label label-default radius" style="margin-right: 20px;">总分润金额：
            <strong id="sum_channel_fee">0</strong>元</span>
    </div>
    <table class="table table-border table-bordered table-bg" table-layout="fixed" style="margin-top:20px">
        <thead>
        <tr class="text-c">
            <th>渠道名称</th>
            <th>商户号</th>
            <th>商户名称</th>
            <th>商户订单号</th>
            <th>系统订单号</th>
            <th style="width: 80px !important;">交易金额</th>
            <th style="width: 80px !important;">交易手续费</th>
            <th style="width: 80px !important;">渠道分润</th>
            <th>交易日期</th>
            <%--<th style="width: 80px !important;">订单类型</th>--%>
            <th style="width: 49px !important;">结算周期</th>
            <th style="width: 49px !important;">支付状态</th>
            <%--<th style="width: 49px !important;">结算状态</th>--%>
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
<%--table相关JS--%>
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

    GetTradeType = function (key) {
        switch (key) {
            case '10':
                return "微信";
            case '11':
                return "微信公众号";
            case '20':
                return "支付宝";
            case '21':
                return "支付宝服务窗";
        }
    };
    GetTradeStatus = function (key) {
        switch (key) {
            case "1":
                return "初始化";
            case "2":
                return "待支付";
            case "3":
                return "成功";
            case "4":
                return "失败";
            case "45":
                return "取消";
            case "99":
                return "未知";

        }
    }
    GetSettletStatus = function (key) {
        switch (key) {
            case "1":
                return "未结算";
            case "2":
                return "结算中";
            case "3":
                return "结算成功";
            case "4":
                return "结算失败";
            case "99":
                return "未知";
        }
    };
    GetSettletDay = function (key) {
        switch (key) {
            case "0":
                return "D0";
            case "1":
                return "T1";
        }
    }

    var t = $('.table').dataTable({
        "ordering": false,//总开关，禁止排序
        "bFilter": false, //过滤功能
        "processing": true,
        "bStateSave": true,//状态保存
        "serverSide": true,
        "columns": [
            {"data": "channelName"},
            {"data": "merchantNo"},
            {"data": "merchantName"},
            {"data": "applyOrderNo"},
            {"data": "orderNo"},
            {"data": "amount"},
            {"data": "merchantFee"},
            {"data": "channelFee"},
            {"data": "createDate"},
//            {"data": "tradeType"},
            {"data": "settleType"},
            {"data": "tradeStatus"},
//            {"data": "settleStatus"}
        ],
        "createdRow": function (row, data, dataIndex) {
            $(row).children('td').attr('style', 'text-align:center;')
        },
        "ajax": {
            "url": "${basePath}/quick/trade/list",
            "type": "POST",
            "data": function (d) {
                d.merNo = $("select[name='mchNo']").val();
//                d.tradeType = $("select[name='tradeType']").val();
                d.tradeNo = $("input[name='tradeNo']").val();
                d.outTradeNo = $("input[name='outTradeNo']").val();
                d.beginTime = $("input[name='beginTime']").val();
                d.endTime = $("input[name='endTime']").val();
                d.tradeStatus = $("select[name='tradeStatus']").val();
                d.channelNo = $("input[name='channelNo']").val();
                d.channelName = $("input[name='channelName']").val();
                d.merchantName = $("input[name='merchantName']").val();
                d.merNo = $("input[name=merchantNo]").val();
            },
            "dataSrc": function (data) {
                //总金额
                if(data.map == null ||data.map['CLOSUM'] == null || data.map['CLOSUM'] == ""){
                    $("#total_10").html("0.00");
                }else{
                    $("#total_10").html(data.map['CLOSUM']);
                }
                //总条数
                if(data.map == null ||data.map['CLOCOUNT']  == null || data.map['CLOCOUNT'] == ""){
                    $("#count_10").html("0");
                }else{
                    $("#count_10").html(data.map['CLOCOUNT']);
                }
                //总分润
                if(data.map == null ||data.map['SUM_CHANNEL_FEE']  == null || data.map['SUM_CHANNEL_FEE'] == ""){
                    $("#sum_channel_fee").html('0');
                }else{
                    $("#sum_channel_fee").html(data.map['SUM_CHANNEL_FEE']);
                }
                var dataArr = data.data;
                for (var i = 0; i < dataArr.length; i++) {
                    dataArr[i].tradeType = GetTradeType(dataArr[i].tradeType);
                    dataArr[i].amount = parseFloat(dataArr[i].amount / 100).toFixed(2);
                    dataArr[i].merchantFee = parseFloat(dataArr[i].merchantFee / 100).toFixed(2);
                    dataArr[i].channelFee = parseFloat(dataArr[i].channelFee / 100).toFixed(2);
                    var dateVal = new Date(dataArr[i].createDate);
                    dataArr[i].createDate = dateVal.Format("yyyy-MM-dd HH:mm:ss");
                    dataArr[i].tradeStatus = GetTradeStatus(dataArr[i].tradeStatus);
                    dataArr[i].settleType = GetSettletDay(dataArr[i].settleType);
                    dataArr[i].settleStatus = GetSettletStatus(dataArr[i].settleStatus)
                }
                return dataArr;
            }
        },
    });

    function search() {
        t.fnDraw();
    }

    function exportExcel() {
//         if($("#channelNo").val() == null || $("#channelNo").val() == ""){
//             layer.msg("请选择代理商编号！");
//             return;
//         }
        $("form").submit();
    }


</script>

<script type="text/html" id="DoMoreHtml">
    <a style="text-decoration:none" href="javascript:;" title="编辑" data-id='#ID'><i class="Hui-iconfont"></i></a>
</script>

<%--模糊搜索相关--%>
<%--代理商名称--%>
<script type="text/javascript">
    $(function () {
        LoadChannel();
        LoadMerchant();
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
    LoadMerchant = function () {
        $.post('${basePath}/merchant/alldata',{},function (data) {
            if(data.length == 1){
                $("input[name=merchantNo]").val(data[0].merchantNo);
                $("input[name=merchantNo]").attr('readonly','readonly');
                $("input[name=merchantName]").val(data[0].merchantName);
                $("input[name=merchantName]").attr('readonly','readonly');
            }else{
                var merchantName = new Array();
                for(var i = 0;i < data.length;i++){
                    merchantName[i] = new Array();
                    merchantName[i][0] = data[i].merchantNo;
                    merchantName[i][1] = data[i].merchantName;
                }
                $("input[name=merchantName]").suggest(merchantName,{attachObject:"#merchantNameSuggest"});
                var merchantNo = new Array();
                for(var i = 0;i < data.length;i++){
                    merchantNo[i] = new Array();
                    merchantNo[i][0] = data[i].merchantName;
                    merchantNo[i][1] = data[i].merchantNo;
                }
                $("input[name=merchantNo]").suggest(merchantNo,{attachObject:"#merchantNoSuggest"});
            }
        })
    }
</script>
</body>
</html>
