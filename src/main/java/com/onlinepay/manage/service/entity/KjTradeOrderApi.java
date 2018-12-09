package com.onlinepay.manage.service.entity;

import java.util.Date;

public class KjTradeOrderApi {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Date createDate;

    /**
     * 
     */
    private Date updateDate;

    /**
     * 
     */
    private Long version;

    /**
     * 上游平台编码
     */
    private String platformCode;

    /**
     * 上游平台订单号
     */
    private String platformOrderNo;

    /**
     * 渠道号
     */
    private String channelNo;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 交易金额
     */
    private Long amount;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 下游渠道订单号
     */
    private String applyOrderNo;

    /**
     * 商品描述
     */
    private String goodsname;

    /**
     * 付款人卡号
     */
    private String payerAccountNo;

    /**
     * 付款人卡号对应身份证号
     */
    private String payerPersonId;

    /**
     * 付款人手机号
     */
    private String payerPhone;

    /**
     * 结算类型，0T0，1T1
     */
    private String settleType;

    /**
     * 短信验证码
     */
    private String smsCode;

    /**
     * 状态：1初始化，2待支付，21待确认，3成功，4失败，45取消，99未知
     */
    private String tradeStatus;

    /**
     * 结算状态：1未结算，2结算中，3结算成功，4结算失败,99未知
     */
    private String settleStatus;

    /**
     * 用户支付ip
     */
    private String orderIp;
    /**
     * 返回错误信息notes
     */
    private String notes;

    /**
     * 
     */
    private Date tradeDate;

    /**
     * 
     */
    private Date platformTradeDate;

    /**
     * 
     */
    private Date noticeDate;

    /**
     * 通知状态：10初始化,20上游通知成功,30通知下游成功,40通知下游失败
     */
    private String noticeStatus;

    /**
     * 上游平台商户号
     */
    private String platformMerchantNo;

    /**
     * 商户手续费（交易金额*商户手续费率）
     */
    private Long merchantFee;

    /**
     * 渠道分润（交易金额*（商户手续费率-渠道手续费率））
     */
    private Long channelFee;

    /**
     * 通道成本手续费（交易金额*通道成本费率）
     */
    private Long platformFee;

    /**
     * 单笔固定手续费
     */
    private Long fixFee;

    public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
     * 
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 
     * @return CREATE_DATE 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return UPDATE_DATE 
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 
     * @param updateDate 
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 
     * @return VERSION 
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 
     * @param version 
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 上游平台编码
     * @return PLATFORM_CODE 上游平台编码
     */
    public String getPlatformCode() {
        return platformCode;
    }

    /**
     * 上游平台编码
     * @param platformCode 上游平台编码
     */
    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    /**
     * 上游平台订单号
     * @return PLATFORM_ORDER_NO 上游平台订单号
     */
    public String getPlatformOrderNo() {
        return platformOrderNo;
    }

    /**
     * 上游平台订单号
     * @param platformOrderNo 上游平台订单号
     */
    public void setPlatformOrderNo(String platformOrderNo) {
        this.platformOrderNo = platformOrderNo;
    }

    /**
     * 渠道号
     * @return CHANNEL_NO 渠道号
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 渠道号
     * @param channelNo 渠道号
     */
    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    /**
     * 商户号
     * @return MERCHANT_NO 商户号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 商户号
     * @param merchantNo 商户号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * 交易金额
     * @return AMOUNT 交易金额
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * 交易金额
     * @param amount 交易金额
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    /**
     * 订单号
     * @return ORDER_NO 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 下游渠道订单号
     * @return APPLY_ORDER_NO 下游渠道订单号
     */
    public String getApplyOrderNo() {
        return applyOrderNo;
    }

    /**
     * 下游渠道订单号
     * @param applyOrderNo 下游渠道订单号
     */
    public void setApplyOrderNo(String applyOrderNo) {
        this.applyOrderNo = applyOrderNo;
    }

    /**
     * 商品描述
     * @return GOODSNAME 商品描述
     */
    public String getGoodsname() {
        return goodsname;
    }

    /**
     * 商品描述
     * @param goodsname 商品描述
     */
    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    /**
     * 付款人卡号
     * @return PAYER_ACCOUNT_NO 付款人卡号
     */
    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    /**
     * 付款人卡号
     * @param payerAccountNo 付款人卡号
     */
    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo;
    }

    /**
     * 付款人卡号对应身份证号
     * @return PAYER_PERSON_ID 付款人卡号对应身份证号
     */
    public String getPayerPersonId() {
        return payerPersonId;
    }

    /**
     * 付款人卡号对应身份证号
     * @param payerPersonId 付款人卡号对应身份证号
     */
    public void setPayerPersonId(String payerPersonId) {
        this.payerPersonId = payerPersonId;
    }

    /**
     * 付款人手机号
     * @return PAYER_PHONE 付款人手机号
     */
    public String getPayerPhone() {
        return payerPhone;
    }

    /**
     * 付款人手机号
     * @param payerPhone 付款人手机号
     */
    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    /**
     * 结算类型，0T0，1T1
     * @return SETTLE_TYPE 结算类型，0T0，1T1
     */
    public String getSettleType() {
        return settleType;
    }

    /**
     * 结算类型，0T0，1T1
     * @param settleType 结算类型，0T0，1T1
     */
    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    /**
     * 短信验证码
     * @return SMS_CODE 短信验证码
     */
    public String getSmsCode() {
        return smsCode;
    }

    /**
     * 短信验证码
     * @param smsCode 短信验证码
     */
    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    /**
     * 状态：1初始化，2待支付，21待确认，3成功，4失败，45取消，99未知
     * @return TRADE_STATUS 状态：1初始化，2待支付，21待确认，3成功，4失败，45取消，99未知
     */
    public String getTradeStatus() {
        return tradeStatus;
    }

    /**
     * 状态：1初始化，2待支付，21待确认，3成功，4失败，45取消，99未知
     * @param tradeStatus 状态：1初始化，2待支付，21待确认，3成功，4失败，45取消，99未知
     */
    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus;
    }

    /**
     * 结算状态：1未结算，2结算中，3结算成功，4结算失败,99未知
     * @return SETTLE_STATUS 结算状态：1未结算，2结算中，3结算成功，4结算失败,99未知
     */
    public String getSettleStatus() {
        return settleStatus;
    }

    /**
     * 结算状态：1未结算，2结算中，3结算成功，4结算失败,99未知
     * @param settleStatus 结算状态：1未结算，2结算中，3结算成功，4结算失败,99未知
     */
    public void setSettleStatus(String settleStatus) {
        this.settleStatus = settleStatus;
    }

    /**
     * 用户支付ip
     * @return ORDER_IP 用户支付ip
     */
    public String getOrderIp() {
        return orderIp;
    }

    /**
     * 用户支付ip
     * @param orderIp 用户支付ip
     */
    public void setOrderIp(String orderIp) {
        this.orderIp = orderIp;
    }

    /**
     * 
     * @return TRADE_DATE 
     */
    public Date getTradeDate() {
        return tradeDate;
    }

    /**
     * 
     * @param tradeDate 
     */
    public void setTradeDate(Date tradeDate) {
        this.tradeDate = tradeDate;
    }

    /**
     * 
     * @return PLATFORM_TRADE_DATE 
     */
    public Date getPlatformTradeDate() {
        return platformTradeDate;
    }

    /**
     * 
     * @param platformTradeDate 
     */
    public void setPlatformTradeDate(Date platformTradeDate) {
        this.platformTradeDate = platformTradeDate;
    }

    /**
     * 
     * @return NOTICE_DATE 
     */
    public Date getNoticeDate() {
        return noticeDate;
    }

    /**
     * 
     * @param noticeDate 
     */
    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    /**
     * 通知状态：10初始化,20上游通知成功,30通知下游成功,40通知下游失败
     * @return NOTICE_STATUS 通知状态：10初始化,20上游通知成功,30通知下游成功,40通知下游失败
     */
    public String getNoticeStatus() {
        return noticeStatus;
    }

    /**
     * 通知状态：10初始化,20上游通知成功,30通知下游成功,40通知下游失败
     * @param noticeStatus 通知状态：10初始化,20上游通知成功,30通知下游成功,40通知下游失败
     */
    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus;
    }

    /**
     * 上游平台商户号
     * @return PLATFORM_MERCHANT_NO 上游平台商户号
     */
    public String getPlatformMerchantNo() {
        return platformMerchantNo;
    }

    /**
     * 上游平台商户号
     * @param platformMerchantNo 上游平台商户号
     */
    public void setPlatformMerchantNo(String platformMerchantNo) {
        this.platformMerchantNo = platformMerchantNo;
    }

    /**
     * 商户手续费（交易金额*商户手续费率）
     * @return MERCHANT_FEE 商户手续费（交易金额*商户手续费率）
     */
    public Long getMerchantFee() {
        return merchantFee;
    }

    /**
     * 商户手续费（交易金额*商户手续费率）
     * @param merchantFee 商户手续费（交易金额*商户手续费率）
     */
    public void setMerchantFee(Long merchantFee) {
        this.merchantFee = merchantFee;
    }

    /**
     * 渠道分润（交易金额*（商户手续费率-渠道手续费率））
     * @return CHANNEL_FEE 渠道分润（交易金额*（商户手续费率-渠道手续费率））
     */
    public Long getChannelFee() {
        return channelFee;
    }

    /**
     * 渠道分润（交易金额*（商户手续费率-渠道手续费率））
     * @param channelFee 渠道分润（交易金额*（商户手续费率-渠道手续费率））
     */
    public void setChannelFee(Long channelFee) {
        this.channelFee = channelFee;
    }

    /**
     * 通道成本手续费（交易金额*通道成本费率）
     * @return PLATFORM_FEE 通道成本手续费（交易金额*通道成本费率）
     */
    public Long getPlatformFee() {
        return platformFee;
    }

    /**
     * 通道成本手续费（交易金额*通道成本费率）
     * @param platformFee 通道成本手续费（交易金额*通道成本费率）
     */
    public void setPlatformFee(Long platformFee) {
        this.platformFee = platformFee;
    }

    /**
     * 单笔固定手续费
     * @return FIX_FEE 单笔固定手续费
     */
    public Long getFixFee() {
        return fixFee;
    }

    /**
     * 单笔固定手续费
     * @param fixFee 单笔固定手续费
     */
    public void setFixFee(Long fixFee) {
        this.fixFee = fixFee;
    }

    //////////////以下为条件查询时使用属性//////////////////

    private String channelName;
    private String merchantName;

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
}