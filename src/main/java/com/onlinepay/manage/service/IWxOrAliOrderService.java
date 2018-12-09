package com.onlinepay.manage.service;



import java.util.List;
import java.util.Map;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.entity.SelectQrOrderPojo;
import com.onlinepay.manage.service.entity.WxOrAliOrder;

/**
 * TODO:微信和支付宝订单查询服务
 * Created by tom on 17/6/30.
 */
public interface IWxOrAliOrderService {

    /**
     * 分页查询
     * @param pageInfo
     * @param pojo
     * @return
     */
    JqueryPageInfo<WxOrAliOrder> selectByPage(JqueryPageInfo<WxOrAliOrder> pageInfo, SelectQrOrderPojo pojo);

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
    List<WxOrAliOrder> exportExcl(SelectQrOrderPojo pojo);
}
