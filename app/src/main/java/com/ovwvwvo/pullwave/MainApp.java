package com.ovwvwvo.pullwave;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.instabug.library.Instabug;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.ovwvwvo.jkit.AppWrapper;
import com.ovwvwvo.jkit.log.LogUtil;

import io.fabric.sdk.android.Fabric;
import io.realm.Realm;

/**
 * Copyright ©2017 by rawer
 */

public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.setEnable(BuildConfig.DEBUG);

        AppWrapper app = AppWrapper.getInstance();
        app.setAppContext(this);

        initRealm();
        Fabric.with(this, new Crashlytics());

        initInstabug();
    }

    private void initInstabug() {
        new Instabug.Builder(this, "643780b955672e8b500bbc875179d4cc")
            .setInvocationEvent(InstabugInvocationEvent.SHAKE)
            .build();
    }

    private void initRealm() {
        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder().build();
//        Realm.deleteRealm(config);
//        Realm.setDefaultConfiguration(config);
    }
}