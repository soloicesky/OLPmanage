package com.onlinepay.manage.web.channel.res;

import com.onlinepay.manage.common.baseres.AjaxBaseRes;

/**
 * TODO:
 * Created by tom on 17/8/15.
 */
public class AddResponse extends AjaxBaseRes {
    private String channelNo;

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }
}
