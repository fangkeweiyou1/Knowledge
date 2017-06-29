package com.module_customview;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.commonlibs.utils.LogUtils;
import com.module_customview.activity.ComparatorActivity;
import com.module_customview.activity.DialogBasicActvitity;
import com.module_customview.activity.DrawerLayoutActivity;
import com.module_customview.activity.Flexbox2Activity;
import com.module_customview.activity.FlexboxActivity;
import com.module_customview.activity.ImageViewBasicActivity;
import com.module_customview.activity.LinearLayoutBasicActivity;
import com.module_customview.activity.MathActivity;
import com.module_customview.activity.ProgressbarBasicActivity;
import com.module_customview.activity.RegexActivity;
import com.module_customview.activity.RenativeLayoutBasicActivity;
import com.module_customview.activity.TabLayoutActivity;
import com.module_customview.activity.ViewpagerBasicActivity;
import com.module_customview.activity.WebviewBasicActivity;
import com.module_customview.customview.LearnViewActivity;
import com.module_customview.receiver.OpenActivityReceiver;
import com.module_customview.recyclerview.DecorationRecAct;
import com.module_customview.recyclerview.PartRecyclerActivity;
import com.module_customview.recyclerview.RecyclerHomeActivity;
import com.module_customview.recyclerview.UDLRRecyclerActivity;
import com.module_customview.widget.flowlayout.FlowLayout;
import com.module_customview.widget.flowlayout.TagAdapter;
import com.module_customview.widget.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.campusapp.router.Router;

/**
 * Created by zhangyuncai on 2017/6/26.
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView skip;

    private Map<String, String> activityNames = new LinkedHashMap<>();//LinkedHashMap可以对KEY值顺序取出
    private Map<String, String> actionActivityNames = new LinkedHashMap<>();//LinkedHashMap可以对KEY值顺序取出
    private List<String> activityNamesForKeys = new ArrayList<>();
    private EditText et_input;
    /**
     * max_select:表示最多可以选择多少个
     */
    private TagFlowLayout tfl_custom;
    private LayoutInflater mInflater;
    private boolean isAuto = false;//是否自动跳转

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customview);
        mInflater = LayoutInflater.from(this);

        Float f = 1.0f;


        skip = (TextView) findViewById(R.id.skip);
        et_input = (EditText) findViewById(R.id.et_input);
        tfl_custom = (TagFlowLayout) findViewById(R.id.tfl_custom);

        addActivityNames();

        activityNamesForKeys = new ArrayList<String>(activityNames.keySet());
        insertView(activityNamesForKeys, tfl_custom);
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

        if (isAuto)
            autoSkip();


//        startActivity(new Intent(this,DrawerLayoutActivity.class));
    }


    private void autoSkip() {
//        String params = "activity://regex";
//        Router.open(params);


    }


    private boolean findRouterParams(String activityName) {
        if (actionActivityNames.containsKey(activityName)) {
            openActivityForReceiver(activityName);
            return true;
        }

        if (!TextUtils.isEmpty(activityName)) {
            String paramsPart = "";
            for (String name : activityNamesForKeys) {
                if (name.contains(activityName)) {
                    paramsPart = name;
                    LogUtils.i(TAG, "需要跳转的类名=" + name);
                    break;
                }
            }
            if (!TextUtils.isEmpty(paramsPart)) {
                String params = String.format("activity://%s", paramsPart);
                LogUtils.i(TAG, "跳转参数=" + params);
                Router.open(params);
            }
            return true;
        }

        return false;
    }


    private void openActivityForReceiver(String activityName) {
        if (!actionActivityNames.containsKey(activityName))
            return;

        OpenActivityReceiver cast = new OpenActivityReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(actionActivityNames.get(activityName));
        registerReceiver(cast, intentFilter);

        Intent intent = new Intent();
        intent.setAction(actionActivityNames.get(activityName));
        sendBroadcast(intent);

        unregisterReceiver(cast);
    }

    private void addActivityNames() {
//        activityNames.put("banner", "BannerActivity");
//        actionActivityNames.put("banner", "open_banneractivity");

//        activityNames.put("musicplayer", "MusicPlayerActivity");
//        actionActivityNames.put("musicplayer", "open_musicplayeractivity");

//        activityNames.put("special", "SpecialActivity");
//        actionActivityNames.put("special", "open_specialactivity");

        activityNames.put("learnview", LearnViewActivity.class.getSimpleName());

        activityNames.put("decorationrecyclerview", DecorationRecAct.class.getSimpleName());

        activityNames.put("regex", RegexActivity.class.getSimpleName());

        activityNames.put("flexbox", FlexboxActivity.class.getSimpleName());

        activityNames.put("flexbox2", Flexbox2Activity.class.getSimpleName());

        activityNames.put("dialogbasic", DialogBasicActvitity.class.getSimpleName());

        activityNames.put("drawerlayout", DrawerLayoutActivity.class.getSimpleName());

        activityNames.put("imageviewbasic", ImageViewBasicActivity.class.getSimpleName());

        activityNames.put("linearlayoutbasic", LinearLayoutBasicActivity.class.getSimpleName());

        activityNames.put("partrecycler", PartRecyclerActivity.class.getSimpleName());
        activityNames.put("progressbarbasic", ProgressbarBasicActivity.class.getSimpleName());
        activityNames.put("recyclerhome", RecyclerHomeActivity.class.getSimpleName());
        activityNames.put("renativelayoutbasic", RenativeLayoutBasicActivity.class.getSimpleName());
        activityNames.put("textviewbasic", TextView.class.getSimpleName());
        activityNames.put("udlrrecycler", UDLRRecyclerActivity.class.getSimpleName());
        activityNames.put("viewpagerbasic", ViewpagerBasicActivity.class.getSimpleName());
        activityNames.put("webviewbasic", WebviewBasicActivity.class.getSimpleName());
        activityNames.put("tablayout", TabLayoutActivity.class.getSimpleName());
        activityNames.put("comparator", ComparatorActivity.class.getSimpleName());
        activityNames.put("math", MathActivity.class.getSimpleName());

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

    @Override
    protected void onPause() {
        super.onPause();
    }
}