package com.ovwvwvo.pullwave.client;

import com.ovwvwvo.pullwave.model.DataResponse;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Copyright ©2017 by rawer
 */

public interface ApiStore {

    @GET("get.php?json=1")
    Observable<DataResponse> getData(@Query("auth_usr") String name, @QueryMap Map<String, String> param, @Query("end_date") String date);
}
