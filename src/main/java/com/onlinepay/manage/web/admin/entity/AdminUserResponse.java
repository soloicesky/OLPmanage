package com.onlinepay.manage.web.admin.entity;

import java.util.List;

import com.onlinepay.manage.common.baseres.AjaxBaseRes;
import com.onlinepay.manage.service.entity.AdminUser;

/**
 * TODO:
 * Created by tom on 17/7/10.
 */
public class AdminUserResponse extends AjaxBaseRes {
    private List<AdminUser> data;

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<AdminUser> getData() {
        return data;
    }

    public void setData(List<AdminUser> data) {
        this.data = data;
    }
}
