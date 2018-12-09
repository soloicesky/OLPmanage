package com.onlinepay.manage.service;

import java.util.List;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.entity.MerchantApi;

/**
 * TODO:
 * Created by tom on 17/7/23.
 */
public interface IMerchantService {
    /**
     * 分页查询
     * @param pageInfo
     * @param pojo
     * @return
     */
    JqueryPageInfo<MerchantApi> selectByPage(JqueryPageInfo<MerchantApi> pageInfo, MerchantApi pojo);

    /**
     * 条件查询所有商户
     * @param pojo
     * @return
     */
    List<MerchantApi> selectByEntity(MerchantApi pojo);
    /**
     * 更新商户信息
     * @param pojo
     * @return
     */
    int update(MerchantApi pojo);

}
