package com.module_customview.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.commonlibs.utils.LogUtils;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/3.
 */
@RouterMap({"activity://test1"})
public class Test1Activity extends BaseActivity {
    public static final String TAG = "<<<>>>Test1Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        EventBus.getDefault().register(this);
        LogUtils.i(TAG, "onCreate");

        String str = "woaini\nniaiwo";
        str = str.replace("\n", "");
        System.out.println("<<<>>>==" + str);

    }

    public void skipTest2(View v) {
//        .setFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        Intent intent = new Intent(this, Test2Activity.class);
//        if (AppDavikActivityMgr.getScreenManager().hasActivity(Test2Activity.class.getSimpleName()))
//        intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String str) {
        LogUtils.i(TAG, "str=" + str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        LogUtils.i(TAG, "onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.i(TAG, "onNewIntent");
    }

}
