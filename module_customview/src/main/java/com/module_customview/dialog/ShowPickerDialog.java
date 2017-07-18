package com.module_customview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
import com.module_customview.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class ShowPickerDialog extends Dialog {

    private TimePickerView pvCustomTime;
    private FrameLayout fl_frame;

    public ShowPickerDialog(Context context) {
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

        View view = View.inflate(getContext(), R.layout.dialog_showpicker, null);
        fl_frame = (FrameLayout) view.findViewById(R.id.fl_frame);
        TextView tv_showpickerindialog = (TextView) view.findViewById(R.id.tv_showpickerindialog);

        tv_showpickerindialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerInDialog();
            }
        });

        setContentView(view);

    }

    private void showPickerInDialog() {
/**
 * @description
 *
 * 注意事项：
 * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
 * 具体可参考demo 里面的两个自定义layout布局。
 * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
 * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
 */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2000, 0, 1);
        Calendar endDate = Calendar.getInstance();
//        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomTime = null;
        if (pvCustomTime == null) {
            pvCustomTime = new TimePickerView.Builder(getContext(), new TimePickerView.OnTimeSelectListener() {
                @Override
                public void onTimeSelect(Date date, View v) {//选中事件回调
                }
            })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
               /*.gravity(Gravity.RIGHT)// default is center*/
                    .setDate(selectedDate)
                    .setRangDate(startDate, endDate)//注释后默认时间1900-2100年
                    .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                        @Override
                        public void customLayout(View v) {
                            final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                            TextView ivCancel = (TextView) v.findViewById(R.id.iv_cancel);
                            tvSubmit.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    pvCustomTime.returnData();
                                    pvCustomTime.dismiss();
                                }
                            });
                            ivCancel.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    pvCustomTime.dismiss();
                                }
                            });
                        }
                    })
                    .setType(new boolean[]{true, true, true, false, false, false})
                    .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                .setDividerColor(Color.RED)
                    .setDecorView(fl_frame)
                    .isCyclic(true)
                    .setOutSideCancelable(true)
                    .build();
        }
        pvCustomTime.show();


    }

}
