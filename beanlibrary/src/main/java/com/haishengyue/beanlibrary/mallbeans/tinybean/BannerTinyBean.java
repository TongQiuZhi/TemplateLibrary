package com.haishengyue.beanlibrary.mallbeans.tinybean;


import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;

/**
 * Created by kanke on 2017/10/11.
 */

public class BannerTinyBean extends TinyDataBean {
    private static final long serialVersionUID = 234209384209123L;
    private long id;
    private String name;
    private String detail;
    private String pic;
    private String url;
    private String destination;
    private long related_id;
    private long agent_user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getRelated_id() {
        return related_id;
    }

    public void setRelated_id(long related_id) {
        this.related_id = related_id;
    }

    public long getAgent_user() {
        return agent_user;
    }

    public void setAgent_user(long agent_user) {
        this.agent_user = agent_user;
    }
}
