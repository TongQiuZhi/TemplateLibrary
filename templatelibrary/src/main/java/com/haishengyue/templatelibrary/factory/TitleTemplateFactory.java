package com.haishengyue.templatelibrary.factory;

import android.content.Context;
import android.view.LayoutInflater;

import com.haishengyue.templatelibrary.ITemplateFactory;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;
import com.haishengyue.templatelibrary.viewholder.TitleHolder;

/**
 * Created by kanke on 2017/10/26.
 */

public class TitleTemplateFactory implements ITemplateFactory {
    @Override
    public SubViewHolder getViewHolder(Context context) {
        return new TitleHolder(LayoutInflater.from(context).inflate(R.layout.lish_item_text_layout, null));
    }
}
