package com.module_customview.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;
import com.module_customview.dialog.ExampleDialog;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/26.
 * 讲解dialog的一些基本配置
 */
@RouterMap({"activity://dialogbasic"})
public class DialogBasicActvitity extends BaseActivity {

    private Button bt_showdialog;
    private Button bt_showdialog2;
    private ExampleDialog mExampleDialog;
    private AlertDialog backDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogbasic);

        bt_showdialog = (Button) findViewById(R.id.bt_showdialog);
        bt_showdialog2 = (Button) findViewById(R.id.bt_showdialog2);


        bt_showdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        bt_showdialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quitEditDialog();
            }
        });
    }

    private void showDialog() {
        if (mExampleDialog == null)
            mExampleDialog = new ExampleDialog(this);
        mExampleDialog.show();
    }

    private void quitEditDialog() {
        if (backDialog == null) {
            backDialog = new AlertDialog.Builder(this)
                    .setMessage("退出此次编辑？")
                    .setPositiveButton("退出", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .create();
        }
        backDialog.show();
    }
}
