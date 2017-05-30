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

    @GET("get.php?json=1&auth_usr=free_vip")
    Observable<DataResponse> getData(@QueryMap Map<String, String> param, @Query("date_end") String dateEnd);
}
