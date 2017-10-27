package com.haishengyue.templaremoudle.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.beanlibrary.mallbeans.MallRecordsBean;
import com.haishengyue.beanlibrary.mallbeans.ResMallHome;
import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;
import com.haishengyue.templaremoudle.R;
import com.haishengyue.templaremoudle.notification.SubAdapter;
import com.haishengyue.templaremoudle.testData.DecodeUtils;
import com.haishengyue.templaremoudle.testData.net.HttpCallBack;
import com.haishengyue.templaremoudle.testData.net.HttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kanke on 2017/10/18.
 * <p>
 * 这里开始测试 模板
 * 还要实现 下拉刷新 和 上拉加载  banner等
 */

public class NotificationsFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private DelegateAdapter mDelegateAdapter;
    private SubAdapter customAdapter;

    @Override
    protected void initView(View view) {
        mRecyclerView = findViewById(view, R.id.recyclerView);
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRecyclerView.setAdapter(mDelegateAdapter);

        initData();

    }

    private List<DataBean> dataBeen;

    private void initData() {
        String url = "http://ss-www.oss-cn-hangzhou.aliyuncs.com/api/result.json";
        url = "http://ceng.heysound.com:4000/api/test/result";
        try {
            HttpUtils.get(NotificationsFragment.this, url, null, new HttpCallBack() {
                @Override
                public void onSuccess(String msg, String data) {
                    try {
                        dataBeen = DecodeUtils.decodeJsonString(data);
                        initAdapter();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


                @Override
                public void onFailure(String msg) {

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void initAdapter() {
        final RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 20);

        final LinkedList<DelegateAdapter.Adapter> adapters = new LinkedList<>();
        if (dataBeen != null && dataBeen.size() > 0) for (final DataBean bean : dataBeen) {
            String template_type = bean.getTemplate_type();
            if (TextUtils.isEmpty(template_type)) template_type = "0";
            switch (Integer.parseInt(template_type)) {
                case 1://banner
                    break;
                case 2://channel
                    SingleLayoutHelper singleLayoutHelper2 = new SingleLayoutHelper();
                    singleLayoutHelper2.setBgColor(0xffffffff);
                    List<DataBean> list = new ArrayList<>();
                    list.add(bean);
                    adapters.add(new SubAdapter<>(mContext, singleLayoutHelper2, list));

                    List<TinyDataBean> datas = bean.getDatas();
                    GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(5);
                    gridLayoutHelper.setBgColor(0xffffffff);
                    gridLayoutHelper.setAutoExpand(false);
                    gridLayoutHelper.setMarginBottom(10);//TODO 10或者更多的时候，需要自己构建 第10个数据
                    int num = datas.size() > 10 ? 10 : datas.size();
                    adapters.add(new SubAdapter<>(mContext, gridLayoutHelper, datas, num, 2));
                    break;
                case 3://水平显示
                    SingleLayoutHelper singleLayoutHelper3 = new SingleLayoutHelper();
                    singleLayoutHelper3.setBgColor(0xffffffff);
                    list = new ArrayList<>();
                    list.add(bean);
                    adapters.add(new SubAdapter<>(mContext, singleLayoutHelper3, list));


                    //1.先确认出一个单行的view 2.单行view 里面是一个recyclerview 3.设置这个recyclerView
                    SubAdapter adapter = new SubAdapter<>(mContext,new DefaultLayoutHelper(),list,1 ,3);
                    adapters.add(adapter);

                    break;
                case 4://goods
                    SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
                    singleLayoutHelper.setBgColor(0xffffffff);
                    list = new ArrayList<>();
                    list.add(bean);
                    adapters.add(new SubAdapter<>(mContext, singleLayoutHelper, list));
                    //
                    StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(2, dp2px(mContext, 10));
                    staggeredGridLayoutHelper.setBgColor(0xffffffff);
                    staggeredGridLayoutHelper.setMargin(dp2px(mContext, 10), 0, dp2px(mContext, 10), 0);
                    final List<MallRecordsBean> records = new ArrayList<>();
                    customAdapter = new SubAdapter<>(mContext, staggeredGridLayoutHelper, records, 0, 4);
                    adapters.add(customAdapter);

                    //TODO 还有一系列的判断条件
                    //"page":{"no":0,"size":1000}
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("no", 0);
                    map.put("size", 20);
                    HashMap<String, Object> map2 = new HashMap<>();
                    map2.put("page", map);
                    Map<String, Object> stringObjectMap = HttpUtils.sortMapByKey(map2);
                    final String s = HttpUtils.sortMapByKey2String(stringObjectMap);

                    HttpUtils.post(this, "http://test.heysound.com/goods/listRc.do", null, null, s, new HttpCallBack() {
                        @Override
                        public void onSuccess(String msg, String data) {
                            ResMallHome resMallHome = DecodeUtils.JsonToBean(data, ResMallHome.class);
                            List<MallRecordsBean> records = resMallHome.getResult().getRecords();
                            customAdapter.add(records);
                        }

                        @Override
                        public void onFailure(String msg) {

                        }
                    });
                    break;
            }
        }
        mDelegateAdapter.addAdapters(adapters);
    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_notifications;
    }

    public static int dp2px(Context context, int dp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) ((dp * displayMetrics.density) + 0.5);
    }

}
