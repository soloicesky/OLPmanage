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
    <title>代理商开通产品列表</title>
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
    <span class="c-gray en">&gt;</span> 产品管理
    <span class="c-gray en">&gt;</span> 产品开通
    <a class="btn btn-success radius r" id ="btn-refresh"  style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c"> 
                  <input type="text" class="input-text" style="width:150px" placeholder="输入渠道编号" id="channelNo" name="channelNo">
        <!-- <input type="text" class="input-text" style="width:150px" placeholder="输入代理商名称" id="nickName" name="nickName">-->
        
             <c:if test="${0 == user.adminNo}">
            <span class="select-box merchant-col-5" > 
                <select class="select " name="level" size="1">
                 <option value="0" selected>-级别选择-</option>
                 <option value="3">下游客户</option>
                 <option value="4">下游渠道</option>
              	 <OPTION VALUE="1">渠道</OPTION>
<!--               	 <OPTION VALUE="2">二级代理商</OPTION> -->
              	 </select>
              	</span>
               </c:if>
         
<%--                  <c:if test="${user.downCustomerId == user.adminNo}"> --%>
<!-- 		            <span class="select-box merchant-col-5" >  -->
<!--                 		<select class="select " name="level" size="1"> -->
<!-- 		                  <option value="0" selected>-请选择-</option> -->
<!-- 		              	  <option value="1">一级</option> -->
<!-- 		              	  <option value="2">二级</option> -->
<!-- 		              	   </select> -->
<!-- 		              	</span> -->
<%--                </c:if> --%>
<%--               <c:if test="${user.l1AgentId == user.adminNo}"> --%>
<!-- 		           	 <span class="select-box merchant-col-5" >  -->
<!--                 <select class="select " name="level" size="1"> -->
<!--               	 <option value="2" selected>二级</option> -->
<!--               	   </select> -->
<!-- 		              	</span> -->
<%--                </c:if> --%>
              
        <button type="submit" class="btn btn-success merchant-button1" onclick="search()"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
    </div>
    <!-- <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="admin_add('添加代理商-基础信息','addpage','800','500')" class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe600;</i> 添加代理商
            </a>
        </span>
    </div> -->
    <input type="hidden" class="input-text" value="${user.adminNo}" style="width:150px" placeholder="输入渠道名称" id="adminNo" name="adminNo">
    <input type="hidden" class="input-text" value="${user.downCustomerId}" style="width:150px" placeholder="输入渠道名称" id="downCustomerId" name="downCustomerId">
     <input type="hidden" class="input-text" value="${user.l1AgentId}" style="width:150px" placeholder="输入渠道名称" id="l1AgentId" name="l1AgentId">
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th style="width:80px !important;">渠道编号</th>
            <th>渠道名称</th>
<!--             <th>上级编号</th> -->
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
<script type="text/javascript">
var adminNo = $('#adminNo').val();
var downCustomerId = $('#downCustomerId').val();
var l1AgentId = $('#l1AgentId').val();
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
            "q+": Math.floor((this.getMonth() + 3) / 3),	 //季度
            "S": this.getMilliseconds() 	//毫秒
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
        "bAutoWidth" : true,
        
       // "bLengthChange": false,
        "sScrollX": true,
       // "sScrollY" : 400,
        
                "columns": [{"data":"channelNo"},
			                {"data":"name"},
// 			                {"data":"level"},
			                {"data":"createDate"},
			                {"data":"doMore","className":"td-manage"}] ,
                "createdRow":function(row,data,dataIndex){
                    $(row).children('td').attr('style','text-align:center;')
                },
                "ajax": {
                    "url": "${basePath}/channel/product/selectOpenList",
                    "type": "POST",
                    "data": function (d) {
                        d.beginTime = $("input[id='datemin']").val();
                        d.endTime = $("input[id='datemax']").val();
                        d.nickName = $("input[name='nickName']").val();
                        d.channelNo = $("input[name='channelNo']").val();
                        d.level = $("select[name='level']").val();
                    },
                    "dataSrc": function (data) {
                        var dataArr = data.data;
                        var html = $("#doMore").html();
                        for (var i = 0; i < dataArr.length; i++) {
                            var itemHtml = html;
							if(dataArr[i].addAgentUserId==0){
								dataArr[i].addAgentUserId="平台";
							}
                            dataArr[i].createDate = new Date(dataArr[i].createDate).Format("yyyy-MM-dd HH:mm:ss");
                            
                            if(dataArr[i].level === 3){
                            	dataArr[i].level="客户";
                            }
                            if(dataArr[i].level === 1){
                            	dataArr[i].level="一级";
                            }
                            if(dataArr[i].level === 2){
                            	dataArr[i].level="二级";
                            }
                            if(dataArr[i].level === 4){
                            	dataArr[i].level="渠道";
                            }
                            var re = /{channelNo}/g;
                            itemHtml = itemHtml.replace(re,dataArr[i].channelNo);
                            dataArr[i]['doMore']= itemHtml;
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
    <a title="配置产品" href="javascript:;" onclick="open_product('配置产品','open','{channelNo}','800','500')" class="ml-5" style="text-decoration:none">
        <i class="Hui-iconfont">&#xe6df;</i>
    </a>
</script>
<script type="text/javascript">
var adminNo = $('#adminNo').val();
var downCustomerId = $('#downCustomerId').val();
var l1AgentId = $('#l1AgentId').val();

function layer_showq(title,url,w,h){
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
		end:function(){
			location.reload();
		}
	});
}

function layer_showq(title,url,w,h){
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
		end:function(){
			location.reload();
		}
	});
}
  
    /*管理员-编辑*/
    function open_product(title, url, channelNo, w, h) {
        layer_showq(title, url+"?channelNo="+channelNo, w, h);
    }
</script>

</body>
</html>
