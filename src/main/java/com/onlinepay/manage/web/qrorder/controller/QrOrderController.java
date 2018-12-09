package com.onlinepay.manage.web.qrorder.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.IMerchantService;
import com.onlinepay.manage.service.IWxOrAliOrderService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.MerchantApi;
import com.onlinepay.manage.service.entity.SelectQrOrderPojo;
import com.onlinepay.manage.service.entity.WxOrAliOrder;
import com.onlinepay.manage.web.qrorder.util.ExcelUitl;
import com.onlinepay.manage.web.system.enums.LoginEnums;
import com.onlinepay.manage.web.util.AmountUtils;
import com.onlinepay.manage.web.util.StringUtil;

/**
 * TODO:
 * Created by tom on 17/7/21.
 */
@Controller
@RequestMapping("qr/trade")
public class QrOrderController extends BaseLog<QrOrderController> {

    @Autowired
    private IWxOrAliOrderService wxOrAliOrderService;
    @Autowired
    private IMerchantService merchantService;

    @RequestMapping("page")
    public ModelAndView page(HttpServletRequest request,HttpSession session){
        log().info("===收到===订单页面请求===");
        MerchantApi merchantApi = new MerchantApi();
        //登录角色
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if(user.getRoleType().indexOf("012") < 0){
            merchantApi.setChannelNo(user.getAdminNo());
        }
        List<MerchantApi> merchantApis = merchantService.selectByEntity(merchantApi);
        request.setAttribute("li",merchantApis);
        return new ModelAndView("order/order-list");
    }

    @RequestMapping("list")
    @ResponseBody
    public JqueryPageInfo<WxOrAliOrder> list(JqueryPageInfo<WxOrAliOrder> jqPage, SelectQrOrderPojo pojo, HttpSession session){
        //登录角色
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if("012".indexOf(user.getRoleType()) < 0){
            pojo.setAgentNo(user.getAdminNo());
            pojo.setChannelNo(user.getAdminNo());
        }
        log().info("===收到===订单列表查询请求===");
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

        JqueryPageInfo<WxOrAliOrder> wxOrAliOrderJqueryPageInfo = wxOrAliOrderService.selectByPage(jqPage, pojo);
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
        List<WxOrAliOrder> wxOrAliOrders = wxOrAliOrderService.exportExcl(pojo);
        List<Map<String, String>> maps = wxOrAliOrderService.selectGroup(pojo);
        //导出Excel表格功能
        if (wxOrAliOrders != null && wxOrAliOrders.size()>0){
            
            LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
            fieldMap.put("channelName","代理商名称");
            fieldMap.put("channelNo","代理商户号");
            fieldMap.put("merchantName","商户名称");
            fieldMap.put("merchantNo","商户号");
            fieldMap.put("applyOrderNo","商户订单号");
            fieldMap.put("orderNo","系统订单号");
            fieldMap.put("amount","交易金额(单位/分)");
            fieldMap.put("createDate","交易日期");
            fieldMap.put("tradeType","订单类型");
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
        Map<String,Object> map = new HashMap<>();
        map.put("10",0);
        map.put("11",0);
        map.put("20",0);
        map.put("21",0);

        map.put("count_10",0);
        map.put("count_11",0);
        map.put("count_20",0);
        map.put("count_21",0);
        if(!li_map.isEmpty() && li_map.size()!=0){
            for (Map<String, String> m : li_map) {
                try {
                    map.put(m.get("TRADE_TYPE"), AmountUtils.changeF2Y(String.valueOf(m.get("CLOSUM"))));
                    map.put("count_"+ m.get("TRADE_TYPE"), StringUtils.isEmpty(m.get("CLOCOUNT"))?0:m.get("CLOCOUNT"));
                }  catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("微信总笔数", map.get("count_10").toString());
        fieldMap.put("微信总额(单位:元)", map.get("10").toString());

        fieldMap.put("微信公众号总笔数", map.get("count_11").toString());
        fieldMap.put("微信公众号总额(单位:元)", map.get("11").toString());

        fieldMap.put("支付宝总笔数", map.get("count_20").toString());
        fieldMap.put("支付宝(单位:元)", map.get("20").toString());

        fieldMap.put("支付宝笔数", map.get("count_21").toString());
        fieldMap.put("支付宝服务窗总额(单位:元)", map.get("21").toString());

        return fieldMap;
    }
}
