package com.pingtop.android.adapter.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pingtop.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhaojie on 2016/8/18 12:27.
 */
public class CommunityAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private final LayoutInflater mLayoutInflater;

    private List<Item> mItems = new ArrayList<>();

    static class Item {

    }

    public CommunityAdapter(Context context, List<Item> items) {
        this(context);
        mItems = items;
    }

    public CommunityAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    {
        mItems.add(new Item());
        mItems.add(new Item());
        mItems.add(new Item());
        mItems.add(new Item());
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_community, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder viewHolder = (Holder) holder;
        // TODO: 2016/8/18 设置内容
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class Holder extends RecyclerView.ViewHolder {

        final TextView mContent;
        final TextView mUser;
        final TextView mFlag;
        final SimpleDraweeView mHeader;
        final GridView mImgs;

        public Holder(View itemView) {
            super(itemView);
            mContent = (TextView) itemView.findViewById(R.id.tv_content);
            mUser = (TextView) itemView.findViewById(R.id.tv_user);
            mFlag = (TextView) itemView.findViewById(R.id.tv_flag);
            mHeader = (SimpleDraweeView) itemView.findViewById(R.id.iv_header);
            mImgs = (GridView) itemView.findViewById(R.id.gv_community_imgs);
        }
    }

}
