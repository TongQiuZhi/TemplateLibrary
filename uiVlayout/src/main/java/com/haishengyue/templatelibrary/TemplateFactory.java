package com.haishengyue.templatelibrary;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.factory.ChannelTemplateFactory;
import com.haishengyue.templatelibrary.factory.HorizontalRecyclerTemplateFactory;
import com.haishengyue.templatelibrary.factory.SingleGoodsLittleTemplateFactory;
import com.haishengyue.templatelibrary.factory.SingleGoodsTemplateFactory;
import com.haishengyue.templatelibrary.factory.SingleIconTemplateFactory;
import com.haishengyue.templatelibrary.factory.TitleTemplateFactory;
import com.haishengyue.templatelibrary.factory.ViewPagerTemplateFactory;

import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_CHANNEL;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_GOODS;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_LITTLE_GOODS;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_RECYCLER_VIEW;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_SINGLE_ICON;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_TITLE;
import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_VIEWPAGER;

/**
 * Created by kanke on 2017/10/31.
 */

public class TemplateFactory {

    public static SubViewHolder getTemplateHolder(Context context, int type) {
        SubViewHolder holder;
        switch (type) {
            case TYPE_HOLDER_TITLE:
                holder = new TitleTemplateFactory().getViewHolder(context);
                holder.itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2px(context, 50)));
                break;
            case TYPE_HOLDER_CHANNEL:
                holder = new ChannelTemplateFactory().getViewHolder(context);
                break;
            case TYPE_HOLDER_GOODS:
                holder = new SingleGoodsTemplateFactory().getViewHolder(context);
                break;
            case TYPE_HOLDER_LITTLE_GOODS:
                holder = new SingleGoodsLittleTemplateFactory().getViewHolder(context);
                break;
            case TYPE_HOLDER_SINGLE_ICON:
                holder = new SingleIconTemplateFactory().getViewHolder(context);
                break;
            case TYPE_HOLDER_VIEWPAGER:
                holder = new ViewPagerTemplateFactory().getViewHolder(context);
                holder.itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2px(context, 160)));
                break;
            case TYPE_HOLDER_RECYCLER_VIEW:
                holder = new HorizontalRecyclerTemplateFactory().getViewHolder(context);
//                holder.itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2px(context, 180)));
                break;
            default:
                throw new RuntimeException("type =" + type + "没有对应的类型");
        }

        return holder;
    }


    public static int dp2px(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }
}
