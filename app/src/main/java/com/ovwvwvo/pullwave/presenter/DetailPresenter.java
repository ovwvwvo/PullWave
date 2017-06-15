package com.ovwvwvo.pullwave.presenter;

import android.util.Log;

import com.ovwvwvo.jkit.rx.EmptyObserver;
import com.ovwvwvo.jkit.utils.StringUtil;
import com.ovwvwvo.jkit.weight.ToastMaster;
import com.ovwvwvo.pullwave.logic.DetailLogic;
import com.ovwvwvo.pullwave.logic.HistoryLogic;
import com.ovwvwvo.pullwave.view.DetailView;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Copyright ©2017 by rawer
 */

public class DetailPresenter extends BasePresenter {

    private DetailLogic detailLogic;
    private HistoryLogic historyLogic;
    private DetailView view;

    public DetailPresenter(DetailView view) {
        this.view = view;
        detailLogic = new DetailLogic();
        historyLogic = new HistoryLogic();
    }

    public void loadData(String query) {
        if (!StringUtil.isBlank(query))
            detailLogic.loadData(query)
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(() -> view.showProgress())
                .doOnError(t -> {
                    Log.i(getClass().getName(), t.getMessage());
                    ToastMaster.showErrorMsg("msg", t);
                    view.onDestroyView();
                })
                .doOnNext(r -> {
                    historyLogic.insertModel(query);
                    view.onLoadSuccess(r);
                })
                .doOnTerminate(() -> view.hideProgress())
                .subscribe(new EmptyObserver<>());
    }
}
