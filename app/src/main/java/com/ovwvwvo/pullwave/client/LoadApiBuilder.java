package com.ovwvwvo.pullwave.client;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright ©2017 by rawer
 */

public class LoadApiBuilder<T> {

    private static final String BASE_URL = "http://www.pullwave.com";

    private Retrofit buildRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient());
        return builder.build();
    }

    synchronized T buildApiClient() {
        Retrofit mRetrofit = buildRetrofit();
        Type sType = getClass().getGenericSuperclass();
        Type[] generics = ((ParameterizedType) sType).getActualTypeArguments();
        Class<T> mTClass = (Class<T>) (generics[0]);
        return mRetrofit.create(mTClass);
    }
}
