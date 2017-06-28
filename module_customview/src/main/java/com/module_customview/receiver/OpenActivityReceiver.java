package com.module_customview.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.commonlibs.utils.LogUtils;

/**
 * Created by zhangyuncai on 2017/6/28.
 */

public class OpenActivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        LogUtils.i("<<<>>>", "main收到了");
    }
}
