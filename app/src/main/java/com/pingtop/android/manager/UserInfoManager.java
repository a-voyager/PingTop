package com.pingtop.android.manager;

import com.pingtop.android.entities.global.UserEntity;

/**
 * Created by wuhaojie on 2016/7/21 22:10.
 */
public class UserInfoManager {

    private UserEntity mUserEntity;

    private static boolean mLogined;

    public static void refresh() {

    }

    public static void setLogined(boolean logined) {
        mLogined = logined;
    }

    public static boolean isLogined() {
        return mLogined;
    }
}
