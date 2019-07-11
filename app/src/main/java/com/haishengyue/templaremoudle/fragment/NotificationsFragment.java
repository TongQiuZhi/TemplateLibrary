package com.haishengyue.templaremoudle.fragment;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.haishengyue.templaremoudle.R;
import com.haishengyue.templatelibrary.SubAdapter;
import com.haishengyue.templatelibrary.TemplateUtils;
import com.haishengyue.templatelibrary.entity.BannerEntity;
import com.haishengyue.templatelibrary.entity.BaseEntity;
import com.haishengyue.templatelibrary.entity.ChannelEntity;
import com.haishengyue.templatelibrary.entity.GoodsEntity;
import com.haishengyue.templatelibrary.entity.SetEntity;
import com.haishengyue.templatelibrary.entity.TitleEntity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.haishengyue.templatelibrary.SubAdapter.TYPE_HOLDER_LITTLE_GOODS;

/**
 * Created by kanke on 2017/10/18.
 * <p>
 * 这里开始测试 模板
 * 还要实现 下拉刷新 和 上拉加载  banner等
 */

public class NotificationsFragment extends BaseFragment {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private DelegateAdapter mDelegateAdapter;
    private VirtualLayoutManager manager;
    private SubAdapter subAdapter;

    @Override
    protected void initView(View view) {
        mRecyclerView = findViewById(view, R.id.recyclerView);
        mSwipeRefreshLayout = findViewById(view, R.id.swipe_refresh_layout);
        mSwipeRefreshLayout.setColorSchemeColors(0xff337733, 0xff772288, 0xff991100, 0xff88ff77);
        manager = new VirtualLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRecyclerView.setAdapter(mDelegateAdapter);
        initListener();
        initData();

    }

    private void initListener() {
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(mContext, "onRefresh", Toast.LENGTH_SHORT).show();
                mContext.getWindow().getDecorView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 5000);
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("NO", "newState == " + newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int p = manager.findLastVisibleItemPosition();
                    int childCount = manager.getItemCount();
                    Log.e("NO", "p == " + p + ", childCount = " + childCount);
                    if (p >= childCount - 2) {
                        Toast.makeText(mContext, "isLoadMore", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

    }

    private List<DataBean> dataBeen;

    class DataBean {
        int type;

        DataBean(int type) {
            this.type = type;
        }
    }

    private void initData() {
        dataBeen = new ArrayList<>();

        dataBeen.add(new DataBean(1));
        dataBeen.add(new DataBean(1));
        dataBeen.add(new DataBean(1));
        dataBeen.add(new DataBean(1));
        dataBeen.add(new DataBean(1));
        dataBeen.add(new DataBean(2));
        dataBeen.add(new DataBean(2));
        dataBeen.add(new DataBean(2));
        dataBeen.add(new DataBean(2));
        dataBeen.add(new DataBean(3));
        dataBeen.add(new DataBean(3));
        dataBeen.add(new DataBean(3));
        dataBeen.add(new DataBean(4));
        dataBeen.add(new DataBean(4));
        dataBeen.add(new DataBean(4));
        dataBeen.add(new DataBean(4));
        dataBeen.add(new DataBean(15));
        dataBeen.add(new DataBean(15));
        dataBeen.add(new DataBean(15));
        dataBeen.add(new DataBean(15));

        initAdapter();

    }

    private void initAdapter() {
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        TemplateUtils utils = new TemplateUtils(mContext);
        final LinkedList<DelegateAdapter.Adapter> adapters = new LinkedList<>();

        if (dataBeen != null && dataBeen.size() > 0)
            for (final DataBean bean : dataBeen) {
                switch (bean.type) {
                    case 15:
                        adapters.add(utils.initTitle(getTitleEntities()));
                        //这里通用需要异步设置数据   拼接的样式 TODO 实现不了
                        // 解决方案 ：此模板 按照两个模板返回 一个模板只显示一个大图，另一个模板显示水平列表


                        break;
                    case 1://banner
                        adapters.add(utils.initTitle(getTitleEntities()));

                        adapters.add(utils.initBanner(getSetEntities("banner")));
                        break;
                    case 2://channel
                        adapters.add(utils.initTitle(getTitleEntities()));

                        adapters.add(utils.initChannel(getMoreEntities()));

                        break;
                    case 3://水平显示
                        adapters.add(utils.initTitle(getTitleEntities()));

                        adapters.add(utils.initHorizontal(getSetEntities("水平"), TYPE_HOLDER_LITTLE_GOODS));

                        break;
                    case 4://goods
                        adapters.add(utils.initTitle(getTitleEntities()));

                        subAdapter = utils.initGridLayout(getMoreEntities(), 2);
                        adapters.add(subAdapter);

                        break;

                }
            }

        mDelegateAdapter.addAdapters(adapters);
    }

    @NonNull
    private List<BaseEntity> getMoreEntities() {
        List<BaseEntity> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {//TODO 是否需要根据需要得到 url
                ChannelEntity bannerEntity = new ChannelEntity("channelName", url);
                //TODO 这里设置 传递值
                Map<String, Object> params = bannerEntity.params;
                params.put("dec", "deccccccc");
                list.add(bannerEntity);
            } else {
                GoodsEntity goodsEntity = new GoodsEntity("naeme", url, "立即购买", "12", "23", true);
                list.add(goodsEntity);
            }
        }
        return list;
    }

    String url = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1562850424&di=5e7ad175e689c8b2d16a20d77e6390f9&src=http://pic.k73.com/up/soft/2016/0504/092616_93677184.jpg";

    @NonNull
    private List<BaseEntity> getSetEntities(String msg) {
        List<BaseEntity> tempList2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {//TODO 是否需要根据需要得到 url
                BannerEntity bannerEntity = new BannerEntity(url);
                tempList2.add(bannerEntity);
            } else {
                GoodsEntity goodsEntity = new GoodsEntity("goodsName", url, "立即购买", "10", "123", true);
                tempList2.add(goodsEntity);
            }
        }
        List<BaseEntity> tempList3 = new ArrayList<>();
        tempList3.add(new SetEntity(msg, tempList2));
        return tempList3;
    }

    /**
     * 标题数据创建
     */
    @NonNull
    private List<BaseEntity> getTitleEntities() {
        TitleEntity entity = new TitleEntity("动态标题", "更多...", true);
        List<BaseEntity> tempList = new ArrayList<>();
        tempList.add(entity);
        return tempList;
    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_notifications;
    }


}
