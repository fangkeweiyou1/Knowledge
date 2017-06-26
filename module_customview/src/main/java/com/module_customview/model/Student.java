package com.module_customview.model;

import android.text.TextUtils;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class Student {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        if (TextUtils.isEmpty(name))
            return "";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
