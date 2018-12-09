package com.onlinepay.manage.web.product.response;

import java.util.List;

import com.onlinepay.manage.common.baseres.AjaxBaseRes;

/**
 * TODO:
 * Created by tom on 17/8/29.
 */
public class ReturnDataResponse<T> extends AjaxBaseRes {

    private List<T> listdata;
    private T data;

    public List<T> getListdata() {
        return listdata;
    }

    public void setListdata(List<T> listdata) {
        this.listdata = listdata;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
