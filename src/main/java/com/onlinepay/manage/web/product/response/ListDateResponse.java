package com.onlinepay.manage.web.product.response;

import com.onlinepay.manage.common.baseres.AjaxBaseRes;

/**
 * TODO:
 * Created by tom on 17/8/28.
 */
public class ListDateResponse extends AjaxBaseRes {
    private String data;
    private String subProductCode;

    public String getSubProductCode() {
        return subProductCode;
    }

    public void setSubProductCode(String subProductCode) {
        this.subProductCode = subProductCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
