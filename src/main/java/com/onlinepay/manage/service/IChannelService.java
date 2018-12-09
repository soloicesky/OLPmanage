package com.onlinepay.manage.service;

import java.util.List;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.service.entity.ChannelApi;

/**
 * TODO:
 * Created by tom on 17/7/25.
 */
public interface IChannelService {
    /**
     * 分页查询
     * @param pageInfo
     * @param pojo
     * @return
     */
    JqueryPageInfo<ChannelApi> selectByPage(JqueryPageInfo<ChannelApi> pageInfo, ChannelApi pojo);

    /**
     * 条件查询所有商户
     * @param pojo
     * @return
     */
    List<ChannelApi> selectByEntity(ChannelApi pojo);

    /**
     * 更新渠道信息
     * @param pojo
     * @return
     */
    int update(ChannelApi pojo);

    /**
     * 添加渠道信息
     * @param pojo
     * @return 返回新增的渠道号
     */
    String addChannel(ChannelApi pojo);
}
