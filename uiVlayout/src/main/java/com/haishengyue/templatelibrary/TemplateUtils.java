package com.haishengyue.templatelibrary;

import android.content.Context;

import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.haishengyue.templatelibrary.entity.BaseEntity;
import com.haishengyue.templatelibrary.entity.SetEntity;

import java.util.List;

import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_CHANNEL;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_GOODS;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_RECYCLER_VIEW;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_SINGLE_ICON;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_TITLE;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_VIEWPAGER;

/**
 * Created by kanke on 2017/10/31.
 * 这里是基于 v_layout 实现的模板  banner引用了ultra_viewpager 库
 * <p>
 * 这个完全可以代码书写中完成  这里只是写几个
 */

public class TemplateUtils {
    private Context context;

    public TemplateUtils(Context context) {
        this.context = context;
    }

    /**
     * 标题
     *
     * @param t 这个必须传入 TitleEntity 的集合
     */
    public SubAdapter initTitle(List<BaseEntity> t) {
        return new SubAdapter(context, new DefaultLayoutHelper(), t, 1, TYPE_HOLDER_TITLE);
    }


    /**
     * banner
     *
     * @param t 这个必须传入 SetEntity集合  且 list 中是BannerEntity的集合
     */
    public SubAdapter initBanner(List<BaseEntity> t) {
        return new SubAdapter(context, new DefaultLayoutHelper(), t, 1, TYPE_HOLDER_VIEWPAGER);
    }

    /**
     * 水平
     *
     * @param t    这个必须传入 SetEntity集合  且 list 中是BaseEntity中必须设置type 区分具体显示类型
     * @param type 这个来显示单个 item的显示类型
     */
    public SubAdapter initHorizontal(List<BaseEntity> t, int type) {
        if (t.size() == 0) throw new RuntimeException("initHorizontal() 参数集合为空");
        SetEntity entity = (SetEntity) t.get(0);
        for (BaseEntity e : entity.getList()) {
            e.type = type;//设置具体显示状态
        }
        SubAdapter subAdapter = new SubAdapter(context, new DefaultLayoutHelper(), t, 1, TYPE_HOLDER_RECYCLER_VIEW);
        return subAdapter;
    }

    /**
     * 导航
     *
     * @param t 这个必须传入ChannelEntity的集合
     */
    public SubAdapter initChannel(List<BaseEntity> t) {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
        gridLayoutHelper.setBgColor(0xffffffff);
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setPaddingBottom(20);
        gridLayoutHelper.setPaddingTop(20);
        gridLayoutHelper.setMarginBottom(10);
        int num = t.size() > 10 ? 10 : t.size();
        return new SubAdapter(context, gridLayoutHelper, t, num, TYPE_HOLDER_CHANNEL);
    }

    /**
     * 单行大图
     *
     * @param t 这个必须传入是BannerEntity的集合
     */
    public SubAdapter initBigPic(List<BaseEntity> t) {
        return new SubAdapter(context, new DefaultLayoutHelper(), t, 1, TYPE_HOLDER_SINGLE_ICON);
    }

    //

    /**
     * num 行小图
     *
     * @param t   这个必须传入是GoodsEntity的集合
     * @param num num列数据
     */
    public SubAdapter initGridLayout(List<BaseEntity> t, int num) {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(num);
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setMargin(0, 0, 0, 20);
        return new SubAdapter(context, gridLayoutHelper, t, t.size(), TYPE_HOLDER_GOODS);
    }


}
