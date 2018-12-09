package com.onlinepay.manage.service;

import java.util.List;
import java.util.Map;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.entity.KjTradeOrderApi;
import com.onlinepay.manage.service.entity.SelectQrOrderPojo;

/**
 * TODO:
 * Created by tom on 17/8/21.
 */
public interface IQuickOrderService {
    /**
     * 分页查询
     * @param pageInfo
     * @param pojo
     * @return
     */
    JqueryPageInfo<KjTradeOrderApi> selectByPage(JqueryPageInfo<KjTradeOrderApi> pageInfo, SelectQrOrderPojo pojo);

    /**
     * 条件查询结果总数
     * @param pojo
     * @return
     */
    List<Map<String,String>> selectGroup(SelectQrOrderPojo pojo);

    /**
     * 查询导出的Excel数据
     * @param pojo
     * @return
     */
    List<KjTradeOrderApi> exportExcl(SelectQrOrderPojo pojo);
}
