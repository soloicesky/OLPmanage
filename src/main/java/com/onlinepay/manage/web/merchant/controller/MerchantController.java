package com.onlinepay.manage.web.merchant.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.IMerchantService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.MerchantApi;
import com.onlinepay.manage.web.channel.res.UpdateStatus;
import com.onlinepay.manage.web.system.enums.LoginEnums;

/**
 * TODO:
 * Created by tom on 17/7/23.
 */
@Controller
@RequestMapping("merchant")
public class MerchantController extends BaseLog<MerchantController> {

    @Autowired
    private IMerchantService merchantService;

    @RequestMapping("list")
    public ModelAndView listPage(){
        log().info("===收到===商户列表查询===");

        return new ModelAndView("merchant/merchant-list");
    }

    @RequestMapping("listdata")
    @ResponseBody
    public JqueryPageInfo<MerchantApi> ajaxMerchant(JqueryPageInfo<MerchantApi> jqueryPageInfo,
                                                    String beginTime,String endTime,String merchantName,String registStatus,String merchantNo,String channelNo,HttpSession session){
        MerchantApi merchantApi = new MerchantApi();
        //登录角色
        System.out.println("分页取数据啊"+jqueryPageInfo.getStart()+"---"+jqueryPageInfo.getLength());
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        try {
            if (beginTime != null && !beginTime.equals("")){
                merchantApi.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(beginTime));
            }
            if (endTime != null && !endTime.equals("")){
                merchantApi.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
            }
            if (merchantName != null && !merchantName.equals("")){
                merchantApi.setMerchantName(merchantName);
            }
            if (registStatus != null && !registStatus.equals("")){
                merchantApi.setRegistStatus(registStatus);
            }
            if (merchantNo != null && !merchantNo.equals("")){
                merchantApi.setMerchantNo(merchantNo);
            }
            if (channelNo != null && !channelNo.equals("")){
                merchantApi.setChannelNo(channelNo);
            }
            System.out.println("012".indexOf(user.getRoleType()));
            if("012".indexOf(user.getRoleType()) < 0){
            	merchantApi.setChannelNo(user.getAdminNo());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JqueryPageInfo<MerchantApi> merchantApiJqueryPageInfo = merchantService.selectByPage(jqueryPageInfo, merchantApi);
        return merchantApiJqueryPageInfo;
    }

    @RequestMapping("alldata")
    @ResponseBody
    public List<MerchantApi> alldata(HttpSession session){
        MerchantApi merchantApi = new MerchantApi();
        System.out.println("取全部数据吗");
        //登录角色
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if("012".indexOf(user.getRoleType()) < 0){
            merchantApi.setChannelNo(user.getAdminNo());
        }
        List<MerchantApi> merchantApis = merchantService.selectByEntity(merchantApi);
        return merchantApis;
    }
    @RequestMapping("update")
    @ResponseBody
    public UpdateStatus updateStatus(MerchantApi merchantApi,String noticeOrderFrontUrl){
        UpdateStatus updateStatus = new UpdateStatus();
        updateStatus.setCode("02");
        updateStatus.setMsg("系统异常！");
        merchantApi.setUpdateDate(new Date());
        int update = merchantService.update(merchantApi);
        if(update == 1){
            updateStatus.setCode("00");
            updateStatus.setMsg("OK");
        }
        return updateStatus;
    }


}
