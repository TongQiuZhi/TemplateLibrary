package com.haishengyue.templaremoudle.testData;

import com.alibaba.fastjson.JSON;
import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.beanlibrary.mallbeans.EnumMIME;
import com.haishengyue.beanlibrary.mallbeans.ExtraWarrpBean;
import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanke on 2017/10/11.
 * <p>
 * 这是一个json解析器  这个需要对应的格式才能正常解析
 */

public class DecodeUtils {

    public static List<DataBean> decodeJsonString(String jsonString) throws Exception {
        return decodeJson(jsonString);//这个预留
    }

    private static List<DataBean> decodeJson(String jsonStr) throws Exception {
        JSONObject json = new JSONObject(jsonStr);
        String status = json.optString("status");
        int errorCode = json.optInt("errorCode");
        String msg = json.optString("msg");
        List<DataBean> list = new ArrayList<>();
        if ("ok".equalsIgnoreCase(status)) {//数据请求成功
            JSONArray datas = json.optJSONArray("datas");
            for (int i = 0; i < datas.length(); i++) {
                JSONObject jso = datas.optJSONObject(i);
                List<TinyDataBean> tinyList = decode(jso.optJSONArray("datas"));
                ExtraWarrpBean arrawBean = decode(jso.optJSONObject("extra_warrp"));
                DataBean bean = new DataBean();
                bean.setChannel_id(jso.optLong("channel_id"));
                bean.setContent_id(jso.optLong("content_id"));
                bean.setContent_name(jso.optString("content_name"));
                bean.setTemplate_type(jso.optString("template_type"));
                bean.setInterface_type(jso.optString("interface_type"));
                bean.setContent_data_url(jso.optString("content_data_url"));
                bean.setVer(jso.optLong("ver"));
                bean.setExtra_warrp(arrawBean);
                bean.setDatas(tinyList);
                list.add(bean);
            }
            return list;
        } else {
            throw new Exception("errorCode:" + errorCode + " msg:" + msg);
        }

    }

    private static ExtraWarrpBean decode(JSONObject extra_warrp) {
        if (null == extra_warrp) {
            return null;
        }
        return JsonToBean(extra_warrp.toString(), ExtraWarrpBean.class);
    }

    private static List<TinyDataBean> decode(JSONArray arrays) {
        List<TinyDataBean> list = new ArrayList<>();
        if (arrays == null) return list;
        for (int m = 0; m < arrays.length(); m++) {
            JSONObject json = arrays.optJSONObject(m);
            String mime = json.optString("MIME");
            TinyDataBean bean = jsonObjectToBean(json, mime);

            JSONArray datas = json.optJSONArray("datas");
            if (null != datas) {
                List<TinyDataBean> decode = decode(datas);
                bean.setDatas(decode);
            }
            list.add(bean);

        }
        return list;
    }

    private static TinyDataBean jsonObjectToBean(JSONObject json, String mime) {
        EnumMIME MIME = getMIME(mime);
        return (TinyDataBean) JsonToBean(json.toString(), MIME.getMIMEClass());
    }

    public static EnumMIME getMIME(String MIME) {
        EnumMIME mime;
        switch (MIME.toUpperCase()) {
            case "APPLICATION/BANNER":
                mime = EnumMIME.BANNER;
                break;
            case "APPLICATION/CHANNEL":
                mime = EnumMIME.CHANNEL;
                break;
            case "APPLICATION/VIDEO":
                mime = EnumMIME.VIDEO;
                break;
            case "APPLICATION/ARTIS":
                mime = EnumMIME.ARTIS;
                break;
            case "APPLICATION/GOOD":
                mime = EnumMIME.GOOD;
                break;
            case "APPLICATION/ACTIVITY":
                mime = EnumMIME.ACTIVITY;
                break;
            default:
                mime = EnumMIME.CHANNEL;
        }
        return mime;
    }

    public static <T> T JsonToBean(String jsonString, Class<T> cls) {
        T t = JSON.parseObject(jsonString, cls);
        return t;
    }

}
