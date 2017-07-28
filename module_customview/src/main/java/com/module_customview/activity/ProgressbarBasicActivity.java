package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/26.
 * 讲解progressbar的一些基本配置
 * 学习Progressbar
 */
@RouterMap({"activity://progressbarbasic"})
public class ProgressbarBasicActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbarbasic);

    }

}
