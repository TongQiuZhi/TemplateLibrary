package com.haishengyue.templatelibrary.viewholder;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.haishengyue.templatelibrary.TemplateFactory;
import com.haishengyue.templatelibrary.base.SubViewHolder;
import com.haishengyue.templatelibrary.entity.BaseEntity;
import com.haishengyue.templatelibrary.entity.SetEntity;
import com.haishengyue.templatelibrary.interfaces.ItemClickListener;

import java.util.List;

/**
 * Created by kanke on 2017/10/27.
 * <p>
 * 只有一个recyclerView
 */

public class HorizontalRecyclerHolder extends SubViewHolder<SetEntity> {
    public HorizontalRecyclerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(final Context context, SetEntity entity, int position) {
        RecyclerView recyclerView = (RecyclerView) itemView;
        itemView.setBackgroundColor(0xff00ff00);
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
//                outRect.set(4,4,4,4);//这个方法多次调用 会叠加
            }

        });
        MyAdapter adapter = new MyAdapter(context, entity.getList());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void setOnItemClickListener(ItemClickListener listener) {
        this.mListener = listener;
    }

    private ItemClickListener mListener;

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    private class MyAdapter extends RecyclerView.Adapter<SubViewHolder> {
        Context context;
        List<BaseEntity> list;

        MyAdapter(Context context, List<BaseEntity> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        public SubViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return TemplateFactory.getTemplateHolder(context, viewType);
        }

        @Override
        public int getItemViewType(int position) {
            return list.get(position).type;
        }

        @Override
        public void onBindViewHolder(SubViewHolder holder, int position) {
            holder.setOnItemClickListener(new ItemClickListener() {
                @Override
                public void onItemClick(View view, BaseEntity obj, int position) {
                    if (mListener != null) mListener.onItemClick(view, obj, position);
                }

                @Override
                public boolean onItemLongClick(View view, BaseEntity obj, int position) {
                    return mListener != null && mListener.onItemLongClick(view, obj, position);
                }
            });

            holder.bindData(context, list.get(position), position);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }


}
