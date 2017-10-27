package com.haishengyue.beanlibrary.mallbeans.tinybean;


import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;

/**
 * Created by kanke on 2017/10/11.
 */

public class VideoTinyBean extends TinyDataBean {
    private static final long serialVersionUID = 234209453384209123L;


    /**
     * idata_id : 4141
     * ver : 5372
     * funs : 4267
     * user_id : 106893
     * nickname : 孙晨
     * pic_url : http://wx.qlogo.cn/mmopen/chwVCoDzooAfwYiaZM2r9Xxq4VR1ggO6lYtrLEtrLA1d6qblDciaoVDxZbFa3CEGlhibdLUZibKeDqJevhE1C6xDcHrQjftSPEvA/0
     * followed : false
     * mark : 0
     * isFollowd : false
     * title : 他们说我帽子换得快
     * note : 嘻哈吗？
     * notecount : 0
     * videoitemid : 50270287611649
     * picurl : http://hsyshopimage.img-cn-shanghai.aliyuncs.com/superstar/video/images/105497/59c0f537e4b089943ce62094.png
     * playcount : 1236
     * likecount : 0
     * videoPlayUrl : {"src_1":"http://1252830422.vod2.myqcloud.com/ea4c729cvodgzp1252830422/adb4524f9031868223244565688/f0.mp4"}
     */

    private String funs;
    private String user_id;
    private String nickname;
    private String pic_url;
    private String followed;
    private String mark;
    private boolean isFollowd;
    private String title;
    private String note;
    private int notecount;
    private long videoitemid;
    private String picurl;
    private int playcount;
    private int likecount;
    private VideoPlayUrlBean videoPlayUrl;


    public String getFuns() {
        return funs;
    }

    public void setFuns(String funs) {
        this.funs = funs;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getFollowed() {
        return followed;
    }

    public void setFollowed(String followed) {
        this.followed = followed;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public boolean isIsFollowd() {
        return isFollowd;
    }

    public void setIsFollowd(boolean isFollowd) {
        this.isFollowd = isFollowd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getNotecount() {
        return notecount;
    }

    public void setNotecount(int notecount) {
        this.notecount = notecount;
    }

    public long getVideoitemid() {
        return videoitemid;
    }

    public void setVideoitemid(long videoitemid) {
        this.videoitemid = videoitemid;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public int getLikecount() {
        return likecount;
    }

    public void setLikecount(int likecount) {
        this.likecount = likecount;
    }

    public VideoPlayUrlBean getVideoPlayUrl() {
        return videoPlayUrl;
    }

    public void setVideoPlayUrl(VideoPlayUrlBean videoPlayUrl) {
        this.videoPlayUrl = videoPlayUrl;
    }

}
