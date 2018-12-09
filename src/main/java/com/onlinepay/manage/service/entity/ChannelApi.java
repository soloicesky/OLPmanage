package com.onlinepay.manage.service.entity;

import java.util.Date;

public class ChannelApi {
	 
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
     * 开户行号
     */
    private String bankNo;

 

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
    private String cardNo;

    /**
     * 加密key
     */
    private String secretKey;

    /**
     * 渠道身份标识key
     */
    private String accessKey;
    /**
     * 电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
   
    /**
     * 开户人（企业）名称
     */
    private String accountHolder;
    /**
     * 开户行
     */
    private String accountBank;
    /**
     * 描述
     */
    private String description;
    /**
     * 代理商级别,0：一级代理商,1：二级代理商
     */
    private int level;
    /**
     * 代理商类型,0：下游渠道自行开发,1：无开发能力本公司产品
     */
    private int agentType;

    /**
     * 启用标识,0未启用,1启用
     */
    private Boolean enabled;
    /**
     * 添加该代理商的用户名称
     */
    private String addAgentUser;
    /**
     * 添加该代理商的用户ID
     */
    private String addAgentUserId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 
     */
    private String config;
    /**
     * 是否查询登录代理商自己
     */
    private String isSelf;
    /**
     * 所属客户编码
     */
    private String downCustomerId;
    /**
     * 当前用户下客户数
     */
    private Integer downCustomerCount;
    /**
     * 当前用户下一级代理商数
     */
    private Integer l1AgentIdCount;
    /**
     * 当前用户下二级代理商数
     */
    private Integer l2AgentIdCount;
    /**
     * 当前用户下C端用户数
     */
    private Integer cUserCount;
    /**
     * 一级最多可发展二级代理商数
     */
    private Long developNo;
    /**
     * 二级最多可发展C端用户数
     */
    private Long developCUserNo;

	
	public Integer getcUserCount() {
		return cUserCount;
	}

	public void setcUserCount(Integer cUserCount) {
		this.cUserCount = cUserCount;
	}
    

   	public Long getDevelopNo() {
   		return developNo;
   	}

   	public void setDevelopNo(Long developNo) {
   		this.developNo = developNo;
   	}

    public Integer getDownCustomerCount() {
		return downCustomerCount;
	}

	public void setDownCustomerCount(Integer downCustomerCount) {
		this.downCustomerCount = downCustomerCount;
	}

	public Integer getL1AgentIdCount() {
		return l1AgentIdCount;
	}

	public void setL1AgentIdCount(Integer l1AgentIdCount) {
		this.l1AgentIdCount = l1AgentIdCount;
	}

	public Integer getL2AgentIdCount() {
		return l2AgentIdCount;
	}

	public void setL2AgentIdCount(Integer l2AgentIdCount) {
		this.l2AgentIdCount = l2AgentIdCount;
	}

    public String getDownCustomerId() {
		return downCustomerId;
	}

	public void setDownCustomerId(String downCustomerId) {
		this.downCustomerId = downCustomerId;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getAgentType() {
		return agentType;
	}

	public void setAgentType(int agentType) {
		this.agentType = agentType;
	}

	public String getAddAgentUser() {
		return addAgentUser;
	}

	public void setAddAgentUser(String addAgentUser) {
		this.addAgentUser = addAgentUser;
	}

	public String getAddAgentUserId() {
		return addAgentUserId;
	}

	

	public void setAddAgentUserId(String addAgentUserId) {
		this.addAgentUserId = addAgentUserId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getIsSelf() {
		return isSelf;
	}

	public void setIsSelf(String isSelf) {
		this.isSelf = isSelf;
	}

	public Long getDevelopCUserNo() {
		return developCUserNo;
	}

	public void setDevelopCUserNo(Long developCUserNo) {
		this.developCUserNo = developCUserNo;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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