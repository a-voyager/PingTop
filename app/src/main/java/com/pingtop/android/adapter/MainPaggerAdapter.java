package com.pingtop.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.pingtop.android.entities.PageItem;

import java.util.List;

/**
 * Created by wuhaojie on 2016/7/13 23:10.
 */
public class MainPaggerAdapter extends FragmentPagerAdapter {


    private final List<PageItem> mPageItems;


    public MainPaggerAdapter(FragmentManager fm, List<PageItem> pageItems) {
        super(fm);
        mPageItems = pageItems;
    }

    @Override
    public Fragment getItem(int position) {
        return mPageItems.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mPageItems.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mPageItems.get(position).getTitle();
    }
}
