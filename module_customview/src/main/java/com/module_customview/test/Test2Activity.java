package com.module_customview.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.commonlibs.utils.LogUtils;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/3.
 */
@RouterMap({"activity://test2"})
public class Test2Activity extends BaseActivity {
    public static final String TAG = "<<<>>>Test2Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        LogUtils.i(TAG, "onCreate");

    }

    public void skipTest1(View v) {
        EventBus.getDefault().post("你好");

        Intent intent = new Intent(this, Test1Activity.class);
//        if(AppDavikActivityMgr.getScreenManager().hasActivity(Test1Activity.class.getSimpleName()))
//            intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.i(TAG, "onNewIntent");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG, "onDestroy");
    }
}
