package com.pingtop.android.adapter.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pingtop.android.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wuhaojie on 2016/7/24 12:50.
 */
public class CityListAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<String> mList = new ArrayList<>();

    public CityListAdapter(Context context) {
        mContext = context;
    }

    public CityListAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    public void setList(List<String> list) {
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_city, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Holder cityHolder = (Holder) holder;
        cityHolder.setTvTitle(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTvTitle;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setTvTitle(String text) {
            mTvTitle.setText(text);
        }

    }

}
