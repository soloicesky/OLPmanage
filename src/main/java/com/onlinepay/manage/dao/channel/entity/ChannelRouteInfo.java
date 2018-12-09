package com.onlinepay.manage.dao.channel.entity;

import java.util.Date;

public class ChannelRouteInfo {
    /**
     * 主键
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
     * 
     */
    private Long channelId;

    /**
     * 
     */
    private String channelNo;

    /**
     * 
     */
    private Long productId;

    /**
     * 
     */
    private String subProductCode;

    /**
     * 
     */
    private Boolean isFix;

    /**
     * 主键
     * @return ID 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
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
     * 
     * @return CHANNEL_NO 
     */
    public String getChannelNo() {
        return channelNo;
    }

    /**
     * 
     * @param channelNo 
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
     * 
     * @return SUB_PRODUCT_CODE 
     */
    public String getSubProductCode() {
        return subProductCode;
    }

    /**
     * 
     * @param subProductCode 
     */
    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    /**
     * 
     * @return IS_FIX 
     */
    public Boolean getIsFix() {
        return isFix;
    }

    /**
     * 
     * @param isFix 
     */
    public void setIsFix(Boolean isFix) {
        this.isFix = isFix;
    }
}