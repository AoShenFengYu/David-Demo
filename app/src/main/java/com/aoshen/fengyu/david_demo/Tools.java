package com.aoshen.fengyu.david_demo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by kika-david on 2017/5/18.
 */

public class Tools {

    /**
     * 取得螢幕的大小
     *
     * @return int[]{x, y}, x is width, y is height.
     **/
    public static int[] getScreenSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return new int[]{size.x, size.y - getStatusBarHeight(context)};
    }

    /**
     * 取得Status Bar高度
     **/
    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        int result = 0;
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");

        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 延遲一段時間，做某件事情
     *
     * @param runnable 要做的事情
     * @param time     延遲時間
     **/
    public static void delayTimeToDo(Runnable runnable, long time) {
        new Handler().postDelayed(runnable, time);
    }

    public static void delayTimeToDo(Runnable runnable) {
        new Handler().postDelayed(runnable, 1);
    }
}

