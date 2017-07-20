package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/26.
 * 讲解DrawerLayout和ActionBar的基本知识
 * 学习DrawerLayout
 */
@RouterMap({"activity://drawerlayout"})
public class DrawerLayoutActivity extends BaseActivity {
    private ActionBar mActionBar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);

        initActionBar();

        initView();
    }

    private void initActionBar() {
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("DrawerLayout示范");
        mActionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mToggle.syncState();

        mDrawerLayout.addDrawerListener(mToggle);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                mToggle.onOptionsItemSelected(item);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
