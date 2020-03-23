package com.xcp.designpatterns.mvc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

import com.xcp.designpatterns.R;


/**
 * Created by 许成谱 on 2018/10/26 18:56.
 * qq:1550540124
 * 热爱生活每一天！
 * model:主要操作数据相关的类，通过接口回调或者观察者模式通知view或者controller，内部方法功能由controller调用。
 * 相当于BitmapUtils
 */
public class Model {
    private Context mContext;
    private Handler handler;
    private Bitmap bitmap;

    public Model(Context context) {
        this.mContext = context;
        handler = new Handler(context.getMainLooper());
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.home_flavonoids_period_bg);
    }

    private onStateChangedListener listener;

    public void setonStateChangedListener(onStateChangedListener listener) {
        this.listener = listener;
    }

    public interface onStateChangedListener {
        void onStateChanged(Bitmap bitmap);
    }

    public void loadImage() {
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(3000);
                    bitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.home_menstrual_period_bg);
                    if (listener != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onStateChanged(bitmap);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void clear() {
        bitmap = null;
        if (listener != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onStateChanged(null);
                }
            });
        }
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
