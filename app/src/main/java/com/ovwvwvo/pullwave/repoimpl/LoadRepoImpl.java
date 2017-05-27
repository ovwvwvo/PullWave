package com.ovwvwvo.pullwave.repoimpl;

import com.ovwvwvo.pullwave.client.ApiFactory;
import com.ovwvwvo.pullwave.client.LoadDataApi;
import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.repo.LoadRepo;

import java.util.Map;

import rx.Observable;
import rx.schedulers.Schedulers;


/**
 * Copyright ©2017 by rawer
 */

public class LoadRepoImpl implements LoadRepo {

    private LoadDataApi loadDataApi;

    public LoadRepoImpl() {
        loadDataApi = ApiFactory.getDefault().buildLoadDataApi();
    }

    @Override
    public Observable<DataResponse> fetchData(String name, Map<String, String> param, String data) {
        return loadDataApi.getData(name, param, data)
            .subscribeOn(Schedulers.io());
    }
}
