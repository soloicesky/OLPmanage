package com.onlinepay.manage.dao.organ.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 机构账户
 */
public class OrganAccount {

    /**
     * id
     */
    private Integer id;
    /**
     * 机构名称
     */
    private String organ_name;
    /**
     * 机构id
     */
    private Integer organ_id;
    /**
     * 账户余额
     */
    private BigDecimal total_amount;
    /**
     * 可用余额
     */
    private BigDecimal use_amount;
    /**
     * 可提现余额
     */
    private BigDecimal draw_amount;
    /**
     * 冻结金额
     */
    private BigDecimal freeze_amount;
    /**
     * 状态 0:正常 1:停用 2:冻结
     */
    private Integer status;
    /**
     * 创建者
     */
    private Integer create_by;
    /**
     * 创建时间
     */
    private Date create_date;
    /**
     * 更新时间
     */
    private Date update_date;
    /**
     * 更新者
     */
    private Integer update_by;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 删除标记（0：正常；1：删除）
     */
    private Integer del_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgan_id() {
        return organ_id;
    }

    public void setOrgan_id(Integer organ_id) {
        this.organ_id = organ_id;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public BigDecimal getUse_amount() {
        return use_amount;
    }

    public void setUse_amount(BigDecimal use_amount) {
        this.use_amount = use_amount;
    }

    public BigDecimal getDraw_amount() {
        return draw_amount;
    }

    public void setDraw_amount(BigDecimal draw_amount) {
        this.draw_amount = draw_amount;
    }

    public BigDecimal getFreeze_amount() {
        return freeze_amount;
    }

    public void setFreeze_amount(BigDecimal freeze_amount) {
        this.freeze_amount = freeze_amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreate_by() {
        return create_by;
    }

    public void setCreate_by(Integer create_by) {
        this.create_by = create_by;
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

    public Integer getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(Integer update_by) {
        this.update_by = update_by;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }

    public String getTotalAmount() {
        return total_amount.toString();
    }

    public String getDrawAmount() {
        return this.draw_amount.toString();
    }

    public String getFreezeAmount() {
        return this.freeze_amount.toString();
    }

    public String getUseAmount() {
        return this.use_amount.toString();
    }

    public String getOrgan_name() {
        return organ_name;
    }

    public void setOrgan_name(String organ_name) {
        this.organ_name = organ_name;
    }
}