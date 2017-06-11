package com.ovwvwvo.pullwave.repoimpl;

import com.ovwvwvo.pullwave.model.db.History;
import com.ovwvwvo.pullwave.repo.HistoryRepo;

import java.util.ListIterator;

import io.realm.Realm;
import io.realm.Sort;
import rx.Observable;

/**
 * Copyright ©2017 by rawer
 */

public class HistoryRepoImpl implements HistoryRepo {
    private Realm realm;

    public HistoryRepoImpl() {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public Observable<ListIterator<History>> findHistory() {
        return realm.asObservable().map(
            realm1 -> realm1.where(History.class).findAll().sort("time", Sort.DESCENDING).listIterator());
    }

    @Override
    public void insertModel(History history) {
        realm.beginTransaction();
        realm.insertOrUpdate(history);
        realm.commitTransaction();
    }

    @Override
    public void deleteModle(String word) {
        realm.beginTransaction();
        realm.where(History.class).equalTo("name", word).findAll().deleteAllFromRealm();
        realm.commitTransaction();
    }
}
