package com.ovwvwvo.pullwave.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.ovwvwvo.jkit.log.LogUtil;
import com.jaeger.library.StatusBarUtil;
import com.ovwvwvo.common.widget.EditText.ClearableEditText;
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
public class MainActivity extends AppCompatActivity implements LoadDataView, HomeAdapter.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.search_input)
    ClearableEditText searchInput;

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
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary));
        setSupportActionBar(toolbar);

        adapter = new HomeAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        searchInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                presenter.loadData(v.getText().toString().trim());
                return true;
            }
            return false;
        });
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

    @Override
    public void onItemClick(String word) {
        searchInput.setText(word);
        presenter.loadData(word);
    }
}
