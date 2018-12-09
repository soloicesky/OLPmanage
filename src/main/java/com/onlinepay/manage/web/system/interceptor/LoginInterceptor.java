package com.onlinepay.manage.web.system.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.web.system.enums.LoginEnums;
import com.onlinepay.manage.web.util.HttpRequestUtil;

/**
 * TODO:后台管理系统登录拦截器
 * Created by tom on 17/6/22.
 */
public class LoginInterceptor implements HandlerInterceptor{
    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
    /**
     * 访问拦截
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //检测用户是否登录
        HttpSession session = request.getSession();
        AdminUser u = (AdminUser) session.getAttribute(LoginEnums.LOGIN_KEY.getKey());
        if (u == null){
            redirect(request,response);
            return false;
        }
        return true;
    }

    /**
     * 前置拦截
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * 后置拦截
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    private void redirect(HttpServletRequest request, HttpServletResponse response){
        log.info("请求地址：" + request.getRequestURL());
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.println("<html>");
            out.println("<script>");
            out.println("window.top.location.href= '"+HttpRequestUtil.getContentPath(request)+"'");
            out.println("</script>");
            out.println("</html>");
        } catch (IOException e) {
            log.info("获取response writer 异常，信息：" + e.getMessage());
        }

    }
}
