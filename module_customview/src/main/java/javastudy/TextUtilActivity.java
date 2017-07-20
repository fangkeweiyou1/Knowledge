package javastudy;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/3.
 * 学习TextUtil,
 * 学习Collections
 * 学习commons-lang
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
        List<String> strings2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            strings.add("天王=" + i);
        }

        strings.add("天王=" + 9);
        strings.add("天王=" + 7);
        strings2.add("天王=" + 17);

        Collections.shuffle(strings);//TODO:打乱集的所有元素顺序
//        Collections.reverse(strings);//TODO:反转顺序
//        Collections.fill(strings,"333");//TODO:合中的所有元素
//        String min = Collections.min(strings);//TODO,找出集合中最小元素
//        String min = Collections.min(strings, new MyComparator());//TODO,找出集合中最小元素,也可以加上比较器
//        LogUtils.i(TAG, "集合中最小元素=" + min);
//        boolean disjoint = Collections.disjoint(strings, strings2);//TODO,测试两个集合是否有相同元素,如果没有相同元素:true
//        LogUtils.i(TAG, "两个集合是否有相同元素=" + disjoint);//如果没有相同元素:true
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
//        String join = TextUtils.join(",", strings);
//        LogUtils.i(TAG, "join=" + join);

    }

    class MyComparator implements Comparator<Object> {

        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }
}
