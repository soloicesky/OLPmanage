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
    <title>添加通道</title>
</head>
<body>
<div class="page-container">
    <form action="${Url}" method="post" class="form form-horizontal" id="form-article-add">
        <%--<div class="radio-box">--%>
        <%--<input type="radio" id="radio-1" name="demo-radio1">--%>
        <%--<label for="radio-1">已有通道</label>--%>
        <%--</div>--%>
        <%--<div class="radio-box">--%>
        <%--<input type="radio" id="radio-2" name="demo-radio1" checked>--%>
        <%--<label for="radio-2">新增通道</label>--%>
        <%--</div>--%>
        <div class="row cl">
            <div class="col-sm-3">
            </div>
            <div class="col-sm-3">
                 <span class="select-box">
                       <select class="select" id="platformId" name="platformId" data-subProductCode="">
                       <option value="0" selected>选择上游平台</option>
                            <c:forEach var="p" items="${data}">
                                <option value="${p.id}">${p.name}</option>
                            </c:forEach>
                           <option style="background: greenyellow" id="addPlatform" name="addPlatform" value="-1">新增上游平台</option>
                 </select>
                 </span>
            </div>
            <div class="col-sm-3">
            </div>
        </div>
        <div id="newplat" style="display: none" class="row cl">
            <label style="background: greenyellow" class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>上游平台名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="newPlatform" id="newPlatform">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>D0最大金额(元)：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t0MaxAmt" id="t0MaxAmt">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>D0最小金额(元)：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t0MinAmt" id="t0MinAmt">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>T1最大金额(元)：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t1MaxAmt" id="t1MaxAmt">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>T1最小金额(元)：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t1MinAmt" id="t1MinAmt">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>D0成本费率：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t0Rate" id="t0Rate">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>T1成本费率：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t1Rate" id="t1Rate">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>D0单笔固定手续费：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="fixT0Fee" id="fixT0Fee">
            </div>
        </div>
        <input type="hidden" value="${subProductCode}" name="subProductCode" id="subProductCode">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>描述：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="description" id="description">
            </div>
        </div>
        <div class="row cl">
            <div class="col-sm-12 text-c">
                <input id="addbtn" name="addbtn" class="btn btn-primary radius" type="submit"
                       value="&nbsp;&nbsp;添加&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</div>

<jsp:include page="../core/_footer.jsp"/>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath}/plugin/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${basePath}/plugin/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${basePath}/plugin/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/html" id="AddChannelConfigHTML">
    <label class="form-label col-xs-4 col-sm-2"></label>
    <div class="formControls col-xs-8 col-sm-9" style="margin-top: 10px" JsonConfig>
        <input type="text" class="input-text" value="" placeholder="JsonKey" name="key" style="width:25%">
        =
        <input type="text" class="input-text" value="" placeholder="JsonVal" name="val" style="width:25%">
    </div>
</script>
<script type="text/javascript">
    $(function () {
//        $("#AddConfigBTN").click(function () {
//            AddChannelConfig();
//        })


        $('.select').change(function () {

            if ($(this).children('option:selected').val() == ('-1')) {
                $("#newplat").show();
            }else{
                $("#newplat").hide();
            }
        })
        $("#form-article-add").validate({
            rules: {
//                platformId: {
//                    required: true
//                },
                t0MaxAmt: {
                    required: true
                },
                t0MinAmt: {
                    required: true
                },
                t1MaxAmt: {
                    required: true
                },
                t1MinAmt: {
                    required: true
                },
                t0Rate: {
                    required: true
                },
                t1Rate: {
                    required: true
                },
                fixT0Fee: {
                    required: true
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                var url = $(form).attr("action");
                $("#addbtn").attr("disabled", true);
                <%--alert("sss");--%>
                <%--${data}.each(function () {--%>
                <%--alert($(this).p.name);--%>
                <%--});--%>
                $(form).ajaxSubmit({
                    type: 'post',
                    url: url,
                    success: function (data) {
                        if (data.code == "00") {
                            layer.msg('添加成功!', {icon: 1, time: 1000}, function () {
                                var index = parent.layer.getFrameIndex(window.name);
                                window.parent.location.reload(); 
                                parent.layer.close(index);
                            });
                        } else {
                            $("#addbtn").attr("disabled", false);
                            layer.msg('添加失败!', {icon: 2, time: 1000});
                        }
                    },
                    error: function (XmlHttpRequest, textStatus, errorThrown) {
                        $("#addbtn").attr("disabled", false);
                        layer.msg('error!', {icon: 2, time: 1000});
                    }
                });
            }
        })

    })

    AddChannelConfig = function () {
        var html = $("#AddChannelConfigHTML").html();
        $("#ChannelConfig").append(html);
        $("#ChannelConfig > div:last").append($("#AddConfigBTN"));
    }
</script>
<%--<script type="text/javascript">




    $(function () {



        $("#form-article-add").validate({
            rules: {
//                platformName: {
//                    required: true
//                },
                t0MaxAmt: {
                    required: true
                },
                t0MinAmt: {
                    required: true
                },
                t1MaxAmt: {
                    required: true
                },
                t1MinAmt: {
                    required: true
                },
                t0Rate: {
                    required: true
                },
                t1Rate: {
                    required: true
                },
                fixT0Fee: {
                    required: true
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
            }
        })


    })


    CheckForm = function () {
        var len = $("form").length;
        $("form").each(function (index) {
            var $productId = $(this).find("input[name=productId]");
            var $select = $(this).find("select");
            if ($productId.attr("checked") && $select.val() != "0") {

            } else {
                layer.msg("请确认是否选择产品或是否选择通道！")
            }
        })
    }
function assd() {
    var url = '${basePath}/product/route/addRoad';
    var data = $("form").serialize();
    $.post(url, data, function (data) {
        alert('111111');
        if (data.code == "00") {
            layer.msg('添加成功!', {icon: 1, time: 1000}, function () {
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            });
        } else {
            layer.msg('添加失败!', {icon: 2, time: 1000});
        }
    });


}
    AddChannelConfig = function () {
        var html = $("#AddChannelConfigHTML").html();
        $("#ChannelConfig").append(html);
        $("#ChannelConfig > div:last").append($("#AddConfigBTN"));
    }
</script>--%>

</body>
</html>
