package com.ovwvwvo.pullwave.model.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Copyright ©2017 by rawer
 */

public class History extends RealmObject {

    @PrimaryKey
    private String name;
    private long time;

    public History() {
    }

    public History(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
