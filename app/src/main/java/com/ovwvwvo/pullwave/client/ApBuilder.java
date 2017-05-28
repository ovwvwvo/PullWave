package com.ovwvwvo.pullwave.client;

import com.ovwvwvo.pullwave.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright ©2017 by rawer
 */

public class ApBuilder extends ApBuilderAbs<ApiStore> {

    private static final String BASE_URL = "http://www.pullwave.com";

    @Override
    Retrofit buildRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(buildOkHttpClient());
        return builder.build();
    }

    private OkHttpClient buildOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        return builder.build();
    }
}
