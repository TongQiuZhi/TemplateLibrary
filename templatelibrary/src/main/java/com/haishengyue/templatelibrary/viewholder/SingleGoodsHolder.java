package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haishengyue.beanlibrary.mallbeans.MallGoodsBean;
import com.haishengyue.beanlibrary.mallbeans.MallRecordsBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.GoodTinyBean;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;


/**
 * Created by kanke on 2017/10/23.
 * 单个商品的 item
 */

public class SingleGoodsHolder<T> extends SubViewHolder<T> {

    ImageView goodsIcon;
    TextView goodsDec;
    TextView goodsSubDec;
    TextView goodsSubDec2;
    TextView goodsBtn;

    public SingleGoodsHolder(View itemView) {
        super(itemView);
        goodsIcon = findViewById(itemView, R.id.goods_icon);
        goodsDec = findViewById(itemView, R.id.goods_dec);
        goodsSubDec = findViewById(itemView, R.id.goods_sub_dec);
        goodsSubDec2 = findViewById(itemView, R.id.goods_sub_dec2);
        goodsBtn = findViewById(itemView, R.id.goods_btn);

    }

    @Override
    public void bindData(Context context, T t, int position) {
        if(t instanceof MallRecordsBean){
            MallRecordsBean bean = (MallRecordsBean) t;
            MallGoodsBean goods = bean.getGoods();
            Glide.with(context).load(goods.getLogo().getUrl()).into(goodsIcon);
            goodsDec.setText(goods.getName());
            goodsSubDec.setText(goods.getPrice());
            goodsSubDec2.setText(goods.getOldPrice());
        }
        if(t instanceof GoodTinyBean){
            GoodTinyBean bean = (GoodTinyBean) t;
            Glide.with(context).load(bean.getUrl()).into(goodsIcon);
            goodsDec.setText(bean.getName());
            goodsSubDec.setText(bean.getPrice());
            goodsSubDec2.setText(bean.getOldPrice());
        }


    }
}
