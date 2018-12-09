package com.onlinepay.manage.common.baseres;

/**
 * TODO:异步请求基础响应对象
 * Created by tom on 17/7/5.
 */
public abstract class AjaxBaseRes {
    public AjaxBaseRes(){
        this.code = "01";
        this.msg = "系统错误";
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
