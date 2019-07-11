package com.haishengyue.templaremoudle.fragment;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.beanlibrary.mallbeans.MallGoodsBean;
import com.haishengyue.beanlibrary.mallbeans.MallRecordsBean;
import com.haishengyue.beanlibrary.mallbeans.ResMallHome;
import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.BannerTinyBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.ChannelTinyBean;
import com.haishengyue.beanlibrary.mallbeans.tinybean.GoodTinyBean;
import com.haishengyue.templaremoudle.R;
import com.haishengyue.templatelibrary.SubAdapter;
import com.haishengyue.templatelibrary.TemplateUtils;
import com.haishengyue.templatelibrary.entity.BannerEntity;
import com.haishengyue.templatelibrary.entity.BaseEntity;
import com.haishengyue.templatelibrary.entity.ChannelEntity;
import com.haishengyue.templatelibrary.entity.GoodsEntity;
import com.haishengyue.templatelibrary.entity.SetEntity;
import com.haishengyue.templatelibrary.entity.TitleEntity;
import com.haishengyue.templatelibrary.interfaces.ItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;
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

    private void initData() {

    }

    private void initAdapter() {
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        TemplateUtils utils = new TemplateUtils(mContext);
        final LinkedList<DelegateAdapter.Adapter> adapters = new LinkedList<>();

        if (dataBeen != null && dataBeen.size() > 0)
            for (final DataBean bean : dataBeen) {
                String template_type = bean.getTemplate_type();
                if (TextUtils.isEmpty(template_type)) template_type = "0";
                switch (Integer.parseInt(template_type)) {
                    case 15:
//                        adapters.add(utils.initTitle(getTitleEntities(bean)));
                        //这里通用需要异步设置数据   拼接的样式 TODO 实现不了
                        // 解决方案 ：此模板 按照两个模板返回 一个模板只显示一个大图，另一个模板显示水平列表


                        break;
                    case 1://banner
//                        adapters.add(utils.initTitle(getTitleEntities(bean)));

                        adapters.add(utils.initBanner(getSetEntities("banner", bean)));
                        break;
                    case 2://channel
//                        adapters.add(utils.initTitle(getTitleEntities(bean)));

                        adapters.add(utils.initChannel(getMoreEntities(bean)));

                        break;
                    case 3://水平显示
                        adapters.add(utils.initTitle(getTitleEntities(bean)));

                        adapters.add(utils.initHorizontal(getSetEntities("水平", bean), TYPE_HOLDER_LITTLE_GOODS));

                        break;
                    case 4://goods
                        adapters.add(utils.initTitle(getTitleEntities(bean)));

                        subAdapter = utils.initGridLayout(getMoreEntities(bean), 2);
                        adapters.add(subAdapter);


                        //TODO 还有一系列的判断条件
                        //"page":{"no":0,"size":1000}
                        List<MallRecordsBean> records = new ArrayList<>();

                        List<BaseEntity> list4 = new ArrayList<>();
                        for (MallRecordsBean b : records) {
                            MallGoodsBean goods = b.getGoods();
                            GoodsEntity goodsEntity = new GoodsEntity(goods.getName(), goods.getLogo().getUrl(), "抢购", goods.getPrice(), goods.getOldPrice(), true);
                            list4.add(goodsEntity);
                        }
                        subAdapter.add(list4);
                        break;

                }
            }
        int m = adapters.size();
        for (; ; ) {
            m--;
            if (m < 0) {
                break;
            }
            SubAdapter adapter = (SubAdapter) adapters.get(m);
            adapter.setOnItemClickListener(new ItemClickListener() {

                @Override
                public void onItemClick(View view, BaseEntity t, int position) {
                    if (t instanceof ChannelEntity) {
                        Object dec = t.params.get("dec");
                        Toast.makeText(mContext, dec.toString(), Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(mContext, "position = " + position, Toast.LENGTH_SHORT).show();
                }

                @Override
                public boolean onItemLongClick(View view, BaseEntity t, int position) {
                    return false;
                }
            });
        }

        mDelegateAdapter.addAdapters(adapters);
    }

    @NonNull
    private List<BaseEntity> getMoreEntities(DataBean bean) {
        List<BaseEntity> list = new ArrayList<>();
        List<TinyDataBean> datas = bean.getDatas();
        for (TinyDataBean b : datas) {
            if (b instanceof ChannelTinyBean) {//TODO 是否需要根据需要得到 url
                ChannelEntity bannerEntity = new ChannelEntity(b.getChannel_name(), b.getIcon_url());
                //TODO 这里设置 传递值
                Map<String, Object> params = bannerEntity.params;
                params.put("dec", b.getChannel_dec());
                list.add(bannerEntity);
            }
            if (b instanceof GoodTinyBean) {
                GoodsEntity goodsEntity = new GoodsEntity(((GoodTinyBean) b).getName(), ((GoodTinyBean) b).getUrl(), "立即购买", ((GoodTinyBean) b).getPrice(), ((GoodTinyBean) b).getOldPrice(), true);
                list.add(goodsEntity);
            }
        }
        return list;
    }

    @NonNull
    private List<BaseEntity> getSetEntities(String msg, DataBean bean) {
        List<BaseEntity> tempList2 = new ArrayList<>();
        List<TinyDataBean> datas = bean.getDatas();
        for (TinyDataBean b : datas) {
            if (b instanceof BannerTinyBean) {//TODO 是否需要根据需要得到 url
                BannerEntity bannerEntity = new BannerEntity(((BannerTinyBean) b).getPic());
                tempList2.add(bannerEntity);
            }
            if (b instanceof GoodTinyBean) {
                GoodsEntity goodsEntity = new GoodsEntity(((GoodTinyBean) b).getName(), ((GoodTinyBean) b).getUrl(), "立即购买", ((GoodTinyBean) b).getPrice(), ((GoodTinyBean) b).getOldPrice(), true);
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
    private List<BaseEntity> getTitleEntities(DataBean bean) {
        TitleEntity entity = new TitleEntity(bean.getContent_name(), "更多...", true);
        List<BaseEntity> tempList = new ArrayList<>();
        tempList.add(entity);
        return tempList;
    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_notifications;
    }


}
