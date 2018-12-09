package com.onlinepay.manage.service.impl.channel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.channel.IChannelDao;
import com.onlinepay.manage.dao.channel.entity.Channel;
import com.onlinepay.manage.service.IChannelService;
import com.onlinepay.manage.service.entity.ChannelApi;

/**
 * TODO:
 * Created by tom on 17/7/25.
 */
@Service
public class ChannelServiceImpl implements IChannelService {

    @Autowired
    private IChannelDao channelDao;

    @Override
    public JqueryPageInfo<ChannelApi> selectByPage(JqueryPageInfo<ChannelApi> pageInfo, ChannelApi pojo) {
        Channel channel = new Channel();
        BeanUtils.copyProperties(pojo,channel);
        List<Channel> merchants = channelDao.selectPageByChannel(channel,pageInfo.getStart(),pageInfo.getLength());
        List<ChannelApi> data = new ArrayList<>();
        for (Channel cha : merchants){
            ChannelApi channelApi = new ChannelApi();
            BeanUtils.copyProperties(cha,channelApi);
            data.add(channelApi);
        }
        pageInfo.setData(data);
        int count = channelDao.selectCount(channel);
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        return pageInfo;
    }

    @Override
    public List<ChannelApi> selectByEntity(ChannelApi pojo) {
        Channel channel = new Channel();
        BeanUtils.copyProperties(pojo,channel);
        List<Channel> merchants = channelDao.selectByChannel(channel);
        List<ChannelApi> returnList = new ArrayList<>();
        for (Channel mer : merchants){
            ChannelApi channelApi = new ChannelApi();
            BeanUtils.copyProperties(mer,channelApi);
            returnList.add(channelApi);
        }
        return returnList;
    }

    @Override
    public int update(ChannelApi pojo) {
        if(pojo.getId() == 0) return 0;
//        if(pojo.getConfig() == null){
//            if(pojo.getEnabled() == null) return 0;
//        }
        Channel channel = new Channel();
        BeanUtils.copyProperties(pojo,channel);
        int update = channelDao.update(channel);
        return update;
    }

    @Override
    public String addChannel(ChannelApi pojo) {
        String channelNo = channelDao.selectMaxChannelNo();
        if(StringUtils.isEmpty(channelNo)) {
        	channelNo = "8001";
        }
        Channel channel = new Channel();
        channel.setAccessKey(UUID.randomUUID().toString().replaceAll("-",""));
        channel.setChannelNo(channelNo);
        channel.setConfig(pojo.getConfig());
        channel.setCreateDate(new Date());
        channel.setDescription(pojo.getDescription());
        channel.setBankNo(pojo.getBankNo());
        channel.setSettleBank(pojo.getSettleBank());
        channel.setSettleCarno(pojo.getSettleCarno());
        channel.setSettleName(pojo.getSettleName());
        channel.setEnabled(true);
        channel.setName(pojo.getName());
        channel.setSecretKey(pojo.getSecretKey());
        channel.setUpdateDate(new Date());
        channel.setVersion((long)1);
        int add = channelDao.add(channel);
        if(add != 1) return null;
        return channelNo;
    }
}
