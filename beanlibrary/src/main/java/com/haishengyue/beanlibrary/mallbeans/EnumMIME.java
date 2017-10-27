package com.haishengyue.beanlibrary.mallbeans;


import com.haishengyue.beanlibrary.mallbeans.tinybean.ActivityTinyBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.ArtisTinyBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.BannerTinyBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.ChannelTinyBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.GoodTinyBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.VideoTinyBean;

/**
 * Created by kanke on 2017/10/11.
 */

public enum EnumMIME {
    BANNER(BannerTinyBean.class),
    CHANNEL(ChannelTinyBean.class),
    VIDEO(VideoTinyBean.class),
    ARTIS(ArtisTinyBean.class),
    GOOD(GoodTinyBean.class),
    ACTIVITY(ActivityTinyBean.class);

    private Class clazz;

    EnumMIME(Class clazz) {
        this.clazz = clazz;
    }

    public Class getMIMEClass() {
        return clazz;
    }

}
