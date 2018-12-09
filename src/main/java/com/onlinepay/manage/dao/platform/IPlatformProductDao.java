package com.onlinepay.manage.dao.platform;

import com.onlinepay.manage.dao.platform.entity.Platform;
import com.onlinepay.manage.dao.platform.entity.PlatformProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/8/29.
 */
public interface IPlatformProductDao {

    /**
     * 查询所有产品
     * @param platform
     * @return
     */
    List<PlatformProduct> selectAll(@Param("plat") PlatformProduct platform);

    /**
     * 根据商户实体查询商户
     * @param platform
     * @return
     */
    List<PlatformProduct> selectPageByPlatformProduct(@Param("plat") PlatformProduct platform, @Param("start") int start, @Param("pageSize") int pageSize);


    /**
     * 添加产品
     * @param platform
     * @return
     */
    int add(PlatformProduct platform);

    /**
     * 修改产品
     * @param platform
     * @return
     */
    int update(PlatformProduct platform);

    /**
     * 条件查询总数
     * @param platform
     * @return
     */
    int selectCount(PlatformProduct platform);
}
