package com.onlinepay.manage.service.impl.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.payment.IWxOrAliDao;
import com.onlinepay.manage.dao.payment.entity.QrTradeOrder;
import com.onlinepay.manage.service.IWxOrAliOrderService;
import com.onlinepay.manage.service.entity.SelectQrOrderPojo;
import com.onlinepay.manage.service.entity.WxOrAliOrder;
import com.onlinepay.manage.web.util.AmountUtils;

/**
 * TODO:
 * Created by tom on 17/7/23.
 */
@Service
public class WxOrAliServiceImpl implements IWxOrAliOrderService {

    @Autowired
    private IWxOrAliDao wxOrAliDao;

    @Override
    public JqueryPageInfo<WxOrAliOrder> selectByPage(JqueryPageInfo<WxOrAliOrder> pageInfo, SelectQrOrderPojo pojo) {
        //条件查询结果
        QrTradeOrder bean = getBean(pojo);
        List<QrTradeOrder> qrTradeOrders = wxOrAliDao.selectAllByPageEntity(bean, pageInfo.getStart(), pageInfo.getLength());
        List<WxOrAliOrder> wxOrAliOrders = new ArrayList<>();
        if(qrTradeOrders == null) return null;
        for (QrTradeOrder qor : qrTradeOrders){
            WxOrAliOrder wxOrAliOrder = new WxOrAliOrder();
            BeanUtils.copyProperties(qor,wxOrAliOrder);
            wxOrAliOrders.add(wxOrAliOrder);
        }
        pageInfo.setData(wxOrAliOrders);
        //条件查询汇总
        int count = wxOrAliDao.selectCount(getBean(pojo));
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        //根据订单类型分组详情
        List<Map<String, Object>> maps = wxOrAliDao.selectGroupBy(getBean(pojo));
        pageInfo.setMap(totalMap(maps));
        pageInfo.setCode("0");
        return pageInfo;
    }
    private String changeTradeTypeVal(String key){
        if(key.equals("10")){
            return "微信";
        }
        if(key.equals("11")){
            return "微信公众号";
        }
        if(key.equals("20")){
            return "支付宝";
        }
        if(key.equals("21")){
            return "支付宝服务窗";
        }
        return null;
    }
    private String changeTradeStatusVal(String key){
        if(key.equals("1")){
            return "初始化";
        }
        if(key.equals("2")){
            return "待支付";
        }
        if(key.equals("3")){
            return "成功";
        }
        if(key.equals("4")){
            return "失败";
        }
        if(key.equals("45")){
            return "取消";
        }
        return "未知";
    }
    private String changeSettletStatusVal(String key){
        if(key.equals("1")){
            return "未结算";
        }
        if(key.equals("2")){
            return "结算中";
        }
        if(key.equals("3")){
            return "结算成功";
        }
        if(key.equals("4")){
            return "结算失败";
        }
        return "未知";
    }
    private String changeSettletDayVal(String key){
        if(key.equals("0")){
            return "D0";
        }
        if(key.equals("1")){
            return "T1";
        }
        return "未知";
    }
    @Override
    public List<Map<String, String>> selectGroup(SelectQrOrderPojo pojo) {
        List<Map<String, Object>> maps = wxOrAliDao.selectGroupBy(getBean(pojo));
        List<Map<String, String>> returnMap = new ArrayList<>();
        for (Map<String, Object> map : maps){
            Map<String, String> ms = new HashMap<>();
            for(Map.Entry<String,Object> entry : map.entrySet()){
                ms.put(entry.getKey(),String.valueOf(entry.getValue()));
            }
            returnMap.add(ms);
        }
        return returnMap;
    }


    @Override
    public List<WxOrAliOrder> exportExcl(SelectQrOrderPojo pojo) {
        List<QrTradeOrder> qrTradeOrders = wxOrAliDao.selectAllByEntity(getBean(pojo));
        List<WxOrAliOrder> list = new ArrayList<>();
        for (QrTradeOrder qo : qrTradeOrders){
            WxOrAliOrder wxOrAliOrder = new WxOrAliOrder();
            BeanUtils.copyProperties(qo,wxOrAliOrder);
            //交易类型值转换
            wxOrAliOrder.setTradeType(changeTradeTypeVal(wxOrAliOrder.getTradeType()));
            //交易状态值转换
            wxOrAliOrder.setTradeStatus(changeTradeStatusVal(wxOrAliOrder.getTradeStatus()));
            //结算状态值转换
            wxOrAliOrder.setSettleStatus(changeSettletStatusVal(wxOrAliOrder.getSettleStatus()));
            //结算周期值转换
            wxOrAliOrder.setSettleType(changeSettletDayVal(wxOrAliOrder.getSettleType()));
            list.add(wxOrAliOrder);
        }
        return list;
    }


    private Map<String, Object> totalMap(List<Map<String, Object>> li_map) {

        Map<String,Object> map = map = new HashMap<>();
        map.put("10",0);
        map.put("11",0);
        map.put("20",0);
        map.put("21",0);

        map.put("count_10",0);
        map.put("count_11",0);
        map.put("count_20",0);
        map.put("count_21",0);
        if(!li_map.isEmpty() && li_map.size()!=0){
            for (Map<String, Object> m : li_map) {
                try {
                    map.put((String) m.get("TRADE_TYPE"), AmountUtils.changeF2Y(String.valueOf(m.get("CLOSUM"))));
                    map.put("count_"+ m.get("TRADE_TYPE"), StringUtils.isEmpty(m.get("CLOCOUNT"))?0:m.get("CLOCOUNT"));
                }  catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    private QrTradeOrder getBean(SelectQrOrderPojo pojo){
        QrTradeOrder qo = new QrTradeOrder();
        qo.setChannelNo(pojo.getAgentNo());
        qo.setMerchantNo(pojo.getMerNo());
        qo.setOrderNo(pojo.getTradeNo());
        qo.setApplyOrderNo(pojo.getOutTradeNo());
        qo.setCreateDate(pojo.getBeginTime());
        qo.setUpdateDate(pojo.getEndTime());
        qo.setTradeType(pojo.getTradeType());
        qo.setTradeStatus(pojo.getTradeStatus());
        qo.setChannelName(pojo.getChannelName());
        qo.setMerchantName(pojo.getMerchantName());
        qo.setChannelNo(pojo.getChannelNo());
        return  qo;
    }

}
