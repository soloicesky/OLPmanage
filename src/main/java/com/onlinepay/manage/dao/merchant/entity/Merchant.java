package com.onlinepay.manage.dao.merchant.entity;

import java.util.Date;

public class Merchant {
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
     * 渠道号
     */
    private String channelNo;

    /**
     * 
     */
    private String merchantName;

    /**
     * 商户号
     */
    private String merchantNo;


    /**
     * 商户类型,1企业商户,2事业单位商户,3个体工商户,4个人商户
     */
    private String merchantType;


    /**
     * 法人代表身份证号
     */
    private String accountPersonId;

    /**
     * 商户联系人电话
     */
    private String accountPersonPhone;

    /**
     * 结算账户性质,1对公,2对私
     */
    private String bankType;

    /**
     * 开户名称
     */
    private String accountName;

    /**
     * 开户账号
     */
    private String accountNo;

    /**
     * 开户银行名（大行全称）
     */
    private String bankName;

    /**
     * 联行号
     */
    private String bankCode;

    /**
     * 注册时间
     */
    private Date registDate;

    /**
     * 注册状态：10审核中，20成功，30失败, 90废弃
     */
    private String registStatus;

    /**
     * 启用标识,0未启用,1启用
     */
    private Boolean enabled;

    /**
     * 
     */
    private String postId;

    /**
     * 费率配置
     */
    private String rateConfig;

    public String getRateConfig() {
		return rateConfig;
	}

	public void setRateConfig(String rateConfig) {
		this.rateConfig = rateConfig;
	}

	private String name;//渠道名称
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
     * @return MERCHANT_NAME 
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 
     * @param merchantName 
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getAccountPersonId() {
		return accountPersonId;
	}

	public void setAccountPersonId(String accountPersonId) {
		this.accountPersonId = accountPersonId;
	}

	public String getAccountPersonPhone() {
		return accountPersonPhone;
	}

	public void setAccountPersonPhone(String accountPersonPhone) {
		this.accountPersonPhone = accountPersonPhone;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}


	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public String getRegistStatus() {
		return registStatus;
	}

	public void setRegistStatus(String registStatus) {
		this.registStatus = registStatus;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

}