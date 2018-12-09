package com.onlinepay.manage.service;

import java.util.List;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.entity.ProductRouteFixApi;

/**
 * TODO:产品路由
 * Created by tom on 17/8/28.
 */
public interface IProductRouteFixService {
    /**
     * 分页查询渠道商已有路由产品
     * @param pageInfo
     * @param pojo
     * @return
     */
    JqueryPageInfo<ProductRouteFixApi> selectByPage(JqueryPageInfo<ProductRouteFixApi> pageInfo, ProductRouteFixApi pojo);

    /**
     * 条件查询路由产品
     * @param pojo
     * @return
     */
    List<ProductRouteFixApi> selectByEntity(ProductRouteFixApi pojo);
    /**
     * 添加路由通道
     * @param pojo
     * @return
     */
    int addProductRoute(ProductRouteFixApi pojo);

    /**
     * 修改路由通道
     * @param pojo
     * @return
     */
    int updateProductRoute(ProductRouteFixApi pojo);

}
