package com.haishengyue.beanlibrary.mallbeans;

import java.io.Serializable;

/**
 * Created by kanke on 2017/10/18.
 * 显示标题和 右箭头
 */

public class ExtraWarrpBean implements Serializable {
    private static final long serialVersionUID = 9530452034L;

    /**
     * extraBtnName : 更多
     * extraId : 123
     * icon : false
     */

    private String extraBtnName;
    private long extraId;
    private boolean icon;

    public String getExtraBtnName() {
        return extraBtnName;
    }

    public void setExtraBtnName(String extraBtnName) {
        this.extraBtnName = extraBtnName;
    }

    public long getExtraId() {
        return extraId;
    }

    public void setExtraId(long extraId) {
        this.extraId = extraId;
    }

    public boolean isIcon() {
        return icon;
    }

    public void setIcon(boolean icon) {
        this.icon = icon;
    }
}
