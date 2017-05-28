package com.ovwvwvo.pullwave.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Copyright ©2017 by rawer
 */

public class DataResponse extends BaseResponse {

    @SerializedName("qushi")
    ArrayList<SingleValueModel> models;

    public ArrayList<SingleValueModel> getModels() {
        return models;
    }

    public void setModels(ArrayList<SingleValueModel> models) {
        this.models = models;
    }
}
