package com.onlinepay.manage.service;

import java.util.Map;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.entity.AdminUser;

/**
 * TODO:
 * Created by tom on 17/7/5.
 */
public interface ISysUserService {
    /**
     * 查询登录信息
     * @param user
     * @return
     */
     AdminUser selectLoginInfo(AdminUser user);
    /**
     * 根据用户实体查询用户
     * @param user
     * @return
     */
    AdminUser selectUserByUser(AdminUser user);

    /**
     * 查询所有用户
     * @param user
     * @return
     */
     Map<String,Object> selectAll(AdminUser user);

    /**
     * 添加用户
     * @param user
     * @return
     */
     int insertAdminUser(AdminUser user);

    /**
     * 更新用户
     * @param user
     * @return
     */
     int updateUser(AdminUser user);

    /**
     * 分页查询管理员信息
     * @param pageInfo
     * @param adminUser
     * @return
     */
     JqueryPageInfo<AdminUser> selectAllByPage(JqueryPageInfo<AdminUser> pageInfo,AdminUser adminUser);
}
