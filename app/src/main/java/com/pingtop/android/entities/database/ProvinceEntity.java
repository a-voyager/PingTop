package com.pingtop.android.entities.database;

/**
 * Created by wuhaojie on 2016/7/24 0:13.
 */
public class ProvinceEntity {
    private String mProName;
    private int mProSort;
    private String mProRemark;

    public ProvinceEntity(String proName, int proSort, String proRemark) {
        mProName = proName;
        mProSort = proSort;
        mProRemark = proRemark;
    }

    public String getProName() {
        return mProName;
    }

    public void setProName(String proName) {
        mProName = proName;
    }

    public int getProSort() {
        return mProSort;
    }

    public void setProSort(int proSort) {
        mProSort = proSort;
    }

    public String getProRemark() {
        return mProRemark;
    }

    public void setProRemark(String proRemark) {
        mProRemark = proRemark;
    }

    @Override
    public String toString() {
        return "ProvinceEntity{" +
                "mProName='" + mProName + '\'' +
                ", mProSort=" + mProSort +
                ", mProRemark='" + mProRemark + '\'' +
                '}';
    }
}
