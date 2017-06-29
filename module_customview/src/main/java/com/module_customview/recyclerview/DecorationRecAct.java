package com.module_customview.recyclerview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.module_customview.R;
import com.module_customview.recyclerview.deroration.PowerfulStickyDecoration;

import java.util.ArrayList;
import java.util.List;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/29.
 *
 * @desc 讲解分割线的RecyclerView
 */
@RouterMap({"activity://decorationrecyclerview"})
public class DecorationRecAct extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> citys = new ArrayList<>();
    private ComparatorAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decorationrec);

        for (int i = 0; i < 40; i++) {

            citys.add("城市" + i);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_decoration);

//        DefaultDecoration defaultDecoration=new DefaultDecoration();

        PowerfulStickyDecoration.Builder builder = PowerfulStickyDecoration.Builder.init(new PowerfulStickyDecoration.PowerGroupListener() {
            @Override
            public String getGroupName(int position) {
                if (position == 3)
                    return "城市3";
                return null;
            }

            @Override
            public View getGroupView(int position) {
                if (position == 3) {
                    View view = View.inflate(DecorationRecAct.this, R.layout.item_comparator, null);
//                    view.setBackgroundColor(Color.BLUE);
                    return view;
                }
                return null;
            }
        });
        PowerfulStickyDecoration powerfulStickyDecoration = builder.build();

        mRecyclerView.addItemDecoration(powerfulStickyDecoration);

        mAdapter = new ComparatorAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    class ComparatorAdapter extends RecyclerView.Adapter<ComparatorAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comparator, parent, false);
            view.setBackgroundColor(Color.parseColor("#33ff0000"));
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindData(position);
        }

        @Override
        public int getItemCount() {
            if (citys != null)
                return citys.size();
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
                String s = citys.get(position);
                tv_name.setText(position + "");
                tv_age.setText(s + "");
            }
        }
    }

}
