package com.onlinepay.manage.dao.organ;

import com.onlinepay.manage.dao.organ.entity.Organ;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrganDao {

    /**
     * 新增
     * @param organ
     */
    void add(@Param("organ")Organ organ);

    /**
     *  分页查询机构
     * @param start
     * @param pageSize
     * @return
     */
    List<Organ> selectPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("organ")Organ organ);

    /**
     * 总数
     * @return
     */
    int selectCount(@Param("organ")Organ organ);
}
