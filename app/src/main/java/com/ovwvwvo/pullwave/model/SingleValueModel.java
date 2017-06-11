package com.ovwvwvo.pullwave.model;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright ©2017 by rawer
 */

public class SingleValueModel {

    @SerializedName("date")
    String date;
    @SerializedName("v")
    long v;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getV() {
        return v;
    }

    public void setV(long v) {
        this.v = v;
    }
}
