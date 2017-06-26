package com.module_customview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.module_customview.R;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class ExampleDialog extends Dialog {

    public ExampleDialog(Context context) {
        super(context, R.style.MMTheme_DataSheet);

        initView();
    }

    private void initView() {
        //去掉dialog的标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /** 设置与屏幕等宽 */
        Window window = getWindow();

        /***
         * dialog 默认的样式@android:style/Theme.Dialog 对应的style 有pading属性 就能够水平占满
         ***/
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);
        window.setWindowAnimations(R.style.popup_animation_updown);

        setContentView(R.layout.dialog_example);


    }
}
