package com.module_customview.customview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;

import com.commonlibs.utils.DisPlayUtils;
import com.commonlibs.utils.LogUtils;
import com.module_customview.R;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/29.
 * 学习自定义view的使用
 */
@RouterMap({"activity://learnview"})
public class LearnViewActivity extends AppCompatActivity {
    private static final String TAG = "LearnViewActivity";

    private Button bt_test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learnview);

        bt_test = (Button) findViewById(R.id.bt_learnview_test);

        bt_test.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                bt_test.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                LogUtils.i(TAG, "width=" + DisPlayUtils.px2dip(bt_test.getWidth()));
                LogUtils.i(TAG, "height=" + DisPlayUtils.px2dip(bt_test.getHeight()));
            }
        });

        bt_test.setOnTouchListener(new MyTouchListener());
    }

    class MyTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    float rawX = event.getRawX();
                    float rawY = event.getRawY();

                    break;
            }
            return false;
        }
    }
}
