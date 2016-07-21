package com.pingtop.android.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.pingtop.android.injector.scrope.ContextLifeCycle;

/**
 * Created by wuhaojie on 2016/7/21 13:12.
 */
public class PreferenceUtils {

    private static final String PREFERENCE_FILE_NAME = "config";
    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor shareEditor;

    private static volatile PreferenceUtils preferenceUtils = null;


    protected PreferenceUtils(@ContextLifeCycle("App") Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCE_FILE_NAME, Context.MODE_PRIVATE);
        shareEditor = sharedPreferences.edit();
    }

    public static PreferenceUtils getInstance(Context context) {
        if (preferenceUtils == null) {
            synchronized (PreferenceUtils.class) {
                if (preferenceUtils == null) {
                    preferenceUtils = new PreferenceUtils(context.getApplicationContext());
                }
            }
        }
        return preferenceUtils;
    }

    public String getStringParam(String key) {
        return getStringParam(key, "");
    }

    public String getStringParam(String key, String defaultString) {
        return sharedPreferences.getString(key, defaultString);
    }

    public void saveParam(String key, String value) {
        shareEditor.putString(key, value).apply();
    }

    public boolean getBooleanParam(String key) {
        return getBooleanParam(key, false);
    }

    public boolean getBooleanParam(String key, boolean defaultBool) {
        return sharedPreferences.getBoolean(key, defaultBool);
    }

    public void saveParam(String key, boolean value) {
        shareEditor.putBoolean(key, value).apply();
    }

    public int getIntParam(String key) {
        return getIntParam(key, 0);
    }

    public int getIntParam(String key, int defaultInt) {
        return sharedPreferences.getInt(key, defaultInt);
    }

    public void saveParam(String key, int value) {
        shareEditor.putInt(key, value).apply();
    }

    public long getLongParam(String key) {
        return getLongParam(key, 0);
    }

    public long getLongParam(String key, long defaultInt) {
        return sharedPreferences.getLong(key, defaultInt);
    }

    public void saveParam(String key, long value) {
        shareEditor.putLong(key, value).apply();
    }

    public void removeKey(String key) {
        shareEditor.remove(key).apply();
    }
}