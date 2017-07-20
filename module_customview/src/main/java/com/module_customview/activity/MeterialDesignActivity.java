package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.module_customview.R;
import com.module_customview.adapter.ListViewAdapter;
import com.module_customview.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/19.
 * 学习meterialdesign
 */
@RouterMap({"activity://meterialdesign"})
public class MeterialDesignActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meterialdesign);

        ListView listView = (ListView) findViewById(R.id.lv_meterial);

        listView.setAdapter(new ListViewAdapter(this));
    }
}
