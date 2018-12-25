package com.onlinepay.manage.dao.organ.entity;

import java.util.Date;

/**
 * 机构
 */
public class Organ {

    /**
     * id
     */
    private Integer id;
    /**
     * 登陆账号
     */
    private Integer login_id;
    /**
     * 机构名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date create_date;
    /**
     * 更新时间
     */
    private Date update_date;
    /**
     * 机构号
     */
    private String organ_no;
    /**
     * 公钥
     */
    private String public_key;
    /**
     * 身份标识key
     */
    private String access_key;
    /**
     * 结算卡号
     */
    private String settle_carno;
    /**
     * 结算人
     */
    private String settle_name;
    /**
     * 结算银行
     */
    private String settle_bank;
    /**
     * 开户行号
     */
    private String bank_no;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Integer login_id) {
        this.login_id = login_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public String getOrgan_no() {
        return organ_no;
    }

    public void setOrgan_no(String organ_no) {
        this.organ_no = organ_no;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getAccess_key() {
        return access_key;
    }

    public void setAccess_key(String access_key) {
        this.access_key = access_key;
    }

    public String getSettle_carno() {
        return settle_carno;
    }

    public void setSettle_carno(String settle_carno) {
        this.settle_carno = settle_carno;
    }

    public String getSettle_name() {
        return settle_name;
    }

    public void setSettle_name(String settle_name) {
        this.settle_name = settle_name;
    }

    public String getSettle_bank() {
        return settle_bank;
    }

    public void setSettle_bank(String settle_bank) {
        this.settle_bank = settle_bank;
    }

    public String getBank_no() {
        return bank_no;
    }

    public void setBank_no(String bank_no) {
        this.bank_no = bank_no;
    }
}
