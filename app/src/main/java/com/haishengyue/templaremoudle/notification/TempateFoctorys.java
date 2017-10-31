package com.haishengyue.templaremoudle.notification;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.templatelibrary.ItemClickListener;
import com.haishengyue.templatelibrary.SubViewHolder;
import com.haishengyue.templatelibrary.factory.ChannelTemplateFactory;
import com.haishengyue.templatelibrary.factory.DefaultTemplateFactory;
import com.haishengyue.templatelibrary.factory.HorizontalRecyclerTemplateFactory;
import com.haishengyue.templatelibrary.factory.SingleGoodsTemplateFactory;
import com.haishengyue.templatelibrary.factory.SingleIconTemplateFactory;
import com.haishengyue.templatelibrary.factory.TitleTemplateFactory;
import com.haishengyue.templatelibrary.factory.ViewPagerTemplateFactory;
import com.haishengyue.templatelibrary.viewholder.ChannelHolder;
import com.haishengyue.templatelibrary.viewholder.DefaultViewHolder;
import com.haishengyue.templatelibrary.viewholder.HorizontalRecyclerHolder;
import com.haishengyue.templatelibrary.viewholder.SingleIconHolder;
import com.haishengyue.templatelibrary.viewholder.TitleHolder;
import com.haishengyue.templatelibrary.viewholder.UltraViewPagerHolder;

/**
 * Created by kanke on 2017/10/26.
 */

public class TempateFoctorys {


    public static SubViewHolder getHolder(Context context, int type) {
        SubViewHolder holder;
        switch (type) {
            case 1:
                holder = new ViewPagerTemplateFactory().getViewHolder(context);
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
                holder = new SingleIconTemplateFactory().getViewHolder(context);
                break;
            default:
                holder = new TitleTemplateFactory().getViewHolder(context);

        }
        return holder;
    }


    public static <T> void setData(final Context context, SubViewHolder holder, T t, final int position) {

        holder.setOnItemClickListener(new ItemClickListener() {

            @Override
            public void onItemClick(View view, Object obj, int position) {
                Toast.makeText(context, "position = " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, Object obj, int position) {
                return false;
            }
        });
        if (holder instanceof UltraViewPagerHolder) {
            ((UltraViewPagerHolder) holder).itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        }

        if (holder instanceof SingleIconHolder) {
            ((SingleIconHolder) holder).itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 250));
        }

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
