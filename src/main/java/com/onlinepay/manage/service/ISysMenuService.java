package com.onlinepay.manage.service;

import com.onlinepay.manage.service.entity.AdminUser;
import com.onlinepay.manage.service.entity.ShowSysMenu;

import java.util.List;
import java.util.Map;

/**
 * TODO:
 * Created by tom on 17/7/7.
 */
public interface ISysMenuService {
    /**
     * 查询菜单
     * @param user
     * @return
     */
    Map<String,List<ShowSysMenu>> selectMenu(AdminUser user);

    /**
     * 添加菜单
     * @param ssm
     * @param user
     * @return
     */
    int addMenu(ShowSysMenu ssm,AdminUser user);
}
