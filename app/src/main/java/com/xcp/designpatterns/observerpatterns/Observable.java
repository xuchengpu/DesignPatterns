package com.xcp.designpatterns.observerpatterns;

/**
 * Created by 许成谱 on 2019/3/7 13:10.
 * qq:1550540124
 * 热爱生活每一天！
 * 抽象观察者
 */
public interface Observable<U,T> {
    void register(T observer);

    void unRegister(T observer);

    void notifyObservers(U userinfo);
}
