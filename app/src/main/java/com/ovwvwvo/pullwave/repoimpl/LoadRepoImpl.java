package com.ovwvwvo.pullwave.repoimpl;

import com.ovwvwvo.pullwave.client.ApiFactory;
import com.ovwvwvo.pullwave.client.ApiStore;
import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.repo.LoadRepo;

import java.util.Map;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Copyright ©2017 by rawer
 */

public class LoadRepoImpl implements LoadRepo {

    private ApiStore apiStore;

    public LoadRepoImpl() {
        apiStore = ApiFactory.getDefault().buildLoadDataApi();
    }

    @Override
    public Observable<DataResponse> fetchData(Map<String, String> param, String dateEnd) {
        return apiStore.getData(param, dateEnd)
            .subscribeOn(Schedulers.io());
    }
}
