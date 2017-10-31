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
import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.BannerTinyBean;
import com.haishengyue.templatelibrary.ItemClickListener;
import com.haishengyue.templatelibrary.R;
import com.haishengyue.templatelibrary.SubViewHolder;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer;
import com.tmall.ultraviewpager.transformer.UltraScaleTransformer;

import java.util.List;

/**
 * Created by kanke on 2017/10/30.
 */

public class UltraViewPagerHolder<T> extends SubViewHolder<T> {
    private Context mContext;

    public UltraViewPagerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(Context context, T t, int position) {
        if (t instanceof DataBean) {
            List<TinyDataBean> datas = ((DataBean) t).getDatas();

            mContext = context;
            UltraViewPager ultraViewPager = (UltraViewPager) itemView;

            ultraViewPager.setAdapter(new MyPagerAdapter(datas));
            ultraViewPager.initIndicator();
//设置indicator样式
            ultraViewPager.getIndicator()
                    .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                    .setFocusColor(Color.GREEN)
                    .setNormalColor(Color.WHITE)
                    .setMargin(0,0,0,5)
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


    }

    @Override
    public void setOnItemClickListener(ItemClickListener listener) {

    }

    class MyPagerAdapter extends PagerAdapter {

        List mData;

        MyPagerAdapter(List list) {
            this.mData = list;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View cardView = LayoutInflater.from(mContext).inflate(R.layout.lish_item_default_image, null);
            TextView text = (TextView) cardView.findViewById(R.id.text);
            text.setText("position = " + position);
            ImageView icon = (ImageView) cardView.findViewById(R.id.icon);//TODO 待设置
            Object o = mData.get(position);
            if(o instanceof BannerTinyBean){
                Glide.with(mContext).load(((BannerTinyBean) o).getPic()).into(icon);
            }

            container.addView(cardView);//这一行不能少
            return cardView;
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
    }

}
