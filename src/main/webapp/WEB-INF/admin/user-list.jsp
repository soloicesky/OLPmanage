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
    <title>添加菜单</title>
</head>
<body>
<nav class="breadcrumb">
    <i class="Hui-iconfont">&#xe67f;</i> 首页
    <span class="c-gray en">&gt;</span> 管理员管理
    <span class="c-gray en">&gt;</span> 管理员列表
    <a class="btn btn-success radius r" id ="btn-refresh"  style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新">
        <i class="Hui-iconfont">&#xe68f;</i>
    </a>
</nav>
<div class="page-container">
    <div class="text-c"> 日期范围：
        <input type="text" onfocus="WdatePicker({ maxDate:'#F{$dp.$D(\'datemax\')||\'%y-%M-%d\'}' })" id="datemin"
               class="input-text Wdate" style="width:120px;">
        -
        <input type="text" onfocus="WdatePicker({ minDate:'#F{$dp.$D(\'datemin\')}',maxDate:'%y-%M-%d' })" id="datemax"
               class="input-text Wdate" style="width:120px;">
        <input type="text" class="input-text" style="width:250px" placeholder="输入管理员名称" id="nickName" name="nickName">
        <button type="submit" class="btn btn-success" id="" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
    </div>
    <div class="cl pd-5 bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="admin_add('添加管理员','addpage','800','500')" class="btn btn-primary radius">
                <i class="Hui-iconfont">&#xe600;</i> 添加管理员
            </a>
        </span>
    </div>
    <table class="table table-border table-bordered table-bg">
        <thead>
        <tr class="text-c">
            <th>角色名称</th>
            <th>登录账号</th>
            <th>手机</th>
            <th>创建时间</th>
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

    $(".table-bg").dataTable({
        "ordering":false,//总开关，禁止排序
        "bFilter":false, //过滤功能
        "processing": true,
        "bStateSave": true,//状态保存
        "serverSide": true,
        "bLengthChange": false,
        "columns": [
            {"data":"nickName"},
            {"data":"loginName"},
            {"data":"phone"},
            {"data":"createTime"},
            {"data":"isActivity","className":"td-status"},
            {"data":"doMore","className":"td-manage"}
        ],
        "createdRow": function( row, data, dataIndex ) {
            $(row).children('td').attr('style', 'text-align:center;')
        },
        "ajax": {
            "url": "${basePath}/admin/user/listdata",
            "type": "POST",
            "data": function (d) {
                d.beginTime = $("input[id='datemin']").val();
                d.endTime = $("input[id='datemax']").val();
                d.nickName = $("input[name='nickName']").val();
            },
            "dataSrc": function (data) {
                var dataArr = data.data;
                var html = $("#doMore").html();
                for (var i = 0; i < dataArr.length; i++) {
                    var itemHtml = html;
                    if(dataArr[i].isActivity === 'F'){
                        dataArr[i].isActivity = '<span class="label label-default radius">已冻结</span>';
                        itemHtml = itemHtml.replace("{IconClass}",'&#xe615;');
                        itemHtml = itemHtml.replace("{Title}","激活");
                        var re = /{ID}/g;
                        itemHtml = itemHtml.replace(re,dataArr[i].id).replace("{Fun}","admin_start");
                        itemHtml = itemHtml.replace(/{dataVersion}/g,dataArr[i].dataVersion);

                    }
                    if(dataArr[i].isActivity === 'T'){
                        dataArr[i].isActivity = '<span class="label label-success radius">已激活</span>';
                        itemHtml = itemHtml.replace("{IconClass}",'&#xe631;').replace("{Title}","冻结")
                            .replace(/{ID}/g,dataArr[i].id).replace("{Fun}","admin_stop").replace(/{dataVersion}/g,dataArr[i].dataVersion);
                    }
                    dataArr[i]['doMore']= itemHtml;

                    var dateVal = new Date(dataArr[i].createTime);
                    dataArr[i].createTime = dateVal.Format("yyyy-MM-dd HH:mm:ss");
                }
                return dataArr;
            }
        }
    });
</script>
<script type="text/html" id="doMore">
    <a style="text-decoration:none" onClick="{Fun}(this,'{ID}')" data-vsersion="{dataVersion}" href="javascript:;" title="{Title}">
        <i class="Hui-iconfont">{IconClass}</i>
    </a>
    <a title="修改" href="javascript:;" onclick="admin_edit('管理员编辑','addpage','{ID}','800','500')" class="ml-5" style="text-decoration:none">
        <i class="Hui-iconfont">&#xe6df;</i>
    </a>
    <a title="删除" href="javascript:;" onclick="admin_del(this,'{ID}')" data-vsersion="{dataVersion}" class="ml-5" style="text-decoration:none">
        <i class="Hui-iconfont">&#xe6e2;</i>
    </a>
    <a title="分配权限" style="text-decoration:none" class="ml-5" onClick="admin_power('分配权限','power','{ID}','800','500')" href="javascript:;" >
        <i class="Hui-iconfont">&#xe63f;</i>
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
    /*管理员-删除*/
    function admin_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            var version = $(obj).attr("data-vsersion");
            version = parseInt(version);
            console.log(version);
            //此处请求后台程序，下方是成功后的前台处理……
            $.post('update',{id:id,isDel:'F',dataVersion:version},function (data) {
                if(data.code == "00"){
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                }else{
                    layer.msg(data.msg, {icon: 5, time: 1000});
                }
            })
        });
    }

    /*管理员-编辑*/
    function admin_edit(title, url, id, w, h) {
        layer_show(title, url+"?id="+id, w, h);
    }
    /*管理员-分配权限*/
    function admin_power(title, url, id, w, h) {
        layer_show(title, url+"?id="+id, w, h);
    }
    /*管理员-停用*/
    function admin_stop(obj, id) {
        layer.confirm('确认要冻结吗？', function (index) {
            var version = $(obj).attr("data-vsersion");
            version = parseInt(version);
            //此处请求后台程序，下方是成功后的前台处理……
            $.post('update',{id:id,isActivity:'F',dataVersion:version},function (data) {
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
            $.post('update',{id:id,isActivity:'T',dataVersion:version},function (data) {
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
