package com.module_customview.model;

import android.text.TextUtils;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class Student {
    private int age;
    private String name;

    {
//        System.out.println("<<<>>>构造代码块");//构造代码块优先于构造函数执行,用于提取所有构造函数共性
    }

    public Student() {
//        System.out.println("构造函数");
    }

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
