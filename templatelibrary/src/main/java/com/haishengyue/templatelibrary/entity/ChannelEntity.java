package com.haishengyue.templatelibrary.entity;

/**
 * Created by kanke on 2017/11/1.
 */

public class ChannelEntity extends BaseEntity {
    private static final long serialVersionUID = 34802394203123L;

    private String channelName;
    private String channelUrl;

    public ChannelEntity(String channelName, String channelUrl) {
        this.channelName = channelName;
        this.channelUrl = channelUrl;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }
}
