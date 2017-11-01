package com.haishengyue.templatelibrary.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kanke on 2017/11/1.
 * <p>
 * entity传递参数通过 params进行传递
 * type 是二级类型的显示
 */

public class BaseEntity implements Serializable {
    public Map<String, Object> params = new HashMap<>();
    public int type;
}
