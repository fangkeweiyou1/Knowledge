package com.module_customview.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.commonlibs.utils.LogUtils;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;
import com.module_customview.weixin.EmotionUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/3.
 */
@RouterMap({"activity://test1"})
public class Test1Activity extends BaseActivity {
    public static final String TAG = "<<<>>>Test1Activity";
    private TextView tv_weixin;
    private String str = "[囧]";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        RelativeLayout rl_layout = (RelativeLayout) findViewById(R.id.rl_layout);
        tv_weixin = (TextView) findViewById(R.id.tv_weixin);
        TextView item_add_member_tab5 = (TextView) View.inflate(this, R.layout.item_add_member_tab5, null);
        item_add_member_tab5.setText("测试");
        item_add_member_tab5.setTag(10001);
        rl_layout.addView(item_add_member_tab5);

        TextView textView = (TextView) rl_layout.findViewWithTag(10001);
        if (textView != null) {
            textView.setText("测试e");
        }

        EventBus.getDefault().register(this);
//        LogUtils.i(TAG, "onCreate");
//
//        String str = "woaini\nniaiwo";
//        str = str.replace("\n", "");
//        System.out.println("<<<>>>==" + str);

//        movetoback();


//        new Thread() {
//            @Override
//            public void run() {
//                for (String s : EmotionUtil.getEmotionList()) {
//                    Message msg = new Message();
//                    msg.obj = s;
//                    mHandler.sendMessage(msg);
//                    SystemClock.sleep(1000);
//                }
//            }
//        }.start();

    }


    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
//            str = (String) msg.obj;
//            weixin();
        }
    };

    boolean isFinishActivity = false;


    boolean flag = true;

    /**
     * 可将APP退至后台
     */
    public void movetoback() {
        Button bt_movetoback = (Button) findViewById(R.id.bt_movetoback);
        bt_movetoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(flag);
                flag = !flag;
            }
        });
    }

    @Override
    public void onBackPressed() {
        isFinishActivity = true;
        super.onBackPressed();
    }

    public void skipTest2(View v) {
//        .setFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        Intent intent = new Intent(this, Test2Activity.class);
//        if (AppDavikActivityMgr.getScreenManager().hasActivity(Test2Activity.class.getSimpleName()))
//        intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String str) {
        LogUtils.i(TAG, "str=" + str);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        LogUtils.i(TAG, "onDestroy");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtils.i(TAG, "onNewIntent");
    }


    private void weixin() {
        /*TODO----------------------->>>>  这是给掌店通新增解析表情的  <<<<<-----------------------start*/

//        str = "af/:--b[囧]ad/::-|/::B/::'(faffff/:,@o/:,@o/:,@o/:,@o/:,@o  [囧]";
        int textSize = (int) tv_weixin.getTextSize();
        SpannableString expressionString = EmotionUtil.getExpressionString(this, str, textSize);
        if (expressionString != null) {
            System.out.println("-----------------<<<>>>--------------------不是空的");
            tv_weixin.setText(expressionString);
        } else {
            System.out.println("-----------------<<<>>>--------------------是空的");

        }
      /*TODO----------------------->>>>  这是给掌店通新增解析表情的  <<<<<-----------------------end*/
    }
}
