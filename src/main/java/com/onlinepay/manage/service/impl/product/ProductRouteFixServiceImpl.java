package com.onlinepay.manage.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.product.IProductRouteFixDao;
import com.onlinepay.manage.dao.product.entity.ProductRouteFix;
import com.onlinepay.manage.service.IProductRouteFixService;
import com.onlinepay.manage.service.entity.ProductRouteFixApi;

/**
 * TODO:
 * Created by tom on 17/8/28.
 */
@Service
public class ProductRouteFixServiceImpl implements IProductRouteFixService {

    @Autowired
    private IProductRouteFixDao productRouteFixDao;

    @Override
    public JqueryPageInfo<ProductRouteFixApi> selectByPage(JqueryPageInfo<ProductRouteFixApi> pageInfo, ProductRouteFixApi pojo) {
        ProductRouteFix product = new ProductRouteFix();
        BeanUtils.copyProperties(pojo,product);
        List<ProductRouteFix> merchants = productRouteFixDao.selectPageByProductRouteFix(product,pageInfo.getStart(),pageInfo.getLength());
        List<ProductRouteFixApi> data = new ArrayList<>();
        for (ProductRouteFix pro : merchants){
            ProductRouteFixApi merchantApi = new ProductRouteFixApi();
            BeanUtils.copyProperties(pro,merchantApi);
            data.add(merchantApi);
        }
        pageInfo.setData(data);
        int count = productRouteFixDao.selectCount(product);
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        return pageInfo;
    }

    @Override
    public List<ProductRouteFixApi> selectByEntity(ProductRouteFixApi pojo) {
        ProductRouteFix product = new ProductRouteFix();
        BeanUtils.copyProperties(pojo,product);
        List<ProductRouteFix> productRouteFixes = productRouteFixDao.selectAll(product);
        List<ProductRouteFixApi> data = new ArrayList<>();
        for (ProductRouteFix pro : productRouteFixes){
            ProductRouteFixApi merchantApi = new ProductRouteFixApi();
            BeanUtils.copyProperties(pro,merchantApi);
            data.add(merchantApi);
        }
        return data;
    }

    @Override
    public int addProductRoute(ProductRouteFixApi pojo) {
        ProductRouteFix product = new ProductRouteFix();
        BeanUtils.copyProperties(pojo,product);
        int add = productRouteFixDao.add(product);
        return add;
    }

    @Override
    public int updateProductRoute(ProductRouteFixApi pojo) {
        ProductRouteFix product = new ProductRouteFix();
        BeanUtils.copyProperties(pojo,product);
        int update = productRouteFixDao.update(product);
        return update;
    }
}
