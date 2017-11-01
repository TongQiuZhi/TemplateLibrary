package com.haishengyue.templatelibrary.interfaces;

import android.view.View;

import com.haishengyue.templatelibrary.entity.BaseEntity;

/**
 * Created by kanke on 2017/10/30.
 * 自定义的监听
 */

public interface ItemClickListener {

    void onItemClick(View view, BaseEntity t, int position);

    boolean onItemLongClick(View view, BaseEntity t, int position);
}
