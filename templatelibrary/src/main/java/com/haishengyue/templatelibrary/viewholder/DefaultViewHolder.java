package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.haishengyue.templatelibrary.SubViewHolder;

/**
 * Created by kanke on 2017/10/26.
 * 默认只显示 文本
 */

public class DefaultViewHolder extends SubViewHolder<String> {
    public DefaultViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(Context context, String s, int position) {
        if (itemView instanceof TextView)
            ((TextView) this.itemView).setText(s);
    }
}
