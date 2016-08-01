package com.pingtop.android.manager;

import com.pingtop.android.api.ApiService;
import com.pingtop.android.entities.response.GudienceResponse;
import com.pingtop.android.entities.response.RegisterResponse;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wuhaojie on 2016/7/21 21:18.
 */
public class HttpHelper {


    public static final String BASE_URL = "http://115.28.0.251:8088";
    private final ApiService mApiService;

    public HttpHelper() {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL);
        Retrofit retrofit = builder.addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mApiService = retrofit.create(ApiService.class);
    }

    public void register(String name, String pwd, Subscriber<RegisterResponse> subscriber) {
        mApiService.register(name, pwd)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }


    public void getHandPicks(String token, long startTime, long endTime, Subscriber<List<GudienceResponse>> subscriber) {
        mApiService.getHandPicks(token, startTime, endTime)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

}
