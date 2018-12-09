package com.onlinepay.manage.service.impl.platform;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.platform.IPlatformDao;
import com.onlinepay.manage.dao.platform.entity.Platform;
import com.onlinepay.manage.service.IPlatformProductService;
import com.onlinepay.manage.service.IPlatformService;
import com.onlinepay.manage.service.entity.PlatformApi;
import com.onlinepay.manage.service.entity.PlatformProductApi;

/**
 * TODO:
 * Created by tom on 17/8/29.
 */
@Service
public class PlatfromServiceImpl implements IPlatformService {
    @Autowired
    private IPlatformProductService platformProductService;
    @Autowired
    private IPlatformDao platformDao;

    @Override
    public JqueryPageInfo<PlatformApi> selectByPage(JqueryPageInfo<PlatformApi> pageInfo, PlatformApi pojo) {
        Platform product = new Platform();
        BeanUtils.copyProperties(pojo, product);
        List<Platform> merchants = platformDao.selectPageByPlatform(product, pageInfo.getStart(), pageInfo.getLength());
        List<PlatformApi> data = new ArrayList<>();
        for (Platform pro : merchants) {
            PlatformApi merchantApi = new PlatformApi();
            BeanUtils.copyProperties(pro, merchantApi);
            data.add(merchantApi);
        }
        pageInfo.setData(data);
        int count = platformDao.selectCount(product);
        pageInfo.setRecordsFiltered((long) count);
        pageInfo.setRecordsTotal((long) count);
        return pageInfo;
    }

    @Override
    public List<PlatformApi> selectByEntity(PlatformApi pojo) {
        Platform product = new Platform();
        BeanUtils.copyProperties(pojo, product);
        List<Platform> platforms = platformDao.selectAll(product);
        List<PlatformApi> data = new ArrayList<>();
        for (Platform pro : platforms) {
            PlatformApi merchantApi = new PlatformApi();
            BeanUtils.copyProperties(pro, merchantApi);
            data.add(merchantApi);
        }
        return data;
    }

    @Override
    public List<PlatformApi> selectByProduct(String product) {
        List<Platform> platforms = platformDao.selectByProduct(product);
        List<PlatformApi> data = new ArrayList<>();
        for (Platform pro : platforms) {
            PlatformApi merchantApi = new PlatformApi();
            BeanUtils.copyProperties(pro, merchantApi);
            data.add(merchantApi);
        }
        return data;
    }
    @Override
    public Platform selectByID(PlatformApi pojo) {
        Long id = pojo.getId();
        Platform platforms = platformDao.selectById(id);

        return platforms;
    }

    @Override
    public int addPlatform(PlatformApi pojo) {
        Platform product = new Platform();
        BeanUtils.copyProperties(pojo, product);
        int add = platformDao.add(product);
        return add;
    }

    @Override
    public int updatePlatform(PlatformApi pojo) {
        Platform product = new Platform();
        BeanUtils.copyProperties(pojo, product);
        int update = platformDao.update(product);
        return update;
    }

    @Override
    public List<Platform> findPlatform(String pojo) {

        Platform product = new Platform();

        PlatformProductApi productApi = new PlatformProductApi();
        productApi.setEnabled(true);
        productApi.setSubProductCode(pojo);
        List<PlatformProductApi> platformProductApis = platformProductService.selectByEntity(productApi);
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(99999l);
        for (PlatformProductApi p:platformProductApis
             ) {
            Long id = p.getPlatformId();
            longs.add(id);
        }
        List<Platform> platforms = platformDao.findPlatform(longs);
//        List<PlatformApi> data = new ArrayList<>();
//        for (Platform pro : platforms) {
//            PlatformApi merchantApi = new PlatformApi();
//            BeanUtils.copyProperties(pro, merchantApi);
//            data.add(merchantApi);
//        }
        return platforms;
    }
}
