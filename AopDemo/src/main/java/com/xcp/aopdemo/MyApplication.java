package com.xcp.aopdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by 许成谱 on 2018/12/20 18:24.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
