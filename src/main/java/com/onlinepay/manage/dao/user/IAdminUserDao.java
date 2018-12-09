package com.onlinepay.manage.dao.user;

import com.onlinepay.manage.dao.user.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:查询系统用户
 * Created by tom on 17/7/5.
 */
public interface IAdminUserDao{
    /**
     * 根据账号密码查询用户信息
     * @param userBean
     * @return
     */
     SysUser selectSysUser(@Param("user") SysUser userBean);

    /**
     * 查询除超级管理员外的所有用户
     * @return
     */
     List<SysUser> selectAll(@Param("user")SysUser sysUser);

    /**
     * 查询除超级管理员外所有用户总数
     * @param sysUser
     * @return
     */
     int selectCount(@Param("user")SysUser sysUser);

    /**
     * 添加管理员
     * @param sysUser
     * @return
     */
     int insertAdminUser(@Param("user")SysUser sysUser);
    /**
     * 更新用户信息
     * @param sysUser
     * @return
     */
    int updateAdminUser(@Param("user")SysUser sysUser);

    /**
     * 分页查询用户信息
     * @param sysUser
     * @param start
     * @param pageSize
     * @return
     */
    List<SysUser> selectPageByAdminUser(@Param("user")SysUser sysUser,@Param("start") int start,@Param("pageSize") int pageSize);
}
