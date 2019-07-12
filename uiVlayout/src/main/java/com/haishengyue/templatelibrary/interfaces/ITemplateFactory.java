package com.haishengyue.templatelibrary.interfaces;

import android.content.Context;

import com.haishengyue.templatelibrary.base.SubViewHolder;

/**
 * Created by kanke on 2017/10/26.
 * 模板工厂  这应该是个代理工程 不能具体实现 不然每次增加模板 都要修改这个依赖库
 */

public interface ITemplateFactory {

    SubViewHolder getViewHolder(Context context);

}
