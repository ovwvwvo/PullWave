package com.ovwvwvo.pullwave.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.ovwvwvo.pullwave.R;
import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.presenter.DetailPresenter;
import com.ovwvwvo.pullwave.view.DetailView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright ©2017 by rawer
 */

public class DetailActivity extends AppCompatActivity implements DetailView {

    @BindView(R.id.combinedChart)
    CombinedChart chart;

    public static final String WORD = "word";

    private String word;
    private DetailPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        word = getIntent().getStringExtra(WORD);
        presenter = new DetailPresenter(this);
        presenter.loadData(word);
    }

    @Override
    public void onLoadSuccess(DataResponse response) {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < response.getModels().size(); i++) {
            entries.add(new Entry(i, response.getModels().get(i).getV()));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColor(Color.RED);
        dataSet.setValueTextColor(Color.BLUE);
        LineData lineData = new LineData(dataSet);
        CombinedData c = new CombinedData();
        c.setData(lineData);
        chart.setData(c);
        chart.invalidate();
    }
}
