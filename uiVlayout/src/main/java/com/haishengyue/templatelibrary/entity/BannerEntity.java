package com.haishengyue.templatelibrary.entity;

/**
 * Created by kanke on 2017/11/1.
 */

public class BannerEntity extends BaseEntity {
    private static final long serialVersionUID = 468397238420L;

    private String bannerDec;
    private String bannerUrl;

    public BannerEntity(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getBannerDec() {
        return bannerDec;
    }

    public void setBannerDec(String bannerDec) {
        this.bannerDec = bannerDec;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }
}
