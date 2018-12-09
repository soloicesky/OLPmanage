package com.onlinepay.manage.service;

import java.util.List;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.entity.PlatformProductApi;

/**
 * TODO:
 * Created by tom on 17/8/29.
 */
public interface IPlatformProductService {
    /**
     * 分页查询渠道商已有路由产品
     * @param pageInfo
     * @param pojo
     * @return
     */
    JqueryPageInfo<PlatformProductApi> selectByPage(JqueryPageInfo<PlatformProductApi> pageInfo, PlatformProductApi pojo);

    /**
     * 条件查询路由产品
     * @param pojo
     * @return
     */
    List<PlatformProductApi> selectByEntity(PlatformProductApi pojo);
    /**
     * 添加路由通道
     * @param pojo
     * @return
     */
    int addPlatformProduct(PlatformProductApi pojo);

    /**
     * 修改路由通道
     * @param pojo
     * @return
     */
    int updatePlatformProduct(PlatformProductApi pojo);
}
