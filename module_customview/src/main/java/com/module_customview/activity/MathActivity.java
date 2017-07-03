package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

@RouterMap({"activity://math"})
public class MathActivity extends BaseActivity {
    String mathDesc = "";
    private TextView tv_math_content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        tv_math_content = (TextView) findViewById(R.id.tv_math_content);

        tv_math_content.setText(mathDesc);

        mathDesc = "\n1)Math.toRadians(30):要先把角度转化为对应的弧度,Math.sin(Math.toRadians(30))=0.5 如同数学中 sin30=0.5";
        tv_math_content.append(mathDesc);

        mathDesc = "\n2)double sin = Math.sin(2*Math.PI/360*30);//sin30度=0.5";
        tv_math_content.append(mathDesc);

        tv_math_content.append(String.format("\n" +
                "3)这两个整数最大的是Math.max(3,1)=%s", Math.max(3, 1)));

        tv_math_content.append(String.format("\n" +
                "4)这两个整数最小的是Math.min(3,1)=%s", Math.min(3, 1)));

        tv_math_content.append(String.format("\n" +
                "5)这个值得绝对值是Math.abs(-4)=%s", Math.abs(-4)));



    }


}
/*
Math.toRadians(30):要先把角度转化为对应的弧度
  Math.sin(Math.toRadians(30))=0.5 如同数学中 sin30=0.5



1	static double abs(double a)
此方法返回一个double值的绝对值.
2	static float abs(float a)
此方法返回一个float值的绝对值.
3	static int abs(int a)
此方法返回一个int值的绝对值.
4	static long abs(long a)
此方法返回一个long值的绝对值.
5	static double acos(double a)
此方法返回一个值的反余弦值，返回的角度范围从0.0到pi.
6	static double asin(double a)
此方法返回一个值的反正弦，返回的角度范围在-pi/2到pi/2.
7	static double atan(double a)
此方法返回一个值的反正切值，返回的角度范围在-pi/2到pi/2.
8	static double atan2(double y, double x)
此方法返回角度theta（x，y）从转换的矩形坐标到极坐标（r，θ）.
9	static double cbrt(double a)
此方法返回一个double值的立方根.
10	static double ceil(double a)
此方法返回最小的（最接近负无穷大）double值，大于或等于参数，并等于一个整数.
11	static double copySign(double magnitude, double sign)
此方法返回的第一个浮点参数与第二个浮点参数的符号.
12	static float copySign(float magnitude, float sign)
此方法返回的第一个浮点参数与第二个浮点参数的符号.
13	static double cos(double a)
此方法返回一个角的三角余弦.
14	static double cosh(double x)
此方法返回一个double值的双曲余弦.
15	static double exp(double a)
此方法返回欧拉数e的一个double值的次幂.
16	static double	expm1(double x)
此方法返回 ex -1.
17	static double floor(double a)
此方法返回最大的（最接近正无穷大）double值小于或相等于参数，并相等于一个整数.
18	static int getExponent(double d)
此方法返回的无偏指数在该项表述的double.
19	static int getExponent(float f)
此方法返回一个浮点数的表示中使用的无偏指数.
20	static double hypot(double x, double y)
没有中间溢出或下溢的情况下，此方法返回的sqrt(x2 +y2) .
21	static double IEEEremainder(double f1, double f2)
这两个参数，IEEE 754标准规定的方法计算，其余操作.
22	static double log(double a)
此方法返回一个double值的自然对数（以e为底）.
23	static double log10(double a)
此方法返回一个double值以10为底.
24	static double log1p(double x)
此方法返回自然对数的总和的参数.
25	static double max(double a, double b)
此方法返回两个double值较大的那一个.
26	static float max(float a, float b)
此方法返回的两个浮点值最大的那一个.
27	static int max(int a, int b)
此方法返回两个int值中最大的那一个.
28	static long max(long a, long b)
此方法返回的两个long值中最大的那一个.
29	static double min(double a, double b)
此方法返回的两个较小的double值.
30	static float min(float a, float b)
此方法返回的两个较小的浮动值.
31	static int min(int a, int b)
此方法返回的两个较小的int值.
32	static long min(long a, long b)
此方法返回的两个较小的长值.
33	static double nextAfter(double start, double direction)
此方法返回浮点数相邻方向的第二个参数，第一个参数.
34	static float nextAfter(float start, double direction)
此方法返回浮点数相邻方向的第二个参数，第一个参数.
35	static double nextUp(double d)
在正无穷大的方向，此方法返回至d相邻的浮点值.
36	static float nextUp(float f)
此方法返回到f相邻的浮点值在正无穷方向上.
37	static double pow(double a, double b)
此方法返回的第一个参数的值提升到第二个参数的幂
38	static double random()
该方法返回一个无符号的double值，大于或等于0.0且小于1.0.
39	static double rint(double a)
此方法返回的double值，值的参数是最接近的，相等于一个整数.
40	static long round(double a)
此方法返回的参数最接近的long.
41	static int round(float a)
此方法返回的参数最接近的整数.
42	static double scalb(double d, int scaleFactor)
此方法返回d × 2scaleFactor 四舍五入，如果由一个单一的正确舍入的浮点乘法的double值组的成员.
43	static float scalb(float f, int scaleFactor)
此方法返回f × 2scaleFactor 四舍五入，如果由一个单一的正确舍入的浮点乘法，浮点值集合的成员.
44	static double signum(double d)
此方法返回signum函数的参数，如果参数是零返回0，如果参数大于零返回1.0，如果参数小于零返回-1.0.
45	static float signum(float f)
此方法返回signum函数的参数，如果参数是零返回0，如果参数大于零返回1.0f，如果参数小于零返回-1.0f.
46	static double sin(double a)
此方法返回一个double值的双曲正弦.
47	static double sinh(double x)
此方法返回一个double值的双曲正弦.
48	static double sqrt(double a)
此方法返回正确舍入的一个double值的正平方根.
49	static double tan(double a)
此方法返回一个角的三角函数正切值
50	static double tanh(double x)
此方法返回一个double值的双曲正切.
51	static double toDegrees(double angrad)
这种方法大致相等的角度，以度为单位的角度转换成弧度测量.
52	static double toRadians(double angdeg)
此方法转换一个角度，以度为单位大致相等的角弧度测量.
53	static double ulp(double d)
此方法返回的参数的ulp的大小.
54	static double ulp(float f)
此方法返回的参数的ulp的大小.
 */