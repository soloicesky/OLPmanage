package com.onlinepay.manage.service;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/7/10.
 */
public interface ISysUserMenuService {
    /**
     * 更新权限
     * @param menuId
     * @param id
     * @return
     */
    boolean updatePower(String[] menuId,String id);

    /**
     * 根据用户ID
     * @param userId
     * @return
     */
    List<Integer> selectAll(String userId);
}
