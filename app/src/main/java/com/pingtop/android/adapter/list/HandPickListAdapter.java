package com.pingtop.android.adapter.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pingtop.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 精选界面
 * Created by wuhaojie on 2016/8/1 22:22.
 */
public class HandPickListAdapter extends RecyclerView.Adapter {

    public static class Item {

    }

    public HandPickListAdapter(Context context) {
        mContext = context;
    }

    private Context mContext;
    private List<Item> mItems = new ArrayList<>();

    private void insertData(Item item) {
        mItems.add(0, item);
        notifyItemInserted(0);
    }

    {
        insertData(new Item());
        insertData(new Item());
        insertData(new Item());
        insertData(new Item());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_hand_pick, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private class Holder extends RecyclerView.ViewHolder {

        public Holder(View itemView) {
            super(itemView);
        }
    }

}
