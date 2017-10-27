package com.haishengyue.templaremoudle.fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.haishengyue.templaremoudle.HelperType;
import com.haishengyue.templaremoudle.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kanke on 2017/10/18.
 * <p>
 * 通过 layoutHelper 完成布局显示
 * 同一个 adapter 显示不同的布局 这是要公用的item
 */

public class DashBoardFragment extends BaseFragment {
    private RecyclerView mRecyclerView;

    @Override
    protected void initView(View view) {
        TextView id = (TextView) view.findViewById(R.id.textView);
        id.setText("this is dashboard fragment");
        id.setVisibility(View.GONE);
        mRecyclerView = findViewById(view, R.id.recyclerView);

        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);


        CustomAdapter adapter = new CustomAdapter(manager);
        LinkedList<LayoutHelper> helpers = new LinkedList<>();

        for (int i = 0; i < HelperType.values().length; i++) {
            LayoutHelper helper;
            switch (HelperType.values()[i]) {
                case LINEAR_LAYOUT:

                    LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper(20, 12);
                    linearLayoutHelper.setBgColor(0x33ff0000);
                    linearLayoutHelper.setMargin(4, 0, 4, 0);
                    helper = linearLayoutHelper;
                    break;
                case GRID_LAYOUT:
                    GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5, 7, 10, 10);
                    gridLayoutHelper.setBgColor(0x5500ff00);
                    gridLayoutHelper.setAutoExpand(false);//是否自动填充空白
                    gridLayoutHelper.setMargin(10, 10, 10, 10);
                    helper = gridLayoutHelper;
                    break;
                case COLUMN_LAYOUT:
                    ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
                    columnLayoutHelper.setBgColor(0x550000ff);
                    columnLayoutHelper.setItemCount(3);
                    columnLayoutHelper.setWeights(new float[]{60, 20f, 20f});
                    columnLayoutHelper.setMargin(10, 10, 10, 10);
                    columnLayoutHelper.setPadding(5, 5, 5, 5);
                    helper = columnLayoutHelper;
                    break;
                case SINGLE_LAYOUT:
                    SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
                    singleLayoutHelper.setBgColor(0x88994499);
                    singleLayoutHelper.setMargin(10, 10, 10, 10);
                    singleLayoutHelper.setPadding(10, 10, 10, 10);
                    helper = singleLayoutHelper;
                    break;
                case ONE_PLUS_N_LAYOUT:
                    OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper(5, 10, 10, 10, 10);//目前 最大 写5 大于7 抛异常
                    onePlusNLayoutHelper.setBgColor(0xffff758c);
                    onePlusNLayoutHelper.setPadding(10, 10, 10, 10);
                    helper = onePlusNLayoutHelper;
                    break;
                // 下面是固定
//                case FIX_LAYOUT:
//                    FixLayoutHelper fixLayoutHelper = new FixLayoutHelper(FixLayoutHelper.TOP_LEFT, 50, 50);
//                    helper = fixLayoutHelper;
//                    break;
                case SCROLL_FIX_LAYOUT:
                    /*
                        SHOW_ALWAYS：永远显示(即效果同固定布局)
                        SHOW_ON_ENTER：默认不显示视图，当页面滚动到该视图位置时才显示；
                        SHOW_ON_LEAVE：默认不显示视图，当页面滚出该视图位置时才显示
                     */
                    ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(FixLayoutHelper.BOTTOM_LEFT, 10, 10);
                    scrollFixLayoutHelper.setBgColor(0xffff00ff);
                    scrollFixLayoutHelper.setItemCount(1);
                    scrollFixLayoutHelper.setAlignType(FixLayoutHelper.BOTTOM_LEFT);
                    scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
                    scrollFixLayoutHelper.setX(100);
                    scrollFixLayoutHelper.setY(100);
                    helper = scrollFixLayoutHelper;
                    break;
                case FLOAT_LAYOUT:
                    FloatLayoutHelper floatLayoutHelper = new FloatLayoutHelper();
                    floatLayoutHelper.setItemCount(1);
                    floatLayoutHelper.setDefaultLocation(300,300);// 设置布局里Item的初始位置
                    helper = floatLayoutHelper;
                    break;
                case STICKY_LAYOUT:
                    StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
                    helper = stickyLayoutHelper;
                    break;
                case STAGGERED_GRID_LAOUT:
                    StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(2, 10);
                    staggeredGridLayoutHelper.setItemCount(20);
                    staggeredGridLayoutHelper.setBgColor(0xffcc9900);
                    staggeredGridLayoutHelper.setMargin(10, 10, 10, 10);
                    staggeredGridLayoutHelper.setPadding(10, 10, 10, 10);
                    helper = staggeredGridLayoutHelper;
                    break;
                default:
                    helper = DefaultLayoutHelper.newHelper(0);
            }
            helpers.add(helper);
        }
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        helpers.add(stickyLayoutHelper);
        helpers.add(DefaultLayoutHelper.newHelper(20));
        manager.setLayoutHelpers(helpers);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_dash_board;
    }

    private class CustomAdapter extends VirtualLayoutAdapter {

        private CustomAdapter(@NonNull VirtualLayoutManager layoutManager) {
            super(layoutManager);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_simple_layout, parent, false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            LayoutHelper byPosition = mLayoutManager.findLayoutHelperByPosition(position);
            if(byPosition instanceof FloatLayoutHelper){
                holder.itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(100,100));
            }
            if (holder instanceof ViewHolder) {
                ViewHolder h = (ViewHolder) holder;
                h.textView.setText("position == " + position);
            }
        }

        @Override
        public int getItemCount() {
            List<LayoutHelper> helpers = getLayoutHelpers();
            if (helpers == null) {
                return 0;
            }
            int count = 0;
            for (int i = 0, size = helpers.size(); i < size; i++) {
                count += helpers.get(i).getItemCount();
            }
            return count;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            TextView textView;

            ViewHolder(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.textView);
            }
        }

    }

}
