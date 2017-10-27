package com.haishengyue.beanlibrary.mallbeans.tinybean;


import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;

/**
 * Created by kanke on 2017/10/11.
 */

public class ActivityTinyBean extends TinyDataBean {
    private static final long serialVersionUID = 2342874414209123L;

    /**
     * idata_id : 4141
     * ver : 5372
     * actRepresentId : 4
     * activityId : 1
     * brandId : 1
     * brandName : 膜家面膜
     * brandDesc : 一款补水美白面膜
     * brandLogo : https://hsyshopimage.oss-cn-shanghai.aliyuncs.com/2017-03-28/105340/a8431d58450a426a85649d0bb4ea4e10_0.png
     * representFee : 10万
     * ended : 2
     * startDate : 1501556400000
     * endDate : 1506826800000
     * actimg : http://hsyshopimage.oss-cn-shanghai.aliyuncs.com/activitylogo44.jpg
     * actname : 膜家面膜
     * ttl : -858540406
     * participantCount : 117
     * participantVideosCount : 266
     */

    private int actRepresentId;
    private int activityId;
    private int brandId;
    private String brandName;
    private String brandDesc;
    private String brandLogo;
    private String representFee;
    private int ended;
    private long startDate;
    private long endDate;
    private String actimg;
    private String actname;
    private int ttl;
    private int participantCount;
    private int participantVideosCount;

    public int getActRepresentId() {
        return actRepresentId;
    }

    public void setActRepresentId(int actRepresentId) {
        this.actRepresentId = actRepresentId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandDesc() {
        return brandDesc;
    }

    public void setBrandDesc(String brandDesc) {
        this.brandDesc = brandDesc;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getRepresentFee() {
        return representFee;
    }

    public void setRepresentFee(String representFee) {
        this.representFee = representFee;
    }

    public int getEnded() {
        return ended;
    }

    public void setEnded(int ended) {
        this.ended = ended;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getActimg() {
        return actimg;
    }

    public void setActimg(String actimg) {
        this.actimg = actimg;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public int getTtl() {
        return ttl;
    }

    public void setTtl(int ttl) {
        this.ttl = ttl;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public int getParticipantVideosCount() {
        return participantVideosCount;
    }

    public void setParticipantVideosCount(int participantVideosCount) {
        this.participantVideosCount = participantVideosCount;
    }
}
