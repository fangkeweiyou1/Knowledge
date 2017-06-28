package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.module_customview.R;
import com.commonlibs.utils.LogUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/28.
 */
@RouterMap({"activity://regex"})
public class RegexActivity extends AppCompatActivity {
    private static final String TAG = "RegexActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regex);


        String content = "file:我是第1个.pnglalalalalfile:我是第2个.pnglalalalalalafile:我是第3个.pnglalalalfile:我是第4个.png";
        String reg = "file:[^>]+png";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            String group = matcher.group();
            LogUtils.i(TAG, "group=" + group);
        }
    }
}
