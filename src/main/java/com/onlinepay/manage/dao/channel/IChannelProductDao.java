package com.onlinepay.manage.dao.channel;

import com.onlinepay.manage.dao.channel.entity.ChannelProduct;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/8/21.
 */
public interface IChannelProductDao {

    /**
     * 查询所有
     * @param channelProduct
     * @return
     */
    public List<ChannelProduct> selectAll(ChannelProduct channelProduct);

    /**
     * 添加渠道产品
     * @param channelProduct
     * @return
     */
    public int add(ChannelProduct channelProduct);

    /**
     * 修改渠道产品
     * @param channelProduct
     * @return
     */
    public int update(ChannelProduct channelProduct);
    /**
     * 查询当前用户开通的产品及费率
     * @param channelProduct
     * @return
     */
    public List<ChannelProduct> selectChannelProduct (ChannelProduct channelProduct);
}
