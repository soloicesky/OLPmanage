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
            <th>机构账户id</th>
            <th>账户余额</th>
            <th>可用余额</th>
            <th>提现余额</th>
            <th>冻结余额</th>
            <th>状态</th>
            <th>更新时间</th>
            <th>备注</th>
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
            {"data":"office_id"},
            {"data":"total_amount"},
            {"data":"use_amount"},
            {"data":"draw_amount"},
            {"data":"freeze_amount"},
            {"data":"status"},
            {"data":"update_date"},
            {"data":"remarks"},
            {"data":"doMore","className":"td-manage"}
        ],
        "createdRow": function( row, data, dataIndex ) {
            $(row).children('td').attr('style', 'text-align:center;')
        },
        "ajax": {
            "url": "${basePath}/organ/listBalanceData",
            "type": "POST",
            "data": function (d) {
                // d.beginTime = $("input[id='datemin']").val();
                // d.endTime = $("input[id='datemax']").val();
                // d.office_id = $("input[name='nickName']").val();
            },
            "dataSrc": function (data) {
                var dataArr = data.data;
                var html = $("#doMore").html();
                for (var i = 0; i < dataArr.length; i++) {
                    var itemHtml = html;
                    dataArr[i]['doMore']= itemHtml;

                    var dateVal = new Date(dataArr[i].createTime);
                    dataArr[i].createTime = dateVal.Format("yyyy-MM-dd HH:mm:ss");
                    dataArr[i].nickName = "<a href='javascript:void(0);' onclick='showDetail(\"" + dataArr[i].id +  "\")' >" + dataArr[i].nickName + "</a>";
                }
                return dataArr;
            }
        }
    });
</script>
    <script type="text/html" id="doMore">
        <c:if test="${curUser.roleType eq '0'}">
            <a style="text-decoration:none" onClick="{Fun}(this,'{ID}')" data-vsersion="{dataVersion}" href="javascript:;" title="{Title}"></a>
            <a title="修改" href="javascript:;" onclick="admin_edit('商户编辑','${basePath}/admin/user/addpage','{ID}','800','500')" class="ml-5" style="text-decoration:none">
                <i class="Hui-iconfont">&#xe6df;</i>
            </a>
            <a title="删除" href="javascript:;" onclick="admin_del(this,'{ID}')" data-vsersion="{dataVersion}" class="ml-5" style="text-decoration:none">
                <i class="Hui-iconfont">&#xe6e2;</i>
            </a>
            <a title="分配权限" style="text-decoration:none" class="ml-5" onClick="admin_power('分配权限','${basePath}/admin/user/power','{ID}','800','500')" href="javascript:;" >
                <i class="Hui-iconfont">&#xe63f;</i>
            </a>
        </c:if>
    </script>

<script type="text/javascript">

    // 查看机构商户明细
    function showDetail(id) {

        $.post('showDetail',{id:id},function (data) {
            console.log(data)

            var index = layer.open({
                id:1,
                type: 1,
                title:'商户明细',
                skin:'layui-layer-rim',
                area:['450px', 'auto'],
                content:$("#detailDiv").html()
                // btn:['保存','取消'],
                // btn1: function (index,layero) {
                //     layer.alert(index)
                // },
                // btn2:function (index,layero) {
                //     layer.close(index);
                // }

            });

            $("#cancelRegBTN").click(function() {
                layer.close(index);
            });

        });

    }

    /*管理员-删除*/
    function admin_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            var version = $(obj).attr("data-vsersion");
            version = parseInt(version);
            //此处请求后台程序，下方是成功后的前台处理……
            $.post('${basePath}/admin/user/update',{id:id,isDel:'F',dataVersion:version},function (data) {
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
        layer_show(title, url+"?isOrgan=true&id="+id, w, h);
    }
    /*管理员-分配权限*/
    function admin_power(title, url, id, w, h) {
        layer_show(title, url+"?isOrgan=true&id="+id, w, h);
    }
    /*管理员-停用*/
    function admin_stop(obj, id) {
        layer.confirm('确认要冻结吗？', function (index) {
            var version = $(obj).attr("data-vsersion");
            version = parseInt(version);
            //此处请求后台程序，下方是成功后的前台处理……
            $.post('${basePath}/admin/user/update',{id:id,isActivity:'F',dataVersion:version},function (data) {
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
            $.post('${basePath}/admin/user/update',{id:id,isActivity:'T',dataVersion:version},function (data) {
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
