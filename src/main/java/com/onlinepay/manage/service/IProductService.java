package com.onlinepay.manage.service;

import java.util.List;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.entity.ProductApi;

/**
 * TODO:产品服务
 * Created by tom on 17/8/16.
 */
public interface IProductService {
    /**
     * 查询所有产品
     * @param productApi
     * @return
     */
    public List<ProductApi> selectAll(ProductApi productApi);
    /**
     * 分页查询所有
     * @param pageInfo
     * @param pojo
     * @return
     */
    JqueryPageInfo<ProductApi> selectByPage(JqueryPageInfo<ProductApi> pageInfo, ProductApi pojo);
    /**
     * 添加产品
     * @param productApi
     * @return
     */
    public int addProduct(ProductApi productApi);

    /**
     * 修改产品
     * @param productApi
     * @return
     */
    public int updateProduct(ProductApi productApi);

}
