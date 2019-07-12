package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.entity.GoodsEntity;
import com.haishengyue.templatelibrary.interfaces.ItemClickListener;


/**
 * Created by kanke on 2017/10/23.
 * 单个商品的 item
 */

public class SingleGoodsHolder extends SubViewHolder<GoodsEntity> {

    private ImageView goodsIcon;
    private TextView goodsDec;
    private TextView goodsSubDec;
    private TextView goodsSubDec2;
    private TextView goodsBtn;

    private ItemClickListener mListener;
    private int mPosition;
    private GoodsEntity mData;

    public SingleGoodsHolder(View itemView) {
        super(itemView);
        goodsIcon = findViewById(itemView, R.id.goods_icon);
        goodsDec = findViewById(itemView, R.id.goods_dec);
        goodsSubDec = findViewById(itemView, R.id.goods_sub_dec);
        goodsSubDec2 = findViewById(itemView, R.id.goods_sub_dec2);
        goodsBtn = findViewById(itemView, R.id.goods_btn);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

    @Override
    public void bindData(Context context, GoodsEntity entity, int position) {
        this.mPosition = position;
        this.mData = entity;
        Glide.with(context).load(entity.getGoodsUrl()).into(goodsIcon);
        goodsDec.setText(entity.getGoodsName());
        goodsSubDec.setText(entity.getPrice());
        goodsSubDec2.setText(entity.getProfit());
        goodsBtn.setText(entity.getBtn());

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
