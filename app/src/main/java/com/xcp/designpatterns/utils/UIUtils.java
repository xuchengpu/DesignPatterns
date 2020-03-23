package com.xcp.designpatterns.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * Created by 许成谱 on 2018/6/7 14:56.
 * qq:1550540124
 * 热爱生活每一天！
 * 与屏幕分辨率相关的工具类
 */

public class UIUtils {

    public static int dp2px(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5);

    }

    public static int px2dp(Context context, int px) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }

    /**
     * 万能适配，更改屏幕密度值
     * @param activity
     * @param application
     * @param widthDp 设计稿的宽度dp数 例如：iPhone6 ，高度*宽度=1334*750 ，density=326ppi/160≈2，则widthDp=750/2=375dp.
     */
    private static float sNoncompatDensity;//原有的屏幕密度
    private static float sNoncompatScaleDensity;//原有的字体缩放密度
    public static void setCustomDensity(Activity activity, final Application application, int widthDp){
        final DisplayMetrics appDisplayMetrics= application.getResources().getDisplayMetrics();
        if(sNoncompatDensity==0) {
            sNoncompatDensity=appDisplayMetrics.density;
            sNoncompatScaleDensity=appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if(newConfig!=null&&newConfig.fontScale>0) {
                        sNoncompatScaleDensity=application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }
        final float targetDensity = (float) appDisplayMetrics.widthPixels / widthDp;
        final float targetScaleDensity=targetDensity*(sNoncompatScaleDensity/sNoncompatDensity);
        final int targetDensityDpi= (int) (160*targetDensity);

        appDisplayMetrics.density=targetDensity;
        appDisplayMetrics.scaledDensity=targetScaleDensity;
        appDisplayMetrics.densityDpi=targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density=targetDensity;
        activityDisplayMetrics.scaledDensity=targetScaleDensity;
        activityDisplayMetrics.densityDpi=targetDensityDpi;
//        Log.e("TAG", "1dp=="+1*targetDensity);
    }
}
