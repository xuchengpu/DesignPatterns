package com.xcp.designpatterns;

import android.app.Application;
import android.content.Context;

/**
 * Created by 许成谱 on 2018/10/27 16:02.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class MyApplication extends Application {
    private static  Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getContext(){
        return  mContext;
    }
}
