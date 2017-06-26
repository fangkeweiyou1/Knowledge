package com.module_utils.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.module_utils.R;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class UtilsHomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils);


        if (true) {
            startActivity(new Intent(this, ComparatorActivity.class));
        }
    }
}
