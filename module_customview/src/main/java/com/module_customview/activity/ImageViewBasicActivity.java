package com.module_customview.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.commonlibs.utils.FileUtil;
import com.commonlibs.utils.LogUtils;
import com.module_customview.R;
import com.module_customview.base.BaseActivity;

import java.io.File;

import cn.campusapp.router.annotation.RouterMap;

/**
 * Created by zhangyuncai on 2017/6/26.
 * 讲解textview的一些基本配置
 */
@RouterMap({"activity://imageviewbasic"})
public class ImageViewBasicActivity extends BaseActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageviewbasic);

        Button bt_getimage = (Button) findViewById(R.id.bt_getimage);
        imageView = (ImageView) findViewById(R.id.iv_imageview);

        bt_getimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setDrawingCacheEnabled(true);
                Bitmap bitmap = Bitmap.createBitmap(imageView.getDrawingCache());
                imageView.setDrawingCacheEnabled(false);
                File file = FileUtil.saveMyBitmap(bitmap, "icon");
                LogUtils.i(TAG, "imagepath=" + file.getAbsolutePath());
            }
        });

    }

}
