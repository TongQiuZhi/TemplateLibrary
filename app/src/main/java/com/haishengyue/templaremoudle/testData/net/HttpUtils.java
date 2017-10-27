package com.haishengyue.templaremoudle.testData.net;

import android.text.TextUtils;


import com.alibaba.fastjson.JSONObject;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.GetBuilder;
import com.zhy.http.okhttp.builder.PostStringBuilder;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.MediaType;


/**
 * 2017-8-17 网络请求的整理
 * get直接调用
 * post需要用的时候，手动拼接json 这里提供排序的json的方法
 */
public class HttpUtils {

    /**
     * get请求
     *
     * @param tag      请求的标识
     * @param url      请求的url （不带参数）
     * @param params   get请求的参数列表
     * @param callBack 请求的回调
     */
    public static void get(Object tag, final String url, Map<String, Object> params, final HttpCallBack callBack) {
        get(tag, url, params, 0, "", callBack);
    }

    /**
     * get请求
     *
     * @param tag      请求的标识
     * @param url      请求的url （不带参数）
     * @param params   get请求的参数列表
     * @param uid      用户的uid
     * @param token    用户的token
     * @param callBack 请求的回调
     */
    public static void get(Object tag, final String url, Map<String, Object> params, long uid, String token, final HttpCallBack callBack) {
        StringBuilder path = new StringBuilder(url);
        long time = System.currentTimeMillis();
        String sign = getSign(time + "", params);

        if (null == params) {
            params = new HashMap<>();
        }
        params.put("app_key", Constants.APP_KEY);
        params.put("sign", sign);
        params.put("time", time + "");

        path.append("?");
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            path.append(entry.getKey() + "=" + entry.getValue().toString() + "&");
        }
        get(tag, path.toString(), uid + "", token, callBack);
    }

    /**
     * get请求
     *
     * @param tag      请求的标识
     * @param url      请求的完整url
     * @param uid      用户的uid
     * @param token    用户的token
     * @param callBack 用户的回调
     */
    private static void get(Object tag, final String url, String uid, String token, final HttpCallBack callBack) {
        GetBuilder builder = OkHttpUtils.get().url(url).tag(tag);
        RequestCall call;
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(token)) {
            call = builder.build();
        } else {
            call = builder.addHeader("uid", uid).addHeader("token", token).addHeader("appKey", Constants.APP_KEY).build();
        }
        call.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                String msg = e.getMessage();
                if (msg == null) {
                    msg = "连接超时请重试";//若e是java.net.SocketTimeoutException，msg=null
                }
                msg = check401(msg);//java.io.IOException: request failed , reponse's code is : 401
                callBack.onFailure(msg);
            }

            @Override
            public void onResponse(String response, int id) {
                if (TextUtils.isEmpty(response)) {
                    callBack.onFailure(response);
                } else {
                    callBack.onSuccess("ok", response);
                }
            }
        });
    }

    /**
     * get签名
     */
    private static String getSign(String time, Map<String, Object> params) {
        String signPrepare = "";
        if (null != params && params.size() > 0) {
            List<Map.Entry<String, Object>> mappingList = new ArrayList<>(params.entrySet());
            Collections.sort(mappingList, new Comparator<Map.Entry<String, Object>>() {
                @Override
                public int compare(Map.Entry<String, Object> entry1, Map.Entry<String, Object> entry2) {
                    return entry1.getKey().compareTo(entry2.getKey());
                }
            });
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Object> mapping : mappingList) {
                sb.append(mapping.getValue());
            }
            signPrepare = Constants.APP_KEY + time + sb.toString() + Constants.APP_SECRET;
        } else {
            signPrepare = Constants.APP_KEY + time + Constants.APP_SECRET;
        }
        return MD5Generator.getMD5(signPrepare);
    }

 /*   *//**
     * post请求 请求的json只包含单层结构
     *
     * @param tag      请求的标识
     * @param url      请求的url
     * @param userId   用户的uid
     * @param token    用户的token
     * @param map      post请求的参数
     * @param callBack 请求的回调
     *//*
    public static void postStrParams(Object tag, String url, String userId, String token, Map<String, Object> map, final HttpCallBack callBack) {
        String params = sortMapByKey2String(map);
        long time = System.currentTimeMillis();
        String sign = postSign(time + "", params);
        //这里设置请求参数
        JSONObject json = JSONObject.parseObject(params);
        json.put("app_key", Constants.APP_KEY);
        json.put("time", time + "");
        json.put("sign", sign);
        post(tag, url, userId, token, json.toJSONString(), callBack);
    }*/

    /**
     * postJson请求
     *
     * @param tag      请求的标识
     * @param url      请求的url
     * @param userId   用户的uid
     * @param token    用户的token
     * @param json     post请求的json
     * @param callBack 请求的回调
     */
    public static void post(Object tag, String url, String userId, String token, String json, final HttpCallBack callBack) {
        PostStringBuilder postStringBuilder = OkHttpUtils.postString();
        postStringBuilder.mediaType(MediaType.parse("application/json; charset=utf-8"));
        PostStringBuilder builder = postStringBuilder.url(url).content(json).tag(tag);
        RequestCall call;
        if (TextUtils.isEmpty(token) || TextUtils.isEmpty(userId)) {
            call = builder.build();
        } else {
            call = builder.addHeader("uid", userId).addHeader("token", token).addHeader("appKey", Constants.APP_KEY).build();
        }
        call.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                String msg = check401(e.getMessage());
                callBack.onFailure(msg);
            }

            @Override
            public void onResponse(String response, int id) {
                if (response == null || response.length() == 0) {
                    callBack.onFailure("网络访问失败");
                } else {
                    callBack.onSuccess("ok", response);
                }
            }
        });
    }
    /**
     * 按照map的key排序 返回排序后的json字符串
     *
     * @param map post请求的参数map
     * @return 排序后的json字符串
     */
    public static String sortMapByKey2String(Map<String, Object> map) {
        ArrayList<Map.Entry<String, Object>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Object>>() {
            @Override
            public int compare(Map.Entry<String, Object> entry1, Map.Entry<String, Object> entry2) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : entries) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return JSONObject.toJSONString(linkedHashMap);
    }

    /**
     * 按照map的key排序 返回排序后的map
     *
     * @param map post请求的参数map
     * @return 按照key排序后的LinkedHashMap
     */
    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
        ArrayList<Map.Entry<String, Object>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Object>>() {
            @Override
            public int compare(Map.Entry<String, Object> entry1, Map.Entry<String, Object> entry2) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Object> entry : entries) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return linkedHashMap;
    }

    /**
     * 设置签名 post
     */
    public static String postSign(String time, String json) {
        String str = Constants.APP_KEY + time + json + Constants.APP_SECRET;
        return MD5Generator.getMD5(str);
    }

    /**
     * 401判断
     */
    private static String check401(String msg) {
        return msg;
    }

}
