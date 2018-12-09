package com.onlinepay.manage.service;

import java.util.List;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.platform.entity.Platform;
import com.onlinepay.manage.service.entity.PlatformApi;

/**
 * TODO:
 * Created by tom on 17/8/29.
 */
public interface IPlatformService {
    /**
     * 分页查询渠道商已有路由产品
     * @param pageInfo
     * @param pojo
     * @return
     */
    JqueryPageInfo<PlatformApi> selectByPage(JqueryPageInfo<PlatformApi> pageInfo, PlatformApi pojo);

    /**
     * 条件查询路由产品
     * @param pojo
     * @return
     */
    List<PlatformApi> selectByEntity(PlatformApi pojo);
    
    List<PlatformApi> selectByProduct(String product);
    /**
     * 条件查询路由产品
     * @param pojo
     * @return
     */
    Platform selectByID(PlatformApi pojo);
    /**
     * 添加路由通道
     * @param pojo
     * @return
     */
    int addPlatform(PlatformApi pojo);

    /**
     * 修改路由通道
     * @param pojo
     * @return
     */
    int updatePlatform(PlatformApi pojo);

    /**
     * 查找通道
     * @param pojo
     * @return
     */
    List<Platform>  findPlatform(String  pojo);
}
