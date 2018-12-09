package com.onlinepay.manage.service.impl.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepay.manage.common.log.BaseLog;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.payment.IQuickOrderDao;
import com.onlinepay.manage.dao.payment.entity.KjTradeOrder;
import com.onlinepay.manage.service.IQuickOrderService;
import com.onlinepay.manage.service.entity.KjTradeOrderApi;
import com.onlinepay.manage.service.entity.SelectQrOrderPojo;
import com.onlinepay.manage.service.impl.order.enums.SettleEnums;
import com.onlinepay.manage.service.impl.order.enums.TradeEnums;
import com.onlinepay.manage.web.util.AmountUtils;

/**
 * TODO:
 * Created by tom on 17/8/21.
 */
@Service
public class QuickOrderServiceImpl extends BaseLog<QuickOrderServiceImpl> implements IQuickOrderService {

    @Autowired
    private IQuickOrderDao quickOrderDao;

    @Override
    public JqueryPageInfo<KjTradeOrderApi> selectByPage(JqueryPageInfo<KjTradeOrderApi> pageInfo, SelectQrOrderPojo pojo) {
        //条件查询结果
        KjTradeOrder bean = getBean(pojo);
        List<KjTradeOrder> qrTradeOrders = quickOrderDao.selectAllByPageEntity(bean, pageInfo.getStart(), pageInfo.getLength());
        List<KjTradeOrderApi> wxOrAliOrders = new ArrayList<KjTradeOrderApi>();
        if(!qrTradeOrders.isEmpty()) {
        for (KjTradeOrder qor : qrTradeOrders){
            KjTradeOrderApi wxOrAliOrder = new KjTradeOrderApi();
            String accountNo = desenNo(qor.getPayerAccountNo());
            qor.setPayerAccountNo(accountNo);
            BeanUtils.copyProperties(qor,wxOrAliOrder);
            wxOrAliOrders.add(wxOrAliOrder);
        }
        }
        pageInfo.setData(wxOrAliOrders);
        //条件查询汇总
        int count = quickOrderDao.selectCount(getBean(pojo));
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        //根据订单类型分组详情
        List<Map<String, Object>> maps = quickOrderDao.selectGroupBy(getBean(pojo));
        if(!maps.isEmpty()) {
        	
        Map<String, Object> stringObjectMap = maps.get(0);
        if(!stringObjectMap.get("CLOCOUNT").toString().equals("0")){
        	String closum = stringObjectMap.get("CLOSUM").toString();
        	String sumChannelFee = stringObjectMap.get("SUM_CHANNEL_FEE").toString();
        	String sumMerchantFee = stringObjectMap.get("SUM_MERCHANT_FEE").toString();
        	String sumPlatformFee = stringObjectMap.get("SUM_PLATFORM_FEE").toString();
            stringObjectMap.put("CLOSUM",AmountUtils.changeF2Y(closum));
            stringObjectMap.put("SUM_CHANNEL_FEE",AmountUtils.changeF2Y(sumChannelFee));
            stringObjectMap.put("SUM_MERCHANT_FEE",AmountUtils.changeF2Y(sumMerchantFee));
            stringObjectMap.put("SUM_MY_FEE",AmountUtils.changeF2Y(Integer.parseInt(sumMerchantFee)-
            		Integer.parseInt(sumChannelFee)-
            		Integer.parseInt(sumPlatformFee)+""));
        }
        pageInfo.setMap(maps.get(0));
        }
        pageInfo.setCode("0");
        return pageInfo;
    }

    @Override
    public List<Map<String, String>> selectGroup(SelectQrOrderPojo pojo) {
        List<Map<String, Object>> maps = quickOrderDao.selectGroupBy(getBean(pojo));
        List<Map<String, String>> returnMap = new ArrayList<>();
        for (Map<String, Object> map : maps){
            Map<String, String> ms = new HashMap<String,String>();
            for(Map.Entry<String,Object> entry : map.entrySet()){
                ms.put(entry.getKey(),String.valueOf(entry.getValue()));
            }
            returnMap.add(ms);
        }
        return returnMap;
    }

    @Override
    public List<KjTradeOrderApi> exportExcl(SelectQrOrderPojo pojo) {
        List<KjTradeOrder> qrTradeOrders = quickOrderDao.selectAllByEntity(getBean(pojo));
        List<KjTradeOrderApi> list = new ArrayList<>();
        for (KjTradeOrder qo : qrTradeOrders){
            KjTradeOrderApi wxOrAliOrder = new KjTradeOrderApi();
            BeanUtils.copyProperties(qo,wxOrAliOrder);
            //交易状态值转换
            wxOrAliOrder.setTradeStatus(TradeEnums.chooseTradeStatus(wxOrAliOrder.getTradeStatus()));
            //结算状态值转换
            wxOrAliOrder.setSettleStatus(SettleEnums.chooseTradeStatus(wxOrAliOrder.getSettleStatus()));
            //结算周期值转换
            wxOrAliOrder.setSettleType(SettleEnums.chooseSettleDay(wxOrAliOrder.getSettleType()));
            
            list.add(wxOrAliOrder);
        }
        return list;
    }


    private KjTradeOrder getBean(SelectQrOrderPojo pojo){
        KjTradeOrder qo = new KjTradeOrder();
        qo.setChannelNo(pojo.getAgentNo());
        qo.setMerchantNo(pojo.getMerNo());
        qo.setOrderNo(pojo.getTradeNo());
        qo.setApplyOrderNo(pojo.getOutTradeNo());
        qo.setCreateDate(pojo.getBeginTime());
        qo.setUpdateDate(pojo.getEndTime());
        qo.setTradeStatus(pojo.getTradeStatus());
        qo.setChannelNo(pojo.getChannelNo());
        qo.setChannelName(pojo.getChannelName());
        qo.setMerchantName(pojo.getMerchantName());
        qo.setPlatformCode(pojo.getPlatformCode());
        return  qo;
    }
    /**
	 * 卡号脱敏
	 * 
	 * @param telphone
	 * @return
	 */
	public String desenNo(String telphone) {
		if (telphone.isEmpty()) {
			return "";
		}
		if (telphone.length() < 4) {
			return telphone;
		}
		String before = telphone.substring(0, 6);
		String last = telphone.substring(telphone.length() - 4);
		return before + "******" + last;
	}

}
