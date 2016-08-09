package com.pingtop.android.adapter.grid;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.pingtop.android.R;

import java.io.File;
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
        File mFile;
    }

    private List<Item> mItemList = new ArrayList<>();

    public int getListSize() {
        return mItemList.size();
    }


    public void insertData(Item item) {
        mItemList.add(item);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mItemList.size() + 1;
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
        if (i == mItemList.size()) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.item_add_gv, null);
            return inflate;
        }
        Holder holder;
        if (view == null) {
            holder = new Holder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_img_write_gv, null);
            holder.mContent = (SimpleDraweeView) view.findViewById(R.id.iv_content_gv);
            holder.mDelete = (ImageView) view.findViewById(R.id.iv_delete_gv);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        Uri uri = Uri.fromFile(mItemList.get(i).mFile);
        holder.mContent.setImageURI(uri);
        return view;
    }

    static class Holder {

        SimpleDraweeView mContent;
        ImageView mDelete;
    }

}
