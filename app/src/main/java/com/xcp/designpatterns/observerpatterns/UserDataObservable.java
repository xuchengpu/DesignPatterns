package com.xcp.designpatterns.observerpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2019/3/7 14:14.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class UserDataObservable<T> implements Observable<T,Observer<T>> {
    private List<Observer<T>> observers;

    public UserDataObservable() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer<T> observer) {
        observers.add(observer);
    }

    @Override
    public void unRegister(Observer<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(T userinfo) {
        for(Observer<T> observer:observers) {
            observer.updata(userinfo);
        }
    }
}
