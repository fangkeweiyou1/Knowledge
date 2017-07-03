package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;
import com.module_customview.dialog.ExampleDialog;

/**
 * Created by zhangyuncai on 2017/6/26.
 * 讲解dialog的一些基本配置
 */

public class DialogBasicActvitity extends BaseActivity {

    private Button bt_showdialog;
    private ExampleDialog mExampleDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogbasic);

        bt_showdialog = (Button) findViewById(R.id.bt_showdialog);
        bt_showdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        if (mExampleDialog == null)
            mExampleDialog = new ExampleDialog(this);
        mExampleDialog.show();
    }
}
