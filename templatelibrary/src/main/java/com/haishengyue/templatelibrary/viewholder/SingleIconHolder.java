package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.haishengyue.beanlibrary.mallbeans.tinybean.BannerTinyBean;
import com.haishengyue.templatelibrary.ItemClickListener;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;

/**
 * Created by kanke on 2017/10/30.
 */

public class SingleIconHolder extends SubViewHolder {
    public SingleIconHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(Context context, Object o, int position) {
        if (o instanceof BannerTinyBean) {
            String pic = ((BannerTinyBean) o).getPic();
            Glide.with(context).load(pic).into((ImageView) itemView.findViewById(R.id.icon));
        }

    }

    @Override
    public void setOnItemClickListener(ItemClickListener listener) {

    }
}
