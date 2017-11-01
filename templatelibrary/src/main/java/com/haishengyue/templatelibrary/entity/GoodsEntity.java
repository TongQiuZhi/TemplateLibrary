package com.haishengyue.templatelibrary.entity;

/**
 * Created by kanke on 2017/11/1.
 */

public class GoodsEntity extends BaseEntity {
    private static final long serialVersionUID = 405734689234021L;

    private String goodsName;
    private String goodsUrl;
    private String btn;
    //这两个值需要处理成html 格式需提前处理
    private String price;
    private String profit;
    private boolean isProfit;//是否显示profit

    public GoodsEntity(String goodsName, String goodsUrl, String btn, String price, String profit, boolean isProfit) {
        this.goodsName = goodsName;
        this.goodsUrl = goodsUrl;
        this.btn = btn;
        this.price = price;
        this.profit = profit;
        this.isProfit = isProfit;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getBtn() {
        return btn;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public boolean isProfit() {
        return isProfit;
    }

    public void setProfit(boolean profit) {
        isProfit = profit;
    }
}
