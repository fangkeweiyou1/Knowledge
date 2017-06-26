package com.module_customview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.module_customview.R;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);

        addActivityNames();


        skip = (TextView) findViewById(R.id.skip);
        et_input = (EditText) findViewById(R.id.et_input);

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String activityName = et_input.getText().toString().trim();
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
                }
            }
        });


//        startActivity(new Intent(this,DrawerLayoutActivity.class));
    }

    private void addActivityNames() {
        activityNames.add("dialogbasic");
        activityNames.add("drawerlayout");
        activityNames.add("imageviewbasic");
        activityNames.add("linearlayoutbasic");
        activityNames.add("partrecycler");
        activityNames.add("progressbarbasic");
        activityNames.add("recyclerhome");
        activityNames.add("renativelayoutbasic");
        activityNames.add("textbasic");
        activityNames.add("udlrrecycler");
        activityNames.add("viewpagerbasic");
        activityNames.add("webviewbasic");
        activityNames.add("comparator");
        activityNames.add("math");

    }
}
