package com.ovwvwvo.pullwave.presenter;

import android.util.Log;

import com.ovwvwvo.jkit.rx.EmptyObserver;
import com.ovwvwvo.pullwave.logic.HistoryLogic;
import com.ovwvwvo.pullwave.logic.LoadDataLogic;
import com.ovwvwvo.pullwave.view.LoadDataView;

import rx.android.schedulers.AndroidSchedulers;


/**
 * Copyright ©2017 by rawer
 */

public class HomePresenter extends BasePresenter {

    private LoadDataLogic loadDataLogic;
    private HistoryLogic historyLogic;
    private LoadDataView view;

    public HomePresenter(LoadDataView view) {
        loadDataLogic = new LoadDataLogic();
        historyLogic = new HistoryLogic();
        this.view = view;
    }

    public void findHistory() {
        historyLogic.loadHistory()
            .doOnSubscribe(view::showProgress)
            .doOnError(t -> Log.i(getClass().getName(), t.getMessage()))
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext(view::onLoadHistorySuccess)
            .doOnTerminate(view::hideProgerss)
            .subscribe(new EmptyObserver<>());
    }


    public void loadData(String query) {
        loadDataLogic.loadData(query)
            .doOnError(t -> Log.i(getClass().getName(), t.getMessage()))
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext(r -> view.onLoadSuccess(r))
            .subscribe(new EmptyObserver<>());
    }

}
