package com.xcp.designpatterns.mvp;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2018/10/27 15:53.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class HttpModelImpl implements IHttpModel {
    private Handler UIHandler = new Handler(Looper.getMainLooper());

    @Override
    public void request(final DataListener<List<String>> listener) {
        //模拟网络请求
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(2000);
                    final List<String> datas = new ArrayList<>();
                    datas.add("1");
                    datas.add("2");
                    datas.add("3");
                    datas.add("4");
                    datas.add("5");
                    datas.add("6");
                    UIHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onComplete(datas);
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
