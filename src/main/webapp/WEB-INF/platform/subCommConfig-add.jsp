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
    <title>椰子优惠券系统配置</title>
</head>
<body>
<div class="page-container">
    <form action="${Url}" method="post" class="form form-horizontal" id="form-article-add">


        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商旅类费率：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${cocoAgentRate.userRate19}" name="userRate19"
                       id="userRate19">
            </div>
        </div>

        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>商旅类单笔提现手续费（分）：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${cocoAgentRate.userFeeDf19}" name="userFeeDf19"
                       id="userFeeDf19">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>公缴类费率：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${cocoAgentRate.userRate20}" name="userRate20"
                       id="userRate20">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>公缴类单笔提现手续费（分）：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${cocoAgentRate.userFeeDf20}" name="userFeeDf20"
                       id="userFeeDf20">
            </div>
        </div>
        <div class="row cl">
            <div class="col-sm-12 text-c">
                <input id="addbtn" name="addbtn" class="btn btn-primary radius" type="submit"
                       value="&nbsp;&nbsp;保存&nbsp;&nbsp;">
            </div>
        </div>
        <input id="agentNo" type="hidden" value="${cocoAgentRate.agentNo}" name="agentNo">
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
        $("#form-article-add").validate({
            rules:{


                userFeeDf19: {
                    required: true
                },
                userRate20: {
                    required: true
                },
                userRate19: {
                    required: true
                }
                ,
                userFeeDf20: {
                    required: true
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                var url = $(form).attr("action");
                $("#addbtn").attr("disabled", true);
                $(form).ajaxSubmit({
                    type: 'post',
                    url: '../../platform/subCommConfig/updateFix',
                    success: function (data) {
                        if (data.code == "00") {
                            layer.msg('保存成功!', {icon: 1, time: 1000}, function () {
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                            });
                        } else {
                            $("#addbtn").attr("disabled", false);
                            layer.msg('保存失败!', {icon: 2, time: 1000});
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
