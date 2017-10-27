package com.haishengyue.beanlibrary.mallbeans.tinybean;


import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;

/**
 * Created by kanke on 2017/10/11.
 */

public class GoodTinyBean extends TinyDataBean {
    private static final long serialVersionUID = 2342645841523L;


    /**
     * idata_id : 4141
     * ver : 5372
     * id : 14903
     * name : 泰国mistine双头三色咬唇妆口红染唇液唇釉
     * price : 28.00
     * oldPrice : 28.00
     * imageType : Img
     * url : https://hsyshopimage.oss-cn-shanghai.aliyuncs.com/2017-09-21/222001/0a1b1108ce8a4fbd9b6284498e1fe2dd_0.png
     * shop : {"id":1348,"name":"岩石商贸","hotline":null,"userId":"222001","role":10,"mark":0,"picurl":"http://hsyshopimage.oss-cn-shanghai.aliyuncs.com/superstarLogo1024.png"}
     */

    private long id;
    private String name;
    private String price;
    private String oldPrice;
    private String imageType;
    private String url;
    private ShopBean shop;

    private String agentUser;

    
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ShopBean getShop() {
        return shop;
    }

    public void setShop(ShopBean shop) {
        this.shop = shop;
    }

    public String getAgentUser() {
        return agentUser;
    }

    public void setAgentUser(String agentUser) {
        this.agentUser = agentUser;
    }
}
