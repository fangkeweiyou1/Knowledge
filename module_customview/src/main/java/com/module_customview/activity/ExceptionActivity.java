package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.commonlibs.utils.LogUtils;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;
import com.module_customview.model.CustomException;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/18.
 * 学习Exception
 */
@RouterMap({"activity://exception"})
public class ExceptionActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);

        try {
            test(1, -1);
        } catch (CustomException e) {
            e.printStackTrace();
            LogUtils.i(TAG, e.toString());
            LogUtils.i(TAG, "进入自定义异常了");
        }

        try {

        } catch (Exception e) {

        }

        try {

        } catch (Exception e) {

        } finally {

        }

        try {

        } finally {

        }
    }

    private void test(int a, int b) throws CustomException {

        if (b == -1) {
            throw new CustomException();
        }
        int c = a / b;
        LogUtils.i(TAG, "c=" + c);
    }

    private void test2() throws ArithmeticException//ArithmeticException是RuntimeException,所以调用者可以不用try/catch,编译一样通过
    {

    }

    private void test3(int a) {//ArithmeticException是RuntimeException,所以函数上可以不用throws,编译一样通过
        if (a == 0) {
            throw new ArithmeticException("a==0啦");
        }
    }
}
