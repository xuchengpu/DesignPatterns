package com.xcp.designpatterns.principle.openclose;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 许成谱 on 2018/10/22 19:22.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class DiskCache implements ImageCache {
    private static String cacheDir;

    public DiskCache(Context context) {
        cacheDir=context.getCacheDir().getPath();
    }

    @Override
    public Bitmap get(String key) {

        return BitmapFactory.decodeFile(cacheDir+ File.separator+key);
    }

    @Override
    public void put(String key, Bitmap bitmap) {
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(cacheDir + File.separator + key);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
