package com.haishengyue.beanlibrary.mallbeans.tinybean;

import java.io.Serializable;

/**
 * Created by kanke on 2017/10/12.
 */

public class ShopBean implements Serializable{
    private static final long serialVersionUID = 23038429305234L;
    /**
     * id : 1348
     * name : 岩石商贸
     * hotline : null
     * userId : 222001
     * role : 10
     * mark : 0
     * picurl : http://hsyshopimage.oss-cn-shanghai.aliyuncs.com/superstarLogo1024.png
     */

    private int id;
    private String name;
    private Object hotline;
    private String userId;
    private int role;
    private int mark;
    private String picurl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getHotline() {
        return hotline;
    }

    public void setHotline(Object hotline) {
        this.hotline = hotline;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}