package com.haishengyue.beanlibrary.mallbeans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kanke on 2017/10/11.
 * <p>
 * 数据的最小单元  具体显示需要子类完成
 */

public abstract class TinyDataBean implements Serializable {
    private static final long serialVersionUID = 20384209384021421L;
    private String MIME;//类型
    private long idata_id;
    private String idata_name;//预留
    private long ver;
    private String btn_name;
    private String mark;

    //##############################################################################################
    //TODO 删除
    private String template_type;
    private String content_name;
    private String content_data_url;
    private long content_id;
    private List<TinyDataBean> datas;
    private long channel_id;
    private String channel_dec;
    private String channel_name;
    private String icon_url;

    //##############################################################################################
    public List<TinyDataBean> getDatas() {
        return datas;
    }
    public void setDatas(List<TinyDataBean> datas) {
        this.datas = datas;
    }

    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }
    public String getChannel_dec() {
        return channel_dec;
    }

    public void setChannel_dec(String channel_dec) {
        this.channel_dec = channel_dec;
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

    public String getMIME() {
        return MIME;
    }

    public void setMIME(String MIME) {
        this.MIME = MIME;
    }

    public long getIdata_id() {
        return idata_id;
    }

    public void setIdata_id(long idata_id) {
        this.idata_id = idata_id;
    }

    public String getIdata_name() {
        return idata_name;
    }

    public void setIdata_name(String idata_name) {
        this.idata_name = idata_name;
    }

    public long getVer() {
        return ver;
    }

    public void setVer(long ver) {
        this.ver = ver;
    }
    
    //==============================================================================================

    public String getTemplate_type() {
        return template_type;
    }

    public void setTemplate_type(String template_type) {
        this.template_type = template_type;
    }

    public String getContent_name() {
        return content_name;
    }

    public void setContent_name(String content_name) {
        this.content_name = content_name;
    }


    public String getContent_data_url() {
        return content_data_url;
    }

    public void setContent_data_url(String content_data_url) {
        this.content_data_url = content_data_url;
    }

    public long getContent_id() {
        return content_id;
    }

    public void setContent_id(long content_id) {
        this.content_id = content_id;
    }

    public long getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(long channel_id) {
        this.channel_id = channel_id;
    }


    public String getBtn_name() {
        return btn_name;
    }

    public void setBtn_name(String btn_name) {
        this.btn_name = btn_name;
    }
}
