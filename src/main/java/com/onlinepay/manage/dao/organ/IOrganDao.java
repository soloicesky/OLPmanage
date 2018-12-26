package com.onlinepay.manage.dao.organ;

import com.onlinepay.manage.dao.organ.entity.Organ;
import com.onlinepay.manage.dao.organ.entity.OrganAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrganDao {

    /**
     * 新增机构
     * @param organ
     */
    void addOrgan(@Param("organ") Organ organ);

    /**
     * 新增机构账户
     * @param organAccount
     */
    void addAccount(@Param("organAccount") OrganAccount organAccount);

    /**
     * 按照条件查询
     * @param organ
     * @return
     */
    Organ getOrgan(@Param("organ") Organ organ);

    OrganAccount getOrganAcount(@Param("organAccount") OrganAccount organAccount);

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
