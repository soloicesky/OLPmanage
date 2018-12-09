package com.onlinepay.manage.dao.platform;

import com.onlinepay.manage.dao.platform.entity.Platform;
import com.onlinepay.manage.dao.product.entity.ProductRouteFix;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO:
 * Created by tom on 17/8/29.
 */
public interface IPlatformDao {

    /**
     * 查询所有产品
     * @param platform
     * @return
     */
    List<Platform> selectAll(@Param("plat") Platform platform);
    List<Platform> selectByProduct(@Param("product") String product);
    /**
     * 查询所有产品
     * @param platform
     * @return
     */
    List<Platform> findPlatform(@Param("notin") List platform);
    /**
     * 根据商户实体查询商户
     * @param platform
     * @return
     */
    List<Platform> selectPageByPlatform(@Param("plat") Platform platform, @Param("start") int start, @Param("pageSize") int pageSize);


    /**
     * 添加产品
     * @param platform
     * @return
     */
    int add(Platform platform);

    /**
     * 修改产品
     * @param platform
     * @return
     */
    int update(Platform platform);

    /**
     * 条件查询总数
     * @param platform
     * @return
     */
    int selectCount(Platform platform);

    Platform selectById(@Param("id")Long id);
}
