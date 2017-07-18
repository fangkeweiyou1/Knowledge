package com.module_customview.model;

/**
 * Created by zhangyuncai on 2017/7/18.
 */

/**
 * throws在函数上,后面跟的是异常类,可以多个
 * throw函数内,后没异常对象
 * <p>
 * 异常分两种
 * 编译时被检测的异常(譬如函数内throw异常,但是函数上未throws异常类)
 * 编译时未被检测的异常(运行时异常,RuntimeException的子类)(通过 e instansof RuntimeException)
 */
public class CustomException extends Exception {//继承Exception,程序员可以进行try/catch,如果继承RuntimeException,就是运行时异常,必须得改代码了
    int b;

    public CustomException() {
    }

    public CustomException(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    @Override
    public String toString() {
        return super.toString();//这个就是在调用getMessage
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
