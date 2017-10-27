package com.haishengyue.beanlibrary.mallbeans.tinybean;


import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;

/**
 * Created by kanke on 2017/10/11.
 */

public class ChannelTinyBean extends TinyDataBean {
    private static final long serialVersionUID = 20384293084520341L;
    /**
     * idata_id : 4141
     * ver : 5372
     * channel_id : 8890431209
     * channel_name : 美妆
     * icon_url : http://via.placeholder.com/350x350
     */

    private long channel_id;
    private String channel_name;
    private String icon_url;
    private String  channel_dec;

    public long getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(long channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getChannel_dec() {
        return channel_dec;
    }

    public void setChannel_dec(String channel_dec) {
        this.channel_dec = channel_dec;
    }
    
}
