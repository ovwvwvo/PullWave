package com.ovwvwvo.pullwave;

import android.app.Application;

import com.ovwvwvo.pullwave.utils.AppWrapper;

/**
 * Copyright ©2017 by rawer
 */

public class MainApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppWrapper app = AppWrapper.getInstance();
        app.setAppContext(this);
    }
}
