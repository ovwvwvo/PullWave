package com.ovwvwvo.pullwave.client;

/**
 * Copyright ©2017 by rawer
 */

public class ApiFactory {

    private static ApiFactory mDefault = new ApiFactory();

    private final ApBuilder mApiBuilder = new ApBuilder();

    public static ApiFactory getDefault() {
        return mDefault;
    }

    public ApiStore buildLoadDataApi() {
        return mApiBuilder.buildApiClient();
    }

}
