package com.ovwvwvo.pullwave.view;

import com.ovwvwvo.pullwave.model.db.History;

import java.util.ListIterator;

/**
 * Copyright ©2017 by rawer
 */

public interface MainView {

    void showToast(String msg);

    void onLoadHistorySuccess(ListIterator<History> historys);
}
