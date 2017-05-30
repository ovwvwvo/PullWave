package com.ovwvwvo.pullwave.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.ovwvwvo.pullwave.R;
import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.presenter.LoadDataPresenter;
import com.ovwvwvo.pullwave.view.LoadDataView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright ©2017 by rawer
 */
public class MainActivity extends AppCompatActivity implements LoadDataView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv)
    TextView textView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private LoadDataPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(view -> presenter.loadData("王者荣耀"));
        presenter = new LoadDataPresenter(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLoadSuccess(DataResponse response) {
        textView.setText(response.getModels().get(0).getV());
    }
}
