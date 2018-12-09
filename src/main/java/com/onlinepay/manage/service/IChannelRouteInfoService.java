package com.onlinepay.manage.service;

import com.onlinepay.manage.service.entity.ChannelRouteInfoApi;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/8/18.
 */
public interface IChannelRouteInfoService {
    /**
     * 查询所有
     * @param channelRouteInfoApi
     * @return
     */
    public List<ChannelRouteInfoApi> selectAll(ChannelRouteInfoApi channelRouteInfoApi);

    /**
     * 查询单个
     * @param channelRouteInfoApi
     * @return
     */
    public ChannelRouteInfoApi selectOne(ChannelRouteInfoApi channelRouteInfoApi);

    /**
     * 添加
     * @param channelRouteInfoApi
     * @return
     */
    public int add(ChannelRouteInfoApi channelRouteInfoApi);

    /**
     * 更新
     * @param channelRouteInfoApi
     * @return
     */
    public int update(ChannelRouteInfoApi channelRouteInfoApi);
}
