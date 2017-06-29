package com.module_customview.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.module_customview.R;

/**
 * Created by zhangyuncai on 2017/6/25.
 * compile 'com.android.support:recyclerview-v7:24.2.0' 这个在布局文件可以预览
 * compile 'com.android.support:recyclerview-v7:25.0.0' 这个在布局文件不能预览
 */

public class RecyclerHomeActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String KEY_TITLENAME = "KEY_TITLENAME";


    private Button bt_udrl;//
    private Button bt_part;//

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerhome);

        initView();

        initData();

        initEvent();
    }

    private void initView() {

        bt_udrl = (Button) findViewById(R.id.bt_udrl);
        bt_part = (Button) findViewById(R.id.bt_part);

    }

    private void initData() {

    }

    private void initEvent() {
        bt_udrl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v instanceof Button) {
            Button button = (Button) v;


            if (v.getId() == R.id.bt_udrl) {
                Intent intent = new Intent(this, UDLRRecyclerActivity.class);
                intent.putExtra(KEY_TITLENAME, button.getText().toString());
                startActivity(intent);
            } else if (v.getId() == R.id.bt_part) {
                Intent intent = new Intent(this, PartRecyclerActivity.class);
                intent.putExtra(KEY_TITLENAME, button.getText().toString());
                startActivity(intent);
            }
        }
    }
}
