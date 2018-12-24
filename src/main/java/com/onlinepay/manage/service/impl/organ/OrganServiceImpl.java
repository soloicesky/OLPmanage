package com.onlinepay.manage.service.impl.organ;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.organ.IOrganDao;
import com.onlinepay.manage.dao.organ.entity.Organ;
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
    public void add(Organ organ) {
        Date now = new Date();
        organ.setCreate_date(now);
        organ.setUpdate_date(now);
        organ.setDel_flag(0);
        organ.setStatus(1);
        organDao.add(organ);
    }

    @Override
    public JqueryPageInfo<Organ> selectPage(JqueryPageInfo<Organ> pageInfo, Organ organ) {

        List<Organ> results = organDao.selectPage(pageInfo.getStart(), pageInfo.getLength(), organ);
        pageInfo.setData(results);
        int count = organDao.selectCount(organ);
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        return pageInfo;
    }

}
