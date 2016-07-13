package com.pingtop.android.interfaces;


import android.support.annotation.StringRes;

import com.pingtop.android.base.IView;

/**
 * Created by wuhaojie on 2016/7/7 11:29.
 */
public interface IMainView extends IView {
    void showSnackBarMsg(@StringRes int msg);

    void showSnackBarMsg(String msg);

}
