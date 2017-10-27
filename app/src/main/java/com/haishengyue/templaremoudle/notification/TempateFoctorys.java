package com.haishengyue.templaremoudle.notification;

import android.content.Context;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.templatelibrary.SubViewHolder;
import com.haishengyue.templatelibrary.factory.ChannelTemplateFactory;
import com.haishengyue.templatelibrary.factory.DefaultTemplateFactory;
import com.haishengyue.templatelibrary.factory.HorizontalRecyclerTemplateFactory;
import com.haishengyue.templatelibrary.factory.SingleGoodsTemplateFactory;
import com.haishengyue.templatelibrary.factory.TitleTemplateFactory;
import com.haishengyue.templatelibrary.viewholder.DefaultViewHolder;
import com.haishengyue.templatelibrary.viewholder.HorizontalRecyclerHolder;
import com.haishengyue.templatelibrary.viewholder.TitleHolder;

/**
 * Created by kanke on 2017/10/26.
 */

public class TempateFoctorys {


    public static SubViewHolder getHolder(Context context, int type) {
        SubViewHolder holder;
        switch (type) {
            case 1:
                holder = new TitleTemplateFactory().getViewHolder(context);
                break;
            case 2:
                holder = new ChannelTemplateFactory().getViewHolder(context);
                break;
            case 3:
                holder = new HorizontalRecyclerTemplateFactory().getViewHolder(context);
                break;
            case 4:
                holder = new SingleGoodsTemplateFactory().getViewHolder(context);
                break;
            case 5:
                holder = new TitleTemplateFactory().getViewHolder(context);
                break;
            default:
                holder = new DefaultTemplateFactory().getViewHolder(context);

        }
        return holder;
    }


    public static <T> void setData(Context context, SubViewHolder holder, T t, int position) {
        if (holder instanceof DefaultViewHolder) {
            ((DefaultViewHolder) holder).bindData(context, "llalla", position);
        } else if (holder instanceof TitleHolder) {
            ((TitleHolder) holder).itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100));
            holder.bindData(context, t, position);
        } else if (holder instanceof HorizontalRecyclerHolder) {
            ((HorizontalRecyclerHolder) holder).itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
            ((HorizontalRecyclerHolder) holder).bindData(context, (DataBean) t, position);
        } else {
            holder.bindData(context, t, position);//这里数据未检测 容易出现类型转换异常

        }
    }
}
