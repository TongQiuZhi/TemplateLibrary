package com.haishengyue.templaremoudle.notification;

import android.content.Context;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.haishengyue.templatelibrary.SubViewHolder;

import java.util.List;

/**
 * Created by kanke on 2017/10/23.
 */

public class SubAdapter<T> extends DelegateAdapter.Adapter<SubViewHolder> {

    private Context mContext;
    private LayoutHelper mHelper;
    protected List<T> datas;
    private int datasCount;
    private int type;//默认类型设置

    public SubAdapter(Context context, LayoutHelper helper, List<T> datas) {
        this(context, helper, datas, datas.size(), 0);
    }

    public SubAdapter(Context context, LayoutHelper helper, List<T> datas, int itemCount, int type) {
        this.mContext = context;
        this.mHelper = helper;
        this.datas = datas;
        this.datasCount = itemCount;
        this.type = type;
    }


    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override
    public SubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return TempateFoctorys.getHolder(mContext, viewType);
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public void onBindViewHolder(SubViewHolder holder, int position) {
        TempateFoctorys.setData(mContext, holder, datas.get(position), position);
    }

    @Override
    public int getItemCount() {//TODO gridView  渠道时候 最多显示两行
        return datasCount;
    }

    public void add(List<T> ts) {
        this.datas.addAll(ts);
        datasCount = datas.size();
        notifyDataSetChanged();
    }
}
