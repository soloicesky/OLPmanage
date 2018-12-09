package com.onlinepay.manage.web.channel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.IChannelService;
import com.onlinepay.manage.service.ISysUserService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.ChannelApi;
import com.onlinepay.manage.web.channel.res.AddResponse;
import com.onlinepay.manage.web.channel.res.UpdateStatus;
import com.onlinepay.manage.web.system.enums.LoginEnums;
import com.onlinepay.manage.web.util.ProjectUtil;

/**
 * TODO:
 * Created by tom on 17/7/23.
 */
@Controller
@RequestMapping("channel")
public class ChannelController extends BaseLog<ChannelController> {

    @Autowired
    private IChannelService channelService;
    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("list")
    public ModelAndView listPage(String id,HttpServletRequest request){
        if(id != null && id != ""){
            ChannelApi channelApi = new ChannelApi();
            channelApi.setId(Long.getLong(id));
            List<ChannelApi> channelApis = channelService.selectByEntity(channelApi);
            request.setAttribute("Channel",channelApis.get(0));
        }
        return new ModelAndView("channel/channel-list");
    }

    @RequestMapping("addpage")
    public ModelAndView addPage(String id){
        ModelAndView mod = new ModelAndView("channel/channel-add");
        if(id!= null && !id.equals("")){
            ChannelApi channelApi = new ChannelApi();
            channelApi.setId(Long.parseLong(id));
            List<ChannelApi> channelApis = channelService.selectByEntity(channelApi);
//            ChannelApi channelApi1 = channelApis.get(0);
//            if(!channelApi1.getConfig().isEmpty()) {
//            	
//            JSONObject jsonObject = JSON.parseObject(channelApi1.getConfig());
//            if(jsonObject.size() == 0){
//                channelApi1.setConfig(null);
//            }else{
//                channelApi1.setConfig(jsonObject.get("noticeOrderUrl").toString());
//                if(jsonObject.getString("noticeOrderFrontUrl")!=null)
//                    mod.addObject("noticeOrderFrontUrl",jsonObject.getString("noticeOrderFrontUrl"));
//            }
//            }
            mod.addObject("Channel",channelApis.get(0));
            mod.addObject("Url","update");
        }else{
            mod.addObject("Url","add");
        }

        return mod;
    }

    @RequestMapping("listdata")
    @ResponseBody
    public JqueryPageInfo<ChannelApi> listData(JqueryPageInfo<ChannelApi> jqueryPageInfo,
            String beginTime,String endTime,String nickName,String channelNo, HttpSession session){
        ChannelApi merchantApi = new ChannelApi();
        try {
            if (beginTime != null && !beginTime.equals("")){
                merchantApi.setCreateDate(new SimpleDateFormat("yyyy-MM-dd").parse(beginTime));
            }
            if (endTime != null && !endTime.equals("")){
                merchantApi.setUpdateDate(new SimpleDateFormat("yyyy-MM-dd").parse(endTime));
            }
            if (nickName != null && !nickName.equals("")){
                merchantApi.setName(nickName);
            }
            if (channelNo != null && !channelNo.equals("")){
                merchantApi.setChannelNo(channelNo);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //登录角色
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if("012".indexOf(user.getRoleType()) < 0){
            merchantApi.setChannelNo(user.getAdminNo());
        }
        JqueryPageInfo<ChannelApi> merchantApiJqueryPageInfo = channelService.selectByPage(jqueryPageInfo, merchantApi);
        return merchantApiJqueryPageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
    public UpdateStatus updateStatus(ChannelApi channelApi){
        UpdateStatus updateStatus = new UpdateStatus();
        updateStatus.setCode("02");
        updateStatus.setMsg("系统异常！");
        channelApi.setUpdateDate(new Date());
//        if(channelApi.getConfig() != null && !channelApi.getConfig().equals("")){
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("noticeOrderUrl",channelApi.getConfig());
//            if(noticeOrderFrontUrl != null && !noticeOrderFrontUrl.equals(""))
//                jsonObject.put("noticeOrderFrontUrl",noticeOrderFrontUrl);
//            channelApi.setConfig(jsonObject.toJSONString());
//        }
        int update = channelService.update(channelApi);
        System.out.println(update);
        if(update == 1){
            updateStatus.setCode("00");
            updateStatus.setMsg("OK");
        }
        return updateStatus;
    }

    @RequestMapping("alldata")
    @ResponseBody
    public List<ChannelApi> allData(HttpSession session){
        ChannelApi pojo = new ChannelApi();
        //登录角色
        AdminUser user = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if("012".indexOf(user.getRoleType()) < 0){
            log().info("获取到渠道号：{}",user.getAdminNo());
            pojo.setChannelNo(user.getAdminNo());
        }
        List<ChannelApi> channelApis = channelService.selectByEntity(pojo);
        return channelApis;
    }

    @RequestMapping("add")
    @ResponseBody
    public AddResponse addChannel(ChannelApi channelApi,String email,String phone,String noticeOrderFrontUrl){
        AddResponse updateStatus = new AddResponse();
        updateStatus.setCode("02");
        updateStatus.setMsg("添加失败！");
        System.out.println(channelApi.getSettleName());
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("noticeOrderUrl",channelApi.getConfig());
//        jsonObject.put("noticeOrderFrontUrl",noticeOrderFrontUrl);
//        channelApi.setConfig(jsonObject.toJSONString());
        String channelNo = channelService.addChannel(channelApi);
        log().info("添加结果：{}",channelNo);
        if(channelNo != null){
            AdminUser adminUser = new AdminUser();
            adminUser.setNickName(channelApi.getName());
            adminUser.setLoginName(email);
            adminUser.setCreateTime(new Date());
            adminUser.setPhone(phone);
            adminUser.setAdminNo(channelNo);
            adminUser.setRoleType("3");
            try{
                adminUser.setLoginPwd(ProjectUtil.gePwd("123abc"));
            }catch (Exception e){
                log().info("MD5加密用户密码异常，信息：" + e.getMessage());
                updateStatus.setCode("04");
                updateStatus.setMsg("系统错误");
            }
            int i = sysUserService.insertAdminUser(adminUser);
            log().info("添加管理员结果：{}",i);
            if(i == 1){
                updateStatus.setCode("00");
                updateStatus.setMsg("OK");
                updateStatus.setChannelNo(channelNo);
            }
        }
        return updateStatus;
    }

    @RequestMapping("choose")
    public ModelAndView chooseChannel(){
        return new ModelAndView("channel/channel-choose");
    }
}
