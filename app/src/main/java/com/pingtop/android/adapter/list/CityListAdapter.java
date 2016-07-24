package com.pingtop.android.adapter.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pingtop.android.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wuhaojie on 2016/7/24 12:50.
 */
public class CityListAdapter extends RecyclerView.Adapter {


    private Context mContext;
    private List<String> mList;

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
        // http://stackoverflow.com/questions/24503760/cardview-layout-width-match-parent-does-not-match-parent-recyclerview-width
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_city, parent, false);
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

    public interface OnClickItemListener {
        void onClick(View v, int position);
    }

    public OnClickItemListener mOnClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        mOnClickItemListener = onClickItemListener;
    }

    class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView mTvTitle;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(view ->
                    mOnClickItemListener.onClick(view, getAdapterPosition())
            );
        }

        public void setTvTitle(String text) {
            mTvTitle.setText(text);
        }

    }

}
