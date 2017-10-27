package com.haishengyue.beanlibrary.mallbeans.tinybean;


import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;

/**
 * Created by kanke on 2017/10/11.
 */

public class ArtisTinyBean extends TinyDataBean {
    private static final long serialVersionUID = 2342058809123L;

    /**
     * idata_id : 4148
     * ver : 5399
     * id : 105615
     * name : ligeyihayou
     * picUrl : http://hsyshopimage.img-cn-shanghai.aliyuncs.com/superstar/video/images/8038053a-1607-4564-8cf2-30b6357d826a.jpg
     * followed : 0
     * videoCount : 0
     * isFollowed : false
     */

    private String id;
    private String name;
    private String picUrl;
    private int followed;
    private int videoCount;
    private boolean isFollowed;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getFollowed() {
        return followed;
    }

    public void setFollowed(int followed) {
        this.followed = followed;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public void setVideoCount(int videoCount) {
        this.videoCount = videoCount;
    }

    public boolean isIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(boolean isFollowed) {
        this.isFollowed = isFollowed;
    }
}
