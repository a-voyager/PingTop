package com.pingtop.android.manager;

import android.content.Context;

/**
 * Created by wuhaojie on 2016/7/21 21:17.
 */
public class DataManager {

    private static class SingletonHolder {

        private final static HttpHelper HTTP_HELPER = new HttpHelper();
        private volatile static PreferenceHelper PREFERENCE_HELPER;

    }

    public static HttpHelper getHttpHelper() {
        return SingletonHolder.HTTP_HELPER;
    }

    public static PreferenceHelper getPreferenceHelper(Context context) {
        if (SingletonHolder.PREFERENCE_HELPER == null) {
            synchronized (DataManager.class) {
                if (SingletonHolder.PREFERENCE_HELPER == null) {
                    SingletonHolder.PREFERENCE_HELPER = new PreferenceHelper(context);
                }
            }
        }
        return SingletonHolder.PREFERENCE_HELPER;
    }

    public static DataBaseProvider getDataBaseProvider(Context context) {
        return DataBaseProvider.getInstance(context);
    }


}
