package com.haishengyue.templaremoudle.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kanke on 2017/10/18.
 */

public abstract class BaseFragment extends Fragment {
    protected String TAG = BaseFragment.class.getSimpleName();
    protected Activity mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int resourcesId = getContentId();
        View rootView = inflater.inflate(resourcesId, container, false);
        initView(rootView);
        return rootView;
    }

    protected abstract void initView(View view);

    protected abstract int getContentId();

    protected <T extends View> T findViewById(View view, int id) {
        return (T) view.findViewById(id);
    }

}
