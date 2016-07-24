package com.pingtop.android.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pingtop.android.entities.database.CityEntity;
import com.pingtop.android.entities.database.ProvinceEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuhaojie on 2016/7/23 23:55.
 */
public class DataDaoUtils {
    public static List<ProvinceEntity> getProvinceInfo(SQLiteDatabase database) {
        List<ProvinceEntity> provinceEntities = new ArrayList<>();
        Cursor cursor = database.query("T_Province", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            String proName = cursor.getString(cursor.getColumnIndex("ProName"));
            int proSort = cursor.getInt(cursor.getColumnIndex("ProSort"));
            String proRemark = cursor.getString(cursor.getColumnIndex("ProRemark"));
            ProvinceEntity provinceEntity = new ProvinceEntity(proName, proSort, proRemark);
            provinceEntities.add(provinceEntity);
        }
        cursor.close();
        return provinceEntities;
    }


    public static List<CityEntity> getCityInfo(SQLiteDatabase database, int proId) {
        List<CityEntity> cityEntities = new ArrayList<>();
        Cursor cursor = database.query("T_City", null, "ProID=?", new String[]{proId + ""}, null, null, null);

        while (cursor.moveToNext()) {
            String cityName = cursor.getString(cursor.getColumnIndex("CityName"));
            int proID = cursor.getInt(cursor.getColumnIndex("ProID"));
            int citySort = cursor.getInt(cursor.getColumnIndex("CitySort"));
            CityEntity cityEntity = new CityEntity(cityName, proID, citySort);
            cityEntities.add(cityEntity);
        }
        cursor.close();
        return cityEntities;
    }

}
