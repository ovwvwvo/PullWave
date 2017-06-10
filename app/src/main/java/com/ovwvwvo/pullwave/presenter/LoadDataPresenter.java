package com.ovwvwvo.pullwave.presenter;

import android.util.Log;

import com.ovwvwvo.jkit.rx.EmptyObserver;
import com.ovwvwvo.jkit.utils.StringUtil;
import com.ovwvwvo.pullwave.logic.LoadDataLogic;
import com.ovwvwvo.pullwave.view.LoadDataView;

import rx.android.schedulers.AndroidSchedulers;


/**
 * Copyright ©2017 by rawer
 */

public class LoadDataPresenter extends BasePresenter {

    private LoadDataLogic logic;
    private LoadDataView view;

    public LoadDataPresenter(LoadDataView view) {
        logic = new LoadDataLogic();
        this.view = view;
    }

    public void loadData(String query) {
        if (!StringUtil.isBlank(query))
            logic.loadData(query)
                .doOnError(t -> Log.i(getClass().getName(), t.getMessage()))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(r -> view.onLoadSuccess(r))
                .subscribe(new EmptyObserver<>());
    }

}
