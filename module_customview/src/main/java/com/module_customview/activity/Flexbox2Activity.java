package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayoutManager;
import com.module_customview.R;

import java.util.ArrayList;
import java.util.List;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/27.
 */
@RouterMap({"activity://flexbox2"})
public class Flexbox2Activity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FlexboxLayoutManager mLayoutManager;
    private List<FlexboxLayoutManager.LayoutParams> mLayoutParams;
    private FiexboxAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexbox2);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_fiexbox2);

        mLayoutParams=new ArrayList<>();
        FlexboxLayoutManager.LayoutParams layoutParams;
        for (int i = 0; i < 20; i++) {

            layoutParams=new FlexboxLayoutManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
//            layoutParams.setFlexBasisPercent(0.25f);//宽度占据父控件比例
//            layoutParams.setAlignSelf(AlignSelf.STRETCH);//设置对其方式
            layoutParams.setFlexGrow(1);
            mLayoutParams.add(layoutParams);

        }


        mLayoutManager = new FlexboxLayoutManager(this);
        mAdapter = new FiexboxAdapter();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }



    class FiexboxAdapter extends RecyclerView.Adapter<FiexboxAdapter.FiexboxViewHolder> {


        @Override
        public FiexboxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.viewholder_flex_item, parent, false);
            return new FiexboxViewHolder(view);
        }

        @Override
        public void onBindViewHolder(FiexboxViewHolder holder, int position) {
            int adapterPosition = holder.getAdapterPosition();
            // TODO: More optimized set the click listener inside the view holder
            holder.bindTo(mLayoutParams.get(position));
        }

        @Override
        public int getItemCount() {
            if (mLayoutParams != null)
                return mLayoutParams.size();
            return 0;
        }

        class FiexboxViewHolder extends RecyclerView.ViewHolder {
            private TextView mTextView;

            public FiexboxViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.textview);
            }

            void bindTo(RecyclerView.LayoutParams layoutParams) {
                int adapterPosition = getAdapterPosition();
                mTextView.setText(String.valueOf(adapterPosition + 1));
                mTextView.setBackgroundResource(R.drawable.flex_item_background);
                mTextView.setGravity(Gravity.CENTER);
                mTextView.setLayoutParams(layoutParams);
            }
        }
    }
}