package com.haishengyue.templatelibrary.factory;

import android.content.Context;
import android.view.LayoutInflater;

import com.haishengyue.templatelibrary.ITemplateFactory;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;
import com.haishengyue.templatelibrary.viewholder.UltraViewPagerHolder;

/**
 * Created by kanke on 2017/10/30.
 */

public class ViewPagerTemplateFactory implements ITemplateFactory {
    @Override
    public SubViewHolder getViewHolder(Context context) {
        return new UltraViewPagerHolder(LayoutInflater.from(context).inflate(R.layout.lish_item_view_pager, null));
    }
}
