package com.pingtop.android.interfaces;

import com.pingtop.android.base.IView;

import java.util.List;

/**
 * Created by wuhaojie on 2016/8/6 20:36.
 */
public interface IWriteView extends IView {
    boolean isQQChecked();

    boolean isWeiXinChecked();

    boolean isWeiBoChecked();

    String getLocation();

    String getMessageText();

    List<String> getImagesFilePaths();

    boolean checkNotNull();

    void hideKeyboard();
}
