package com.ovwvwvo.pullwave.client;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Retrofit;

/**
 * Copyright ©2017 by rawer
 */

abstract class ApiBuilderAbs<T> {

    abstract Retrofit buildRetrofit();

    synchronized T buildApiClient() {
        Retrofit mRetrofit = buildRetrofit();
        Type t = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) t).getActualTypeArguments();
        Class<T> mTClass = (Class<T>) params[0];
        return mRetrofit.create(mTClass);
    }
}
