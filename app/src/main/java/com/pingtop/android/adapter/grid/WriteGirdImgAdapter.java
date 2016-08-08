package com.pingtop.android.adapter.grid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.pingtop.android.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhaojie on 2016/8/8 21:23.
 */
public class WriteGirdImgAdapter extends BaseAdapter {

    private Context mContext;

    public WriteGirdImgAdapter(Context context) {
        mContext = context;
    }

    public static class Item {


    }

    private List<Item> mItemList = new ArrayList<>();

    public void insertData(Item item) {
        mItemList.add(0, item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return mItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_img_write_gv, null);
            holder = new Holder();
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        return view;
    }

    static class Holder {

    }

}
