package com.onlinepay.manage.web.system.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.common.baseres.AjaxBaseRes;
import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.service.ISysMenuService;
import com.onlinepay.manage.service.ISysUserService;
import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.ShowSysMenu;
import com.onlinepay.manage.web.system.enums.LoginEnums;
import com.onlinepay.manage.web.system.res.LoginResponse;
import com.onlinepay.manage.web.util.ProjectUtil;
import com.onlinepay.manage.web.util.SecurityCode;

/**
 * TODO:商户后台管理系统登录控制层
 * Created by tom on 17/6/21.
 */
@Controller
@RequestMapping("")
public class LoginController extends BaseLog<LoginController> {

    @Autowired
    private ISysUserService loginService;
    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 显示登录界面
     * @return
     */
    @RequestMapping("")
    public ModelAndView loginPage(){
        log().info("访问登录页面");
        return new ModelAndView("system/login");
    }
    /**
     * 显示系统主界面
     * @return
     */
    @RequestMapping("main")
    public ModelAndView mainPage(HttpSession session, HttpServletRequest request){
        log().info("系统主页面");
        AdminUser adminUser = (AdminUser)session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        Map<String,List<ShowSysMenu>> showSysMenus = sysMenuService.selectMenu(adminUser);
        System.out.println(showSysMenus.isEmpty());
        request.setAttribute("MenuMap",showSysMenus);
        return new ModelAndView("system/main");
    }
    /**
     * 系统登录方法
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxBaseRes login(AdminUser adminUser, String vaditCode, HttpSession session){
        LoginResponse response = new LoginResponse();
        String code = (String)session.getAttribute(LoginEnums.PIC_VERIFICATION_CODE.getKey());
        if(vaditCode.isEmpty() || !code.equals(vaditCode)){
            response.setCode("02");
            response.setMsg("验证码错误");
            return response;
        }
        String loginPwd = null;
        try{
            loginPwd = ProjectUtil.gePwd(adminUser.getLoginPwd());
        }catch (Exception e){
            log().info("MD5加密用户密码异常，信息：" + e.getMessage());
            response.setCode("04");
            response.setMsg("系统错误");
        }
        adminUser.setLoginPwd(loginPwd);
        adminUser = loginService.selectLoginInfo(adminUser);
        if (adminUser == null){
        	code = SecurityCode.getSecurityCode();
            session.setAttribute(LoginEnums.PIC_VERIFICATION_CODE.getKey(), code);
            // 利用图片工具生成图片
//            BufferedImage image = SecurityImage.createImage(code);
//            OutputStream os = response.getOutputStream();
//            ImageIO.write(image, "png", os);
            response.setCode("03");
            response.setMsg("账号或密码错误");
            return response;
        }else{
            session.setAttribute(LoginEnums.LOGIN_KEY.getKey(),adminUser);
            response.setCode("00");
            response.setMsg("OK");
        }
        return response;
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session){
        session.removeAttribute(LoginEnums.LOGIN_KEY.getKey());
        return new ModelAndView("system/login");
    }

}
