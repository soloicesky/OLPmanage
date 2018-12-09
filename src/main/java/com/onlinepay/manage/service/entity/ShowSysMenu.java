package com.onlinepay.manage.service.entity;

/**
 * TODO:
 * Created by tom on 17/7/7.
 */
public class ShowSysMenu {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单地址
     */
    private String url;
    /**
     * 菜单等级，O：一级菜单，T：二级菜单
     */
    private String level;

    /**
     * 菜单图标，仅一级菜单有图标显示。
     */
    private String iconClass;

    /**
     * 二级菜单父ID
     */
    private Integer parentId;

    private String isDel;

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    /**
     * 菜单排序
     */
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
