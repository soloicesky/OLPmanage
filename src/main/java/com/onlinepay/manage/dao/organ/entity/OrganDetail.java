package com.onlinepay.manage.dao.organ.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 机构流水
 */
public class OrganDetail {

    /**
     * `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
     *   `office_id` int(11) NOT NULL COMMENT '机构ID',
     *   `account_id` int(11) NOT NULL COMMENT '机构账户ID',
     *   `oper_type` char(1) DEFAULT NULL COMMENT '操作类型 1:收入 2:支出 3:冻结 4:提现 5:差错+ 6:差错-',
     *   `actual_amount` decimal(12,2) DEFAULT '0.00' COMMENT '发生金额',
     *   `actual_date` varchar(10) DEFAULT NULL COMMENT '发生日期',
     *   `actual_time` varchar(8) DEFAULT NULL COMMENT '发生时间',
     *   `create_by` int(11) NOT NULL COMMENT '创建者',
     *   `create_date` datetime DEFAULT NULL COMMENT '创建时间',
     *   `update_by` int(11) DEFAULT NULL COMMENT '更新者',
     *   `update_date` datetime DEFAULT NULL COMMENT '更新时间',
     *   `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
     *   `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
     */

    /**
     * id
     */
    private Integer id;
    /**
     * 机构号
     */
    private Integer office_id;
    /**
     * 操作类型 1:收入 2:支出 3:冻结 4:提现 5:差错+ 6:差错-
     */
    private short oper_type;
    /**
     * 发生金额
     */
    private BigDecimal actual_amount;

    private Date actual_date;

}
