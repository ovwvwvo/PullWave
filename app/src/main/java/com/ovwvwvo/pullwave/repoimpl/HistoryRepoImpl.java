package com.ovwvwvo.pullwave.repoimpl;

import com.ovwvwvo.pullwave.model.db.History;
import com.ovwvwvo.pullwave.repo.HistoryRepo;

import java.util.ListIterator;

import io.realm.Realm;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Copyright ©2017 by Teambition
 */

public class HistoryRepoImpl implements HistoryRepo {
    private Realm realm;

    public HistoryRepoImpl() {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public Observable<ListIterator<History>> findHistory() {
        return realm.asObservable().map(
            realm1 -> realm1.where(History.class).findAll().listIterator())
            .subscribeOn(Schedulers.io());
    }
}
