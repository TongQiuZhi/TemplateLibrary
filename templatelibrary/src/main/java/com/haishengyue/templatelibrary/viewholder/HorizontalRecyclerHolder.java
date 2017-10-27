package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.haishengyue.beanlibrary.mallbeans.DataBean;
import com.haishengyue.beanlibrary.mallbeans.TinyDataBean;
import com.haishengyue.templatelibrary.SubViewHolder;
import com.haishengyue.templatelibrary.factory.SingleGoodsLittleTemplateFactory;

import java.util.List;

/**
 * Created by kanke on 2017/10/27.
 * <p>
 * 只有一个recyclerView
 */

public class HorizontalRecyclerHolder extends SubViewHolder<DataBean> {
    public HorizontalRecyclerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(final Context context, DataBean t, int position) {
        RecyclerView recyclerView = (RecyclerView) itemView;
        itemView.setBackgroundColor(0xff00ff00);
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration(){
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//                outRect.set(4,4,4,4);
            }

        });
        MyAdapter adapter = new MyAdapter(context,t.getDatas());
        recyclerView.setAdapter(adapter);

    }

    class MyAdapter extends RecyclerView.Adapter<SingleGoodsHolder>{
        Context context;
        List<TinyDataBean> list;

        MyAdapter(Context context, List<TinyDataBean> list){
            this.context = context;
            this.list = list;
        }
        @Override
        public SingleGoodsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return (SingleGoodsHolder) new SingleGoodsLittleTemplateFactory().getViewHolder(context);
        }

        @Override
        public void onBindViewHolder(SingleGoodsHolder holder, int position) {
            holder.itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 400));
            holder.bindData(context,list.get(position),position);//这个 需要里面再次设置
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


}
