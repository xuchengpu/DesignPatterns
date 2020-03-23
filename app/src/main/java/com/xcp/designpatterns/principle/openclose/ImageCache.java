package com.xcp.designpatterns.principle.openclose;

import android.graphics.Bitmap;

/**
 * Created by 许成谱 on 2018/10/22 19:21.
 * qq:1550540124
 * 热爱生活每一天！
 */
public interface ImageCache {
    Bitmap get(String key);
    void put(String key,Bitmap bitmap);
}
