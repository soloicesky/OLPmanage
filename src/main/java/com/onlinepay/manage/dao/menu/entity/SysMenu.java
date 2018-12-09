package com.onlinepay.manage.dao.menu.entity;

public class SysMenu {
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

    /**
     * 菜单排序
     */
    private Integer sort;

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
     * 菜单名称
     * @return NAME 菜单名称
     */
    public String getName() {
        return name;
    }

    /**
     * 菜单名称
     * @param name 菜单名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 菜单地址
     * @return URL 菜单地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 菜单地址
     * @param url 菜单地址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 菜单等级，O：一级菜单，T：二级菜单
     * @return LEVEL 菜单等级，O：一级菜单，T：二级菜单
     */
    public String getLevel() {
        return level;
    }

    /**
     * 菜单等级，O：一级菜单，T：二级菜单
     * @param level 菜单等级，O：一级菜单，T：二级菜单
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * 菜单图标，仅一级菜单有图标显示。
     * @return ICON_CLASS 菜单图标，仅一级菜单有图标显示。
     */
    public String getIconClass() {
        return iconClass;
    }

    /**
     * 菜单图标，仅一级菜单有图标显示。
     * @param iconClass 菜单图标，仅一级菜单有图标显示。
     */
    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    /**
     * 二级菜单父ID
     * @return PARENT_ID 二级菜单父ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 二级菜单父ID
     * @param parentId 二级菜单父ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 菜单排序
     * @return SORT 菜单排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 菜单排序
     * @param sort 菜单排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}