package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.module_customview.R;

/**
 * Created by zhangyuncai on 2017/6/26.
 * 讲解textview的一些基本配置
 */

public class TextBasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textviewbasic);

        TextView tv_content = (TextView) findViewById(R.id.tv_content);
    }


    /**
     * android:textStyle="bold"
     粗体
     android:lineSpacingMultiplier=“1.4” 行与行之间的间距
     TextView控件有一个属性是ellipsize，指的是当文字内容长度超过TextView大小时显示问题，一般情况下我们都是用省略号表示，常用的情况有以下四种：
     1，Android:ellipsize = "end"　　  省略号在结尾

     3，android:ellipsize = "start" 　　省略号在开头

     3，android:ellipsize = "middle"     省略号在中间

     4，android:ellipsize = "marquee”  跑马灯



     android:lineSpacingExtra="12dp"表示行间距
     */

}
