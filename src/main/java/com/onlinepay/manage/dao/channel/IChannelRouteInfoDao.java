package com.onlinepay.manage.dao.channel;

import com.onlinepay.manage.dao.channel.entity.ChannelRouteInfo;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/8/28.
 */
public interface IChannelRouteInfoDao {
    /**
     * 查询所有
     * @param channelRouteInfo
     * @return
     */
    public List<ChannelRouteInfo> selectAll(ChannelRouteInfo channelRouteInfo);

    /**
     * 查询单个
     * @param channelRouteInfo
     * @return
     */
    public ChannelRouteInfo selectOne(ChannelRouteInfo channelRouteInfo);

    /**
     * 添加
     * @param channelRouteInfo
     * @return
     */
    public int add(ChannelRouteInfo channelRouteInfo);

    /**
     * 更新
     * @param channelRouteInfo
     * @return
     */
    public int update(ChannelRouteInfo channelRouteInfo);
}
