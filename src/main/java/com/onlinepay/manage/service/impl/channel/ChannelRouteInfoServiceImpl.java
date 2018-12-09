package com.onlinepay.manage.service.impl.channel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.dao.channel.IChannelRouteInfoDao;
import com.onlinepay.manage.dao.channel.entity.ChannelRouteInfo;
import com.onlinepay.manage.service.IChannelRouteInfoService;
import com.onlinepay.manage.service.entity.ChannelRouteInfoApi;

/**
 * TODO:
 * Created by tom on 17/8/18.
 */
@Service
public class ChannelRouteInfoServiceImpl implements IChannelRouteInfoService {

    @Autowired
    private IChannelRouteInfoDao routeInfoDao;

    @Override
    public List<ChannelRouteInfoApi> selectAll(ChannelRouteInfoApi channelRouteInfoApi) {
        ChannelRouteInfo channelRouteInfo = new ChannelRouteInfo();
        BeanUtils.copyProperties(channelRouteInfoApi,channelRouteInfo);
        List<ChannelRouteInfo> channelRouteInfos = routeInfoDao.selectAll(channelRouteInfo);
        List<ChannelRouteInfoApi> list = new ArrayList<>();
        for (ChannelRouteInfo cri : channelRouteInfos){
            ChannelRouteInfoApi cria = new ChannelRouteInfoApi();
            BeanUtils.copyProperties(cri,cria);
            list.add(cria);
        }
        return list;
    }

    @Override
    public ChannelRouteInfoApi selectOne(ChannelRouteInfoApi channelRouteInfoApi) {
        ChannelRouteInfo channelRouteInfo = new ChannelRouteInfo();
        BeanUtils.copyProperties(channelRouteInfoApi,channelRouteInfo);
        ChannelRouteInfo channelRouteInfo1 = routeInfoDao.selectOne(channelRouteInfo);
        ChannelRouteInfoApi cria = new ChannelRouteInfoApi();
        BeanUtils.copyProperties(channelRouteInfo1,cria);
        return cria;
    }

    @Override
    public int add(ChannelRouteInfoApi channelRouteInfoApi) {
        ChannelRouteInfo channelRouteInfo = new ChannelRouteInfo();
        BeanUtils.copyProperties(channelRouteInfoApi,channelRouteInfo);
        int add = routeInfoDao.add(channelRouteInfo);
        return add;
    }

    @Override
    public int update(ChannelRouteInfoApi channelRouteInfoApi) {
        ChannelRouteInfo channelRouteInfo = new ChannelRouteInfo();
        BeanUtils.copyProperties(channelRouteInfoApi,channelRouteInfo);
        int update = routeInfoDao.update(channelRouteInfo);
        return update;
    }
}
