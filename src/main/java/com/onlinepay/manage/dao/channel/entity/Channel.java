package com.onlinepay.manage.dao.channel.entity;

import java.util.Date;

public class Channel {
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
     * 名称
     */
    private String name;

    /**
     * 渠道号
     */
    private String channelNo;

    /**
     * 加密key
     */
    private String secretKey;

    /**
     * 渠道身份标识key
     */
    private String accessKey;

    /**
     * 描述
     */
    private String description;

    /**
     * 启用标识,0未启用,1启用
     */
    private Boolean enabled;

    /**
     * 
     */
    private String config;

    /**
     * 结算卡号
     */
    private String settleCarno;

    /**
     * 开户名
     */
    private String settleName;

    /**
     * 开户行
     */
    private String settleBank;

    /**
     * 结算费率
     */
    private String bankNo;

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
     * 名称
     * @return NAME 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 加密key
     * @return SECRET_KEY 加密key
     */
    public String getSecretKey() {
        return secretKey;
    }

    /**
     * 加密key
     * @param secretKey 加密key
     */
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    /**
     * 渠道身份标识key
     * @return ACCESS_KEY 渠道身份标识key
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * 渠道身份标识key
     * @param accessKey 渠道身份标识key
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
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
     * @return CONFIG 
     */
    public String getConfig() {
        return config;
    }

    /**
     * 
     * @param config 
     */
    public void setConfig(String config) {
        this.config = config;
    }

	public String getSettleCarno() {
		return settleCarno;
	}

	public void setSettleCarno(String settleCarno) {
		this.settleCarno = settleCarno;
	}

	public String getSettleName() {
		return settleName;
	}

	public void setSettleName(String settleName) {
		this.settleName = settleName;
	}

	public String getSettleBank() {
		return settleBank;
	}

	public void setSettleBank(String settleBank) {
		this.settleBank = settleBank;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

    
}