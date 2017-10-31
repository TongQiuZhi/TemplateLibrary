package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.haishengyue.templatelibrary.ItemClickListener;
import com.haishengyue.templatelibrary.SubViewHolder;

/**
 * Created by kanke on 2017/10/26.
 * 默认只显示 文本
 */

public class DefaultViewHolder extends SubViewHolder<String> implements View.OnClickListener, View.OnLongClickListener {
    private ItemClickListener mListener;
    private int mPosition;
    private String mData;

    public DefaultViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void bindData(Context context, String s, int position) {
        this.mPosition = position;
        this.mData = s;
        if (itemView instanceof TextView)
            ((TextView) this.itemView).setText(s);
    }

    @Override
    public void setOnItemClickListener(ItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            mListener.onItemClick(v, mData, mPosition);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return mListener != null && mListener.onItemLongClick(v, mData, mPosition);
    }
}
