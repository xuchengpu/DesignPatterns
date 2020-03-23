package com.xcp.designpatterns.principle.openclose;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by 许成谱 on 2018/10/22 19:56.
 * qq:1550540124
 * 热爱生活每一天！
 * 双缓存类
 */
public class DoubleCache implements ImageCache {
    private MemoryCache mMemoryCache;
    private DiskCache mDiskCache;

    public DoubleCache(Context context) {
        mMemoryCache=new MemoryCache();
        mDiskCache=new DiskCache(context);
    }
    //先从内存缓存中获取图片，如果没有，再从存储卡中获取
    @Override
    public Bitmap get(String key) {
        Bitmap bitmap = mMemoryCache.get(key);
        if(bitmap==null) {
            bitmap=mDiskCache.get(key);
        }
        return bitmap;
    }
    //分别在内存和存储卡中都缓存一遍
    @Override
    public void put(String key, Bitmap bitmap) {
        mMemoryCache.put(key,bitmap);
        mDiskCache.put(key,bitmap);
    }
}
