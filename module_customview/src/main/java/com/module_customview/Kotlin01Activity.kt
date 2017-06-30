package com.module_customview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import cn.campusapp.router.annotation.RouterMap
import com.module_customview.model.Student

@RouterMap("activity://kotlin01")
class Kotlin01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin01)

        val recylerView=findViewById(R.id.recyclerview__kotlin);

//        val student = Student()
//        student.age = 10
//        student.name = "姓名"
//        LogUtils.i("<<<>>>", student.name)

        val student=Student();
        student.age=10;
        student.name="我是爱情"
        Toast.makeText(this,student.name,Toast.LENGTH_SHORT).show()
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
