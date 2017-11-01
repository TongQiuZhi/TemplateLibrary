package com.haishengyue.templatelibrary.factory;

import android.content.Context;
import android.view.LayoutInflater;

import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.interfaces.ITemplateFactory;
import com.haishengyue.templatelibrary.viewholder.ChannelHolder;

/**
 * Created by kanke on 2017/10/26.
 */

public class ChannelTemplateFactory implements ITemplateFactory {

    @Override
    public SubViewHolder getViewHolder(Context context) {
        return new ChannelHolder(LayoutInflater.from(context).inflate(R.layout.lish_item_channel_layout, null));
    }
}
