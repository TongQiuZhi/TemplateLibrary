package com.haishengyue.templaremoudle.fragment;

import android.view.View;
import android.widget.TextView;

import com.haishengyue.templaremoudle.R;

/**
 * Created by kanke on 2017/10/18.
 */

public class NotificationsFragment extends BaseFragment {
    @Override
    protected void initView(View view) {
        TextView id = (TextView) view.findViewById(R.id.textView);
        id.setText("this is notification fragment");
    }

    @Override
    protected int getContentId() {
        return R.layout.fragment_notifications;
    }
}