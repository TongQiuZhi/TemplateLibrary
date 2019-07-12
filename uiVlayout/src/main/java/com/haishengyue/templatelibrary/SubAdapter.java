package com.haishengyue.templatelibrary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.entity.BaseEntity;
import com.haishengyue.templatelibrary.interfaces.ItemClickListener;

import java.util.List;

/**
 * Created by kanke on 2017/10/23.
 */

public class SubAdapter extends DelegateAdapter.Adapter<SubViewHolder> {

    //默认
    public static final int TYPE_HOLDER_DEFAULT = 0;
    //标题
    public static final int TYPE_HOLDER_TITLE = 1;
    //网格布局  这里显示渠道
    public static final int TYPE_HOLDER_CHANNEL = 2;
    //单个商品的样式
    public static final int TYPE_HOLDER_GOODS = 3;
    //小的单个商品的样式
    public static final int TYPE_HOLDER_LITTLE_GOODS = 4;
    //大图片展示
    public static final int TYPE_HOLDER_SINGLE_ICON = 5;
    //一个viewPager
    public static final int TYPE_HOLDER_VIEWPAGER = 6;
    //一个recyclerView
    public static final int TYPE_HOLDER_RECYCLER_VIEW = 7;


    private Context mContext;
    private LayoutHelper mHelper;
    protected List<BaseEntity> list;
    private int listSize;
    private int type;//默认类型设置

    /**
     * @param context   上下文
     * @param helper    使用的helper
     * @param data      数据
     * @param itemCount helper绘制对应的item个数
     * @param type      helper对应的显示类型  @ TYPE_HOLDER_DEFAULT
     */
    public SubAdapter(Context context, LayoutHelper helper, List<BaseEntity> data, int itemCount, int type) {
        this.mContext = context;
        this.mHelper = helper;
        this.list = data;
        this.listSize = itemCount;
        this.type = type;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public SubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TemplateFactory.getTemplateHolder(mContext, viewType);
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public void onBindViewHolder(SubViewHolder holder, int position) {
        holder.setOnItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View view, BaseEntity obj, int position) {
                if (listener != null) listener.onItemClick(view, obj, position);
            }

            @Override
            public boolean onItemLongClick(View view, BaseEntity obj, int position) {
                return listener != null && listener.onItemLongClick(view, obj, position);
            }
        });

        holder.bindData(mContext, list.get(position), position);
    }

    @Override
    public int getItemCount() {//TODO gridView  渠道时候 最多显示两行
        return listSize;
    }

    public void add(List<BaseEntity> ts) {
        this.list.addAll(ts);
        listSize = list.size();
        notifyDataSetChanged();
    }

    private ItemClickListener listener;

    /**
     * 外部监听
     *
     * @param listener
     */
    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

}
