<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <jsp:include page="../core/_header.jsp"/>
    <title>编辑机构</title>
</head>
<body>
<div class="page-container">
    <form action="${Url}" method="post" class="form form-horizontal" id="form-article-add">
        <c:if test="${organ != null}">
            <input type="text" class="input-text" value="${organ.id}" name="id" id="id" style="display: none">
        </c:if>
        <%--<input type="text" class="input-text" value="${organ.version + 1}" name="version" id="version" style="display: none">--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>机构名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <c:if test="${organ != null}">
                    <input type="text" class="input-text" value="${organ.name}" name="name" id="name" readonly="readonly">
                </c:if>
                <c:if test="${organ == null}">
                    <input type="text" class="input-text" value="${organ.name}" name="name" id="name" >
                </c:if>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>机构号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${organ.organ_no}" name="organ_no" id="organ_no" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>结算卡号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${organ.settle_carno}" name="settle_carno" id="settle_carno" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>开户名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${organ.settle_name}" name="settle_name" id="settle_name" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>开户银行：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${organ.settle_bank}" name="settle_bank" id="settle_bank" >
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>开户行号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${organ.bank_no}" name="bank_no" id="bank_no" >
            </div>
        </div>
        
        <%--<c:if test="${organ == null}">--%>
        <%--<div class="row cl">--%>
            <%--<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>加密秘钥：</label>--%>
            <%--<div class="formControls col-xs-8 col-sm-9">--%>
                <%--<input type="text" class="input-text" value="${organ.secretKey}" name="secretKey" id="secretKey">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--<div class="row cl">--%>
            <%--<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>安全邮箱：</label>--%>
            <%--<div class="formControls col-xs-8 col-sm-9">--%>
                <%--<input type="text" class="input-text" value="${organ.email}" name="email" id="email">--%>
            <%--</div>--%>
        <%--</div>--%>

        <%--<div class="row cl">--%>
            <%--<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>联系电话：</label>--%>
            <%--<div class="formControls col-xs-8 col-sm-9">--%>
                <%--<input type="text" class="input-text" value="${organ.phone}" name="phone" id="phone">--%>
            <%--</div>--%>
        <%--</div>--%>
        <%--</c:if>--%>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${organ.remarks}" name="remarks" id="remarks">
            </div>
        </div>
        <c:if test="${isReadOnly}" >

        </c:if>
        <div class="row cl">
            <div class="col-sm-12 text-c">
                <input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
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
<script type="text/html" id="AddorganConfigHTML">
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
//            AddorganConfig();
//        })
        $("#form-article-add").validate({
            rules:{
                organName:{
                    required:true
                },
                description:{
                    required:true
                },
                secretKey:{
                    required:true
                },
                email:{
                    required:true,
                    email:true
                },
                phone:{
                    required:true,
                    isPhone:true
                }
            },
            onkeyup:false,
            focusCleanup:true,
            success:"valid",
            submitHandler:function(form){
                var url = $(form).attr("action");
                $(form).ajaxSubmit({
                    type: 'post',
                    url: url ,
                    success: function(data){
                    	if(url=="add"){
                            if(data.code == "00"){
                               layer.msg('添加成功!',{icon:1,time:1000},function () {
                                    var index = parent.layer.getFrameIndex(window.name);
                                    window.parent.location.reload(); 
                                    parent.layer.close(index);
                                    });
                            }else{
                                layer.msg('添加失败!',{icon:2,time:1000});
                            }
                        	}
                    	if(url=="update"){
                            alert(data.code);
                    		if(data.code == "00"){
                               layer.msg('修改成功!',{icon:1,time:1000},function () {
                                    var index = parent.layer.getFrameIndex(window.name);
                                    window.parent.location.reload(); 
                                    parent.layer.close(index);
                                    });
                            }else{
                                layer.msg('修改失败!',{icon:2,time:1000});
                            }
                        	}
                    },
                    error: function(XmlHttpRequest, textStatus, errorThrown){
                        layer.msg('error!',{icon:1,time:1000});
                    }
                });

            }
        })

    })

</script>
</body>
</html>
