package com.pingtop.android.adapter.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pingtop.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhaojie on 2016/7/21 10:06.
 */
public class SettingsListAdapter extends BaseAdapter {

    private List<String> mItems = new ArrayList<>();
    private Context mContext;

    public SettingsListAdapter(Context context) {
        mContext = context;
    }

    {
        mItems.add("接收消息");
        mItems.add("清除缓存");
        mItems.add("意见反馈");
        mItems.add("关于拼途");
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_zone_lv, null);
            TextView title = (TextView) view.findViewById(R.id.tv_title);
            viewHolder = new ViewHolder(title);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.mTitle.setText(mItems.get(i));
        return view;
    }

    private class ViewHolder {
        private TextView mTitle;

        public ViewHolder(TextView title) {
            mTitle = title;
        }
    }

}
