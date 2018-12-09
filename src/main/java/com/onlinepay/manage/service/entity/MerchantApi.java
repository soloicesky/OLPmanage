package com.onlinepay.manage.service.entity;

import java.util.Date;

public class MerchantApi {
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
     * 
     */
    private String billMerchantName;

    /**
     * 商户号
     */
    private String merchantNo;

    /**
     * 安装归属省
     */
    private String installProvince;

    /**
     * 安装归属市
     */
    private String installCity;

    /**
     * 安装归属县（区）
     */
    private String installCountry;

    /**
     * 经营地址
     */
    private String operateAddress;

    /**
     * 商户类型,1企业商户,2事业单位商户,3个体工商户,4个人商户
     */
    private String merchantType;

    /**
     * 营业执照号码
     */
    private String businessLicense;

    /**
     * 法人代表姓名
     */
    private String legalPersonName;

    /**
     * 法人代表身份证号
     */
    private String accountPersonId;

    /**
     * 商户联系人姓名
     */
    private String merchantPersonName;

    /**
     * 商户联系人电话
     */
    private String accountPersonPhone;

    /**
     * 商户联系人邮箱
     */
    private String merchantPersonEmail;

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
     * 开户行省
     */
    private String bankProv;

    /**
     * 开户行市
     */
    private String bankCity;

    /**
     * 开户银行名称（精确到支行）
     */
    private String bankBranch;

    /**
     * 联行号
     */
    private String bankCode;

    /**
     * 结算人信用卡
     */
    private String creditCardNo;

    /**
     * 备注
     */
    private String remarks;

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
    private String fixT0Fee;
    private String fixT1Fee;
    /**
     * 
     */
    private String t0Rate;
    /**
     * 
     */
    private String t1Rate;
    /**
     * 费率配置
     */
    private String rateConfig;
    /**
     * 
     */
    private String postId;
    
    public String getFixT1Fee() {
		return fixT1Fee;
	}

	public void setFixT1Fee(String fixT1Fee) {
		this.fixT1Fee = fixT1Fee;
	}

	public String getFixT0Fee() {
		return fixT0Fee;
	}

	public void setFixT0Fee(String fixT0Fee) {
		this.fixT0Fee = fixT0Fee;
	}

	public String getT0Rate() {
		return t0Rate;
	}

	public void setT0Rate(String t0Rate) {
		this.t0Rate = t0Rate;
	}

	public String getT1Rate() {
		return t1Rate;
	}

	public void setT1Rate(String t1Rate) {
		this.t1Rate = t1Rate;
	}

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

    /**
     * 
     * @return BILL_MERCHANT_NAME 
     */
    public String getBillMerchantName() {
        return billMerchantName;
    }

    /**
     * 
     * @param billMerchantName 
     */
    public void setBillMerchantName(String billMerchantName) {
        this.billMerchantName = billMerchantName;
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
     * 安装归属省
     * @return INSTALL_PROVINCE 安装归属省
     */
    public String getInstallProvince() {
        return installProvince;
    }

    /**
     * 安装归属省
     * @param installProvince 安装归属省
     */
    public void setInstallProvince(String installProvince) {
        this.installProvince = installProvince;
    }

    /**
     * 安装归属市
     * @return INSTALL_CITY 安装归属市
     */
    public String getInstallCity() {
        return installCity;
    }

    /**
     * 安装归属市
     * @param installCity 安装归属市
     */
    public void setInstallCity(String installCity) {
        this.installCity = installCity;
    }

    /**
     * 安装归属县（区）
     * @return INSTALL_COUNTRY 安装归属县（区）
     */
    public String getInstallCountry() {
        return installCountry;
    }

    /**
     * 安装归属县（区）
     * @param installCountry 安装归属县（区）
     */
    public void setInstallCountry(String installCountry) {
        this.installCountry = installCountry;
    }

    /**
     * 经营地址
     * @return OPERATE_ADDRESS 经营地址
     */
    public String getOperateAddress() {
        return operateAddress;
    }

    /**
     * 经营地址
     * @param operateAddress 经营地址
     */
    public void setOperateAddress(String operateAddress) {
        this.operateAddress = operateAddress;
    }

    /**
     * 商户类型,1企业商户,2事业单位商户,3个体工商户,4个人商户
     * @return MERCHANT_TYPE 商户类型,1企业商户,2事业单位商户,3个体工商户,4个人商户
     */
    public String getMerchantType() {
        return merchantType;
    }

    /**
     * 商户类型,1企业商户,2事业单位商户,3个体工商户,4个人商户
     * @param merchantType 商户类型,1企业商户,2事业单位商户,3个体工商户,4个人商户
     */
    public void setMerchantType(String merchantType) {
        this.merchantType = merchantType;
    }

    /**
     * 营业执照号码
     * @return BUSINESS_LICENSE 营业执照号码
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 营业执照号码
     * @param businessLicense 营业执照号码
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * 法人代表姓名
     * @return LEGAL_PERSON_NAME 法人代表姓名
     */
    public String getLegalPersonName() {
        return legalPersonName;
    }

    /**
     * 法人代表姓名
     * @param legalPersonName 法人代表姓名
     */
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }


    public String getAccountPersonId() {
		return accountPersonId;
	}

	public void setAccountPersonId(String accountPersonId) {
		this.accountPersonId = accountPersonId;
	}

	/**
     * 商户联系人姓名
     * @return MERCHANT_PERSON_NAME 商户联系人姓名
     */
    public String getMerchantPersonName() {
        return merchantPersonName;
    }

    /**
     * 商户联系人姓名
     * @param merchantPersonName 商户联系人姓名
     */
    public void setMerchantPersonName(String merchantPersonName) {
        this.merchantPersonName = merchantPersonName;
    }


    public String getAccountPersonPhone() {
		return accountPersonPhone;
	}

	public void setAccountPersonPhone(String accountPersonPhone) {
		this.accountPersonPhone = accountPersonPhone;
	}

	/**
     * 商户联系人邮箱
     * @return MERCHANT_PERSON_EMAIL 商户联系人邮箱
     */
    public String getMerchantPersonEmail() {
        return merchantPersonEmail;
    }

    /**
     * 商户联系人邮箱
     * @param merchantPersonEmail 商户联系人邮箱
     */
    public void setMerchantPersonEmail(String merchantPersonEmail) {
        this.merchantPersonEmail = merchantPersonEmail;
    }

    /**
     * 结算账户性质,1对公,2对私
     * @return BANK_TYPE 结算账户性质,1对公,2对私
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * 结算账户性质,1对公,2对私
     * @param bankType 结算账户性质,1对公,2对私
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * 开户名称
     * @return ACCOUNT_NAME 开户名称
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 开户名称
     * @param accountName 开户名称
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * 开户账号
     * @return ACCOUNT_NO 开户账号
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * 开户账号
     * @param accountNo 开户账号
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * 开户银行名（大行全称）
     * @return BANK_NAME 开户银行名（大行全称）
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 开户银行名（大行全称）
     * @param bankName 开户银行名（大行全称）
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * 开户行省
     * @return BANK_PROV 开户行省
     */
    public String getBankProv() {
        return bankProv;
    }

    /**
     * 开户行省
     * @param bankProv 开户行省
     */
    public void setBankProv(String bankProv) {
        this.bankProv = bankProv;
    }

    /**
     * 开户行市
     * @return BANK_CITY 开户行市
     */
    public String getBankCity() {
        return bankCity;
    }

    /**
     * 开户行市
     * @param bankCity 开户行市
     */
    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    /**
     * 开户银行名称（精确到支行）
     * @return BANK_BRANCH 开户银行名称（精确到支行）
     */
    public String getBankBranch() {
        return bankBranch;
    }

    /**
     * 开户银行名称（精确到支行）
     * @param bankBranch 开户银行名称（精确到支行）
     */
    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    /**
     * 联行号
     * @return BANK_CODE 联行号
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * 联行号
     * @param bankCode 联行号
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * 结算人信用卡
     * @return CREDIT_CARD_NO 结算人信用卡
     */
    public String getCreditCardNo() {
        return creditCardNo;
    }

    /**
     * 结算人信用卡
     * @param creditCardNo 结算人信用卡
     */
    public void setCreditCardNo(String creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    /**
     * 备注
     * @return REMARKS 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 注册时间
     * @return REGIST_DATE 注册时间
     */
    public Date getRegistDate() {
        return registDate;
    }

    /**
     * 注册时间
     * @param registDate 注册时间
     */
    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    /**
     * 注册状态：10审核中，20成功，30失败, 90废弃
     * @return REGIST_STATUS 注册状态：10审核中，20成功，30失败, 90废弃
     */
    public String getRegistStatus() {
        return registStatus;
    }

    /**
     * 注册状态：10审核中，20成功，30失败, 90废弃
     * @param registStatus 注册状态：10审核中，20成功，30失败, 90废弃
     */
    public void setRegistStatus(String registStatus) {
        this.registStatus = registStatus;
    }

    /**
     * 启用标识,0未启用,1启用
     * @return ENABLED 启用标识,0未启用,1启用
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 启用标识,0未启用,1启用
     * @param enabled 启用标识,0未启用,1启用
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 
     * @return POST_ID 
     */
    public String getPostId() {
        return postId;
    }

    /**
     * 
     * @param postId 
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }
}