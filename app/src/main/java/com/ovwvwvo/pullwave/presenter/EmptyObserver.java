package com.ovwvwvo.pullwave.presenter;

import android.util.Log;

import rx.Observer;

public class EmptyObserver<T> implements Observer<T> {

    public static final String TAG = "PullWave";

    public EmptyObserver() {
    }

    public void onCompleted() {
    }

    public void onError(Throwable e) {
        Log.e(TAG, "onError", e);
    }

    public void onNext(T t) {
    }
}
