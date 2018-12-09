package com.onlinepay.manage.web.system.enums;

/**
 * TODO:系统登录常量
 * Created by tom on 17/7/4.
 */
public enum LoginEnums {
    /**
     * 系统登录角色SessionKey
     */
    LOGIN_KEY("SESSION_LOGIN_KEY"),
    /**
     * 验证码SessionKey
     */
    PIC_VERIFICATION_CODE("SESSION_PIC_VERIFICATION_CODE"),

    SECURITY_KEY("37d769e486fa");

    LoginEnums(String value){
        this.key = value;
    }
    private String key;

    public String getKey() {
        return key;
    }

}
