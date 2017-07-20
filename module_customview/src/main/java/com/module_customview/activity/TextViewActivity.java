package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/26.
 * 讲解textview的一些基本配置
 * 学习TextView
 */
@RouterMap({"activity://textview"})
public class TextViewActivity extends BaseActivity {

    private TextView tv_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textviewbasic);

        tv_content = (TextView) findViewById(R.id.tv_content);

        tv_content.isShown();//只有当view本身以及它的所有祖先们都是visible时，isShown（）才返回TRUE

        //TODO:TextView:includeFontPadding="false"，TextView默认上下是有一定的padding的，有时候我们可能不需要上下这部分留白，加上它即可。


//        TODO:android:animateLayoutChanges 这是一个非常酷炫的属性。在父布局加上 android:animateLayoutChanges="true"
// 后，如果触发了layout方法（比如它的子View设置为GONE），系统就会自动帮你加上布局改变时的动画特效！！

        tv_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_content.setVisibility(tv_content.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

//        TODO:android:clipToPadding 设置父view是否允许其子view在它的padding（这里指的是父View的padding）中绘制。是不是有点绕？
//        举个实际场景吧：假如有个ListView，我们想要在初始位置时，第一项Item离顶部有10dp的距离，就可以在ListView的布局中加入
//        android:clipToPadding="false" android:paddingTop="10dp"即可。是不是很方便呢？

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
