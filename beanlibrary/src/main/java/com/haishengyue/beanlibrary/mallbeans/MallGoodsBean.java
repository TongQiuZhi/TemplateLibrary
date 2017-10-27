package com.haishengyue.beanlibrary.mallbeans;

import java.io.Serializable;

/**
 * Created by liyayun on 2016/11/2.
 */
public class MallGoodsBean implements Serializable {
    private static final long serialVersionUID = 2134871037140341L;
    private long createTime;
    private long id;
    private String intro;
    private LogoBean logo;
    private String name;
    private String oldPrice;
    private String postage;
    private String price;
    private ShopBean shop;
    private String status;
    private int stockAmount;
    private long updateTime;
    private int ver;


    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public LogoBean getLogo() {
        return logo;
    }

    public void setLogo(LogoBean logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getPostage() {
        return postage;
    }

    public void setPostage(String postage) {
        this.postage = postage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public ShopBean getShop() {
        return shop;
    }

    public void setShop(ShopBean shop) {
        this.shop = shop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public int getVer() {
        return ver;
    }

    public void setVer(int ver) {
        this.ver = ver;
    }

    public static class LogoBean implements Serializable{
        private static final long serialVersionUID = 451823418901L;
        /**
         * id : 74
         * imageType : Img
         * size : 0
         * status : 0
         * url : http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-24/105119/3d4757f89dee4610af4c8f273e3d1939_0.jpg
         */

        private int id;
        private String imageType;
        private int size;
        private int status;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageType() {
            return imageType;
        }

        public void setImageType(String imageType) {
            this.imageType = imageType;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class ShopBean implements Serializable{
        private static final long serialVersionUID = 134458349582139L;
        /**
         * id : 10
         * name : 105119
         * userId : 105119
         */

        private int id;
        private String name;
        private String userId;

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

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

}
