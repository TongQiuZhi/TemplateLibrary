package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;

/**
 * Created by kanke on 2017/10/23.
 * <p>
 * 这个就是标题 配置相关信息
 */

public class TitleHolder<T> extends SubViewHolder<T> implements View.OnClickListener {

    TextView title;
    TextView textMore;
    ImageView arrowRight;

    public TitleHolder(View itemView) {
        super(itemView);
        title = findViewById(itemView, R.id.text_title);
        textMore = findViewById(itemView, R.id.text_more);
        arrowRight = findViewById(itemView, R.id.arrow);
    }

    @Override
    public void bindData(Context context, T t, int position) {
        if(t instanceof DataBean){
            DataBean dataBean = (DataBean) t;
            title.setText(dataBean.getContent_name());
            textMore.setText(position + "= more");
            textMore.setOnClickListener(this);
            arrowRight.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {//这个需要外部监听
    }
}
