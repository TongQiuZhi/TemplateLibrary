package com.haishengyue.templatelibrary.factory;

import android.content.Context;
import android.view.LayoutInflater;

import com.haishengyue.templatelibrary.ITemplateFactory;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;
import com.haishengyue.templatelibrary.viewholder.DefaultViewHolder;

/**
 * Created by kanke on 2017/10/26.
 * 具体的 工厂  默认 一个textView 展示
 */

public class DefaultTemplateFactory implements ITemplateFactory {

    @Override
    public SubViewHolder getViewHolder(Context context) {
        return new DefaultViewHolder(LayoutInflater.from(context).inflate(R.layout.lish_item_default, null));
    }

}
