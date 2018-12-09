package com.onlinepay.manage.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * TODO:
 * Created by tom on 17/7/4.
 */
public class HttpRequestUtil {
    private static final Logger log = LoggerFactory.getLogger(HttpRequestUtil.class);
    public static String getContentPath(HttpServletRequest request){
        String requestUrl = request.getRequestURL().toString();
        String requestUri = request.getRequestURI();
        int endIndex =  requestUrl.indexOf(requestUri);
        String path = requestUrl.substring(0,endIndex);
        log.info("Path = {}",request.getContextPath());
        return request.getContextPath();
    }
}
