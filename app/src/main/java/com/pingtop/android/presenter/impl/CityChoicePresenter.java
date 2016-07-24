package com.pingtop.android.presenter.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.pingtop.android.adapter.list.CityListAdapter;
import com.pingtop.android.base.IView;
import com.pingtop.android.entities.database.ProvinceEntity;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.ICityChoiceView;
import com.pingtop.android.manager.DataManager;
import com.pingtop.android.presenter.IPresenter;
import com.pingtop.android.utils.DataDaoUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by wuhaojie on 2016/7/24 12:37.
 */
public class CityChoicePresenter implements IPresenter {
    private Context mContext;
    private ICityChoiceView mCityChoiceView;
    private List<ProvinceEntity> mProvinceInfo;
    private List<String> mDatas = new ArrayList<>();

    @Inject
    public CityChoicePresenter(@ContextLifeCycle("Activity") Context context) {
        mContext = context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        CityListAdapter cityListAdapter = new CityListAdapter(mContext, mDatas);
        mCityChoiceView.setAdapter(cityListAdapter);

        queryProvinces();
    }

    private void queryProvinces() {
        mCityChoiceView.showProgressBar();
        mCityChoiceView.setToolBarTitle("选择省份");

        Observable
                .defer(new Func0<Observable<ProvinceEntity>>() {
                    @Override
                    public Observable<ProvinceEntity> call() {
                        if (mProvinceInfo == null || mProvinceInfo.isEmpty()) {
                            SQLiteDatabase cityDataBase = DataManager.getDataBaseProvider(mContext).getCityDataBase();
                            mProvinceInfo = DataDaoUtils.getProvinceInfo(cityDataBase);
                        }
                        return Observable.from(mProvinceInfo);
                    }
                })
                .map(new Func1<ProvinceEntity, String>() {
                    @Override
                    public String call(ProvinceEntity provinceEntity) {
                        return provinceEntity.getProName();
                    }
                })
                .toList()
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        mCityChoiceView.hideProgressBar();
                    }
                })
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<String> strings) {
                        mDatas.addAll(strings);
                        mCityChoiceView.refreshAdapter();
                    }
                });

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void attachView(IView v) {
        mCityChoiceView = (ICityChoiceView) v;
    }
}
