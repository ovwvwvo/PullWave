package com.ovwvwvo.pullwave.view;

import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.model.db.History;

import java.util.ListIterator;

/**
 * Copyright ©2017 by rawer
 */

public interface LoadDataView {

    void showProgress();

    void hideProgerss();

    void onLoadHistorySuccess(ListIterator<History> historys);

    void onLoadSuccess(DataResponse response);

}
