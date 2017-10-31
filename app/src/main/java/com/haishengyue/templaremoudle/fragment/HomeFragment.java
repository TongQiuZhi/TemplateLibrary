package com.haishengyue.templaremoudle.fragment;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;
import com.haishengyue.templaremoudle.R;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraDepthScaleTransformer;
import com.tmall.ultraviewpager.transformer.UltraScaleTransformer;

/**
 * Created by kanke on 2017/10/18.
 * <p>
 * 这里开始 设置模板 和一些工具方法
 */

public class HomeFragment extends BaseFragment {

    private RecyclerView mRecyclerView;

    @Override
    protected void initView(View view) {
        TextView id = findViewById(view, R.id.textView);
        id.setText("this is home fragment");
        mRecyclerView = findViewById(view, R.id.recycler_view);

        VirtualLayoutManager layoutManager = new VirtualLayoutManager(mContext);
        mRecyclerView.setLayoutManager(layoutManager);

        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);

        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, false);
        mRecyclerView.setAdapter(delegateAdapter);


        delegateAdapter.addAdapter(new MyAdapter(mContext, new DefaultLayoutHelper(), 5));

    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_home;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    class MyAdapter extends DelegateAdapter.Adapter<MyViewHolder> {
        private final Context mContext;
        private final LayoutHelper mHelper;
        private final int mCount;

        public MyAdapter(Context context, LayoutHelper helper, int count) {
            this.mContext = context;
            this.mHelper = helper;
            this.mCount = count;
        }

        @Override
        public LayoutHelper onCreateLayoutHelper() {
            return mHelper;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.lish_view_pager, parent, false));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            UltraViewPager ultraViewPager = (UltraViewPager) holder.itemView;

            ultraViewPager.setAdapter(new MyPageAdapter(mCount));
            ultraViewPager.initIndicator();
//设置indicator样式
            ultraViewPager.getIndicator()
                    .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
                    .setFocusColor(Color.GREEN)
                    .setNormalColor(Color.WHITE)
                    .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics()));
//设置indicator对齐方式
            ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//构造indicator,绑定到UltraViewPager
            ultraViewPager.getIndicator().build();

            ultraViewPager.setLayoutParams(new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400));
            ultraViewPager.setAutoScroll(1000);
            ultraViewPager.setInfiniteLoop(true);
            ultraViewPager.setMultiScreen(1f);
            //下面两行代码 是切换的状态
//            ultraViewPager.setPageTransformer(true, new UltraDepthScaleTransformer());
//            ultraViewPager.setPageTransformer(false, new UltraScaleTransformer());
            ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);

        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }

    class MyPageAdapter extends PagerAdapter {
        int count;

        MyPageAdapter(int count) {
            this.count = count;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View linearLayout = LayoutInflater.from(mContext).inflate(R.layout.item_simple_layout, null);
            switch (position) {
                case 0:
                    linearLayout.setBackgroundColor(Color.parseColor("#2196F3"));
                    break;
                case 1:
                    linearLayout.setBackgroundColor(Color.parseColor("#673AB7"));
                    break;
                case 2:
                    linearLayout.setBackgroundColor(Color.parseColor("#009688"));
                    break;
                case 3:
                    linearLayout.setBackgroundColor(Color.parseColor("#607D8B"));
                    break;
                case 4:
                    linearLayout.setBackgroundColor(Color.parseColor("#F44336"));
                    break;
            }
            TextView textView = (TextView) linearLayout.findViewById(R.id.textView);
            textView.setText(position + " 位置");
            container.addView(linearLayout);
            return linearLayout;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public int getCount() {
            return count;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

}
