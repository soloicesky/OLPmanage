package com.onlinepay.manage.dao.platform.entity;

import java.util.Date;

public class Platform {
    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", enabled=" + enabled +
                ", config='" + config + '\'' +
                '}';
    }

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
     * 编码
     */
    private String code;

    /**
     * 
     */
    private Boolean enabled;

    /**
     * 个性化配置信息，如chaannelNo，channelName
     */
    private String config;

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
     * 编码
     * @return CODE 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 编码
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 
     * @return ENABLED 
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 
     * @param enabled 
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 个性化配置信息，如chaannelNo，channelName
     * @return CONFIG 个性化配置信息，如chaannelNo，channelName
     */
    public String getConfig() {
        return config;
    }

    /**
     * 个性化配置信息，如chaannelNo，channelName
     * @param config 个性化配置信息，如chaannelNo，channelName
     */
    public void setConfig(String config) {
        this.config = config;
    }
}