package com.onlinepay.manage.service.impl.merchant;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.support.json.JSONParser;
import com.onlinepay.manage.common.page.JqueryPageInfo;
import com.onlinepay.manage.dao.merchant.IMerchantDao;
import com.onlinepay.manage.dao.merchant.entity.Merchant;
import com.onlinepay.manage.service.IMerchantService;
import com.onlinepay.manage.service.entity.MerchantApi;

/**
 * TODO:
 * Created by tom on 17/7/23.
 */
@Service
public class MerchantServiceImpl implements IMerchantService {

    @Autowired
    private IMerchantDao merchantDao;

    @Override
    public JqueryPageInfo<MerchantApi> selectByPage(JqueryPageInfo<MerchantApi> pageInfo, MerchantApi pojo) {
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(pojo,merchant);
        List<Merchant> merchants = merchantDao.selectPageByMerchant(merchant,pageInfo.getStart(),pageInfo.getLength());
        List<MerchantApi> data = copyBean(merchants);
        for(MerchantApi m:data) {
        	String rateConfig = m.getRateConfig();
        	JSONParser j = new JSONParser(rateConfig);
        	Map map =j.parseMap();
        	if(!map.isEmpty()) {
        		if(map.get("fixT0Fee")!=null&&!"".equals(map.get("fixT0Fee"))) {
        			m.setFixT0Fee(new BigDecimal(map.get("fixT0Fee").toString()).divide(new BigDecimal("100"))+"");
        		}else {
        			m.setFixT0Fee("0");
        		}
        			m.setT0Rate(map.get("t0Rate")+"");
        			m.setT1Rate(map.get("t1Rate")+"");
        		if(map.get("fixT1Fee")!=null&&!"".equals(map.get("fixT1Fee"))) {
        			m.setFixT1Fee(new BigDecimal(map.get("fixT1Fee").toString()).divide(new BigDecimal("100"))+"");
        		}else {
        			m.setFixT1Fee("0");
        		}
        	}
        }
        pageInfo.setData(data);
        int count = merchantDao.selectCount(merchant);
        pageInfo.setRecordsFiltered((long)count);
        pageInfo.setRecordsTotal((long)count);
        return pageInfo;
    }

    @Override
    public List<MerchantApi> selectByEntity(MerchantApi pojo) {
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(pojo,merchant);
        List<Merchant> merchants = merchantDao.selectByMerchant(merchant);
        List<MerchantApi> returnList = copyBean(merchants);
        return returnList;
    }
    private String getRegistStatus(String key){
        if(key.equals("10")){
            return  "审核中";
        }
        if(key.equals("20")){
            return  "成功";
        }
        if(key.equals("30")){
            return  "失败";
        }
        return "废弃";
    }

    private List<MerchantApi> copyBean(List<Merchant> merchants){
        List<MerchantApi> returnList = new ArrayList<>();
        for (Merchant mer : merchants){
            MerchantApi merchantApi = new MerchantApi();
            BeanUtils.copyProperties(mer,merchantApi);
            merchantApi.setRegistStatus(getRegistStatus(merchantApi.getRegistStatus()));
            returnList.add(merchantApi);
        }
        return returnList;
        
    }
    

    @Override
    public int update(MerchantApi pojo) {
        if(pojo.getMerchantNo() == null) return 0;
            if(pojo.getEnabled() == null) return 0;
            Merchant merchant = new Merchant();
        BeanUtils.copyProperties(pojo,merchant);
        int update = merchantDao.update(merchant);
        return update;
    }
}
