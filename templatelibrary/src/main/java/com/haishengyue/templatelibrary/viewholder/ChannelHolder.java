package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haishengyue.beanlibrary.mallbeans.tinybean.ChannelTinyBean;
import com.haishengyue.templatelibrary.ItemClickListener;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;

/**
 * Created by kanke on 2017/10/23.
 * <p>
 * 显示渠道样式  只有一个 图片和文本
 */

public class ChannelHolder extends SubViewHolder<ChannelTinyBean> implements View.OnClickListener, View.OnLongClickListener {
    private TextView channelName;
    private ImageView channelIcon;
    private ItemClickListener mListener;
    private int mPosition;
    private ChannelTinyBean mData;

    public ChannelHolder(View itemView) {
        super(itemView);
        channelName = findViewById(itemView, R.id.channel_name);
        channelIcon = findViewById(itemView, R.id.channel_icon);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void bindData(Context context, ChannelTinyBean tinyDataBean, int position) {
        mPosition = position;
        this.mData = tinyDataBean;
        if (tinyDataBean instanceof ChannelTinyBean) {
            ChannelTinyBean bean = (ChannelTinyBean) tinyDataBean;
            channelName.setText(bean.getChannel_name());
            Glide.with(context).load(bean.getIcon_url()).into(channelIcon);
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
