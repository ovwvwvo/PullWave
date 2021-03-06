package com.ovwvwvo.pullwave.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
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
    BarChart chart;

    public static final String WORD = "word";

    private String word;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        chart.setVisibility(View.GONE);

        word = getIntent().getStringExtra(WORD);
        DetailPresenter presenter = new DetailPresenter(this);
        presenter.loadData(word);
    }

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
        }
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    @Override
    public void onLoadSuccess(DataResponse response) {
        chart.setVisibility(View.VISIBLE);
        List<BarEntry> entries = new ArrayList<>();
        BarEntry entry;
        for (int i = 0; i < response.getModels().size(); i++) {
            entry = new BarEntry(i, response.getModels().get(i).getV());
            entries.add(entry);
        }
        BarDataSet set = new BarDataSet(entries, getString(R.string.exponent, word));
        set.setColor(ContextCompat.getColor(this, R.color.colorPrimary));
        BarData barData = new BarData(set);
        chart.setData(barData);

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(15, true);
        xAxis.setLabelRotationAngle(60);
        xAxis.setValueFormatter((value, axis) -> response.getModels().get((int) value).getDate().substring(5));

        Description description = new Description();
        description.setEnabled(false);
        chart.setDescription(description);

        chart.invalidate();
    }

    @Override
    public void onDestroyView() {
        finish();
    }
}
