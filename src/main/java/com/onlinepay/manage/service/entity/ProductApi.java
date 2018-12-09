package com.onlinepay.manage.service.entity;

import java.util.Date;

public class ProductApi {
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
     * 产品名称
     */
    private String productName;

    /**
     * 产品编码
     */
    private String subProductCode;

    /**
     * 产品组
     */
    private String productCode;

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
     * 产品名称
     * @return PRODUCT_NAME 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 产品名称
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 产品编码
     * @return SUB_PRODUCT_CODE 产品编码
     */
    public String getSubProductCode() {
        return subProductCode;
    }

    /**
     * 产品编码
     * @param subProductCode 产品编码
     */
    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    /**
     * 产品组
     * @return PRODUCT_CODE 产品组
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 产品组
     * @param productCode 产品组
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
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
}