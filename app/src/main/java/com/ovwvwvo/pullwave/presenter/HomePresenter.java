package com.ovwvwvo.pullwave.presenter;

import com.ovwvwvo.jkit.rx.EmptyObserver;
import com.ovwvwvo.jkit.utils.StringUtil;
import com.ovwvwvo.pullwave.logic.HistoryLogic;
import com.ovwvwvo.pullwave.view.MainView;


/**
 * Copyright ©2017 by rawer
 */

public class HomePresenter extends BasePresenter {

    private HistoryLogic historyLogic;
    private MainView view;

    public HomePresenter(MainView view) {
        historyLogic = new HistoryLogic();
        this.view = view;
    }

    public void findHistory() {
        historyLogic.loadHistory()
            .doOnError(t -> view.showToast(t.getMessage()))
            .doOnNext(view::onLoadHistorySuccess)
            .subscribe(new EmptyObserver<>());
    }

    public void deleteHistory(String word) {
        if (!StringUtil.isBlank(word))
            historyLogic.deleteModel(word);
    }

}
