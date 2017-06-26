package com.module_customview.activity;

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

/**
 * Created by zhangyuncai on 2017/6/25.
 * 可以上下左右滑动的RecyclerView
 */

public class UDLRRecyclerActivity extends AppCompatActivity {
    private String titleName = "";
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_udlr);

        titleName = getIntent().getStringExtra(RecyclerHomeActivity.KEY_TITLENAME);

        initView();

        initData();

        initEvent();
    }

    private void initView() {
        TextView tv_titlename = (TextView) findViewById(R.id.tv_titlename);
//        tv_titlename.setText(titleName);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_udrl);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new MyAdapter());

    }

    private void initData() {

    }

    private void initEvent() {


    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_udrl, parent, false);
            MyViewHolder holder = new MyViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindData(position);
        }

        @Override
        public int getItemCount() {
            return 40;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView tv_udrl1;
            private TextView tv_udrl2;
            private TextView tv_udrl3;
            private TextView tv_udrl4;
            private TextView tv_udrl5;
            private TextView tv_udrl6;
            private TextView tv_udrl7;

            public MyViewHolder(View itemView) {
                super(itemView);

                tv_udrl1 = (TextView) itemView.findViewById(R.id.tv_udrl1);
                tv_udrl2 = (TextView) itemView.findViewById(R.id.tv_udrl2);
                tv_udrl3 = (TextView) itemView.findViewById(R.id.tv_udrl3);
                tv_udrl4 = (TextView) itemView.findViewById(R.id.tv_udrl4);
                tv_udrl5 = (TextView) itemView.findViewById(R.id.tv_udrl5);
                tv_udrl6 = (TextView) itemView.findViewById(R.id.tv_udrl6);
                tv_udrl7 = (TextView) itemView.findViewById(R.id.tv_udrl7);
            }

            public void bindData(int position) {
                tv_udrl1.setText("列1/行" + (position + 1));
                tv_udrl2.setText("列2/行" + (position + 1));
                tv_udrl3.setText("列3/行" + (position + 1));
                tv_udrl4.setText("列4/行" + (position + 1));
                tv_udrl5.setText("列5/行" + (position + 1));
                tv_udrl6.setText("列6/行" + (position + 1));
                tv_udrl7.setText("列7/行" + (position + 1));
            }
        }
    }
}
