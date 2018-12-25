package com.onlinepay.manage.service.impl.organ;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.IOrganDao;
import com.onlinepay.manage.dao.organ.entity.OrganAccount;
import com.onlinepay.manage.service.IOrganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *  机构逻辑层
 */
@Service
public class OrganServiceImpl  extends BaseLog<OrganServiceImpl> implements IOrganService {

    @Autowired
    private IOrganDao organDao;

    @Override
    public void add(OrganAccount organAccount) {
        Date now = new Date();
        organAccount.setCreate_date(now);
        organAccount.setUpdate_date(now);
        organAccount.setDel_flag(0);
        organAccount.setStatus(1);
        organDao.add(organAccount);
    }

    @Override
    public JqueryPageInfo<OrganAccount> selectAccountPage(JqueryPageInfo<OrganAccount> pageInfo, OrganAccount organAccount) {

        List<OrganAccount> results = organDao.selectAccountPage(pageInfo.getStart(), pageInfo.getLength(), organAccount);
        pageInfo.setData(results);
        int count = organDao.selectAccountCount(organAccount);
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        return pageInfo;
    }

}
