package javastudy;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;
import com.module_customview.model.Student;

import java.util.Comparator;
import java.util.List;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/7.
 * 学习java
 */
@RouterMap({"activity://studyjava"})
public class StudyJavaActivity extends BaseActivity {
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

//        Student student=new Student();


        //TODO:学习线程
//        TestThread testThread1 = new TestThread("线程1");
//        TestThread testThread2 = new TestThread("线程2");
//
//        testThread1.start();
//        testThread2.start();

        //TODO:synchronized可以加在方法上,也可以synchronized()

        //线程安全是由于多个线程才会不安全,而安卓很少出现多个线程调用单例,所以可以不用锁


        //TODO:学习ArrayList
//        Student student100 = new Student();
//        student100.setAge(100);
//        student100.setName("学生100");
//
//        Student student200 = new Student();
//        student200.setAge(200);
//        student200.setName("学生200");
//
//        Student student300 = new Student();
//        student300.setAge(300);
//        student300.setName("学生300");
//
//        Student student400 = new Student();
//        student400.setAge(400);
//        student400.setName("学生400");
//
//
////        ArrayList<Student> arrayList = new ArrayList<>(new StudentCom());
//        TreeSet<Student> treeSet = new TreeSet<>(new StudentCom());//这样就可以排序
//        treeSet.add(student200);
//        treeSet.add(student100);
//        treeSet.add(student400);
//        treeSet.add(student300);
//
//
//        for (Student student : treeSet) {
//            System.out.println("<<<>>>name=" + student.getName());
//
//        }

//        经常发现有List<? super T>、Set<? extends T> 的声明，是什么意思呢？<? super T>表示包括T在内的任何T的父类
// ，<? extends T>表示包括T在内的任何T的子类，下面我们详细分析一下两种通配符具体的区别。

        //TODO import static System,这样就可以使用out.printlf的静态方法了,前面不用加上System了

        //TODO 学习System
        //TODO System中in是记录键盘录入,out是打印到控制台上
    }

    public <T extends Comparator<? super T>> void sort(List<T> list) {

    }

    class StudentCom implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    class TestThread extends Thread {
        public TestThread(String name) {
            super(name);
        }

        @Override
        public void run() {

            show();
            System.out.println(TAG + Thread.currentThread().getName());
        }

        private synchronized void show() {
            System.out.println(TAG + "方法锁");
        }

        private void show2() {
            Object obj = new Object();
//            synchronized (this) {//只要这个锁是唯一就行(该对象肯定是唯一的啦,)
//            synchronized (obj) {//只要这个锁是唯一就行(obj肯定是唯一的啦,)
            synchronized (TestThread.class) {//只要这个锁是唯一就行(TestThread.class肯定是唯一的啦,)
                System.out.println(TAG + "代码块锁");

            }
        }
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
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
