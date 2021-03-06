package com.ovwvwvo.pullwave.view;

import com.ovwvwvo.pullwave.model.DataResponse;

/**
 * Copyright ©2017 by rawer
 */

public interface DetailView {

    void showProgress();

    void hideProgress();

    void onLoadSuccess(DataResponse response);

    void onDestroyView();
}
