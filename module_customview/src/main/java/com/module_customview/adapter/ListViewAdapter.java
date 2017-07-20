package com.module_customview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.module_customview.R;
import com.module_customview.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyuncai on 2017/7/20.
 */

public class ListViewAdapter extends BaseAdapter {

    private List<Student> list;
    private Context mContext;

    public ListViewAdapter(Context context) {
        mContext = context;
        list=new ArrayList<>();
        Student student;
        for (int i = 0; i < 30; i++) {
            student = new Student();
            student.setAge(i + 1);
            student.setName("姓名=" + (i + 1));
            list.add(student);
        }
    }

    public ListViewAdapter(List<Student> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(mContext, R.layout.item_comparator, null);

        Student student = list.get(position);

        TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
        TextView tv_age = (TextView) view.findViewById(R.id.tv_age);

        tv_name.setText(student.getName());
        tv_age.setText("年龄" + student.getAge());

        return view;
    }
}
