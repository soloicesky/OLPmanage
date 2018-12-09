<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="basePath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<jsp:include page="../core/_header.jsp" />
<title>支付通道设置</title>
</head>
<body>
	<div class="page-container">
		<input value="${ChannelNo}" name="channelNo" style="display: none">
		<input value="${thisChannelLevel}" name="thisChannelLevel"
			style="display: none">
		<div class="row cl">
			<div class="formControls col-sm-12">
				<c:if test="${not empty CuserRate}">
					<input type="hidden" class="t0Rate20User" name="t0Rate20User"
						value="${CuserRate.userRate20}">
					<input type="hidden" class="fixT0Fee20User" name="fixT0Fee20User"
						value="<fmt:formatNumber value='${CuserRate.userFeeDf20}' type='number'></fmt:formatNumber>">
					<input type="hidden" class="t0Rate19User" name="t0Rate19User"
						value="${CuserRate.userRate19}">
					<input type="hidden" class="fixT0Fee19User" name="fixT0Fee19User"
						value="<fmt:formatNumber value='${CuserRate.userFeeDf19}' type='number'></fmt:formatNumber>">
				</c:if>
				<c:forEach var="p" items="${ProductList}">
					<form action="" method="post" class="form form-horizontal"
						id="${p.id}">
						<input value="${p.subProductCode}" name="subProductCode"
							style="display: none"> <input value="${p.productCode}"
							name="productCode" style="display: none">
						<dl class="permission-list" id="dl${p.id}">
							<dt>
								<c:if test="${ not empty p.id}">
									<label> <input type="checkbox" value="${p.id}"
										name="productId" id="user-Character-0" data="${p.productName}">
										${p.productName}
									</label>
								</c:if>
								<c:if test="${empty p.id}">
									<label> <input type="checkbox" value="${p.productId}"
										name="productId" id="user-Character-0" data="${p.productName}">
										${p.productName}
									</label>
								</c:if>
								<input type="hidden" class="productName" name="productName"
									value="${p.productName}">
							</dt>
							<dd>
								<c:if test="${thisChannelLevel==3}">
									<input type="hidden" class="ourFixT0Fee" name="ourFixT0Fee"
										value="">
									<input type="hidden" class="ourT0Rate" name="ourT0Rate"
										value="">
									<input type="hidden" class="ourT1Rate" name="ourT1Rate"
										value="">
								</c:if>
								<div class="row cl">
									<%--  <c:if test="${LoginRoleType==3}">--%>
									<c:if test="${empty p.id}">
										<div class="row cl">
											<label class="form-label col-xs-4 col-sm-3 forDefualt"><span
												class="c-red">*</span>提现手续费（单位/元）：</label>
											<div class="col-sm-3" id="col-sm-3-reset">
												<input type="text" class="input-text" maxlength="4" placeholder="T0固定手续费<c:if test='${ not empty p.fixT0Fee}'>>0.5</c:if>" name="fixT0Fee" value=""> 
												<input type="hidden" class="fixT0FeeLast" name="fixT0FeeLast" value="<fmt:formatNumber value='0.5' type='number'></fmt:formatNumber>">
											</div>
										</div>

										<div class="row cl">
											<label class="form-label col-xs-4 col-sm-3 forDefualt"><span
												class="c-red">*</span>即时结算成本费率（单位/%）：</label>
											<div class="col-sm-3" id="col-sm-3-reset">
												<input type="text" class="input-text" placeholder="DO费率"name="t0Rate" value=""> 
												<input type="hidden" class="t0RateLast" name="t0RateLast" value="<fmt:formatNumber value='${p.t0Rate*0.01}' type='number'></fmt:formatNumber>">
											</div>
										</div>

										<c:if test="${p.productId!=5&&p.productId!=18}">
											<div class="row cl">
												<label class="form-label col-xs-4 col-sm-3 forDefualt"><span
													class="c-red">*</span>第二个工作日结算成本费率（单位/%）：</label>
												<div class="col-sm-3" id="col-sm-3-reset">
													<input type="text" class="input-text" placeholder="T1费率" name="t1Rate" value="">
													 <input type="hidden"  class="t1RateLast" name="t1RateLast" value="<fmt:formatNumber value='${p.t1Rate*0.01}' type='number'></fmt:formatNumber>">
												</div>
											</div>
										</c:if>
									</c:if>

									<%-- <c:if test="${LoginRoleType==0}">  --%>
									<c:if test="${not empty p.id}">
										<div class="row cl">
											<label class="form-label col-xs-4 col-sm-3 forDefualt"><span
												class="c-red">*</span>固定手续费（单位/元）：</label>
											<div class="col-sm-3" id="col-sm-3-reset">
												<input type="text" class="input-text" maxlength="4"
													placeholder="T0固定手续费" name="fixT0Fee" value="">
											</div>
										</div>
										<div class="row cl">
											<label class="form-label col-xs-4 col-sm-3 forDefualt"><span
												class="c-red">*</span>即时结算成本费率（单位/%）：</label>
											<div class="col-sm-3" id="col-sm-3-reset">
												<input type="text" class="input-text" placeholder="DO费率"
													name="t0Rate" value="">
											</div>
										</div>
										<c:if test="${p.id!=5&&p.id!=18}">
											<div class="row cl">
												<label class="form-label col-xs-4 col-sm-3 forDefualt"><span
													class="c-red">*</span>第二个工作日结算成本费率（单位/%）：</label>
												<div class="col-sm-3" id="col-sm-3-reset">
													<input type="text" class="input-text" placeholder="T1费率"
														name="t1Rate" value="">
												</div>
											</div>
										</c:if>
									</c:if>
									<%--  </c:if>  --%>
								</div>
							</dd>
						</dl>
					</form>
				</c:forEach>
			</div>
		</div>
		<div class="row cl">
			<div class="col-sm-12 text-c">
				<input class="btn btn-primary radius" type="submit"
					onclick="CheckForm()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;"> <input
					class="btn btn-primary radius" type="submit" onclick="CloseForm()"
					value="&nbsp;&nbsp;关闭&nbsp;&nbsp;">
			</div>
		</div>
	</div>

	<jsp:include page="../core/_footer.jsp" />
	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="${basePath}/plugin/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript"
		src="${basePath}/plugin/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="${basePath}/plugin/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="${basePath}/plugin/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript"
		src="${basePath}/plugin/webuploader/0.1.5/webuploader.min.js"></script>
	<script type="text/javascript"
		src="${basePath}/plugin/laypage/1.2/laypage.js"></script>
	<script type="text/html" id="AddChannelConfigHTML">
    <label class="form-label col-xs-4 col-sm-2"></label>
    <div class="formControls col-xs-8 col-sm-9" style="margin-top: 10px" JsonConfig>
        <input type="text" class="input-text" value="" placeholder="JsonKey" name="key" style="width:25%">
        =
        <input type="text" class="input-text" value="" placeholder="JsonVal" name="val" style="width:25%">
    </div>
</script>
	<script type="text/javascript">
var  xiaoshu= /^\d+\.\d+$/;
var  zhenshu= /^\d+(\.\d{1,2})?$/;
var thisChannelLevel = $("input[name=thisChannelLevel]").val();

    $(function () {
    	
         //检查渠道号是否存在
        var channelNo = $("input[name=channelNo]").val();
        var subProductCode = $("input[name=subProductCode]").val();
        if(channelNo == null || channelNo == ""){
            LoadChannelProduct();
        }else{
            console.log(channelNo);
        if(thisChannelLevel==3){
        	 LoadplatformProduct(subProductCode);
        }
        LoadHasOpenChannel(channelNo);
        }
    }); 

  
    //加载已开通产品
    LoadHasOpenChannel = function (channelNo) {
        $.post('${basePath}/channel/product/selectopen',{channelNo:channelNo},function (data) {
            $.each(data,function (index,iteam) {
                console.log(iteam);
                $("form").each(function () {
                    var $productId = $(this).find("dl input[name=productId]");
                    if($productId.val() == iteam.productId){
                        $productId.attr("checked",true);
                        $(this).find("dd input").each(function () {
                        });
                        $(this).find("dd input[name=fixT0Fee]").val(numMulti(iteam.fixT0Fee, 0.01));
                        $(this).find("dd input[name=t0Rate]").val(numMulti(iteam.t0Rate, 0.01));
                        $(this).find("dd input[name=t1Rate]").val(numMulti(iteam.t1Rate, 0.01));
                    }
                });
            });
        });
    } 
   
    function numMulti(num1, num2) { 
    	var baseNum = 0; 
    	try { 
    	baseNum += num1.toString().split(".")[1].length; 
    	} catch (e) { 
    	} 
    	try { 
    	baseNum += num2.toString().split(".")[1].length; 
    	} catch (e) { 
    	} 
    	return Number(num1.toString().replace(".", "")) * Number(num2.toString().replace(".", "")) / Math.pow(10, baseNum); 
    	}; 
    //加载通道成本费率
    LoadplatformProduct = function (subProductCode) {
        $.post('${basePath}/channel/product/platformInfo',{subProductCode:subProductCode},function (data) {
            $.each(data,function (index,iteam) {
                console.log(iteam);
                $("form").each(function () {
                    var $subProductCode = $(this).find("input[name=subProductCode]");
                    if($subProductCode.val() == iteam.subProductCode){
                    	//提示用户输入正确数字
                        $(this).find("dd input[name=fixT0Fee]").attr('placeholder','我司成本手续费'+numMulti(iteam.fixT0Fee, 0.01)+"元");
                        $(this).find("dd input[name=t0Rate]").attr('placeholder','我司D0成本费率'+iteam.t0Rate+"%");
                        $(this).find("dd input[name=t1Rate]").attr('placeholder','我司T1成本费率'+iteam.t1Rate+"%");
                        //
                        $(this).find("dd input[name=ourFixT0Fee]").val(numMulti(iteam.fixT0Fee, 0.01));
                        $(this).find("dd input[name=ourT0Rate]").val(iteam.t0Rate);
                        $(this).find("dd input[name=ourT1Rate]").val(iteam.t1Rate);
                    }
                });
            });
        });
    } 
    
   var result = "00";
    CheckForm = function () {
    	var userRate20=  $(" input[name='t0Rate20User'] ").val();
    	var userFeeDf20 =  $(" input[name='fixT0Fee20User'] ").val();
    	var userRate19  = $(" input[ name='t0Rate19User'] ").val();
    	var userFeeDf19 = $(" input[name='fixT0Fee19User'] ").val();
    	if(thisChannelLevel!=4&&thisChannelLevel!=3){
// 	    	if(userRate20==null||userRate20==""){
// 	    		 layer.msg("会员成本费率未经配置，不可操作！");
// 	           	 $(this).focus();
// 	                return false;
// 	    	}
    	}
    	
    	
        $("form").each(function () {
        	var productIdName = $(this).find("dl input[name=productName]").val();
            var isRead = $(this).find("dt input").attr("disabled");
            if(isRead == "disabled") return true;
            var isChecked = $(this).find("dt input").prop("checked");
            var productIdValue = $(this).find("dl input[name=productId]").val();
            if(isChecked){
            	if(!zhenshu.test($(this).find("dd [name=fixT0Fee]").val())){
	           		layer.msg(productIdName+":请输入正确的手续费");
	                return false;
	           	}
	           	if(!xiaoshu.test($(this).find("dd [name=t0Rate]").val())){
	           		layer.msg(productIdName+":请输入正确的及时结算成本费率");
	                   return false;
	           	} 
            	if(thisChannelLevel==4){
            		
            		/* if(!xiaoshu.test($(this).find("dd [name=t1Rate]").val())) {
                		layer.msg(productIdName+':请输入正确第二个工作日结算成本费率!',{icon:2,time:1000});
                        return false;
                	} */
                	/* if($(this).find("dd [name=fixT0Fee]").val() == null || $(this).find("dd [name=fixT0Fee]").val() == ""||$(this).find("dd [name=t0Rate]").val()== null||$(this).find("dd [name=t0Rate]").val()==""||$(this).find("dd [name=t1Rate]").val()==null||$(this).find("dd [name=t1Rate]").val()==""){
                   	 layer.tips(productIdName+":请输入产品固定手续费或成本费率",$(this),{
                            tips: [1, '#3595CC'],
                            time: 2000
                        });
                        return false;
                   }
                	alert(); */
                	var inputFixT0Fee = $(this).find("dd [name=fixT0Fee]").val();
	                $(this).find("dd [name=fixT0Fee]").val(numMulti(inputFixT0Fee, 100));
                	 var $Form = $(this);
                	  SubmitFrom($Form);
                	  $(this).find("dd [name=fixT0Fee]").val(inputFixT0Fee);
            	}else{
	           
	            	//若当前为管理员配置渠道伙伴费率
	            	 if(thisChannelLevel==3){
	            		 if($(this).find("dd [name=fixT0Fee]").val()<$(this).find("dd [name=ourFixT0Fee]").val()){
	                 		layer.msg(productIdName+"：固定手续费必须大于等于我司的成本 "+$(this).find("dd [name=ourFixT0Fee]").val()+"元");
	                       	 $(this).focus();
	                            return false;
	                 	}
	                 	if($(this).find("dd [name=t0Rate]").val()<$(this).find("dd [name=ourT0Rate]").val()){
	                 		 layer.msg(productIdName+"：即时结算成本费率必须大于等于我司的成本费率 "+$(this).find("dd [name=ourT0Rate]").val()+"%");
	                        	 $(this).focus();
	                             return false;
	                 	}
	                 	if($(this).find("dd [name=t1Rate]").val()<$(this).find("dd [name=ourT1Rate]").val()){
	                		 layer.msg(productIdName+"：第二个工作日结算成本费率必须大于等于我司的成本费率 "+$(this).find("dd [name=ourT1Rate]").val()+"%");
	                       	 $(this).focus();
	                            return false;
	                		}
	            	 }
	            	console.info("固定手续"+$(this).find("dd [name=fixT0Fee]").val());
	            	console.info("上级固定手续"+$(this).find("dd [name=fixT0FeeLast]").val());
	            	if($(this).find("dd [name=fixT0Fee]").val()<$(this).find("dd [name=fixT0FeeLast]").val()){
	            		layer.msg(productIdName+"：下级固定手续费必须大于等于上级成本 "+$(this).find("dd [name=fixT0FeeLast]").val()+"元");
	                  	 $(this).focus();
	                     return false;
	            	}
	            	if($(this).find("dd [name=t0Rate]").val()<$(this).find("dd [name=t0RateLast]").val()){
	            		 layer.msg(productIdName+"：下级即时结算成本费率必须大于等于上级成本费率 "+$(this).find("dd [name=t0RateLast]").val()+"%");
	                   	 $(this).focus();
	                        return false;
	            	}
	            	if($(this).find("dd [name=t1Rate]").val()<$(this).find("dd [name=t1RateLast]").val()){
	           		 layer.msg(productIdName+"：下级第二个工作日结算成本费率必须大于等于上级成本费率 "+$(this).find("dd [name=t1RateLast]").val()+"%");
	                  	 $(this).focus();
	                       return false;
	           		}
	            	
	            	if($(this).find("dd [name=t0Rate]").val()<$(this).find("dd [name=t1Rate]").val()){
	               	 layer.msg(productIdName+"：即时结算成本费率必须大于等于隔日结算成本费率");
	               	 $(this).focus();
	                    return false;
	               }
	                var $Form = $(this);
	                if(productIdValue==5 || productIdValue==18){
	                    if($(this).find("dd [name=fixT0Fee]").val() == null || $(this).find("dd [name=fixT0Fee]").val() == ""||$(this).find("dd [name=t0Rate]").val()== null||$(this).find("dd [name=t0Rate]").val()==""){
	                    	 layer.tips("请输入产品手续费或费率",$(this),{
	                             tips: [1, '#3595CC'],
	                             time: 2000
	                         });
	                         $(this).focus();
	                         return false;
	                    }
	                    if(thisChannelLevel!=4&&thisChannelLevel!=3){
		                    if(productIdValue==18){
			                    if(userFeeDf20<$(this).find("dd [name=fixT0Fee]").val()){
			                		layer.msg(productIdName+"：固定手续费必须小于等于C端用户的成本 "+userFeeDf20+"元");
			                      	 $(this).focus();
			                           return false;
			                	}
			                    if(userRate20<$(this).find("dd [name=t0Rate]").val()){
				               		 layer.msg(productIdName+"：即时结算成本费率必须小于等于C端用户的成本费率 "+userRate20+"%");
				                      	 $(this).focus();
				                           return false;
				               		}
		                    }else{
			                    if(userFeeDf19<$(this).find("dd [name=fixT0Fee]").val()){
			                		layer.msg(productIdName+"：固定手续费必须小于等于C端用户的成本 "+userFeeDf19+"元");
			                      	 $(this).focus();
			                           return false;
			                	}
			                    if(userRate19<$(this).find("dd [name=t0Rate]").val()){
				               		 layer.msg(productIdName+"：即时结算成本费率必须小于等于C端用户的成本费率 "+userRate19+"%");
				                      	 $(this).focus();
				                           return false;
				               		}
		                    }
	                    }
	                }else{
	                	if(!xiaoshu.test($(this).find("dd [name=t1Rate]").val())) {
	                		layer.msg('请输入正确第二个工作日结算成本费率!',{icon:2,time:1000});
	                		return false;
	                	}
	                	if($(this).find("dd [name=fixT0Fee]").val() == null || $(this).find("dd [name=fixT0Fee]").val() == ""||$(this).find("dd [name=t0Rate]").val()== null||$(this).find("dd [name=t0Rate]").val()==""||$(this).find("dd [name=t1Rate]").val()==null||$(this).find("dd [name=t1Rate]").val()==""){
	                   	 layer.tips("请输入产品固定手续费或成本费率",$(this),{
	                            tips: [1, '#3595CC'],
	                            time: 2000
	                        });
	                        $(this).focus();
	                        return false;
	                   }
	                }
	                
	                var inputFixT0Fee = $(this).find("dd [name=fixT0Fee]").val();
	                $(this).find("dd [name=fixT0Fee]").val(numMulti(inputFixT0Fee, 100));
	                SubmitFrom($Form);
	                $(this).find("dd [name=fixT0Fee]").val(inputFixT0Fee);
            	}
            }
        });
    }
 
    CloseForm = function () {
    	var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
        location.replace();
    } 
     SubmitFrom = function (from) {
       var data = from.serialize();
        var channelNo = $("input[name=channelNo]").val();
        data = data + "&channelNo=" + channelNo;
        $.post('${basePath}/channel/product/add',data,function (data) {
        	result = data.code;
        	console.info(result);
        });
      if(result == "00"||result == "02"){
          window.parent.location.reload(); 
	   	 layer.msg('操作成功!');
	   }else{
	   	 layer.msg("产品添加失败，请稍后再试！");
	   } 
    } 
    
</script>
</body>
</html>
