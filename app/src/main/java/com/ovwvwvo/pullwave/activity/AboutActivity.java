package com.ovwvwvo.pullwave.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.jaeger.library.StatusBarUtil;
import com.ovwvwvo.pullwave.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import us.feras.mdv.MarkdownView;

/**
 * Copyright ©2017 by rawer
 */

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.markdownView)
    MarkdownView markdownView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        markdownView.loadMarkdownFile("file:///android_asset/about.md");
    }
}
