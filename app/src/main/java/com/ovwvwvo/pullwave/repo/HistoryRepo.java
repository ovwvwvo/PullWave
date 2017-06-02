package com.ovwvwvo.pullwave.repo;

import com.ovwvwvo.pullwave.model.db.History;

import java.util.ListIterator;

import rx.Observable;

/**
 * Copyright ©2017 by Teambition
 */

public interface HistoryRepo {

    Observable<ListIterator<History>> findHistory();

}
