package com.haishengyue.templatelibrary.entity;

import java.util.List;

/**
 * Created by kanke on 2017/11/1.
 * <p>
 * 这里需要二次处理数据 一级数据  二级数据才是正常显示的数据
 * 展示二级列表的数据结构
 */

public class SetEntity extends BaseEntity {
    private static final long serialVersionUID = 6345728913410L;

    private String setName;
    private List<BaseEntity> list;

    public SetEntity(String setName, List<BaseEntity> list) {
        this.setName = setName;
        this.list = list;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public List<BaseEntity> getList() {
        return list;
    }

    public void setList(List<BaseEntity> list) {
        this.list = list;
    }
}
