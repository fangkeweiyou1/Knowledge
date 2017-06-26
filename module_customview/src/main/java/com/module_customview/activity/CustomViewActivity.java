package com.module_customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.module_customview.R;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class CustomViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);

        startActivity(new Intent(this,TextBasicActivity.class));
    }
}
