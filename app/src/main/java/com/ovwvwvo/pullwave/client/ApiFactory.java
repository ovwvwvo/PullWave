package com.ovwvwvo.pullwave.client;

/**
 * Copyright ©2017 by rawer
 */

public class ApiFactory {

    private static ApiFactory mDefault = new ApiFactory();

    private final LoadApiBuilder<LoadDataApi> mLoadApiBuilder = new LoadApiBuilder<>();

    public static ApiFactory getDefault() {
        return mDefault;
    }

    public LoadDataApi buildLoadDataApi() {
        return mLoadApiBuilder.buildApiClient();
    }

}
