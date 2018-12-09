package com.onlinepay.manage.dao.user.entity;

import java.util.Date;


public class SysUser {
    /**
     * 表主键
     */
    private Integer id;

    /**
     * 登录系统后显示的名称
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
     * 角色类型，0：超级管理员，1：系统管理员，2：系统运营操作员，3：代理商管理员，4：代理商运营操作员，5：代理商商户管理员，6：代理商商户操作员
     */
    private String roleType;

    /**
     * 数据版本
     */
    private Integer dataVersion;

    /**
     * 管理号，当角色类型为3，4时此处的值应当是代理商编号。当角色类型为5，6时此处的值为内部商户号。
     */
    private String adminNo;

    /**
     * 是否删除，F：删除，T：不删除。
     */
    private String isDel;

    /**
     * 是否冻结/激活，F：冻结，T：激活
     */
    private String isActivity;

    private Date updateTime;
    private Date createTime;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 是否删除，F：删除，T：不删除。
     * @return IS_DEL 是否删除，F：删除，T：不删除。
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 是否删除，F：删除，T：不删除。
     * @param isDel 是否删除，F：删除，T：不删除。
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    /**
     * 是否冻结/激活，F：冻结，T：激活
     * @return IS_ACTIVITY 是否冻结/激活，F：冻结，T：激活
     */
    public String getIsActivity() {
        return isActivity;
    }

    /**
     * 是否冻结/激活，F：冻结，T：激活
     * @param isActivity 是否冻结/激活，F：冻结，T：激活
     */
    public void setIsActivity(String isActivity) {
        this.isActivity = isActivity;
    }

    /**
     * 创建时间
     * @return CREATE_TIME 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    /**
     * 更新时间
     * @return UPDATE_TIME 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 表主键
     * @return ID 表主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 表主键
     * @param id 表主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 登录系统后显示的名称
     * @return NICK_NAME 登录系统后显示的名称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 登录系统后显示的名称
     * @param nickName 登录系统后显示的名称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * 登录账号
     * @return LOGIN_NAME 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录账号
     * @param loginName 登录账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 登录密码
     * @return LOGIN_PWD 登录密码
     */
    public String getLoginPwd() {
        return loginPwd;
    }

    /**
     * 登录密码
     * @param loginPwd 登录密码
     */
    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    /**
     * 角色类型，0：超级管理员，1：系统管理员，2：系统运营操作员，3：代理商管理员，4：代理商运营操作员，5：代理商商户管理员，6：代理商商户操作员
     * @return ROLE_TYPE 角色类型，0：超级管理员，1：系统管理员，2：系统运营操作员，3：代理商管理员，4：代理商运营操作员，5：代理商商户管理员，6：代理商商户操作员
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * 角色类型，0：超级管理员，1：系统管理员，2：系统运营操作员，3：代理商管理员，4：代理商运营操作员，5：代理商商户管理员，6：代理商商户操作员
     * @param roleType 角色类型，0：超级管理员，1：系统管理员，2：系统运营操作员，3：代理商管理员，4：代理商运营操作员，5：代理商商户管理员，6：代理商商户操作员
     */
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    /**
     * 数据版本
     * @return DATA_VERSION 数据版本
     */
    public Integer getDataVersion() {
        return dataVersion;
    }

    /**
     * 数据版本
     * @param dataVersion 数据版本
     */
    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    /**
     * 管理号，当角色类型为3，4时此处的值应当是代理商编号。当角色类型为5，6时此处的值为内部商户号。
     * @return ADMIN_NO 管理号，当角色类型为3，4时此处的值应当是代理商编号。当角色类型为5，6时此处的值为内部商户号。
     */
    public String getAdminNo() {
        return adminNo;
    }

    /**
     * 管理号，当角色类型为3，4时此处的值应当是代理商编号。当角色类型为5，6时此处的值为内部商户号。
     * @param adminNo 管理号，当角色类型为3，4时此处的值应当是代理商编号。当角色类型为5，6时此处的值为内部商户号。
     */
    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo;
    }

}