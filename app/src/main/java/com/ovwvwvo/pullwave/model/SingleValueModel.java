package com.ovwvwvo.pullwave.model;

import com.google.gson.annotations.SerializedName;

/**
 * Copyright ©2017 by rawer
 */

public class SingleValueModel {

    @SerializedName("date")
    String date;
    @SerializedName("v")
    String v;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}
