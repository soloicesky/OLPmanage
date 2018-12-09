package com.onlinepay.manage.dao.merchant;

import com.onlinepay.manage.dao.channel.entity.Channel;
import com.onlinepay.manage.dao.merchant.entity.Merchant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/7/23.
 */
public interface IMerchantDao {
    /**
     * 根据商户实体查询商户
     * @param merchant
     * @return
     */
    List<Merchant> selectByMerchant(@Param("mer") Merchant merchant);

    /**
     * 根据商户实体查询商户
     * @param merchant
     * @return
     */
    List<Merchant> selectPageByMerchant(@Param("mer") Merchant merchant,@Param("start") int start,@Param("pageSize") int pageSize);

    /**
     * 条件查询总数
     * @param merchant
     * @return
     */
    int selectCount(@Param("mer") Merchant merchant);
    
    /**
     * 根据实体修改商户信息
     * @param channel
     * @return
     */
    int update(@Param("mer") Merchant merchant);

}
