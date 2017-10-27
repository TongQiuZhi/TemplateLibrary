package com.haishengyue.beanlibrary.mallbeans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liyayun on 2016/11/1.
 */

public class ResMallHome implements Serializable {
    private static final long serialVersionUID = 34014715808230L;

    /**
     * result : {"pageInfo":{"pageNo":0,"pageRecordSize":10,"totalPage":1,"totalRecord":3},"records":[{"agentUser":"105130","goods":{"createTime":1477289755000,"id":154,"images":{"Detail":{"images":[{"id":75,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-24/105119/3d4757f89dee4610af4c8f273e3d1939_1.jpg"}],"name":"Detail"}},"intro":"阿拉丁神灯","logo":{"id":74,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-24/105119/3d4757f89dee4610af4c8f273e3d1939_0.jpg"},"name":"阿拉丁神灯","oldPrice":"0.01","postage":"0.00","price":"0.01","shop":{"id":10,"name":"105119","userId":"105119"},"spects":[{"spectClassInfo":{"name":"颜色","spectClass":"Color"},"spects":[{"id":163,"name":"白色"},{"id":164,"name":"黄色"}]}],"status":"OffShelf","stockAmount":1000,"stockAndPrice":[{"display":["颜色:白色"],"id":69,"oldPrice":"0.01","price":"0.01","quantity":500,"spect1":{"id":163,"name":"白色"}},{"display":["颜色:黄色"],"id":70,"oldPrice":"0.01","price":"0.02","quantity":500,"spect1":{"id":164,"name":"黄色"}}],"updateTime":1477289910000,"ver":197}},{"agentUser":"105139","goods":{"createTime":1475927806000,"id":83,"images":{"Detail":{"images":[{"id":6,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-08/105130/6782eae303d0433c8c07b195fc160133_1.jpg"}],"name":"Detail"}},"intro":"好和谁啊","logo":{"id":5,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-08/105130/6782eae303d0433c8c07b195fc160133_0.jpg"},"name":"好和谁啊","oldPrice":"2.00","postage":"0.00","price":"1.00","shop":{"id":2,"name":"105130","userId":"105130"},"spects":[{"spectClassInfo":{"name":"color","spectClass":"Color"},"spects":[{"id":143,"name":"蓝"},{"id":144,"name":"黄"}]},{"spectClassInfo":{"name":"size","spectClass":"Size"},"spects":[{"id":102,"name":"中"},{"id":131,"name":"大"},{"id":132,"name":"小"}]}],"status":"OffShelf","stockAmount":1334,"stockAndPrice":[{"display":["size:大"],"id":20,"oldPrice":"2.00","price":"1.00","quantity":111,"spect2":{"id":131,"name":"大"}},{"display":["size:小"],"id":19,"oldPrice":"2.00","price":"1.00","quantity":1111,"spect2":{"id":132,"name":"小"}},{"display":["color:蓝","size:中"],"id":208,"oldPrice":"0.40","price":"1.00","quantity":1,"spect1":{"id":143,"name":"蓝"},"spect2":{"id":102,"name":"中"}},{"display":["size:中"],"id":21,"oldPrice":"2.00","price":"3.00","quantity":111,"spect2":{"id":102,"name":"中"}}],"updateTime":1480168152000,"ver":297}},{"agentUser":"105130","goods":{"categoryCode":"测试分类","createTime":1476960832000,"id":117,"images":{"Detail":{"images":[{"id":49,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.oss-cn-shanghai.aliyuncs.com/2016-10-19/105119/7ac916d99beb4ced9752cdff393e89fe_1.jpg"}],"name":"Detail"}},"intro":"测试","logo":{"id":54,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.oss-cn-shanghai.aliyuncs.com/2016-10-20/105139/ff816407ff284613a8b38a977692c73c_0.jpg"},"name":"测试","oldPrice":"0.02","postage":"0.00","price":"0.01","shop":{"id":7,"name":"102183","userId":"102183"},"spects":[{"spectClassInfo":{"name":"种类","spectClass":"Color"},"spects":[{"id":123,"name":"护发"},{"id":124,"name":"洗发"}]}],"status":"OnShelf","stockAmount":500,"stockAndPrice":[{"display":["种类:护发"],"id":45,"oldPrice":"0.02","price":"0.01","quantity":500,"spect1":{"id":123,"name":"护发"}},{"display":["种类:洗发"],"id":46,"oldPrice":"0.02","price":"0.01","quantity":0,"spect1":{"id":124,"name":"洗发"}}],"updateTime":1476960925000,"ver":130}}]}
     * success : true
     */

    private ResultBean result;
    private boolean success;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class ResultBean implements Serializable{
        private static final long serialVersionUID = 41730417301382L;
        /**
         * pageInfo : {"pageNo":0,"pageRecordSize":10,"totalPage":1,"totalRecord":3}
         * records : [{"agentUser":"105130","goods":{"createTime":1477289755000,"id":154,"images":{"Detail":{"images":[{"id":75,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-24/105119/3d4757f89dee4610af4c8f273e3d1939_1.jpg"}],"name":"Detail"}},"intro":"阿拉丁神灯","logo":{"id":74,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-24/105119/3d4757f89dee4610af4c8f273e3d1939_0.jpg"},"name":"阿拉丁神灯","oldPrice":"0.01","postage":"0.00","price":"0.01","shop":{"id":10,"name":"105119","userId":"105119"},"spects":[{"spectClassInfo":{"name":"颜色","spectClass":"Color"},"spects":[{"id":163,"name":"白色"},{"id":164,"name":"黄色"}]}],"status":"OffShelf","stockAmount":1000,"stockAndPrice":[{"display":["颜色:白色"],"id":69,"oldPrice":"0.01","price":"0.01","quantity":500,"spect1":{"id":163,"name":"白色"}},{"display":["颜色:黄色"],"id":70,"oldPrice":"0.01","price":"0.02","quantity":500,"spect1":{"id":164,"name":"黄色"}}],"updateTime":1477289910000,"ver":197}},{"agentUser":"105139","goods":{"createTime":1475927806000,"id":83,"images":{"Detail":{"images":[{"id":6,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-08/105130/6782eae303d0433c8c07b195fc160133_1.jpg"}],"name":"Detail"}},"intro":"好和谁啊","logo":{"id":5,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.img-cn-shanghai.aliyuncs.com/2016-10-08/105130/6782eae303d0433c8c07b195fc160133_0.jpg"},"name":"好和谁啊","oldPrice":"2.00","postage":"0.00","price":"1.00","shop":{"id":2,"name":"105130","userId":"105130"},"spects":[{"spectClassInfo":{"name":"color","spectClass":"Color"},"spects":[{"id":143,"name":"蓝"},{"id":144,"name":"黄"}]},{"spectClassInfo":{"name":"size","spectClass":"Size"},"spects":[{"id":102,"name":"中"},{"id":131,"name":"大"},{"id":132,"name":"小"}]}],"status":"OffShelf","stockAmount":1334,"stockAndPrice":[{"display":["size:大"],"id":20,"oldPrice":"2.00","price":"1.00","quantity":111,"spect2":{"id":131,"name":"大"}},{"display":["size:小"],"id":19,"oldPrice":"2.00","price":"1.00","quantity":1111,"spect2":{"id":132,"name":"小"}},{"display":["color:蓝","size:中"],"id":208,"oldPrice":"0.40","price":"1.00","quantity":1,"spect1":{"id":143,"name":"蓝"},"spect2":{"id":102,"name":"中"}},{"display":["size:中"],"id":21,"oldPrice":"2.00","price":"3.00","quantity":111,"spect2":{"id":102,"name":"中"}}],"updateTime":1480168152000,"ver":297}},{"agentUser":"105130","goods":{"categoryCode":"测试分类","createTime":1476960832000,"id":117,"images":{"Detail":{"images":[{"id":49,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.oss-cn-shanghai.aliyuncs.com/2016-10-19/105119/7ac916d99beb4ced9752cdff393e89fe_1.jpg"}],"name":"Detail"}},"intro":"测试","logo":{"id":54,"imageType":"Img","size":0,"status":0,"url":"http://hsyshopimage.oss-cn-shanghai.aliyuncs.com/2016-10-20/105139/ff816407ff284613a8b38a977692c73c_0.jpg"},"name":"测试","oldPrice":"0.02","postage":"0.00","price":"0.01","shop":{"id":7,"name":"102183","userId":"102183"},"spects":[{"spectClassInfo":{"name":"种类","spectClass":"Color"},"spects":[{"id":123,"name":"护发"},{"id":124,"name":"洗发"}]}],"status":"OnShelf","stockAmount":500,"stockAndPrice":[{"display":["种类:护发"],"id":45,"oldPrice":"0.02","price":"0.01","quantity":500,"spect1":{"id":123,"name":"护发"}},{"display":["种类:洗发"],"id":46,"oldPrice":"0.02","price":"0.01","quantity":0,"spect1":{"id":124,"name":"洗发"}}],"updateTime":1476960925000,"ver":130}}]
         */

        private List<MallRecordsBean> records;

        public List<MallRecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<MallRecordsBean> records) {
            this.records = records;
        }


    }

}
