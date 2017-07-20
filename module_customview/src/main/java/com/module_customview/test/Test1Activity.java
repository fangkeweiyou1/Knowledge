package com.module_customview.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

        RelativeLayout rl_layout = (RelativeLayout) findViewById(R.id.rl_layout);
        TextView item_add_member_tab5 = (TextView) View.inflate(this, R.layout.item_add_member_tab5, null);
        item_add_member_tab5.setText("测试");
        item_add_member_tab5.setTag(10001);
        rl_layout.addView(item_add_member_tab5);

        TextView textView = (TextView) rl_layout.findViewWithTag(10001);
        if (textView != null) {
            textView.setText("测试e");
        }

        EventBus.getDefault().register(this);
//        LogUtils.i(TAG, "onCreate");
//
//        String str = "woaini\nniaiwo";
//        str = str.replace("\n", "");
//        System.out.println("<<<>>>==" + str);

        movetoback();

    }

    boolean flag = true;

    /**
     * 可将APP退至后台
     */
    public void movetoback() {
        Button bt_movetoback = (Button) findViewById(R.id.bt_movetoback);
        bt_movetoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(flag);
                flag = !flag;
            }
        });
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
