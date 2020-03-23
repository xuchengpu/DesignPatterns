package com.xcp.designpatterns.mvp;

/**
 * Created by 许成谱 on 2018/10/27 14:44.
 * qq:1550540124
 * 热爱生活每一天！
 */
public interface DataListener<T> {
    void onComplete(T t);
}
