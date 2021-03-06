package javastudy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.module_customview.R;
import com.module_customview.base.BaseActivity;
import com.module_customview.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/26.
 * Comparator比较器的使用
 * 学习Comparator
 */

@RouterMap({"activity://comparator"})
public class ComparatorActivity extends BaseActivity {

    private RecyclerView mRecyclerView;
    private List<Student> mDadas;
    private Button bt_sort;
    private Button bt_resetdatas;
    private Button bt_additem;
    private Button bt_deleteitem;
    private ComparatorAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparator);

        bt_sort = (Button) findViewById(R.id.bt_sort);
        bt_resetdatas = (Button) findViewById(R.id.bt_resetdatas);
        bt_additem = (Button) findViewById(R.id.bt_additem);
        bt_deleteitem = (Button) findViewById(R.id.bt_deleteitem);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_comparator);

        addDatas();

        mAdapter = new ComparatorAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);


        bt_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortDatas();
                mAdapter.notifyDataSetChanged();
            }
        });


        bt_resetdatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDatas();
                mAdapter.notifyDataSetChanged();
            }
        });

        bt_additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student();
                student.setName("这是新增的");
                student.setAge(200);
                mDadas.add(0, student);
                mAdapter.notifyItemInserted(0);
                mRecyclerView.scrollToPosition(0);
            }
        });

        bt_deleteitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDadas.remove(0);
                mAdapter.notifyItemRemoved(0);

            }
        });


    }

    private void addDatas() {
        mDadas = new ArrayList<>();
        Student student;
        for (int i = 0; i < 10; i++) {
            student = new Student();
            student.setAge(i * 2);
            student.setName("姓名" + (i * 2));
            mDadas.add(student);
        }

        for (int i = 0; i < 10; i++) {
            student = new Student();
            student.setAge(i * 1);
            student.setName("姓名" + (i * 1));
            mDadas.add(student);
        }
    }

    /**
     * 对数据进行排序
     */
    private void sortDatas() {
        if (mDadas != null && mDadas.size() != 0) {
            Collections.sort(mDadas, new MyComparator());
        }
    }

    class MyComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    class ComparatorAdapter extends RecyclerView.Adapter<ComparatorAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comparator, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindData(position);
        }

        @Override
        public int getItemCount() {
            if (mDadas != null)
                return mDadas.size();
            return 0;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private final TextView tv_age;
            private final TextView tv_name;

            public MyViewHolder(View itemView) {
                super(itemView);

                tv_age = (TextView) itemView.findViewById(R.id.tv_age);
                tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            }

            public void bindData(int position) {
                Student student = mDadas.get(position);
                tv_age.setText(student.getAge() + "");
                tv_name.setText(student.getName() + "");
            }
        }
    }

}
