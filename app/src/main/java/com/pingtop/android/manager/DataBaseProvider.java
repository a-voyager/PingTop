package com.pingtop.android.manager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.annotation.RawRes;

import com.pingtop.android.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wuhaojie on 2016/7/23 23:07.
 */
class DataBaseProvider {

    private static final int CITY_DB = R.raw.china_city;
    public static final String CITY_DB_FILE_NAME = "china_city.db";

    private Context mContext;
    private final String dbFilePath;
    private SQLiteDatabase mSQLiteDatabase;

    private static volatile DataBaseProvider mDataBaseProvider;

    private DataBaseProvider(Context context) {
        mContext = context;
        dbFilePath = Environment.getDataDirectory().getPath()
                + File.separator + "data" + File.separator + mContext.getPackageName() + File.separator + "databases";
    }

    public static DataBaseProvider getInstance(Context context) {
        if (mDataBaseProvider == null) {
            synchronized (DataBaseProvider.class) {
                if (mDataBaseProvider == null) {
                    mDataBaseProvider = new DataBaseProvider(context);
                }
            }
        }
        return mDataBaseProvider;
    }

    public SQLiteDatabase getCityDataBase() {
        File file = new File(dbFilePath + CITY_DB_FILE_NAME);
        return getSQLiteDatabase(file, CITY_DB);
    }


    private SQLiteDatabase getSQLiteDatabase(File desFile, @RawRes int dbRawId) {
        if (mSQLiteDatabase == null) {
            if (!desFile.exists())
                copyDataBase(desFile, dbRawId);
            mSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(desFile, null);
        }
        return mSQLiteDatabase;
    }

    private void copyDataBase(File desFile, @RawRes int dbRawId) {
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = mContext.getResources().openRawResource(dbRawId);
            outputStream = new FileOutputStream(desFile);
            byte[] buffer = new byte[1024];
            int len;

            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null && inputStream != null) {
                try {
                    outputStream.close();
                    inputStream.close();
                } catch (IOException e) {
                    outputStream = null;
                    inputStream = null;
                }
            }
        }

    }

}
