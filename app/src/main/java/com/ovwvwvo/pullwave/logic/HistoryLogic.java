package com.ovwvwvo.pullwave.logic;

import com.ovwvwvo.pullwave.model.db.History;
import com.ovwvwvo.pullwave.repo.HistoryRepo;
import com.ovwvwvo.pullwave.repoimpl.HistoryRepoImpl;

import java.util.ListIterator;

import rx.Observable;

/**
 * Copyright ©2017 by rawer
 */

public class HistoryLogic {
    private HistoryRepo historyRepo;

    public HistoryLogic() {
        historyRepo = new HistoryRepoImpl();
    }

    public Observable<ListIterator<History>> loadHistory() {
        return historyRepo.findHistory();
    }

    public void insertModel(String word) {
        historyRepo.insertModel(new History(word, System.currentTimeMillis()));
    }

    public void deleteModel(String word) {
        historyRepo.deleteModle(word);
    }
}
