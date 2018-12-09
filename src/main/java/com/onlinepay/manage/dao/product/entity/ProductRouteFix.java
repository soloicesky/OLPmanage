package com.onlinepay.manage.dao.product.entity;

import java.util.Date;

public class ProductRouteFix {
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
    private Long platformId;

    /**
     * 
     */
    private String platformCode;

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
     * @return PLATFORM_ID 
     */
    public Long getPlatformId() {
        return platformId;
    }

    /**
     * 
     * @param platformId 
     */
    public void setPlatformId(Long platformId) {
        this.platformId = platformId;
    }

    /**
     * 
     * @return PLATFORM_CODE 
     */
    public String getPlatformCode() {
        return platformCode;
    }

    /**
     * 
     * @param platformCode 
     */
    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }


    ////////////////表连接查询字段////////////////////////
    private String channelName;
    private String productName;
    private String plantfromName;

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPlantfromName() {
        return plantfromName;
    }

    public void setPlantfromName(String plantfromName) {
        this.plantfromName = plantfromName;
    }
}