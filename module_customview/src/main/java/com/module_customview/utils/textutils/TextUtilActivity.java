package com.module_customview.utils.textutils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.commonlibs.utils.LogUtils;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/3.
 */
@RouterMap({"activity://textutil"})
public class TextUtilActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textutil);

        //TODO:是否全部为数字
//        String str="1234";
//        LogUtils.i(TAG,"str是否全部为数字="+TextUtils.isDigitsOnly(str));

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add("天王=" + i);
        }

        strings.add("天王=" + 9);

//        for (String string : strings) {
//            LogUtils.i(TAG, "string=" + string);
//        }

        //TODO:这个API可以知道对象在集合出现的次数
//        int num = Collections.frequency(strings, "天王=9");//这个API可以知道对象在集合出现的次数
//        LogUtils.i(TAG, "出现天王9的次数=" + num);


        //TODO:这个API可以拼接多个字符串
//        String str1="我是爱情";
//        String str2="的保卫战";
//        LogUtils.i(TAG,"str1和str2的拼接字符串是:"+ TextUtils.concat(str1,str2,","));


        //TODO:在数组中每个元素之间使用“,”来连接
        String join = TextUtils.join(",", strings);
        LogUtils.i(TAG, "join=" + join);
    }
}
