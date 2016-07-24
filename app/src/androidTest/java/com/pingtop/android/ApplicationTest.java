package com.pingtop.android;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.pingtop.android.entities.database.CityEntity;
import com.pingtop.android.entities.database.ProvinceEntity;
import com.pingtop.android.manager.DataBaseProvider;
import com.pingtop.android.manager.DataManager;
import com.pingtop.android.utils.DataDaoUtils;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testDataBase() {
        DataBaseProvider dataBaseProvider = DataManager.getDataBaseProvider(getContext());
        SQLiteDatabase cityDataBase = dataBaseProvider.getCityDataBase();
        List<ProvinceEntity> provinceInfo = DataDaoUtils.getProvinceInfo(cityDataBase);
        for (ProvinceEntity provinceEntity : provinceInfo) {
            Log.d("test>>", provinceEntity.toString());
        }

        List<CityEntity> cityInfo = DataDaoUtils.getCityInfo(cityDataBase, 28);
        for (CityEntity entity : cityInfo) {
            Log.d("test>>", entity.toString());
        }
    }
}