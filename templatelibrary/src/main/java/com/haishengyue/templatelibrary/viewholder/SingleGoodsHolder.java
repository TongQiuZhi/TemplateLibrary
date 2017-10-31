package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haishengyue.beanlibrary.mallbeans.MallGoodsBean;
import com.haishengyue.beanlibrary.mallbeans.MallRecordsBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.GoodTinyBean;
import com.haishengyue.templatelibrary.ItemClickListener;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;


/**
 * Created by kanke on 2017/10/23.
 * 单个商品的 item
 */

public class SingleGoodsHolder<T> extends SubViewHolder<T> implements View.OnClickListener, View.OnLongClickListener {

    private ImageView goodsIcon;
    private TextView goodsDec;
    private TextView goodsSubDec;
    private TextView goodsSubDec2;
    private TextView goodsBtn;

    private ItemClickListener mListener;
    private int mPosition;
    private T mData;

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
    public void bindData(Context context, T t, int position) {
        this.mPosition = position;
        this.mData = t;
        if (t instanceof MallRecordsBean) {
            MallRecordsBean bean = (MallRecordsBean) t;
            MallGoodsBean goods = bean.getGoods();
            Glide.with(context).load(goods.getLogo().getUrl()).into(goodsIcon);
            goodsDec.setText(goods.getName());
            goodsSubDec.setText(goods.getPrice());
            goodsSubDec2.setText(goods.getOldPrice());
        }
        if (t instanceof GoodTinyBean) {
            GoodTinyBean bean = (GoodTinyBean) t;
            Glide.with(context).load(bean.getUrl()).into(goodsIcon);
            goodsDec.setText(bean.getName());
            goodsSubDec.setText(bean.getPrice());
            goodsSubDec2.setText(bean.getOldPrice());
        }


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
