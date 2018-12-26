package com.onlinepay.manage.service;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.entity.Organ;
import com.onlinepay.manage.dao.organ.entity.OrganAccount;

public interface IOrganService {

    /**
     * 新增机构
     * @param organ
     */
    void add(Organ organ);

    /**
     * 根据登陆id 查询机构
     * @param login_id
     * @return
     */
    Organ getOrgan(Integer login_id);

    /**
     * 查询账户列表
     * @param pageInfo
     * @param organAccount
     * @return
     */
    JqueryPageInfo<OrganAccount> selectAccountPage(JqueryPageInfo<OrganAccount> pageInfo, OrganAccount organAccount);
}
