package javastudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.module_customview.R;
import com.module_customview.model.Student;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/7.
 */
@RouterMap({"activity://studyjava"})
public class StudyJavaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studyjava);

//        for (; ; ) {//TODO:这种表达式表示无限循环,默认第二个参数为true
//
//        }

//        while (true) {//TODO:这种表达式表示无限循环
//
//        }

        //TODO:函数重载只要参数个数或者参数类型不一样即可

        /*TODO:java有两种内存机制:栈,堆
        栈用来存放局部变量:例如参数,for循环中的参数等
        int[] arr=new int[10] 该数组中的值在堆里,arr引用则在栈中,引用存放的值是在堆总的值得地址引用
        如果 arr=null 那么堆中的值没有任何引用,则作为垃圾被回收
          */

//        int[] arr = new int[10];
//        int[] arr2 = arr;
//        arr[1] = 99;
////        arr = null;
//        int length = arr2.length;
//        arr2.clone();
//
//        for (int i : arr2) {
//            System.out.println("<<<>>>i=" + i);
//        }

        Student student=new Student();
    }

    class Test {

        {
            System.out.println("----");//构造代码块优先于构造函数执行,用于提取所有构造函数共性

        }

        public Test() {
//            System.out.println("----");
        }

        public Test(String str) {

//            System.out.println("----");
        }
    }

    /**
     * java 中的main是jvm自动调用 java demo haha ,java表示调用jvm demo表示该类名 haha表示main方法中的参数,不传也可以
     * @param args
     */
    public static void main(String[] args) {

    }
}
