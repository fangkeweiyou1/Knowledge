package com.module_customview.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.module_customview.R;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/27.
 */
@RouterMap({"activity://tablayout"})
public class TabLayoutActivity extends AppCompatActivity {
//    @BindView(R.id.tab_tablayout)
//    TabLayout tab_tablayout;
//    @BindView(R.id.tab_viewpager)
//    ViewPager tab_viewpager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
//        ButterKnife.bind(this);

        ViewPager tab_viewpager = (ViewPager) findViewById(R.id.tab_viewpager);
        TabLayout tab_tablayout = (TabLayout) findViewById(R.id.tab_tablayout);
        MyAdapter myAdapter = new MyAdapter();
        tab_viewpager.setAdapter(myAdapter);
        tab_tablayout.setupWithViewPager(tab_viewpager);
    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(container.getContext());
            ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
            layoutParams.width = ViewPager.LayoutParams.MATCH_PARENT;
            layoutParams.height = ViewPager.LayoutParams.MATCH_PARENT;
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER);
            textView.setTextColor(Color.parseColor("#222222"));
            textView.setText("这是几页:" + position);
            textView.setTextSize(14);
            container.addView(textView);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return position + "";
        }
    }
}
