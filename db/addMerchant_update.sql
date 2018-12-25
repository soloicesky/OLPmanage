#新增机构商户列表菜单
INSERT INTO paygateway.T_SYS_MENU (id, name, url, level, icon_class, parent_id, sort)
VALUES (40, '机构列表', 'organAccount/List', 'T', null, 22, 2);
#新增机构账户余额
INSERT INTO paygateway.T_SYS_MENU (id, name, url, level, icon_class, parent_id, sort)
VALUES (41, '机构账户余额', 'organAccount/balance', 'T', null, 22, 3);
#机构账户明细
INSERT INTO paygateway.T_SYS_MENU (id, name, url, level, icon_class, parent_id, sort)
VALUES (42, '机构流水明细', 'organAccount/detail', 'T', null, 22, 4);
#机构账户提现
INSERT INTO paygateway.T_SYS_MENU (id, name, url, level, icon_class, parent_id, sort)
VALUES (43, '机构提现列表', 'organAccount/withdraw', 'T', null, 22, 5);

#商户模板用户
INSERT INTO T_SYS_USER (id, nick_name, login_name, login_pwd, role_type, is_del, is_activity, create_time, data_version, admin_no, phone)
VALUES (7, '商户模板', 'organModel', 'D4B533155B82393893DBAFA5711822A8', '7', 'F', 'F', '2018-12-15 18:32:32', 7, '0', '13888888888');
#为商户模板用户添加权限 机构用户/账户余额/账户明细/账户提现
INSERT INTO T_SYS_USER_MENU (id, user_id, menu_id, power_btn, is_del) VALUES (207, 7, 22, 0, 'T');
INSERT INTO T_SYS_USER_MENU (id, user_id, menu_id, power_btn, is_del) VALUES (208, 7, 40, 0, 'T');
INSERT INTO T_SYS_USER_MENU (id, user_id, menu_id, power_btn, is_del) VALUES (209, 7, 41, 0, 'T');
INSERT INTO T_SYS_USER_MENU (id, user_id, menu_id, power_btn, is_del) VALUES (210, 7, 42, 0, 'T');
INSERT INTO T_SYS_USER_MENU (id, user_id, menu_id, power_btn, is_del) VALUES (211, 7, 43, 0, 'T');

#user 的 role_type 新增7

CREATE TABLE organ
(
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    create_date datetime,
    update_date datetime,
    version bigint,
    name varchar(50) COMMENT '名称',
    login_id int(11) NOT NULL COMMENT '登陆账户id',
    organ_no varchar(20) NOT NULL COMMENT '机构号',
    remarks varchar(200) COMMENT '备注',
    public_key varchar(512) COMMENT '公钥',
    access_key varchar(200) COMMENT '身份标识key',
    settle_carno varchar(100) COMMENT '结算卡号',
    settle_name varchar(100) COMMENT '结算人',
    settle_bank varchar(100) COMMENT '结算银行',
    bank_no varchar(100) COMMENT '开户行号'
);
CREATE UNIQUE INDEX organ_id_uindex ON organ (id);
CREATE UNIQUE INDEX organ_organ_no_uindex ON organ (organ_no);
ALTER TABLE organ COMMENT = '机构表';

CREATE TABLE `organ_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `organ_id` int(11) NOT NULL COMMENT '机构ID',
  `total_amount` decimal(12,2) DEFAULT '0.00' COMMENT '账户总额',
  `use_amount` decimal(12,2) DEFAULT '0.00' COMMENT '可用余额',
  `draw_amount` decimal(12,2) DEFAULT '0.00' COMMENT '提现金额',
  `freeze_amount` decimal(12,2) DEFAULT '0.00' COMMENT '冻结金额',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态 0:正常 1:停用 2:冻结',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ;
ALTER TABLE organAccount COMMENT = '机构账户余额信息表';


CREATE TABLE `organ_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `organ_id` int(11) NOT NULL COMMENT '机构ID',
  `account_id` int(11) NOT NULL COMMENT '机构账户ID',
  `oper_type` char(1) DEFAULT NULL COMMENT '操作类型 1:收入 2:支出 3:冻结 4:提现 5:差错+ 6:差错-',
  `actual_amount` decimal(12,2) DEFAULT '0.00' COMMENT '发生金额',
  `actual_date` varchar(10) DEFAULT NULL COMMENT '发生日期',
  `actual_time` varchar(8) DEFAULT NULL COMMENT '发生时间',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
);
ALTER TABLE organ_detail COMMENT = '机构账户明细表';


CREATE TABLE `organ_withdraw` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `organ_id` int(11) NOT NULL COMMENT '机构ID',
  `account_id` int(11) NOT NULL COMMENT '机构账户ID',
  `status` char(1) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '操作类型 0:审核中 1:待出款 2:已出款 3:审核失败',
  `draw_amount` decimal(12,2) DEFAULT '0.00' COMMENT '提现金额',
  `draw_date` varchar(10) DEFAULT NULL COMMENT '提现日期',
  `draw_time` varchar(8) DEFAULT NULL COMMENT '提现时间',
  `audit_by` int(11) NOT NULL COMMENT '审核者',
  `audit_date` datetime DEFAULT NULL COMMENT '审核时间',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
);
ALTER TABLE organ_withdraw COMMENT = '机构账户提现表(账户提现、待审核、待打款)';
