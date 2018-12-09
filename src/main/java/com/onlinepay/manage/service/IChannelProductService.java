package com.onlinepay.manage.service;

import com.onlinepay.manage.service.entity.ChannelProductApi;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/8/18.
 */
public interface IChannelProductService {

    /**
     * 查询渠道支付产品
     * @param channelProductApi
     * @return
     */
    public List<ChannelProductApi> selectAll(ChannelProductApi channelProductApi);

    /**
     * 添加渠道支付产品
     * @param channelProductApi
     * @return
     */
    public int addChannelProduct(ChannelProductApi channelProductApi);

    /**
     *
     * @param channelProductApi
     * @return
     */
    public int updateChannelProduct(ChannelProductApi channelProductApi);
    /**
     * 查询渠道支付产品和对应产品信息
     * @param channelProductApi
     * @return
     */
    public List<ChannelProductApi> selectChannelProduct(ChannelProductApi channelProductApi);
}
