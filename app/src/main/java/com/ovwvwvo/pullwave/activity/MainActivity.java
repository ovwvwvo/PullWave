package com.ovwvwvo.pullwave.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import com.jaeger.library.StatusBarUtil;
import com.ovwvwvo.common.activity.BaseActivity;
import com.ovwvwvo.common.widget.EditText.ClearableEditText;
import com.ovwvwvo.jkit.utils.KeyBoardUtils;
import com.ovwvwvo.jkit.weight.ToastMaster;
import com.ovwvwvo.pullwave.R;
import com.ovwvwvo.pullwave.adapter.HomeAdapter;
import com.ovwvwvo.pullwave.model.db.History;
import com.ovwvwvo.pullwave.presenter.HomePresenter;
import com.ovwvwvo.pullwave.view.MainView;

import java.util.ListIterator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright ©2017 by rawer
 */
public class MainActivity extends BaseActivity implements MainView, HomeAdapter.OnClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.search_input)
    ClearableEditText searchInput;

    private HomePresenter presenter;
    private HomeAdapter adapter;

    private String word;

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
        recyclerView.setOnCreateContextMenuListener(this);
        searchInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                handleIntent(v.getText().toString().trim());
                return true;
            }
            return false;
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_history, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_delete)
            presenter.deleteHistory(word);
        return super.onContextItemSelected(item);
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
            startActivity(new Intent(this, SettingActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String msg) {
        ToastMaster.showToastMsg(msg);
    }

    @Override
    public void onLoadHistorySuccess(ListIterator<History> historys) {
        if (historys.hasNext()) {
            adapter.clear();
            adapter.setModels(historys);
        }
    }

    @Override
    public void onItemClick(String word) {
        searchInput.setText(word);
        searchInput.setSelection(word.length());
        handleIntent(word);
    }

    @Override
    public void onItemLongClick(String word) {
        this.word = word;
        KeyBoardUtils.closeKeybord(this, searchInput);
        recyclerView.showContextMenu();
    }

    private void handleIntent(String word) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.WORD, word);
        startActivity(intent);
    }

}
