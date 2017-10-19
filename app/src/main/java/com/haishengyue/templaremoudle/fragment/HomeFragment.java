package com.haishengyue.templaremoudle.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.haishengyue.templaremoudle.R;

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


    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_home;
    }
}
