package com.onlinepay.manage.dao.channel;

import com.onlinepay.manage.dao.channel.entity.Channel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * TODO:
 * Created by tom on 17/7/25.
 */
public interface IChannelDao {

    /**
     * 根据渠道实体查询渠道信息
     * @param channel
     * @return
     */
    List<Channel> selectByChannel(@Param("cha") Channel channel);

    /**
     * 根据渠道实体查询渠道商户信息
     * @param channel
     * @return
     */
    List<Channel> selectPageByChannel(@Param("cha") Channel channel,@Param("start") int start,@Param("pageSize") int pageSize);

    /**
     * 条件查询总数
     * @param channel
     * @return
     */
    int selectCount(@Param("cha") Channel channel);

    /**
     * 根据实体修改渠道信息
     * @param channel
     * @return
     */
    int update(@Param("cha") Channel channel);

    /**
     * 根据实体添加渠道信息
     * @param channel
     * @return
     */
    int add(@Param("cha") Channel channel);

    /**
     * 查询数据库最大的渠道号并加1作为下一个渠道商的渠道号
     * @return
     */
    String selectMaxChannelNo();
}
