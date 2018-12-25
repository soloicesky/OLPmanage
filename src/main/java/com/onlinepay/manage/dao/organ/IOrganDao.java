package com.onlinepay.manage.dao.organ;

import com.onlinepay.manage.dao.organ.entity.OrganAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrganDao {

    /**
     * 新增
     * @param organAccount
     */
    void add(@Param("organAccount") OrganAccount organAccount);

    /**
     *  分页查询机构
     * @param start
     * @param pageSize
     * @return
     */
    List<OrganAccount> selectAccountPage(@Param("start") int start, @Param("pageSize") int pageSize, @Param("organAccount") OrganAccount organAccount);

    /**
     * 总数
     * @return
     */
    int selectAccountCount(@Param("organAccount") OrganAccount organAccount);
}
