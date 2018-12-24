package com.onlinepay.manage.service;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.entity.Organ;

public interface IOrganService {

    /**
     * 新增机构
     * @param organ
     */
    void add(Organ organ);

    /**
     * 查询
     * @param pageInfo
     * @param organ
     * @return
     */
    JqueryPageInfo<Organ> selectPage(JqueryPageInfo<Organ> pageInfo, Organ organ);
}
