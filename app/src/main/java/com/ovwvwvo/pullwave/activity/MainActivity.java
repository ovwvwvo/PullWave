package com.ovwvwvo.pullwave.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.ovwvwvo.jkit.log.LogUtil;
import com.ovwvwvo.pullwave.R;
import com.ovwvwvo.pullwave.adapter.HomeAdapter;
import com.ovwvwvo.pullwave.model.DataResponse;
import com.ovwvwvo.pullwave.model.db.History;
import com.ovwvwvo.pullwave.presenter.HomePresenter;
import com.ovwvwvo.pullwave.view.LoadDataView;

import java.util.ListIterator;

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

    private HomePresenter presenter;
    private HomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        presenter = new HomePresenter(this);
        presenter.findHistory();
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
    public void showProgress() {

    }

    @Override
    public void hideProgerss() {

    }

    @Override
    public void onLoadHistorySuccess(ListIterator<History> historys) {
        while (historys.hasNext()) {
            LogUtil.d("MainActivity", historys.next().getId());
        }
    }

    @Override
    public void onLoadSuccess(DataResponse response) {
    }
}
