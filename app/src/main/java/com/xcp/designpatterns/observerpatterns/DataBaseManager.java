package com.xcp.designpatterns.observerpatterns;

/**
 * Created by 许成谱 on 2019/3/7 14:38.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class DataBaseManager {
    private static volatile DataBaseManager manager;
    private UserDataObservable<UserInfo> observable;

    private DataBaseManager() {
        observable=new UserDataObservable<UserInfo>();
    }

    public static DataBaseManager getManager() {
        if (manager == null) {
            synchronized (DataBaseManager.class) {
                if (manager == null) {
                    manager = new DataBaseManager();
                }
            }
        }
        return manager;
    }
    public void insert(UserInfo userInfo){
        //利用观察者模式通知观察者
        observable.notifyObservers(userInfo);

    }
    public void register(Observer<UserInfo> userInfoObserver){
        observable.register(userInfoObserver);
    }
    public void unRegister(Observer<UserInfo> userInfoObserver){
        observable.unRegister(userInfoObserver);
    }

}
