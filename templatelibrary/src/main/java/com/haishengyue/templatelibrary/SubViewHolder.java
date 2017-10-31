package com.haishengyue.templatelibrary;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kanke on 2017/10/23.
 * 通用的adapter
 */

public abstract class SubViewHolder<T> extends RecyclerView.ViewHolder {
    public SubViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindData(Context context, T t, int position);

    public abstract void setOnItemClickListener(ItemClickListener listener);

    protected <G extends View> G findViewById(View view, int id) {
        return (G) view.findViewById(id);
    }

}
