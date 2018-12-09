package com.onlinepay.manage.dao.product;

import com.onlinepay.manage.dao.merchant.entity.Merchant;
import com.onlinepay.manage.dao.product.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/8/16.
 */
public interface IProductDao {
    /**
     * 查询所有产品
     * @param product
     * @return
     */
    public List<Product> selectAll(@Param("pro") Product product);

    /**
     * 根据商户实体查询商户
     * @param product
     * @return
     */
    List<Product> selectPageByProduct(@Param("pro") Product product, @Param("start") int start, @Param("pageSize") int pageSize);


    /**
     * 添加产品
     * @param product
     * @return
     */
    public int addProduct(@Param("pro")Product product);

    /**
     * 修改产品
     * @param product
     * @return
     */
    public int updateProduct(@Param("pro")Product product);

    /**
     * 条件查询总数
     * @param merchant
     * @return
     */
    int selectCount(@Param("pro") Product merchant);
}
