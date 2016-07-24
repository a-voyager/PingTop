package com.pingtop.android.presenter.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

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
import rx.schedulers.Schedulers;

/**
 * Created by wuhaojie on 2016/7/24 12:37.
 */
public class CityChoicePresenter implements IPresenter {
    private Context mContext;
    private ICityChoiceView mCityChoiceView;

    @Inject
    public CityChoicePresenter(@ContextLifeCycle("Activity") Context context) {
        mContext = context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.e("test>>", "onCreate()");
        final CityListAdapter cityListAdapter = new CityListAdapter(mContext);
        mCityChoiceView.setAdapter(cityListAdapter);

        Observable.create(new Observable.OnSubscribe<ArrayList<String>>() {
            @Override
            public void call(Subscriber<? super ArrayList<String>> subscriber) {
                subscriber.onStart();
                ArrayList<String> list = queryProvinces();
                subscriber.onNext(list);
                subscriber.onCompleted();
            }
        }).observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArrayList<String>>() {

                    @Override
                    public void onStart() {
                        super.onStart();

                        mCityChoiceView.showProgressBar();
                    }

                    @Override
                    public void onCompleted() {
                        mCityChoiceView.hideProgressBar();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ArrayList<String> strings) {
                        cityListAdapter.setList(strings);
                        cityListAdapter.notifyDataSetChanged();
                    }
                });
    }

    @NonNull
    private ArrayList<String> queryProvinces() {
        SQLiteDatabase cityDataBase = DataManager.getDataBaseProvider(mContext).getCityDataBase();
        List<ProvinceEntity> provinceInfo = DataDaoUtils.getProvinceInfo(cityDataBase);
        ArrayList<String> list = new ArrayList<>();
        for (ProvinceEntity entity : provinceInfo) {
            list.add(entity.getProName());
        }
        return list;
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
