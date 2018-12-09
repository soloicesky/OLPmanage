package com.onlinepay.manage.web.qrorder.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.IQuickOrderService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.KjTradeOrderApi;
import com.onlinepay.manage.service.entity.SelectQrOrderPojo;
import com.onlinepay.manage.web.qrorder.util.ExcelUitl;
import com.onlinepay.manage.web.system.enums.LoginEnums;
import com.onlinepay.manage.web.util.AmountUtils;
import com.onlinepay.manage.web.util.StringUtil;

/**
 * TODO:
 * Created by tom on 17/9/6.
 */
@Controller
@RequestMapping("nb/quick/order")
public class NBOrderController extends BaseLog<NBOrderController> {


    @RequestMapping("page")
    public ModelAndView page(){
        return new ModelAndView("order/nb-order-list");
    }
    @Autowired
    private IQuickOrderService quickOrderService;

    @RequestMapping("list")
    @ResponseBody
    public JqueryPageInfo<KjTradeOrderApi> list(JqueryPageInfo<KjTradeOrderApi> jqPage, SelectQrOrderPojo pojo, HttpSession session){
        //登录角色
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if("012".indexOf(user.getRoleType()) < 0){
            pojo.setAgentNo(user.getAdminNo());
            pojo.setChannelNo(user.getAdminNo());
        }
        jqPage.setStart((jqPage.getStart() -1)*jqPage.getLength());
        log().info("===收到===订单列表查询请求===");
        System.out.println(pojo.getEndTime());
        if(StringUtil.isEmpty(pojo.getMerNo()) || pojo.getMerNo().equals("0")){
            pojo.setMerNo(null);
        }
        if(StringUtil.isEmpty(pojo.getTradeNo())){
            pojo.setTradeNo(null);
        }
        if(StringUtil.isEmpty(pojo.getOutTradeNo())){
            pojo.setOutTradeNo(null);
        }
        if(StringUtil.isEmpty(pojo.getTradeType()) || pojo.getTradeType().equals("00")){
            pojo.setTradeType(null);
        }
        if(StringUtil.isEmpty(pojo.getTradeStatus()) || pojo.getTradeStatus().equals("0")){
            pojo.setTradeStatus(null);
        }

        if(StringUtil.isEmpty(pojo.getChannelNo())){
            pojo.setChannelNo(null);
        }
        if(StringUtil.isEmpty(pojo.getChannelName())){
            pojo.setChannelName(null);
        }
        if(StringUtil.isEmpty(pojo.getMerchantName())){
            pojo.setMerchantName(null);
        }
            if(StringUtil.isEmpty(pojo.getPlatformCode()) || pojo.getPlatformCode().equals("0")){
            pojo.setPlatformCode(null);
        }
        JqueryPageInfo<KjTradeOrderApi> wxOrAliOrderJqueryPageInfo = quickOrderService.selectByPage(jqPage, pojo);
        return wxOrAliOrderJqueryPageInfo;
    }
    @RequestMapping("/exportExcel")
    @ResponseBody
    public void exportExcel(SelectQrOrderPojo pojo, HttpSession session, HttpServletResponse response){
        //登录角色
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        StringBuffer sb = new StringBuffer();
        if("012".indexOf(user.getRoleType()) < 0){
            pojo.setAgentNo(user.getAdminNo());
            sb.append(user.getAdminNo() + "_Trade_");
        }else{
            sb.append(pojo.getChannelNo() + "_Trade_");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sb.append(sdf.format(pojo.getBeginTime())+"_"+sdf.format(pojo.getEndTime()));
        log().info("===收到===导出Excel表格请求===");
        if(StringUtil.isEmpty(pojo.getMerNo()) || pojo.getMerNo().equals("0")){
            pojo.setMerNo(null);
        }
        if(StringUtil.isEmpty(pojo.getTradeNo())){
            pojo.setTradeNo(null);
        }
        if(StringUtil.isEmpty(pojo.getOutTradeNo())){
            pojo.setOutTradeNo(null);
        }
        if(StringUtil.isEmpty(pojo.getTradeType()) || pojo.getTradeType().equals("00")){
            pojo.setTradeType(null);
        }
        if(StringUtil.isEmpty(pojo.getTradeStatus()) || pojo.getTradeStatus().equals("0")){
            pojo.setTradeStatus(null);
        }
        if(StringUtil.isEmpty(pojo.getChannelNo())){
            pojo.setChannelNo(null);
        }
        if(StringUtil.isEmpty(pojo.getChannelName())){
            pojo.setChannelName(null);
        }
        if(StringUtil.isEmpty(pojo.getMerchantName())){
            pojo.setMerchantName(null);
        }
        if(StringUtil.isEmpty(pojo.getPlatformCode()) || pojo.getPlatformCode().equals("0")){
            pojo.setPlatformCode(null);
        }
        List<KjTradeOrderApi> wxOrAliOrders = quickOrderService.exportExcl(pojo);
        List<Map<String, String>> maps = quickOrderService.selectGroup(pojo);
        //导出Excel表格功能
        if (wxOrAliOrders != null && wxOrAliOrders.size()>0){

            LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
            fieldMap.put("platformCode","上游平台编码 ");
            fieldMap.put("channelName","代理商名称");
            fieldMap.put("channelNo","代理商户号");
            fieldMap.put("merchantName","商户名称");
            fieldMap.put("merchantNo","商户号");
            fieldMap.put("applyOrderNo","商户订单号");
            fieldMap.put("orderNo","系统订单号");
            fieldMap.put("amount","交易金额(单位/元)");
            fieldMap.put("merchantFee","交易手续费(单位/元)");
            fieldMap.put("channelFee","渠道分润(单位/元)");
            fieldMap.put("createDate","交易日期");
            fieldMap.put("settleType","结算周期");
            fieldMap.put("tradeStatus","支付状态");
            fieldMap.put("settleStatus","结算状态");

            //汇总字段：
            LinkedHashMap<String, String> totalMap = totalMap(maps);

            ExcelUitl.listToExcel(wxOrAliOrders, fieldMap, sb.toString(),totalMap,null,response);

        }else{
            try {
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print("获取订单信息失败或订单信息为空，请稍后重试。");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    private LinkedHashMap<String, String> totalMap(List<Map<String, String>> li_map) {

        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("快捷交易笔数", li_map.get(0).get("CLOCOUNT").toString());
        try {
        	fieldMap.put("快捷交易总额(单位:元)", AmountUtils.changeF2Y(Long.valueOf(li_map.get(0).get("CLOSUM").toString())));
			fieldMap.put("总交易手续费(单位:元)", AmountUtils.changeF2Y(Long.valueOf(li_map.get(0).get("SUM_MERCHANT_FEE").toString())));
			fieldMap.put("总渠道分润(单位:元)", AmountUtils.changeF2Y(Long.valueOf(li_map.get(0).get("SUM_CHANNEL_FEE"))));
			fieldMap.put("我司分润(单位:元)",AmountUtils.changeF2Y(Long.valueOf((Integer.parseInt(li_map.get(0).get("SUM_MERCHANT_FEE").toString())-
					Integer.parseInt(li_map.get(0).get("SUM_CHANNEL_FEE").toString())-
					Integer.parseInt(li_map.get(0).get("SUM_PLATFORM_FEE").toString()))+"")));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return fieldMap;
    }
}
