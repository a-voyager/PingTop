package com.pingtop.android.api;

import com.pingtop.android.entities.response.GudienceResponse;
import com.pingtop.android.entities.response.RegisterResponse;

import java.util.List;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by wuhaojie on 2016/7/21 21:26.
 */
public interface ApiService {

    @POST("/UserHandle/SingUp")
    Observable<RegisterResponse> register(@Query("username") String name, @Query("password") String pwd);

    @POST("/view/GetGudienceList")
    Observable<List<GudienceResponse>> getHandPicks(@Query("tokenStr") String token, @Query("aTimeStamp") long startTime, @Query("bTimeStamp") long endTime);

}
