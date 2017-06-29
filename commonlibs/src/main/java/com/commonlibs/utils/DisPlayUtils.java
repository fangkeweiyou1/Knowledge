package com.commonlibs.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by zhangyuncai on 2017/6/29.
 */

public final class DisPlayUtils {
    private static float density = -1F;
    private static int screenWidth = -1;
    private static int screenHeight = -1;
    private static DisplayMetrics displayMetrics = null;

    private DisPlayUtils() {
    }

    private static DisplayMetrics getDisplayMetrics() {
        if (displayMetrics == null) {
            displayMetrics = Resources.getSystem().getDisplayMetrics();
        }
        return displayMetrics;
    }

    public static float getDensity() {
        if (density <= 0F) {
            density = getDisplayMetrics().density;
        }
        return density;
    }

    public static int dip2px(float dpValue) {
        return (int) (dpValue * getDensity() + 0.5F);
    }

    public static int px2dip(float pxValue) {
        return (int) (pxValue / getDensity() + 0.5F);
    }

    public static int getScreenWidth() {
        if (screenWidth <= 0) {
            screenWidth = getDisplayMetrics().widthPixels;
        }
        return screenWidth;
    }


    public static int getScreenHeight() {
        if (screenHeight <= 0) {
            screenHeight = getDisplayMetrics().heightPixels;
        }
        return screenHeight;
    }
}
