package com.ovwvwvo.pullwave.repo;

import com.ovwvwvo.pullwave.model.DataResponse;

import java.util.Map;

import rx.Observable;

/**
 * Copyright ©2017 by rawer
 */

public interface LoadRepo {

    Observable<DataResponse> fetchData(String name, Map<String, String> param, String data);

}
