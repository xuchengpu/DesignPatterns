package com.xcp.designpatterns.principle.openclose;


import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by 许成谱 on 2018/10/22 19:22.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class MemoryCache implements ImageCache {
    //图片缓存
    private LruCache<String, Bitmap> mImageCache;

    public MemoryCache() {
        initImageCache();
    }
    private void initImageCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);//KB
        int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                //Bitmap所占用的内存空间数等于Bitmap的每一行所占用的空间数乘以Bitmap的行数
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    @Override
    public Bitmap get(String key) {

        return mImageCache.get(key);
    }

    @Override
    public void put(String key, Bitmap bitmap) {
        mImageCache.put(key, bitmap);
    }
}
