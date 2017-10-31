package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.templatelibrary.ItemClickListener;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;

/**
 * Created by kanke on 2017/10/23.
 * <p>
 * 这个就是标题 配置相关信息
 */

public class TitleHolder<T> extends SubViewHolder<T> implements View.OnClickListener, View.OnLongClickListener {

    private TextView title;
    private TextView textMore;
    private ImageView arrowRight;
    private ItemClickListener mListener;
    private int mPosition;
    private T mData;


    public TitleHolder(View itemView) {
        super(itemView);
        title = findViewById(itemView, R.id.text_title);
        textMore = findViewById(itemView, R.id.text_more);
        arrowRight = findViewById(itemView, R.id.arrow);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

    }

    @Override
    public void bindData(Context context, T t, int position) {
        this.mPosition = position;
        this.mData = t;
        if (t instanceof DataBean) {
            DataBean dataBean = (DataBean) t;
            title.setText(dataBean.getContent_name());
            textMore.setText(position + "= more");
            textMore.setOnClickListener(this);
            arrowRight.setOnClickListener(this);
        }
    }

    @Override
    public void setOnItemClickListener(ItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (v == itemView && mListener != null) {
            mListener.onItemClick(v, mData, mPosition);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return mListener != null && mListener.onItemLongClick(v, mData, mPosition);
    }

}
