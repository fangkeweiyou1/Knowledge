package com.module_specialview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by zhangyuncai on 2017/6/28.
 */

public class SpecialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialview);

    }

    public void marquee(View v) {
        startActivity(new Intent(this, MarqueeActivity.class));
    }
}
