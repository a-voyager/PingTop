package com.pingtop.android.interfaces;


import com.pingtop.android.adapter.MainPaggerAdapter;
import com.pingtop.android.base.IView;

/**
 * Created by wuhaojie on 2016/7/7 11:29.
 */
public interface IMainView extends IView {

    void setPagerAdapter(MainPaggerAdapter mainPaggerAdapter);
}
