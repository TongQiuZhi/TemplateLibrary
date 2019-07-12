package com.haishengyue.templatelibrary.entity;

/**
 * Created by kanke on 2017/11/1.
 */

public class TitleEntity extends BaseEntity {
    private static final long serialVersionUID = 230423095810321L;
    private String title;
    private String extend;
    private boolean arrow;

    public TitleEntity(String title, String extend, boolean arrow) {
        this.title = title;
        this.extend = extend;
        this.arrow = arrow;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public boolean isArrow() {
        return arrow;
    }

    public void setArrow(boolean arrow) {
        this.arrow = arrow;
    }
}
