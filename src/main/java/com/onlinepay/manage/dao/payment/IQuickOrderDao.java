package com.onlinepay.manage.dao.payment;

import com.onlinepay.manage.dao.payment.entity.KjTradeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * TODO:
 * Created by tom on 17/8/21.
 */
public interface IQuickOrderDao {
    /**
     * 根据实体对象查询订单信息
     * @param qrTradeOrder
     * @return
     */
    List<KjTradeOrder> selectAllByEntity(@Param("qo") KjTradeOrder qrTradeOrder);

    /**
     * 根据实体对象分页查询订单信息
     * @param qrTradeOrder
     * @param start
     * @param pageSize
     * @return
     */
    List<KjTradeOrder> selectAllByPageEntity(@Param("qo")KjTradeOrder qrTradeOrder,@Param("start")int start,@Param("pageSize")int pageSize);

    /**
     * 条件查询总数
     * @param qrTradeOrder
     * @return
     */
    int selectCount(@Param("qo")KjTradeOrder qrTradeOrder);

    /**
     * 分组查询统计
     * @return
     */
    List<Map<String,Object>> selectGroupBy(@Param("qo")KjTradeOrder qrTradeOrder);
}
