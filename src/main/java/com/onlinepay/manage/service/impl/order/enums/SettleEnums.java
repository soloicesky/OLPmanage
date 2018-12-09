package com.onlinepay.manage.service.impl.order.enums;

/**
 * TODO:
 * Created by tom on 17/8/21.
 */
public enum SettleEnums {
    SETTLE_INIT("1","未结算"),
    SETTLE_WAIT("2","结算中"),
    SETTLE_SUCCESS("3","结算成功"),
    SETTLE_FINAL("4","结算失败"),
    SETTLE_UNKNOW("99","未知"),

    SETTLE_DO("0","D0"),
    SETTLE_T1("1","T1");

    SettleEnums(String key,String val){
        this.key = key;
        this.val = val;
    }

    private String key;
    private String val;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public static String chooseTradeStatus(String key){
        if(key.equals("1")){
            return SETTLE_INIT.getVal();
        }
        if(key.equals("2")){
            return SETTLE_WAIT.getVal();
        }
        if(key.equals("3")){
            return SETTLE_SUCCESS.getVal();
        }
        if(key.equals("4")){
            return SETTLE_FINAL.getVal();
        }
        return SETTLE_UNKNOW.getVal();
    }

    public static String chooseSettleDay(String key){
        if(key.equals("0")){
            return SETTLE_DO.getVal();
        }
        if(key.equals("1")){
            return SETTLE_T1.getVal();
        }
        return SETTLE_UNKNOW.getVal();
    }
}
