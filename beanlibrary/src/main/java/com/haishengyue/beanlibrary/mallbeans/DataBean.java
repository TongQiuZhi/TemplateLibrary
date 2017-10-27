package com.haishengyue.beanlibrary.mallbeans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kanke on 2017/10/11.
 */

public class DataBean implements Serializable{
    private static final long serialVersionUID = 23802492304L;
    /**
     * 数据1 设置；  1空 从2中请求；  2空 3中请求
     */
    private long channel_id;//数据 3
    private long content_id;
    private String content_name;
    private String template_type;
    private long ver;//静态数据才有 存在该值需要缓存
    private String content_data_url;//数据 2
    private List<TinyDataBean> datas;//数据 1
    private ExtraWarrpBean extra_warrp;
    
    private String interface_type;//兼容旧接口
    private String tempVar01;//中转变量，传递参数值

    public ExtraWarrpBean getExtra_warrp() {
        return extra_warrp;
    }

    public void setExtra_warrp(ExtraWarrpBean extra_warrp) {
        this.extra_warrp = extra_warrp;
    }

    public long getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(long channel_id) {
        this.channel_id = channel_id;
    }

    public long getContent_id() {
        return content_id;
    }

    public void setContent_id(long content_id) {
        this.content_id = content_id;
    }

    public String getContent_name() {
        return content_name;
    }

    public void setContent_name(String content_name) {
        this.content_name = content_name;
    }

    public String getTemplate_type() {
        return template_type;
    }

    public void setTemplate_type(String template_type) {
        this.template_type = template_type;
    }

    public long getVer() {
        return ver;
    }

    public void setVer(long ver) {
        this.ver = ver;
    }

    public String getContent_data_url() {
        return content_data_url;
    }

    public void setContent_data_url(String content_data_url) {
        this.content_data_url = content_data_url;
    }

    public List<TinyDataBean> getDatas() {
        return datas;
    }

    public void setDatas(List<TinyDataBean> datas) {
        this.datas = datas;
    }

    public String getInterface_type() {
        return interface_type;
    }

    public void setInterface_type(String interface_type) {
        this.interface_type = interface_type;
    }

    public String getTempVar01() {
        return tempVar01;
    }

    public void setTempVar01(String tempVar01) {
        this.tempVar01 = tempVar01;
    }
}
