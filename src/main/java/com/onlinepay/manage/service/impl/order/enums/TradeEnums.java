package com.onlinepay.manage.service.impl.order.enums;

/**
 * TODO:
 * Created by tom on 17/8/21.
 */
public enum TradeEnums {
    TRADE_INIT("1","初始化"),
    TRADE_WAIT("2","待支付"),
    TRADE_SUCCESS("3","成功"),
    TRADE_FINAL("4","失败"),
    TRADE_CANCEL("45","取消"),
    TRADE_UNKNOW("99","未知");

    TradeEnums(String key,String val){
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
            return TRADE_INIT.getVal();
        }
        if(key.equals("2")){
            return TRADE_WAIT.getVal();
        }
        if(key.equals("3")){
            return TRADE_SUCCESS.getVal();
        }
        if(key.equals("4")){
            return TRADE_FINAL.getVal();
        }
        if(key.equals("45")){
            return TRADE_CANCEL.getVal();
        }
        return TRADE_UNKNOW.getVal();
    }
}
