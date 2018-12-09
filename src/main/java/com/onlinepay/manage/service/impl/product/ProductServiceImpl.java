package com.onlinepay.manage.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.product.IProductDao;
import com.onlinepay.manage.dao.product.entity.Product;
import com.onlinepay.manage.service.IProductService;
import com.onlinepay.manage.service.entity.ProductApi;

/**
 * TODO:
 * Created by tom on 17/8/17.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<ProductApi> selectAll(ProductApi productApi) {
        Product product = new Product();
        BeanUtils.copyProperties(productApi,product);
        List<Product> products = productDao.selectAll(product);
        List<ProductApi> list = new ArrayList<>();
        for(Product pro : products){
            ProductApi pa = new ProductApi();
            BeanUtils.copyProperties(pro,pa);
            list.add(pa);
        }
        return list;
    }


    @Override
    public JqueryPageInfo<ProductApi> selectByPage(JqueryPageInfo<ProductApi> pageInfo, ProductApi pojo) {
        Product product = new Product();
        BeanUtils.copyProperties(pojo,product);
        List<Product> merchants = productDao.selectPageByProduct(product,pageInfo.getStart(),pageInfo.getLength());
        List<ProductApi> data = new ArrayList<>();
        for (Product pro : merchants){
            ProductApi merchantApi = new ProductApi();
            BeanUtils.copyProperties(pro,merchantApi);
            data.add(merchantApi);
        }
        pageInfo.setData(data);
        int count = productDao.selectCount(product);
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        return pageInfo;
    }

    @Override
    public int addProduct(ProductApi productApi) {
        Product product = new Product();
        BeanUtils.copyProperties(productApi,product);
        int i = productDao.addProduct(product);
        return i;
    }

    @Override
    public int updateProduct(ProductApi productApi) {
        Product product = new Product();
        BeanUtils.copyProperties(productApi,product);
        int i = productDao.updateProduct(product);
        return i;
    }
}
