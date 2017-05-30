package com.ovwvwvo.pullwave.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ovwvwvo.pullwave.R;
import com.ovwvwvo.pullwave.adapter.HomeAdapter;
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
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private LoadDataPresenter presenter;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        presenter = new LoadDataPresenter(this);
    }

    private void initView() {
        setSupportActionBar(toolbar);
        fab.setOnClickListener(view -> {
        });

        adapter = new HomeAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
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
    }
}
