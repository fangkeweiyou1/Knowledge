package com.module_customview.recyclerview;

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
import com.module_customview.widget.MoveHorizontalScrollView;

/**
 * Created by zhangyuncai on 2017/6/26.
 * 部分上下左右滑动的RecyclerView
 */

public class PartRecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerview_part;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partrecycler);

        recyclerview_part = (RecyclerView) findViewById(R.id.recyclerview_part);

        mLayoutManager = new LinearLayoutManager(this);
        recyclerview_part.setLayoutManager(mLayoutManager);
        recyclerview_part.setAdapter(new MyAdapter());

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private int mX, mY;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_part, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.bindData(position);

        }

        @Override
        public int getItemCount() {
            return 40;
        }

        class MyViewHolder extends RecyclerView.ViewHolder implements MoveHorizontalScrollView.ScrollViewListener {
            private TextView tv_udrl1;
            private TextView tv_udrl2;
            private TextView tv_udrl3;
            private TextView tv_udrl4;
            private TextView tv_udrl5;
            private TextView tv_udrl6;
            private TextView tv_udrl7;
            private MoveHorizontalScrollView mhsv;

            public MyViewHolder(View itemView) {
                super(itemView);

                tv_udrl1 = (TextView) itemView.findViewById(R.id.tv_udrl1);
                tv_udrl2 = (TextView) itemView.findViewById(R.id.tv_udrl2);
                tv_udrl3 = (TextView) itemView.findViewById(R.id.tv_udrl3);
                tv_udrl4 = (TextView) itemView.findViewById(R.id.tv_udrl4);
                tv_udrl5 = (TextView) itemView.findViewById(R.id.tv_udrl5);
                tv_udrl6 = (TextView) itemView.findViewById(R.id.tv_udrl6);
                tv_udrl7 = (TextView) itemView.findViewById(R.id.tv_udrl7);

                mhsv = (MoveHorizontalScrollView) itemView.findViewById(R.id.mhsv);
            }

            public void bindData(int position) {
                tv_udrl1.setText("列1/行" + (position + 1));
                tv_udrl2.setText("列2/行" + (position + 1));
                tv_udrl3.setText("列3/行" + (position + 1));
                tv_udrl4.setText("列4/行" + (position + 1));
                tv_udrl5.setText("列5/行" + (position + 1));
                tv_udrl6.setText("列6/行" + (position + 1));
                tv_udrl7.setText("列7/行" + (position + 1));

                mhsv.setScrollViewListener(this);
            }

            @Override
            public void onScrollChanged(int x, int y, int oldx, int oldy) {
                mX = x;
                mY = y;
                syncMoveHorizontalScrollView();
            }
        }

        private void syncMoveHorizontalScrollView() {
            if (mLayoutManager != null) {
                int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();


                for (int i = firstVisibleItemPosition; i <= lastVisibleItemPosition; i++) {
                    View viewById = mLayoutManager.findViewByPosition(i).findViewById(R.id.mhsv);
                    if (viewById != null) {
                        viewById.scrollTo(mX, mY);
                    }
                }
            }
        }
    }
}
