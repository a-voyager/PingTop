package com.pingtop.android.interfaces;

import com.pingtop.android.adapter.list.CityListAdapter;
import com.pingtop.android.base.IView;

/**
 * Created by wuhaojie on 2016/7/24 12:36.
 */
public interface ICityChoiceView extends IView {
    void setAdapter(CityListAdapter cityListAdapter);

    void hideProgressBar();

    void showProgressBar();

    void refreshAdapter();

    void setToolBarTitle(String s);
}
