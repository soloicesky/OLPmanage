package com.onlinepay.manage.web.util;

/**
 * TODO:
 * Created by tom on 17/7/23.
 */
public class StringUtil{
    private StringUtil(){};

    public static boolean isEmpty(String str){
        if(str == null) return true;
        if(str.equals("")) return true;
        return false;
    }

    /**
     *  判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }
}
