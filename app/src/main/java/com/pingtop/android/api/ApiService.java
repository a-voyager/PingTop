package com.pingtop.android.api;

import com.pingtop.android.entities.response.RegisterResponse;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wuhaojie on 2016/7/21 21:26.
 */
public interface ApiService {

    @POST("/UserHandle/SingUp")
    Observable<RegisterResponse> registe(@Query("username") String name, @Query("password") String pwd);
}
