package com.ovwvwvo.pullwave.presenter;

import android.util.Log;

import com.ovwvwvo.pullwave.logic.LoadDataLogic;

import rx.android.schedulers.AndroidSchedulers;


/**
 * Copyright ©2017 by rawer
 */

public class LoadDataPresenter extends BasePresenter {

    private LoadDataLogic logic;

    public LoadDataPresenter() {
        logic = new LoadDataLogic();
    }

    public void loadData(String query) {
        logic.loadData(query)
            .doOnError(t -> Log.i(getClass().getName(), t.getMessage()))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new EmptyObserver<>());
    }

}
