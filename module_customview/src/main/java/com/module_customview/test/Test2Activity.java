package com.module_customview.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/3.
 */
@RouterMap({"activity://test2"})
public class Test2Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
    }
}
