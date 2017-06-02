package com.ovwvwvo.pullwave.logic;

import com.ovwvwvo.pullwave.model.db.History;
import com.ovwvwvo.pullwave.repo.HistoryRepo;
import com.ovwvwvo.pullwave.repoimpl.HistoryRepoImpl;

import java.util.ListIterator;

import rx.Observable;

/**
 * Copyright ©2017 by Teambition
 */

public class HistoryLogic {
    private HistoryRepo historyRepo;

    public HistoryLogic() {
        historyRepo = new HistoryRepoImpl();
    }

    public Observable<ListIterator<History>> loadHistory() {
        return historyRepo.findHistory();
    }
}
