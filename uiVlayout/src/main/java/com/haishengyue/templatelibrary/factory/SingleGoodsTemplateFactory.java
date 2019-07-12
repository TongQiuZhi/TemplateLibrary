package com.haishengyue.templatelibrary.factory;

import android.content.Context;
import android.view.LayoutInflater;

import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.interfaces.ITemplateFactory;
import com.haishengyue.templatelibrary.viewholder.SingleGoodsHolder;

/**
 * Created by kanke on 2017/10/26.
 */

public class SingleGoodsTemplateFactory implements ITemplateFactory {
    @Override
    public SubViewHolder getViewHolder(Context context) {
        return new SingleGoodsHolder(LayoutInflater.from(context).inflate(R.layout.lish_item_goods_layout, null));
    }
}
