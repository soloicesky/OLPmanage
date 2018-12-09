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
    <link rel="stylesheet" href="${basePath}/plugin/layui/css/layui.css" media="all">
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
        class="c-gray en">&gt;</span> 订单列表
    <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px"
       href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
    <div class="row cl" style="margin-bottom: 20px;">
        <form action="${basePath}/nb/quick/order/exportExcel" method="post">
            <div class="col-xs-12 col-sm-12">
                <%--条件查询第一行--%>
                <div class="row cl">
                    <div class="col-sm-3">
                         <input type="text" name="channelNo" id="channelNo" placeholder="代理商编号" class="input-text" />
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
					<div class="col-sm-3" >
                        <span class="select-box" >
                            <select class="select" id="platform" name="platformCode" size="1">
                                    <option value="0" selected>上游通道</option>
                            </select>
                        </span>
                    </div>                    <div class="col-sm-4 ">
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
        <span class="label label-default radius" style="margin-right: 20px;">快捷支付:<strong
                id="total_10">0</strong>元(共<font id='count_10'>0</font>笔)</span>
        <span class="label label-default radius" style="margin-right: 20px;">渠道总分润金额:<strong 
        id="sum_channel_fee">0</strong>元</span>
            <span class="label label-default radius" style="margin-right: 20px;">我司收益:<strong 
            id="sum_my_fee">0</strong>元</span>
    </div>

    <table id="orderList">
    </table>

    <script type="text/html" id="TradeType">
        {{ GetTradeType(d.tradeType) }}
    </script>
    <script type="text/html" id="CreateDate">
        {{ CreateDate(d.createDate) }}
    </script>
    <script type="text/html" id="SettleType">
        {{ GetSettletDay(d.settleType) }}
    </script>
    <script type="text/html" id="TradeStatus">
        {{ GetTradeStatus(d.tradeStatus) }}
    </script>
    <script type="text/html" id="Amount">
        {{ GetAmount(d.amount) }}
    </script>
    <script type="text/html" id="merchantFee">
        {{ GetAmount(d.merchantFee) }}
    </script>
    <script type="text/html" id="fixFee">
        {{ GetAmount(d.fixFee) }}
    </script>
    <script type="text/html" id="channelFee">
        {{ GetAmount(d.channelFee) }}
    </script>
    <script type="text/html" id="platformFee">
        {{ GetAmount(d.platformFee) }}
    </script>

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
    CreateDate = function (data) {
        var dateVal = new Date(data);
        return dateVal.Format("yyyy-MM-dd HH:mm:ss");
    }
    GetTradeType = function (key) {
        switch (key) {
            case '10':
                return "快捷支付";
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

    function exportExcel() {
//         if($("#channelNo").val() == null || $("#channelNo").val() == ""){
//             layer.msg("请选择代理商编号！");
//             return;
//         }
        $("form").submit();
    }
    GetAmount = function (data) {
       return parseFloat(data / 100).toFixed(2);
    }

</script>

<script src="${basePath}/plugin/layui/layui.js"></script>
<script>
    var table;
    layui.use('table', function(){
        table = layui.table //表格
        table.render({
            elem: '#orderList' //指定原始表格元素选择器（推荐id选择器）
            ,id:'orderTable'
            ,height: 390 //容器高度
            ,cols: [[
                {field:'channelName',title:'渠道名称',width:86, align:'center',},
                {field:'merchantNo',title:'商户号',width:80, align:'center',},
                {field:'merchantName',title:'商户名称',width:90, align:'center',},
                {field:'applyOrderNo',title:'商户订单号',width:104, align:'center',},
                {field:'orderNo',title:'系统订单号',width:104, align:'center',},
                {field:'payerAccountNo',title:'交易卡号',width:104, align:'center',},
                {field:'amount',title:'交易金额',width:86, align:'center',templet:"#Amount"},
                {field:'merchantFee',title:'商户手续费',width:103, align:'center',templet:"#merchantFee"},
                {field:'fixFee',title:'单笔固定手续费',width:128, align:'center',templet:"#fixFee"},
                {field:'channelFee',title:'渠道分润',width:86, align:'center',templet:"#channelFee"},
                {field:'platformFee',title:'通道成本手续费',width:129, align:'center',templet:"#platformFee"},
                {field:'createDate',title:'交易日期',width:86, align:'center',templet:"#CreateDate"},
//                {field:'tradeType',title:'订单类型',width:86, align:'center',templet:"#TradeType"},
                {field:'settleType',title:'结算周期',width:86, align:'center',templet:"#SettleType"},
                {field:'platformCode',title:'上游平台编码',width:120, align:'center'},
                {field:'platformMerchantNo',title:'上游商户编码',width:120, align:'center'},
                {field:'tradeStatus',title:'支付状态',width:86, align:'center',templet:"#TradeStatus"},
                {field:'notes',title:'支付详情',width:86, align:'center',templet:"#notes"},
				]] //设置表头
            ,page: true
            ,limits: [10,20,30]
            ,limit: 10
            ,even:true
            ,url:'${basePath}/nb/quick/order/list'
            ,method:'post'
            ,where:WhereData()
            ,request:{
                pageName:'start'
                ,limitName:'length'
            }
            ,response:{
                countName:'recordsTotal'
            }
            ,done:function (res, curr, count) {
                if(res.map == null ||res.map['CLOSUM'] == null || res.map['CLOSUM'] == ""){
                    $("#total_10").html("0.00");
                }else{
                    $("#total_10").html(res.map['CLOSUM']);
                }
                if(res.map == null ||res.map['CLOCOUNT']  == null || res.map['CLOCOUNT'] == ""){
                    $("#count_10").html("0");
                }else{
                    $("#count_10").html(res.map['CLOCOUNT']);
                }
                //总分润
                if(res.map == null ||res.map['SUM_CHANNEL_FEE']  == null || res.map['SUM_CHANNEL_FEE'] == ""){
                    $("#sum_channel_fee").html('0');
                }else{
                    $("#sum_channel_fee").html(res.map['SUM_CHANNEL_FEE']);
                }
                if(res.map == null ||res.map['SUM_MY_FEE']  == null || res.map['SUM_MY_FEE'] == ""){
                    $("#sum_my_fee").html('0');
                }else{
                    $("#sum_my_fee").html(res.map['SUM_MY_FEE']);
                }
//                $("#total_11").html(res.map["11"]);
//                $("#count_11").html(res.map["count_11"]);
//                $("#total_20").html(res.map["20"]);
//                $("#count_20").html(res.map["count_20"]);
//                $("#total_21").html(res.map["21"]);
//                $("#count_21").html(res.map["count_21"]);
            }
        });

    });
    function search() {
        table.reload('orderTable',{
            where:WhereData()
        });
    }

    WhereData = function () {
        return {
            merNo : $("select[name='mchNo']").val()
            ,tradeType : $("select[name='tradeType']").val()
            ,tradeNo : $("input[name='tradeNo']").val()
            ,outTradeNo : $("input[name='outTradeNo']").val()
            ,beginTime : $("input[name='beginTime']").val()
            ,endTime : $("input[name='endTime']").val()
            ,tradeStatus : $("select[name='tradeStatus']").val()
            ,platformCode : $("select[name='platformCode']").val()
            ,channelNo : $("input[name='channelNo']").val()
            ,channelName : $("input[name='channelName']").val()
            ,merchantName : $("input[name='merchantName']").val()
            ,merNo : $("input[name=merchantNo]").val()
        };
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
        LoadPlatForm();
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
    LoadPlatForm = function () {
        $.post('${basePath}/platform/product/alldata',{},function (data) {
                var platformCode = $("select[name='platformCode']");
                
                for(var i = 0;i < data.length;i++){
                	var opt = new Option(data[i].name, data[i].code);  
                    document.getElementById("platform").options.add(opt);
                    }
        })
    }
//     LoadMerchant = function () {
//         $.post('${basePath}/merchant/alldata',{},function (data) {
//             if(data.length == 1){
//                 $("input[name=merchantNo]").val(data[0].channelNo);
//                 $("input[name=merchantNo]").attr('readonly','readonly');
//                 $("input[name=merchantName]").val(data[0].name);
//                 $("input[name=merchantName]").attr('readonly','readonly');
//             }else{
//                 var merchantName = new Array();
//                 for(var i = 0;i < data.length;i++){
//                     merchantName[i] = new Array();
//                     merchantName[i][0] = data[i].merchantNo;
//                     merchantName[i][1] = data[i].merchantName;
//                 }
//                 $("input[name=merchantName]").suggest(merchantName,{attachObject:"#merchantNameSuggest"});
//                 var merchantNo = new Array();
//                 for(var i = 0;i < data.length;i++){
//                     merchantNo[i] = new Array();
//                     merchantNo[i][0] = data[i].merchantName;
//                     merchantNo[i][1] = data[i].merchantNo;
//                 }
//                 $("input[name=merchantNo]").suggest(merchantNo,{attachObject:"#merchantNoSuggest"});
//             }
//         })
//     }
</script>
</body>
</html>
