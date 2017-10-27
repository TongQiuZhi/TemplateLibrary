package com.haishengyue.beanlibrary.mallbeans;

import java.io.Serializable;

/**
 * Created by liyayun on 2016/12/2.
 */
public class MallRecordsBean implements Serializable {
    private static final long serialVersionUID = 43710512349123819L;
    /**
     * agentUser : 105130
     * goods : {"createTime":1477289755000,"id":154,"images":{"Detail":{"images":[{"id":75,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-24/105119/3d4757f89dee4610af4c8f273e3d1939_1.jpg"}],"name":"Detail"}},"intro":"阿拉丁神灯","logo":{"id":74,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-24/105119/3d4757f89dee4610af4c8f273e3d1939_0.jpg"},"name":"阿拉丁神灯","oldPrice":"0.01","postage":"0.00","price":"0.01","shop":{"id":10,"name":"105119","userId":"105119"},"spects":[{"spectClassInfo":{"name":"颜色","spectClass":"Color"},"spects":[{"id":163,"name":"白色"},{"id":164,"name":"黄色"}]}],"status":"OffShelf","stockAmount":1000,"stockAndPrice":[{"display":["颜色:白色"],"id":69,"oldPrice":"0.01","price":"0.01","quantity":500,"spect1":{"id":163,"name":"白色"}},{"display":["颜色:黄色"],"id":70,"oldPrice":"0.01","price":"0.02","quantity":500,"spect1":{"id":164,"name":"黄色"}}],"updateTime":1477289910000,"ver":197}
     */

    private String agentUser;
    private MallGoodsBean goods;

    public String getAgentUser() {
        return agentUser;
    }

    public void setAgentUser(String agentUser) {
        this.agentUser = agentUser;
    }

    public MallGoodsBean getGoods() {
        return goods;
    }

    public void setGoods(MallGoodsBean goods) {
        this.goods = goods;
    }


}
