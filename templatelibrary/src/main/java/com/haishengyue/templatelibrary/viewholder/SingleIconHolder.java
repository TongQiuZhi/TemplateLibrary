package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.entity.BannerEntity;
import com.haishengyue.templatelibrary.interfaces.ItemClickListener;

/**
 * Created by kanke on 2017/10/30.
 */

public class SingleIconHolder extends SubViewHolder<BannerEntity> {

    private ItemClickListener mListener;
    private int mPosition;
    private BannerEntity mData;

    public SingleIconHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnClickListener(this);
    }

    @Override
    public void bindData(Context context, BannerEntity entity, int position) {
        this.mPosition = position;
        this.mData = entity;
        Glide.with(context).load(entity.getBannerUrl()).into((ImageView) itemView.findViewById(R.id.icon));
    }

    @Override
    public void setOnItemClickListener(ItemClickListener listener) {
        this.mListener = listener;
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
