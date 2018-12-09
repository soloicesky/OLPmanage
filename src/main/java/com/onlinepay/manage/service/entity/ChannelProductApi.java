package com.onlinepay.manage.service.entity;

import java.util.Date;

public class ChannelProductApi {
    /**
     * 
     */
    private Long id;
    /**
     * 产品名称
     */
    private String productName;

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
     * 
     */
    private Long channelId;

    /**
     * 渠道号
     */
    private String channelNo;

    /**
     * 
     */
    private Long productId;

    /**
     * 子产品编码
     */
    private String subProductCode;

    /**
     * 产品编码
     */
    private String productCode;

    /**
     * T0费率
     */
    private String t0Rate;

    /**
     * T1费率
     */
    private String t1Rate;

    /**
     * T0单笔固定手续费
     */
    private Long fixT0Fee;

    /**
     * 描述
     */
    private String description;

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
     * 
     * @return CHANNEL_ID 
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 
     * @param channelId 
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
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
     * 
     * @return PRODUCT_ID 
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId 
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 子产品编码
     * @return SUB_PRODUCT_CODE 子产品编码
     */
    public String getSubProductCode() {
        return subProductCode;
    }

    /**
     * 子产品编码
     * @param subProductCode 子产品编码
     */
    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    /**
     * 产品编码
     * @return PRODUCT_CODE 产品编码
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 产品编码
     * @param productCode 产品编码
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * T0费率
     * @return T0_RATE T0费率
     */
    public String getT0Rate() {
        return t0Rate;
    }

    /**
     * T0费率
     * @param t0Rate T0费率
     */
    public void setT0Rate(String t0Rate) {
        this.t0Rate = t0Rate;
    }

    /**
     * T1费率
     * @return T1_RATE T1费率
     */
    public String getT1Rate() {
        return t1Rate;
    }

    /**
     * T1费率
     * @param t1Rate T1费率
     */
    public void setT1Rate(String t1Rate) {
        this.t1Rate = t1Rate;
    }

    /**
     * T0单笔固定手续费
     * @return FIX_T0_FEE T0单笔固定手续费
     */
    public Long getFixT0Fee() {
        return fixT0Fee;
    }

    /**
     * T0单笔固定手续费
     * @param fixT0Fee T0单笔固定手续费
     */
    public void setFixT0Fee(Long fixT0Fee) {
        this.fixT0Fee = fixT0Fee;
    }

    /**
     * 描述
     * @return DESCRIPTION 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
    
    
}