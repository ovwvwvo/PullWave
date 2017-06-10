package com.ovwvwvo.pullwave;

import android.app.Application;

import com.ovwvwvo.jkit.AppWrapper;
import com.ovwvwvo.jkit.log.LogUtil;

import io.realm.Realm;

/**
 * Copyright ©2017 by rawer
 */

public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppWrapper app = AppWrapper.getInstance();
        app.setAppContext(this);
        LogUtil.setEnable(BuildConfig.DEBUG);

        initRealm();
    }

    private void initRealm() {
        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder().build();
//        Realm.deleteRealm(config);
//        Realm.setDefaultConfiguration(config);
    }
}