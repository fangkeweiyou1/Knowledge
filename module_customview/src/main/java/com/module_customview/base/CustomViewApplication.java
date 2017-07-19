package com.module_customview.base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.commonlibs.utils.ToastUtils;

import cn.campusapp.router.Router;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class CustomViewApplication extends Application {
    private static Context mContext;
    private static Handler mHandler;
    private static long mMianThreadId;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

        mHandler = new Handler();

        mMianThreadId = android.os.Process.myTid();


        Router.initActivityRouter(mContext);

        ToastUtils.application=this;
    }


    /**
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

    /**
     * 得到主线程handle
     *
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }

    /**
     * 得到主线程id
     *
     * @return
     */
    public static long getMainThreadId() {
        return mMianThreadId;
    }
}
