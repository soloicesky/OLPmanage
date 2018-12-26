package com.onlinepay.manage.service.entity;

import java.util.Date;

/**
 * TODO:系统登录账号表
 * Created by tom on 17/7/4.
 */
public class AdminUser {
    /**
     * 表主键
     */
    private Integer id;
    /**
     * 登录显示名称
     */
    private String nickName;
    /**
     * 登录账号
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String loginPwd;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 是否删除
     */
    private String isDel;
    /**
     * 角色类型
     */
    private String roleType;
    /**
     * 是否冻结/激活，F：冻结，T：激活
     */
    private String isActivity;
    /**
     * 管理号，当角色类型为3，4时此处的值应当是代理商编号。当角色类型为5，6时此处的值为内部商户号。
     */
    private String adminNo;
    private String phone;
    private Integer dataVersion;

    private String organ_no;
    private String name;

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(String isActivity) {
        this.isActivity = isActivity;
    }

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrgan_no() {
        return organ_no;
    }

    public void setOrgan_no(String organ_no) {
        this.organ_no = organ_no;
    }
}
