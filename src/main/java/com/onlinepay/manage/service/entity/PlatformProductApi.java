package com.onlinepay.manage.service.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlatformProductApi {

    /**
     * 
     */
    private Long id;

    private String newPlatform;
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
    private Long platformId;

    /**
     * 上游平台编码
     */
    private String platformCode;

    /**
     * 
     */
    private Long productId;

    /**
     * 产品编码
     */
    private String subProductCode;

//    /**
//     * 是否支持T0对公
//     */
//    private Boolean isT0PubAcc;
//
//    /**
//     * 是否支持T1对公
//     */
//    private Boolean isT1PubAcc;
//
//    public double getT0MaxAmt() {
//        return t0MaxAmt;
//    }
//
//    public void setT0MaxAmt(double t0MaxAmt) {
//        this.t0MaxAmt = t0MaxAmt;
//    }
//
//    public double getT0MinAmt() {
//        return t0MinAmt;
//    }
//
//    public void setT0MinAmt(double t0MinAmt) {
//        this.t0MinAmt = t0MinAmt;
//    }

    /**

     * HHmmss T0开始时间
     */
    private String t0BegTime;

    /**
     * HHmmss T0结束时间
     */
    private String t0EndTime;

    /**
     * HHmmss T1开始时间
     */
    private String t1BegTime;

    /**
     * HHmmss T1结束时间
     */
    private String t1EndTime;
    /**
     * 优先级
     */
    private Integer priority;

//    /**
//     * T0最大金额
//     */
    private double maxAmt;

//    /**
//     * T0最小金额
//     */
    private double minAmt;

//    /**
//     * T1最大金额
//     */
//    private double t1MaxAmt;
//
//    /**
//     * T1最小金额
//     */
//    private double t1MinAmt;


	/**
     * T0成本费率
     */
    private String t0Rate;

    
    public double getMaxAmt() {
		return maxAmt;
	}

	public void setMaxAmt(double maxAmt) {
		this.maxAmt = maxAmt;
	}

	public double getMinAmt() {
		return minAmt;
	}

	public void setMinAmt(double minAmt) {
		this.minAmt = minAmt;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
     * T1成本费率
     */
    private String t1Rate;

    /**
     * T0单笔固定手续费
     */
    private double fixT0Fee;

    /**
     * 启用标识,0未启用,1启用
     */
    private Boolean enabled;

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
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createDate);
        setDateString(format);
        this.createDate = createDate;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    private String dateString;

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

//    /**
//     * 是否支持T0对公
//     * @return IS_T0_PUB_ACC 是否支持T0对公
//     */
//    public Boolean getIsT0PubAcc() {
//        return isT0PubAcc;
//    }
//
//    /**
//     * 是否支持T0对公
//     * @param isT0PubAcc 是否支持T0对公
//     */
//    public void setIsT0PubAcc(Boolean isT0PubAcc) {
//        this.isT0PubAcc = isT0PubAcc;
//    }

//    /**
//     * 是否支持T1对公
//     * @return IS_T1_PUB_ACC 是否支持T1对公
//     */
//    public Boolean getIsT1PubAcc() {
//        return isT1PubAcc;
//    }
//
//    /**
//     * 是否支持T1对公
//     * @param isT1PubAcc 是否支持T1对公
//     */
//    public void setIsT1PubAcc(Boolean isT1PubAcc) {
//        this.isT1PubAcc = isT1PubAcc;
//    }

    /**
     * HHmmss T0开始时间
     * @return T0_BEG_TIME HHmmss T0开始时间
     */
    public String getT0BegTime() {
        return t0BegTime;
    }

    /**
     * HHmmss T0开始时间
     * @param t0BegTime HHmmss T0开始时间
     */
    public void setT0BegTime(String t0BegTime) {
        this.t0BegTime = t0BegTime;
    }

    /**
     * HHmmss T0结束时间
     * @return T0_END_TIME HHmmss T0结束时间
     */
    public String getT0EndTime() {
        return t0EndTime;
    }

    /**
     * HHmmss T0结束时间
     * @param t0EndTime HHmmss T0结束时间
     */
    public void setT0EndTime(String t0EndTime) {
        this.t0EndTime = t0EndTime;
    }

    /**
     * HHmmss T1开始时间
     * @return T1_BEG_TIME HHmmss T1开始时间
     */
    public String getT1BegTime() {
        return t1BegTime;
    }

    /**
     * HHmmss T1开始时间
     * @param t1BegTime HHmmss T1开始时间
     */
    public void setT1BegTime(String t1BegTime) {
        this.t1BegTime = t1BegTime;
    }

    /**
     * HHmmss T1结束时间
     * @return T1_END_TIME HHmmss T1结束时间
     */
    public String getT1EndTime() {
        return t1EndTime;
    }

    /**
     * HHmmss T1结束时间
     * @param t1EndTime HHmmss T1结束时间
     */
    public void setT1EndTime(String t1EndTime) {
        this.t1EndTime = t1EndTime;
    }


//    /**
//     * T1最大金额
//     * @return T1_MAX_AMT T1最大金额
//     */
//    public double getT1MaxAmt() {
//        return t1MaxAmt;
//    }
//
//    /**
//     * T1最大金额
//     * @param t1MaxAmt T1最大金额
//     */
//    public void setT1MaxAmt(double t1MaxAmt) {
//        this.t1MaxAmt = t1MaxAmt;
//    }

//    /**
//     * T1最小金额
//     * @return T1_MIN_AMT T1最小金额
//     */
//    public double getT1MinAmt() {
//        return t1MinAmt;
//    }
//
//    /**
//     * T1最小金额
//     * @param t1MinAmt T1最小金额
//     */
//    public void setT1MinAmt(double t1MinAmt) {
//        this.t1MinAmt = t1MinAmt;
//    }

    /**
     * T0成本费率
     * @return T0_RATE T0成本费率
     */
    public String getT0Rate() {
        return t0Rate;
    }

    /**
     * T0成本费率
     * @param t0Rate T0成本费率
     */
    public void setT0Rate(String t0Rate) {
        this.t0Rate = t0Rate;
    }

    /**
     * T1成本费率
     * @return T1_RATE T1成本费率
     */
    public String getT1Rate() {
        return t1Rate;
    }

    /**
     * T1成本费率
     * @param t1Rate T1成本费率
     */
    public void setT1Rate(String t1Rate) {
        this.t1Rate = t1Rate;
    }

    /**
     * T0单笔固定手续费
     * @return FIX_T0_FEE T0单笔固定手续费
     */
    public double getFixT0Fee() {
        return fixT0Fee;
    }

    /**
     * T0单笔固定手续费
     * @param fixT0Fee T0单笔固定手续费
     */
    public void setFixT0Fee(double fixT0Fee) {
        this.fixT0Fee = fixT0Fee;
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

//    public Boolean getT0PubAcc() {
//        return isT0PubAcc;
//    }
//
//    public void setT0PubAcc(Boolean t0PubAcc) {
//        isT0PubAcc = t0PubAcc;
//    }
//
//    public Boolean getT1PubAcc() {
//        return isT1PubAcc;
//    }
//
//    public void setT1PubAcc(Boolean t1PubAcc) {
//        isT1PubAcc = t1PubAcc;
//    }
    /////////表连接查询扩展字段////////////////
    private String platformName;



    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    @Override
    public String toString() {
        return "PlatformProductApi{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", version=" + version +
                ", platformId=" + platformId +
                ", platformCode='" + platformCode + '\'' +
                ", productId=" + productId +
                ", subProductCode='" + subProductCode + '\'' +
//                ", isT0PubAcc=" + isT0PubAcc +
//                ", isT1PubAcc=" + isT1PubAcc +
                ", t0BegTime='" + t0BegTime + '\'' +
                ", t0EndTime='" + t0EndTime + '\'' +
                ", t1BegTime='" + t1BegTime + '\'' +
                ", t1EndTime='" + t1EndTime + '\'' +
//                ", t0MaxAmt=" + t0MaxAmt +
//                ", t0MinAmt=" + t0MinAmt +
//                ", t1MaxAmt=" + t1MaxAmt +
//                ", t1MinAmt=" + t1MinAmt +
                ", t0Rate='" + t0Rate + '\'' +
                ", t1Rate='" + t1Rate + '\'' +
                ", fixT0Fee=" + fixT0Fee +
                ", enabled=" + enabled +
                ", platformName='" + platformName + '\'' +
                '}';
    }

    public String getNewPlatform() {
        return newPlatform;
    }

    public void setNewPlatform(String newPlatform) {
        this.newPlatform = newPlatform;
    }
}