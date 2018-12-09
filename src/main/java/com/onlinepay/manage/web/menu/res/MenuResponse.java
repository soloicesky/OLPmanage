package com.onlinepay.manage.web.menu.res;

import java.util.List;

import com.onlinepay.manage.common.baseres.AjaxBaseRes;
import com.onlinepay.manage.web.menu.entity.TreeMode;

/**
 * TODO:
 * Created by tom on 17/7/7.
 */
public class MenuResponse extends AjaxBaseRes {

    private List<TreeMode> data;

    public List<TreeMode> getData() {
        return data;
    }

    public void setData(List<TreeMode> data) {
        this.data = data;
    }
}
