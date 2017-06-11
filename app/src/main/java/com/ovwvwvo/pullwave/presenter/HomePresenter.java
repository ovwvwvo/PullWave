package com.ovwvwvo.pullwave.presenter;

import android.util.Log;

import com.ovwvwvo.jkit.rx.EmptyObserver;
import com.ovwvwvo.jkit.utils.StringUtil;
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
            .doOnError(t -> view.showToast(t.getMessage()))
            .doOnNext(view::onLoadHistorySuccess)
            .subscribe(new EmptyObserver<>());
    }

    public void loadData(String query) {
        if (!StringUtil.isBlank(query))
            loadDataLogic.loadData(query)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(t -> Log.i(getClass().getName(), t.getMessage()))
                .doOnNext(r -> {
                    historyLogic.insertModel(query);
                    view.onLoadSuccess(r);
                })
                .subscribe(new EmptyObserver<>());
    }

    public void deleteHistory(String word) {
        if (!StringUtil.isBlank(word))
            historyLogic.deleteModel(word);
    }

}
