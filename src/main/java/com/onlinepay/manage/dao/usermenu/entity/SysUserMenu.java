package com.onlinepay.manage.dao.usermenu.entity;

/**
 * TODO:
 * Created by tom on 17/7/12.
 */
public class SysUserMenu {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 主键ID
     * @return ID 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户ID
     * @return USER_ID 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    /**
     * 菜单ID
     */
    private Integer menuId;

    /**
     * 菜单页面下按钮权限值
     */
    private Integer powerBtn;

    /**
     * 是否删除
     */
    private String isDel;

    /**
     * 菜单ID
     * @return MENU_ID 菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 菜单ID
     * @param menuId 菜单ID
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    /**
     * 菜单页面下按钮权限值
     * @return POWER_BTN 菜单页面下按钮权限值
     */
    public Integer getPowerBtn() {
        return powerBtn;
    }

    /**
     * 菜单页面下按钮权限值
     * @param powerBtn 菜单页面下按钮权限值
     */
    public void setPowerBtn(Integer powerBtn) {
        this.powerBtn = powerBtn;
    }

    /**
     * 是否删除
     * @return IS_DEL 是否删除
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * 是否删除
     * @param isDel 是否删除
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }
}
