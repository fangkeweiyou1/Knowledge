package com.module_customview.sharepre;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.commonlibs.utils.AppNetworkMgr;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/7/2.
 */
@RouterMap({"activity://sharepre"})
public class SharepreActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepre);

//        AppSharePreferenceMgr.put(this, "ceshi01", "这是测试第一个");
//
//        String str = (String) AppSharePreferenceMgr.get(this, "ceshi01", "没有");
//
//        LogUtils.i("<<<>>>", "str=" + str);

//        AppToastMgr.ToastShortTopCenter(this,str);

        AppNetworkMgr.getNetworkState(this);
    }
}
