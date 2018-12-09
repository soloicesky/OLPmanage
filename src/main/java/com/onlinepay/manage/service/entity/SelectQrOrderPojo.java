package com.onlinepay.manage.service.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO:订单查询基础条件
 * Created by tom on 17/6/30.
 */
public class SelectQrOrderPojo {
    private String agentNo;
    private String merNo;
    private String tradeType;
    private String tradeNo;
    private String outTradeNo;
    private Date beginTime;
    private Date endTime;
    private String tradeStatus;
    private String channelNo;
    private String channelName;
    private String merchantName;
    private String platformCode;

    
    public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public String getMerNo() {
        return merNo;
    }

    public void setMerNo(String merNo) {
        this.merNo = merNo;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        try {
            this.beginTime = new SimpleDateFormat("yyyy-MM-dd").parse(beginTime);
        } catch (ParseException e) {
            System.out.println("查询条件日期函数转换异常");
            e.printStackTrace();
        }
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        try {
        	System.out.println(endTime);
            this.endTime = new SimpleDateFormat("yyyy-MM-dd").parse(endTime);
        } catch (ParseException e) {
            System.out.println("查询条件日期函数转换异常");
            e.printStackTrace();
        }
    }
}
