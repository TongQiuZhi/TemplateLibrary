package com.haishengyue.templatelibrary;

import android.view.View;

/**
 * Created by kanke on 2017/10/30.
 * 自定义的监听
 */

public interface ItemClickListener {

    void onItemClick(View view, Object t, int position);

    boolean onItemLongClick(View view, Object t, int position);
}
