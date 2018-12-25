package com.onlinepay.manage.service;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.entity.OrganAccount;

public interface IOrganService {

    /**
     * 新增机构
     * @param organAccount
     */
    void add(OrganAccount organAccount);

    /**
     * 查询
     * @param pageInfo
     * @param organAccount
     * @return
     */
    JqueryPageInfo<OrganAccount> selectAccountPage(JqueryPageInfo<OrganAccount> pageInfo, OrganAccount organAccount);
}
