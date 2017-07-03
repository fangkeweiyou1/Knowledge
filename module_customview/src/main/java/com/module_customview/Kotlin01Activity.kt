package com.module_customview

import android.os.Bundle
import cn.campusapp.router.annotation.RouterMap
import com.module_customview.base.BaseActivity

@RouterMap("activity://kotlin01")
class Kotlin01Activity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin01)

//        val recylerView = findViewById(R.id.recyclerview__kotlin);

//        val student = Student()
//        student.age = 10
//        student.name = "姓名"
//        LogUtils.i("<<<>>>", student.name)

//        val student = Student();
//        student.age = 10;
//        student.name = "我是爱情"
//        Toast.makeText(this, student.name, Toast.LENGTH_SHORT).show()

//        sum(1, 1);

//        val sum2Result = sum2(1, 2);
//        LogUtils.i(sum2Result);

//        sum3(1,2)

//        val a:Int//初始化一定要赋值,这种属于常量
//        a=0
//        println(a)

//        var b:Int//这种属于变量
//        b=2//变量要使用之前必须赋值

//        println(b)
//
//       val sum4Result= sum4(1,2)
//        println(sum4Result)

//        val c="我是爱情c"
//        val c: String
//        c = "我是爱情c"
////        println(c)
//
//        val d = c.replace("我", "你");
////        println(d)
//
//        val e = "${c.replace("我是", "大家都是")},前面的我不清楚"
//        println(e)

//        val maxOf = maxOf(10, 20)
//        println(maxOf)

//        val maxOf2Reulst=maxOf2(30,40)
//        println(maxOf2Reulst)

//        println(parseInt(""))//这里不能给 null或""  NumberFormatException

//        val f = getObjLength(3)//如果返回null 可能就不是Int类型了
//
//        if (f is Int) {
//            println("f是Int类型")
//        }
//
//        println(f)

//        var g=3
//        if(g is Int)
//        {
//            println("g是Int类型")
//        }

//        val g1=4
//        if(g1 is  Int)
//        {
//            println("g1是Int类型")
//        }

        val g2 = listOf("1", "2", "3")
//        for (g in g2) {
//            if (g is String) {
//                println("g是String类型")
//            }
//            println(g)
//        }

//        for (index in g2.indices) {
//            println("index=${g2[index]}")
//        }

//        var index = 0
//        while (index < g2.size) {
//            println("index=${g2[index]}")
//            index++
//        }

//        val g3=describe(1)
//        println(g3)

//        val g4 = describe2(1)
//        println(g4)

//        testIn(9)

        testIn2(9)

    }


    fun testIn2(a: Int)//步进方式
    {
//        for (a in 1..5) {//步进方式
//            println("a=" + a)
//        }

        for (a in 1..5 step 2) {//步进方式 +2
            println("a=" + a)
        }

        for (a in 9 downTo 0 step 2) {//倒叙方式 +2
            println("a=" + a)
        }
    }

    fun testIn(a: Int) {
        if (a in 9..19) {
            println("传进来的值在9到19之间")
        }
    }

    fun describe2(obj: Any): String =
            when (obj) {
                1 -> "这是Int类型"
                else -> "不知道什么类型"
            }

    fun describe(obj: Any): String {
        when (obj) {
            1 -> "这是Int类型"
            else -> "不知道什么类型"
        }
        return "好吧,你赢了"

    }

    fun getObjLength(obj: Any): Int? {//这里加上?表示可以返回null,如果返回null 可能就不是Int类型了
//        if (obj is String) {
//            //obj 将会在这个分支上自动转化为String类型
//            return obj.length
//        }
//
//        return null

        if (obj !is String) return null
        //obj 将会在这个分支上自动转化为String类型
        return obj.length
    }

    fun parseInt(str: String): Int? {
//        return str.toInt()
//        return str.toInt()
        return null
    }

    fun maxOf2(a: Int, b: Int) = if (a > b) a else b

    fun maxOf(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun sum(a: Int, b: Int) {
        println("我是爱情啊")
    }

    fun sum2(a: Int, b: Int): String {
        return "我是爱情啊2"
    }

    fun sum4(a: Int, b: Int) = "我是爱情啊4"

    /*
      返回一个没意义的值
     */
    fun sum3(a: Int, b: Int): Unit {
        println("我是爱情啊3")
    }

//    internal inner class MyStudent : Student()
//internal inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), MoveHorizontalScrollView.ScrollViewListener {
//    private val tv_udrl1: TextView
//    private val tv_udrl2: TextView
//    private val tv_udrl3: TextView
//    private val tv_udrl4: TextView
//    private val tv_udrl5: TextView
//    private val tv_udrl6: TextView
//    private val tv_udrl7: TextView
//    private val mhsv: MoveHorizontalScrollView
//
//    init {
//
//        tv_udrl1 = itemView.findViewById(R.id.tv_udrl1) as TextView
//        tv_udrl2 = itemView.findViewById(R.id.tv_udrl2) as TextView
//        tv_udrl3 = itemView.findViewById(R.id.tv_udrl3) as TextView
//        tv_udrl4 = itemView.findViewById(R.id.tv_udrl4) as TextView
//        tv_udrl5 = itemView.findViewById(R.id.tv_udrl5) as TextView
//        tv_udrl6 = itemView.findViewById(R.id.tv_udrl6) as TextView
//        tv_udrl7 = itemView.findViewById(R.id.tv_udrl7) as TextView
//
//        mhsv = itemView.findViewById(R.id.mhsv) as MoveHorizontalScrollView
//    }
//
//    fun bindData(position: Int) {
//        tv_udrl1.text = "列1/行" + (position + 1)
//        tv_udrl2.text = "列2/行" + (position + 1)
//        tv_udrl3.text = "列3/行" + (position + 1)
//        tv_udrl4.text = "列4/行" + (position + 1)
//        tv_udrl5.text = "列5/行" + (position + 1)
//        tv_udrl6.text = "列6/行" + (position + 1)
//        tv_udrl7.text = "列7/行" + (position + 1)
//
//        mhsv.setScrollViewListener(this)
//    }
//
//    override fun onScrollChanged(x: Int, y: Int, oldx: Int, oldy: Int) {
//    }
//}


}
