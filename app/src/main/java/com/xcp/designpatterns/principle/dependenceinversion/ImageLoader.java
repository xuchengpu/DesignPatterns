package com.xcp.designpatterns.principle.dependenceinversion;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import com.xcp.designpatterns.principle.openclose.ImageCache;
import com.xcp.designpatterns.principle.openclose.MemoryCache;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 许成谱 on 2018/10/22 19:18.
 * qq:1550540124
 * 热爱生活每一天！
 * 依赖倒置原则：模块之间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象产生的。简而言之，就是面向接口编程。
 */
public class ImageLoader {
    //依据依赖倒置原则，此处不能用MemoryCache，会导致不能扩展，如果拓展只能改为private DoubleCache imageCache=new DoubleCache();会导致直接修改了ImageLoader这个类的代码，违反了开闭原则。类型用该用抽象类或者接口。
//    private MemoryCache imageCache=new MemoryCache();
    private ImageCache imageCache=new MemoryCache();
    //线程池 线程数量为cup的数量
    private ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    //UI handler
    private Handler mUIHandler = new Handler(Looper.getMainLooper());

    public void displayImage(final String url, final ImageView imageView) {
        Bitmap bitmap = imageCache.get(url);
        if(bitmap!=null) {
            updateImageView(imageView,bitmap);
            return;
        }
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) {
                    return;
                }
                if (imageView.getTag().equals(url)) {
                    updateImageView(imageView, bitmap);
                }
                imageCache.put(url, bitmap);
            }
        });
    }

    private void updateImageView(final ImageView imageView, final Bitmap bitmap) {
        mUIHandler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    private Bitmap downloadImage(String url) {
        Bitmap bitmap = null;
        try {
            URL imageUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    //扩展性，让用户自己实现
    public void setImageCache(ImageCache imageCache){
        this.imageCache=imageCache;
    }
}
