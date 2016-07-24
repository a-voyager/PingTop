package com.pingtop.android.presenter.impl;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.pingtop.android.adapter.list.CityListAdapter;
import com.pingtop.android.base.IView;
import com.pingtop.android.entities.database.CityEntity;
import com.pingtop.android.entities.database.ProvinceEntity;
import com.pingtop.android.injector.scrope.ContextLifeCycle;
import com.pingtop.android.interfaces.ICityChoiceView;
import com.pingtop.android.manager.DataManager;
import com.pingtop.android.presenter.IPresenter;
import com.pingtop.android.utils.DataDaoUtils;

import org.greenrobot.eventbus.EventBus;

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
    private List<CityEntity> mCityInfo;
    private CityListAdapter mCityListAdapter;
    private STATE mCurrState;
    private SQLiteDatabase mCityDataBase;

    public void onBackPressed() {
        if (mCurrState == STATE.PROVINCE)
            ((Activity) mContext).finish();
        else
            queryProvinces();
    }

    private enum STATE {
        PROVINCE,
        CITY
    }

    @Inject
    public CityChoicePresenter(@ContextLifeCycle("Activity") Context context) {
        mContext = context;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (mCityDataBase == null)
            mCityDataBase = DataManager.getDataBaseProvider(mContext).getCityDataBase();
        mCityListAdapter = new CityListAdapter(mContext, mDatas);
        mCityChoiceView.setAdapter(mCityListAdapter);
        mCityListAdapter.setOnClickItemListener((v, p) -> {
            if (mCurrState == STATE.PROVINCE) {
                int proSort = mProvinceInfo.get(p).getProSort();
                Log.d(getClass().getSimpleName(), "position = " + p + "; proSort = " + proSort);
                queryCity(proSort);
            } else {
                EventBus.getDefault().postSticky(mCityInfo.get(p).getCityName());
                ((Activity) mContext).finish();
            }
        });

        queryProvinces();
    }

    private void queryProvinces() {
        mDatas.clear();
        mCityChoiceView.showProgressBar();
        mCityChoiceView.setToolBarTitle("选择省份");
        mCityListAdapter.notifyDataSetChanged();

        Observable
                .defer(new Func0<Observable<ProvinceEntity>>() {
                    @Override
                    public Observable<ProvinceEntity> call() {
                        if (mProvinceInfo == null || mProvinceInfo.isEmpty()) {
                            mProvinceInfo = DataDaoUtils.getProvinceInfo(mCityDataBase);
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
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {
                        mCityListAdapter.notifyDataSetChanged();
                        mCurrState = STATE.PROVINCE;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<String> strings) {
                        mDatas.addAll(strings);
//                        mCityChoiceView.refreshAdapter();
                    }
                });

    }


//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .unsubscribeOn(AndroidSchedulers.mainThread())


    public void queryCity(final int id) {
        mDatas.clear();
        mCityChoiceView.setToolBarTitle("选择城市");
        mCityChoiceView.showProgressBar();
//        mCityChoiceView.refreshAdapter();
        mCityListAdapter.notifyDataSetChanged();
        Observable
                .defer(new Func0<Observable<CityEntity>>() {
                    @Override
                    public Observable<CityEntity> call() {
                        // whether if it is empty
                        mCityInfo = DataDaoUtils.getCityInfo(mCityDataBase, id);
                        return Observable.from(mCityInfo);
                    }
                })
                .map(new Func1<CityEntity, String>() {
                    @Override
                    public String call(CityEntity cityEntity) {
                        return cityEntity.getCityName();
                    }
                })
                .toList()
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        mCityChoiceView.hideProgressBar();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<String>>() {
                    @Override
                    public void onCompleted() {
                        mCurrState = STATE.CITY;
                        mCityListAdapter.notifyDataSetChanged();
                        mCityChoiceView.scroll2Position(0);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<String> strings) {
                        mDatas.addAll(strings);
//                        mCityChoiceView.refreshAdapter();
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
