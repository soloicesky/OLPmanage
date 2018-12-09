package com.onlinepay.manage.service.impl.platform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.platform.IPlatformProductDao;
import com.onlinepay.manage.dao.platform.entity.PlatformProduct;
import com.onlinepay.manage.service.IPlatformProductService;
import com.onlinepay.manage.service.entity.PlatformProductApi;

/**
 * TODO:
 * Created by tom on 17/8/29.
 */
@Service
public class PlatformProductServiceImpl implements IPlatformProductService {

    @Autowired
    private IPlatformProductDao platformProductDao;

    @Override
    public JqueryPageInfo<PlatformProductApi> selectByPage(JqueryPageInfo<PlatformProductApi> pageInfo, PlatformProductApi pojo) {
        PlatformProduct product = new PlatformProduct();
        BeanUtils.copyProperties(pojo,product);
        List<PlatformProduct> merchants = platformProductDao.selectPageByPlatformProduct(product,pageInfo.getStart(),pageInfo.getLength());
        List<PlatformProductApi> data = new ArrayList<>();
        for (PlatformProduct pro : merchants){
            PlatformProductApi merchantApi = new PlatformProductApi();
            BeanUtils.copyProperties(pro,merchantApi);
            data.add(merchantApi);
        }
        pageInfo.setData(data);
        int count = platformProductDao.selectCount(product);
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        return pageInfo;
    }

    @Override
    public List<PlatformProductApi> selectByEntity(PlatformProductApi pojo) {
        PlatformProduct product = new PlatformProduct();
        BeanUtils.copyProperties(pojo,product);
        List<PlatformProduct> platforms = platformProductDao.selectAll(product);
        List<PlatformProductApi> data = new ArrayList<>();
        for (PlatformProduct pro : platforms){
            PlatformProductApi merchantApi = new PlatformProductApi();
            BeanUtils.copyProperties(pro,merchantApi);
            data.add(merchantApi);
        }
        return data;
    }

    @Override
    public int addPlatformProduct(PlatformProductApi pojo) {
        PlatformProduct product = new PlatformProduct();
        BeanUtils.copyProperties(pojo,product);
        int add = platformProductDao.add(product);
        return add;
    }

    @Override
    public int updatePlatformProduct(PlatformProductApi pojo) {
        PlatformProduct product = new PlatformProduct();
        BeanUtils.copyProperties(pojo,product);
        int update = platformProductDao.update(product);
        return update;
    }
}
