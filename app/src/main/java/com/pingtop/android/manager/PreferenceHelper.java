package com.pingtop.android.manager;

import android.content.Context;
import android.text.TextUtils;

import com.pingtop.android.utils.PreferenceUtils;

/**
 * Created by wuhaojie on 2016/7/21 21:44.
 */
class PreferenceHelper {
    public static final String KEY_TOKEN = "token";
    private PreferenceUtils mPreferenceUtils;

    public PreferenceHelper(Context context) {
        mPreferenceUtils = PreferenceUtils.getInstance(context);
    }

    public boolean hasLoginInfo() {
        String s = mPreferenceUtils.getStringParam(KEY_TOKEN);
        return !TextUtils.isEmpty(s);
    }

    public String getToken() {
        return mPreferenceUtils.getStringParam(KEY_TOKEN);
    }

}
