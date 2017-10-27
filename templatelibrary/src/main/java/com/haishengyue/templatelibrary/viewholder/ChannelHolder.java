package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haishengyue.beanlibrary.mallbeans.tinybean.ChannelTinyBean;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;

/**
 * Created by kanke on 2017/10/23.
 * <p>
 * 显示渠道样式  只有一个 图片和文本
 */

public class ChannelHolder<T> extends SubViewHolder<T> {
    protected TextView channelName;
    protected ImageView channelIcon;

    public ChannelHolder(View itemView) {
        super(itemView);
        channelName = findViewById(itemView, R.id.channel_name);
        channelIcon = findViewById(itemView, R.id.channel_icon);
    }

    @Override
    public void bindData(Context context, T tinyDataBean, int position) {
        if (tinyDataBean instanceof ChannelTinyBean) {
            ChannelTinyBean bean = (ChannelTinyBean) tinyDataBean;

            channelName.setText(bean.getChannel_name());
            Glide.with(context).load(bean.getIcon_url()).into(channelIcon);
        }

    }
}
