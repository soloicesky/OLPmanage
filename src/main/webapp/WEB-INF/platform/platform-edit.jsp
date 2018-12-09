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
    <form action="" method="post" class="form form-horizontal" id="form-article-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>通道名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="productName" id="productName">
            </div>
        </div>
        <div class="row cl" id="ChannelConfig">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>通道编码：</label>
            <div class="formControls col-xs-8 col-sm-9" JsonConfig>
                <input type="text" class="input-text" value="" name="platformCode" id="productCode" >
            </div>
        </div>
        
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>D0最大金额（元）：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t0MaxAmt" id="t0MaxAmt">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>D0最小金额（元）：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t0MinAmt" id="t0MinAmt">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>T1最大金额（元）：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t1MaxAmt" id="t1MaxAmt">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>T1最小金额（元）：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t1MinAmt" id="t1MinAmt">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>D0成本费率：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="subProductCode" id="subProductCode">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>T1成本费率：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t1Rate" id="t1Rate">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>D0单笔手续费：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" name="t0Rate" id="t0Rate">
            </div>
        </div>
        <div class="row cl">
            <div class="col-sm-12 text-c">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;添加&nbsp;&nbsp;">
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
        $("#form-article-add").validate({
            rules:{
                productName:{
                    required:true
                },
                productCode:{
                    required:true
                },
                subProductCode:{
                    required:true
                },
                description:{
                    required:true
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                var url = '${basePath}/product/add';
                $(form).ajaxSubmit({
                    type: 'post',
                    url: url ,
                    success: function(data){
                        if(data.code == "00"){
                           layer.msg('添加成功!',{icon:1,time:1000},function () {
                                var index = parent.layer.getFrameIndex(window.name);
                                window.parent.location.reload(); 
                                parent.layer.close(index);
                           });
                        }else{
                            layer.msg('添加失败!',{icon:2,time:1000});
                        }
                    },
                    error: function(XmlHttpRequest, textStatus, errorThrown){
                        layer.msg('error!',{icon:2,time:1000});
                    }
                });

            }
        })

    })

//     AddChannelConfig = function () {
//         var html = $("#AddChannelConfigHTML").html();
//         $("#ChannelConfig").append(html);
//         $("#ChannelConfig > div:last").append($("#AddConfigBTN"));
//     }
</script>
</body>
</html>
