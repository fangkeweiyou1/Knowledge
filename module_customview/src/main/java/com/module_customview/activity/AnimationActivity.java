package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.module_customview.R;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/17.
 * 学习animation
 */
@RouterMap({"activity://animation"})
public class AnimationActivity extends AppCompatActivity {

    private TextView tv_rotate;

    private RotateAnimation rotateAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        rotate();

        tv_rotate = (TextView) findViewById(R.id.tv_rotate);

        tv_rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation animation = tv_rotate.getAnimation();
                if (animation == null) {
                    tv_rotate.clearAnimation();
                    tv_rotate.setAnimation(rotateAnimation);
                }else {
                    tv_rotate.clearAnimation();
                }
            }
        });
    }

    private void rotate() {
        rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());//不停顿
        rotateAnimation.setDuration(1000);//时间
        rotateAnimation.setRepeatCount(-1);//重复次数
        rotateAnimation.setFillAfter(true);//是否停在最后
        rotateAnimation.setStartOffset(0);//
    }
}
