package com.onlinepay.manage.dao.product;

import com.onlinepay.manage.dao.product.entity.Product;
import com.onlinepay.manage.dao.product.entity.ProductRouteFix;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/8/28.
 */
public interface IProductRouteFixDao {
    /**
     * 查询所有产品
     * @param product
     * @return
     */
    List<ProductRouteFix> selectAll(@Param("pro") ProductRouteFix product);

    /**
     * 根据商户实体查询商户
     * @param product
     * @return
     */
    List<ProductRouteFix> selectPageByProductRouteFix(@Param("pro") ProductRouteFix product, @Param("start") int start, @Param("pageSize") int pageSize);


    /**
     * 添加产品
     * @param product
     * @return
     */
    int add(@Param("pro") ProductRouteFix product);

    /**
     * 修改产品
     * @param product
     * @return
     */
    int update(@Param("pro") ProductRouteFix product);

    /**
     * 条件查询总数
     * @param merchant
     * @return
     */
    int selectCount(@Param("pro") ProductRouteFix merchant);
}
