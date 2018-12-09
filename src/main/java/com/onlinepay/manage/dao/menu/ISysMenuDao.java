package com.onlinepay.manage.dao.menu;

import com.onlinepay.manage.dao.menu.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/7/7.
 */
public interface ISysMenuDao {
    /**
     * 查询菜单
     * @param roleType
     * @return
     */
    public List<SysMenu> selectSysMenu(@Param("roleType") String roleType,@Param("userId") Integer userId);

    /**
     * 添加菜单
     * @param sysMenu
     * @return
     */
    public int insertSysMenu(@Param("sysMenu") SysMenu sysMenu);

    /**
     * 查询菜单序列
     * @param parentId
     * @return
     */
    public int selectNextSort(@Param("pId") Integer parentId);
}
