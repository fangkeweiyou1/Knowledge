package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.module_customview.R;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

@RouterMap({"activity://math"})
public class MathActivity extends AppCompatActivity {
    String mathDesc="";
    private TextView tv_math_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        tv_math_content = (TextView) findViewById(R.id.tv_math_content);

        tv_math_content.setText(mathDesc);

        mathDesc="\n1)Math.toRadians(30):要先把角度转化为对应的弧度,Math.sin(Math.toRadians(30))=0.5 如同数学中 sin30=0.5";
        tv_math_content.append(mathDesc);

        mathDesc="\n2)double sin = Math.sin(2*Math.PI/360*30);//sin30度=0.5";
        tv_math_content.append(mathDesc);


    }


}
/*
Math.toRadians(30):要先把角度转化为对应的弧度
  Math.sin(Math.toRadians(30))=0.5 如同数学中 sin30=0.5

 */