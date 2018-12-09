package com.onlinepay.manage.service.impl.channel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.dao.channel.IChannelProductDao;
import com.onlinepay.manage.dao.channel.entity.ChannelProduct;
import com.onlinepay.manage.service.IChannelProductService;
import com.onlinepay.manage.service.entity.ChannelProductApi;

/**
 * TODO:渠道产品服务
 * Created by tom on 17/8/18.
 */
@Service
public class ChannelProductServiceImpl implements IChannelProductService {

    @Autowired
    private IChannelProductDao channelProductDao;

    @Override
    public List<ChannelProductApi> selectAll(ChannelProductApi channelProductApi) {
        ChannelProduct channelProduct = new ChannelProduct();
        BeanUtils.copyProperties(channelProductApi,channelProduct);
        List<ChannelProduct> channelProducts = channelProductDao.selectAll(channelProduct);
        List<ChannelProductApi> list = new ArrayList<>();
        for (ChannelProduct cp : channelProducts){
            ChannelProductApi cpa = new ChannelProductApi();
            BeanUtils.copyProperties(cp,cpa);
            list.add(cpa);
        }
        return list;
    }

    @Override
    public int addChannelProduct(ChannelProductApi channelProductApi) {
        ChannelProduct channelProduct = new ChannelProduct();
        BeanUtils.copyProperties(channelProductApi,channelProduct);
        int add = channelProductDao.add(channelProduct);
        return add;
    }

    @Override
    public int updateChannelProduct(ChannelProductApi channelProductApi) {
        ChannelProduct channelProduct = new ChannelProduct();
        BeanUtils.copyProperties(channelProductApi,channelProduct);
        int update = channelProductDao.update(channelProduct);
        return update;
    }

	@Override
	public List<ChannelProductApi> selectChannelProduct(
			ChannelProductApi channelProductApi) {
		ChannelProduct channelProduct = new ChannelProduct();
        BeanUtils.copyProperties(channelProductApi,channelProduct);
        List<ChannelProduct> channelProducts = channelProductDao.selectChannelProduct(channelProduct);
        List<ChannelProductApi> list = new ArrayList<>();
        for (ChannelProduct cp : channelProducts){
            ChannelProductApi cpa = new ChannelProductApi();
            System.out.println();
            BeanUtils.copyProperties(cp,cpa);
            list.add(cpa);
        }
        return list;
	}
}
