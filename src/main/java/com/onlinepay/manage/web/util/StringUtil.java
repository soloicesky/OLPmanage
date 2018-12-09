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
}
