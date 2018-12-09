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
    <title>渠道列表</title>
    <style>
        table{
            width: 100% !important;
        }
    </style>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 渠道管理
    <span class="c-gray en">&gt;</span> 渠道列表
    <a class="btn btn-success radius r" id ="btn-refresh"  style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="row cl">
        <div class="col-sm-4">
            <div class="col-sm-3" style="padding-right: 0px">
                日期范围：
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-right: 0px">
                <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
                       class="input-text Wdate" >
            </div>
            <div class="col-sm-1 text-c" style="padding-left: 0px;padding-right: 0px">
                -
            </div>
            <div class="col-sm-4" style="padding-left: 0px;padding-right: 0px">
                <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax"
                       class="input-text Wdate">
            </div>
        </div>
        <div class="col-sm-3">
            <input type="text" class="input-text" placeholder="输入渠道商名称" id="nickName" name="nickName">
        </div>
        <div class="col-sm-3">
            <input type="text" class="input-text" placeholder="输入渠道商编号" id="channelNo" name="channelNo">
        </div>
        <div class="col-sm-2">
            <button type="submit" class="btn btn-success" id="" name="" onclick="search()"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
        </div>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="admin_add('添加渠道-基础信息','addpage','800','500')" class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe600;</i> 添加渠道
            </a>
        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th>渠道编号</th>
            <th>渠道名称</th>
            <th>商户密钥</th>
<!--             <th>加密密钥</th> -->
            <th>结算卡号</th>
            <th>结算卡开户名</th>
            <th>开户银行</th>
            <th>开户行号</th>
            <th>创建时间</th>
            <th>描述</th>
            <th>是否已启用</th>
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
                    {"data":"channelNo"},
                    {"data":"name"},
                    {"data":"accessKey"},
//                     {"data":"secretKey"},
                    {"data":"settleCarno"},
                    {"data":"settleName"},
                    {"data":"settleBank"},
                    {"data":"bankNo"},
                    {"data":"createDate"},
                    {"data":"description"},
                    {"data":"enabled","className":"td-status"},
                    {"data":"doMore","className":"td-manage"}
                ],
                "createdRow": function( row, data, dataIndex ) {
                    $(row).children('td').attr('style', 'text-align:center;')
                },
                "ajax": {
                    "url": "${basePath}/channel/listdata",
                    "type": "POST",
                    "data": function (d) {
                        d.beginTime = $("input[id='datemin']").val();
                        d.endTime = $("input[id='datemax']").val();
                        d.nickName = $("input[name='nickName']").val();
                        d.channelNo = $("input[name='channelNo']").val();
                    },
                    "dataSrc": function (data) {
                        var dataArr = data.data;
                        var html = $("#doMore").html();
                        for (var i = 0; i < dataArr.length; i++) {
                            var itemHtml = html;

                            dataArr[i].createDate = new Date(dataArr[i].createDate).Format("yyyy-MM-dd HH:mm:ss");

                            if(dataArr[i].enabled === false){
                                dataArr[i].enabled = '<span class="label label-default radius">已冻结</span>';
                                itemHtml = itemHtml.replace("{IconClass}",'&#xe615;');
                                itemHtml = itemHtml.replace("{Title}","激活");
                                var re = /{ID}/g;
                                itemHtml = itemHtml.replace(re,dataArr[i].id).replace("{Fun}","admin_start");
                                itemHtml = itemHtml.replace(/{dataVersion}/g,dataArr[i].version);

                            }
                            if(dataArr[i].enabled === true){
                                dataArr[i].enabled = '<span class="label label-success radius">已激活</span>';
                                itemHtml = itemHtml.replace("{IconClass}",'&#xe631;').replace("{Title}","冻结")
                                    .replace(/{ID}/g,dataArr[i].id).replace("{Fun}","admin_stop").replace(/{dataVersion}/g,dataArr[i].version);
                            }
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
    <a style="text-decoration:none" onClick="{Fun}(this,'{ID}')" data-vsersion="{dataVersion}" href="javascript:;" title="{Title}">
        <i class="Hui-iconfont">{IconClass}</i>
    </a>

    <a title="查看详情" href="javascript:;" onclick="admin_edit('查看详情','addpage','{ID}','900','500')" class="ml-5" style="text-decoration:none">
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
    /*管理员-增加*/
    function admin_add(title, url, w, h) {
        layer_show(title, url, w, h);
    }

    /*管理员-编辑*/
    function admin_edit(title, url, id, w, h) {
        layer_show(title, url+"?id="+id, w, h);
    }
    /*管理员-停用*/
    function admin_stop(obj, id) {
        layer.confirm('确认要冻结吗？', function (index) {
            var version = $(obj).attr("data-vsersion");
            version = parseInt(version);
            //此处请求后台程序，下方是成功后的前台处理……
            $.post('update',{id:id,enabled:false,version:version},function (data) {
                if(data.code == "00"){
                    $(obj).parents("tr").find(".td-manage").prepend('<a onClick=admin_start(this,'+ id +') href="javascript:;" data-vsersion=' + version+' title="启用" style="text-decoration:none"><i class="Hui-iconfont">&#xe615;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-default radius">已冻结</span>');
                    $(obj).remove();
                    $(obj).attr("data-vsersion",version + 1);
                    layer.msg('已冻结!', {icon: 5, time: 1000});
                }else{
                    layer.msg(data.msg, {icon: 5, time: 1000});
                }
            })

        });
    }

    /*管理员-启用*/
    function admin_start(obj, id) {
        layer.confirm('确认要激活吗？', function (index) {
            //此处请求后台程序，下方是成功后的前台处理……
            var version = $(obj).attr("data-vsersion");
            version = parseInt(version);
            $.post('update',{id:id,enabled:true,version:version},function (data) {
                if(data.code == "00"){
                    $(obj).parents("tr").find(".td-manage").prepend('<a onClick="admin_stop(this,'+id+')" href="javascript:;" data-vsersion="'+version+'" title="停用" style="text-decoration:none"><i class="Hui-iconfont">&#xe631;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已激活</span>');
                    $(obj).remove();
                    $(obj).attr("data-vsersion",version + 1);
                    layer.msg('已激活!', {icon: 6, time: 1000});
                }else{
                    layer.msg(data.msg, {icon: 5, time: 1000});
                }
            })


        });
    }


</script>

</body>
</html>
