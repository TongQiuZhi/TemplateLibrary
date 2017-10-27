package com.haishengyue.templatelibrary.factory;

import android.content.Context;
import android.view.LayoutInflater;

import com.haishengyue.templatelibrary.ITemplateFactory;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;
import com.haishengyue.templatelibrary.viewholder.HorizontalRecyclerHolder;

/**
 * Created by kanke on 2017/10/27.
 */

public class HorizontalRecyclerTemplateFactory implements ITemplateFactory {
    @Override
    public SubViewHolder getViewHolder(Context context) {
        return new HorizontalRecyclerHolder(LayoutInflater.from(context).inflate(R.layout.lish_item_recycler_view, null));
    }
}
