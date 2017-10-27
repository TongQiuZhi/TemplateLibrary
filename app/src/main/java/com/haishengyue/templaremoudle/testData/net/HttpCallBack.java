package com.haishengyue.templaremoudle.testData.net;

public interface HttpCallBack {


    void onSuccess(String msg, String data);

    void onFailure(String msg);

}
