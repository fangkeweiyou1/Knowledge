package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.module_customview.R;
import com.module_customview.widget.flowlayout.FlowLayout;
import com.module_customview.widget.flowlayout.TagAdapter;
import com.module_customview.widget.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

import cn.campusapp.router.Router;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class CustomViewActivity extends AppCompatActivity {

    private TextView skip;

    private List<String> activityNames = new ArrayList<>();
    private EditText et_input;
    /**
     * max_select:表示最多可以选择多少个
     */
    private TagFlowLayout tfl_custom;
    private LayoutInflater mInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);
        mInflater = LayoutInflater.from(this);


        skip = (TextView) findViewById(R.id.skip);
        et_input = (EditText) findViewById(R.id.et_input);
        tfl_custom = (TagFlowLayout) findViewById(R.id.tfl_custom);

        addActivityNames();
        insertView(activityNames, tfl_custom);
//        tfl_custom.getAdapter().setSelectedList(new HashSet<Integer>());设置哪一行被选中

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String activityName = et_input.getText().toString().trim();
                findRouterParams(activityName);
            }
        });

        et_input.setOnEditorActionListener(new TextView.OnEditorActionListener() {


            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                String activityName = et_input.getText().toString().trim();


                boolean routerParams = findRouterParams(activityName);
                if (routerParams)
                    return true;

                return false;
            }
        });


//        startActivity(new Intent(this,DrawerLayoutActivity.class));
    }

    private boolean findRouterParams(String activityName) {
        if (!TextUtils.isEmpty(activityName)) {
            String paramsPart = "";
            for (String name : activityNames) {
                if (name.contains(activityName)) {
                    paramsPart = name;
                    System.out.println("<<<>>>需要跳转的类名=" + name);
                    break;
                }
            }
            if (!TextUtils.isEmpty(paramsPart)) {
                String params = String.format("activity://%s", paramsPart);
                System.out.println("<<<>>>跳转参数=" + params);
                Router.open(params);
            }
            return true;
        }

        return false;
    }

    private void addActivityNames() {
        activityNames.add("flexbox");
        activityNames.add("dialogbasic");

        activityNames.add("drawerlayout");

        activityNames.add("imageviewbasic");

        activityNames.add("linearlayoutbasic");

        activityNames.add("partrecycler");
        activityNames.add("progressbarbasic");
        activityNames.add("recyclerhome");
        activityNames.add("renativelayoutbasic");
        activityNames.add("textviewbasic");
        activityNames.add("udlrrecycler");
        activityNames.add("viewpagerbasic");
        activityNames.add("webviewbasic");
        activityNames.add("tablayout");
        activityNames.add("comparator");
        activityNames.add("math");

    }

    private void insertView(List<String> list, final TagFlowLayout mFlowLayout) {
        if (list == null || list.size() <= 0)
            return;
        TagAdapter<String> mAdapter = new TagAdapter<String>(list) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                final TextView tv = (TextView) mInflater.inflate(R.layout.item_add_member_tab5,
                        mFlowLayout, false);
                tv.setText(s);

                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String activityName = tv.getText().toString().trim();
                        findRouterParams(activityName);
                    }
                });

                return tv;
            }
        };
        mFlowLayout.setAdapter(mAdapter);

    }
}
