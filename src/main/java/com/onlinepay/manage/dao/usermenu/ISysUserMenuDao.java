package com.onlinepay.manage.dao.usermenu;

import com.onlinepay.manage.dao.usermenu.entity.SysUserMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/7/12.
 */
public interface ISysUserMenuDao {
    /**
     * 添加权限
     * @param
     * @return
     */
    int insert(@Param("menuId") Integer menuId,@Param("userId") Integer userId);

    /**
     * 更新权限
     * @param
     * @return
     */
    int update(@Param("isDel") String isDel,@Param("userId") Integer userId,@Param("menuId") Integer menuId);

    /**
     * 根据用户ID查询用户权限菜单
     * @param userId
     * @return
     */
    List<SysUserMenu> selectAll(@Param("userId") Integer userId);
    /**
     * 根据用户ID查询用户权限菜单
     * @param userId
     * @return
     */
    SysUserMenu selectOne(@Param("userId") Integer userId,@Param("menuId") Integer menuId);
}
