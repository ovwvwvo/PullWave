package com.ovwvwvo.pullwave.repo;

import com.ovwvwvo.pullwave.model.db.History;

import java.util.ListIterator;

import rx.Observable;

/**
 * Copyright ©2017 by rawer
 */

public interface HistoryRepo {

    Observable<ListIterator<History>> findHistory();

    void insertModel(History history);

    void deleteModle(String word);
}
