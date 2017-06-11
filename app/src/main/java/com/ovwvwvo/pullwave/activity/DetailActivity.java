package com.ovwvwvo.pullwave.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Copyright ©2017 by rawer
 */

public class DetailActivity extends AppCompatActivity {
    public static final String WORD = "word";

    private String word;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        word = getIntent().getStringExtra(WORD);
    }
}
