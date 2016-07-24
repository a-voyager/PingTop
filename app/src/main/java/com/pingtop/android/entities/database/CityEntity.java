package com.pingtop.android.entities.database;

/**
 * Created by wuhaojie on 2016/7/24 10:06.
 */
public class CityEntity {
    private String mCityName;
    private int mProID;
    private int mCitySort;

    public CityEntity(String cityName, int proID, int citySort) {
        mCityName = cityName;
        mProID = proID;
        mCitySort = citySort;
    }

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    public int getProID() {
        return mProID;
    }

    public void setProID(int proID) {
        mProID = proID;
    }

    public int getCitySort() {
        return mCitySort;
    }

    public void setCitySort(int citySort) {
        mCitySort = citySort;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "mCityName='" + mCityName + '\'' +
                ", mProID=" + mProID +
                ", mCitySort=" + mCitySort +
                '}';
    }
}
