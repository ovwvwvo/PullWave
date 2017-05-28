package com.ovwvwvo.pullwave.utils;

import android.content.Context;

/**
 * Copyright ©2017 by rawer
 */

public class AppWrapper {

    private static AppWrapper mInstance = new AppWrapper();

    private Context mAppContext = null;

    private AppWrapper() {
    }

    public static AppWrapper getInstance() {
        return mInstance;
    }

    public Context getAppContext() {
        if (this.mAppContext == null) {
            throw new IllegalStateException("application context has not been injected");
        } else {
            return this.mAppContext;
        }
    }

    public void setAppContext(Context context) {
        this.mAppContext = context;
    }
}