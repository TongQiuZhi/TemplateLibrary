package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.entity.BannerEntity;
import com.haishengyue.templatelibrary.entity.BaseEntity;
import com.haishengyue.templatelibrary.entity.SetEntity;
import com.haishengyue.templatelibrary.interfaces.ItemClickListener;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.List;

/**
 * Created by kanke on 2017/10/30.
 */

public class UltraViewPagerHolder extends SubViewHolder<SetEntity> {
    private Context mContext;
    private ItemClickListener mListener;

    public UltraViewPagerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(Context context, SetEntity entity, int position) {
        mContext = context;
        UltraViewPager ultraViewPager = (UltraViewPager) itemView;

        ultraViewPager.setAdapter(new MyPagerAdapter(entity.getList()));
        ultraViewPager.initIndicator();
//设置indicator样式
        ultraViewPager.getIndicator()
                .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                .setFocusColor(Color.GREEN)
                .setNormalColor(Color.WHITE)
                .setMargin(0, 0, 0, 5)
                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, context.getResources().getDisplayMetrics()));
//设置indicator对齐方式
        ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//构造indicator,绑定到UltraViewPager
        ultraViewPager.getIndicator().build();

        ultraViewPager.setAutoScroll(2000);
        ultraViewPager.setInfiniteLoop(true);
        ultraViewPager.setMultiScreen(1f);
        //下面两行代码 是切换的状态
//            ultraViewPager.setPageTransformer(true, new UltraDepthScaleTransformer());
//            ultraViewPager.setPageTransformer(false, new UltraScaleTransformer());
        ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);

    }

    @Override
    public void setOnItemClickListener(ItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    private class MyPagerAdapter extends PagerAdapter implements View.OnClickListener {

        List<BaseEntity> mData;
        BaseEntity entity;
        int position;

        MyPagerAdapter(List<BaseEntity> list) {
            this.mData = list;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.lish_item_default_image, null);

            this.entity = mData.get(position);
            this.position = position;
            itemView.setOnClickListener(this);

            TextView text = (TextView) itemView.findViewById(R.id.text);
            text.setText("position = " + position);
            ImageView icon = (ImageView) itemView.findViewById(R.id.icon);
            if (entity instanceof BannerEntity) {
                Glide.with(mContext).load(((BannerEntity) entity).getBannerUrl()).into(icon);
            }
            container.addView(itemView);//这一行不能少
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return mData == null ? 0 : mData.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void onClick(View v) {
            if (mListener != null)
                mListener.onItemClick(v, entity, position);
        }
    }

}
