package com.knowledge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    private List<String> mDatas = new ArrayList<>();
    private MainAdapter mAdapter;

    enum ModuleLibrary {
        MODULE_CUSTOMVIEW;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();

        initData();

        initEvent();

        if (true) {
            autoSkip();
        }
    }

    private void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        mAdapter = new MainAdapter();
        mRecyclerview.setLayoutManager(gridLayoutManager);
        mRecyclerview.setAdapter(mAdapter);
    }

    private void initData() {

    }

    private void initEvent() {

    }

    /**
     * 自动跳转
     */
    private void autoSkip() {
    }

    class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


        @Override
        public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mainadapter, parent, false);
            MainViewHolder holder = new MainViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MainViewHolder holder, int position) {
            holder.bindData(position);
        }

        @Override
        public int getItemCount() {
            return ModuleLibrary.values().length;
        }

        class MainViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            @BindView(R.id.tv_modulename)
            TextView tv_modulename;

            public MainViewHolder(View itemView) {
                super(itemView);

                ButterKnife.bind(this, itemView);
            }

            public void bindData(int position) {
                tv_modulename.setText(ModuleLibrary.values()[position].name());

                tv_modulename.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.tv_modulename: {
                    }
                    break;
                }
            }
        }
    }
}
