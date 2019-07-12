package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.entity.TitleEntity;
import com.haishengyue.templatelibrary.interfaces.ItemClickListener;

/**
 * Created by kanke on 2017/10/23.
 * <p>
 * 这个就是标题 配置相关信息
 */

public class TitleHolder extends SubViewHolder<TitleEntity> {

    private TextView title;
    private TextView textMore;
    private ImageView arrowRight;
    private ItemClickListener mListener;
    private int mPosition;
    private TitleEntity mData;


    public TitleHolder(View itemView) {
        super(itemView);
        itemView.setBackgroundColor(0xffffffff);
        title = findViewById(itemView, R.id.text_title);
        textMore = findViewById(itemView, R.id.text_more);
        arrowRight = findViewById(itemView, R.id.arrow);

        textMore.setOnClickListener(this);
        arrowRight.setOnClickListener(this);
    }

    @Override
    public void bindData(Context context, TitleEntity entity, int position) {
        this.mPosition = position;
        this.mData = entity;
        arrowRight.setVisibility(entity.isArrow() ? View.VISIBLE : View.GONE);
        title.setText(entity.getTitle());
        textMore.setText(entity.getExtend());

    }

    @Override
    public void setOnItemClickListener(ItemClickListener listener) {
        mListener = listener;
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
