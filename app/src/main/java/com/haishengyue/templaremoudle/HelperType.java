package com.haishengyue.templaremoudle;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelperEx;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;

/**
 * Created by kanke on 2017/10/20.
 * <p>
 * VLayout 默认的10种helper 对应同名 helper
 */

public enum HelperType {
    LINEAR_LAYOUT(LinearLayoutHelper.class),//线性布局
    GRID_LAYOUT(GridLayoutHelper.class),//网格布局
    COLUMN_LAYOUT(ColumnLayoutHelper.class),//栏格布局
    SINGLE_LAYOUT(SingleLayoutHelper.class),//通栏布局
    ONE_PLUS_N_LAYOUT(OnePlusNLayoutHelper.class),//一拖N布局
    ONE_PLUS_N_LAYOUT_EX(OnePlusNLayoutHelperEx.class),//一拖N布局 扩展

    FIX_LAYOUT(FixLayoutHelper.class),//固定布局
    SCROLL_FIX_LAYOUT(ScrollFixLayoutHelper.class),//可选显示的固定布局
    FLOAT_LAYOUT(FloatLayoutHelper.class),//浮动布局
    STICKY_LAYOUT(StickyLayoutHelper.class),//吸边布局
    STAGGERED_GRID_LAOUT(StaggeredGridLayoutHelper.class);//瀑布流布局

    private Class<? extends LayoutHelper> clazz;

    HelperType(Class<? extends LayoutHelper> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends LayoutHelper> getClazz() {
        return clazz;
    }

}
