package com.pingtop.android.entities;

import android.support.v4.app.Fragment;

/**
 * Created by wuhaojie on 2016/7/13 23:27.
 */
public class PageItem {

    public PageItem(Fragment fragment, String title) {
        mFragment = fragment;
        mTitle = title;
    }

    private Fragment mFragment;
    private String mTitle;

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
