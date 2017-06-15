package com.ovwvwvo.pullwave.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ovwvwvo.jkit.utils.AppUtil;
import com.ovwvwvo.jkit.weight.ToastMaster;
import com.ovwvwvo.pullwave.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright ©2017 by rawer
 */

public class SettingActivity extends AppCompatActivity {

    @BindView(R.id.github)
    TextView github;
    @BindView(R.id.version)
    TextView version;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);
        github.setOnCreateContextMenuListener(this);
        version.setText(AppUtil.getVersionName(this));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_github, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_gotoGithub) {
            gotoGithub();
        } else if (item.getItemId() == R.id.action_copy)
            copy(getString(R.string.github_url));
        return super.onContextItemSelected(item);
    }

    @OnClick(R.id.github)
    void github() {
        github.showContextMenu();
    }

    @OnClick(R.id.about)
    void about() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    private void gotoGithub() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(getString(R.string.github_url)));
        startActivity(intent);
    }

    private void copy(String content) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("PullWave", content);
        clipboard.setPrimaryClip(clip);
        ToastMaster.showToastMsg(R.string.copy_tip);
    }
}
