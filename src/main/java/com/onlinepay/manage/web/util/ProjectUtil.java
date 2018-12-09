package com.onlinepay.manage.web.util;

import com.onlinepay.manage.web.system.enums.LoginEnums;

/**
 * TODO:
 * Created by tom on 17/7/11.
 */
public class ProjectUtil {
    private ProjectUtil(){};

    public static String gePwd(String loginPwd)throws Exception{
        return EncryptUtil.md5Digest(loginPwd + LoginEnums.SECURITY_KEY);
    }

    public static void main(String[] args) {
        try {
            System.out.println(ProjectUtil.gePwd("Liht@9608"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
