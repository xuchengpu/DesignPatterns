package com.xcp.designpatterns.singleinstance;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 许成谱 on 2018/10/26 13:45.
 * qq:1550540124
 * 热爱生活每一天！
 * 单例模式
 */
public class SingleInstance {

}

//饿汉式
class EHan {
    private static EHan mEHan = new EHan();

    private EHan() {

    }

    public static EHan getInstance() {
        return mEHan;
    }
}

//懒汉式
class LanHan {
    private static volatile LanHan mLanHan;//volatile主要是避免编译指令乱序执行问题

    private LanHan() {

    }

    public static LanHan getInstance() {
        if (mLanHan == null) {
            synchronized (LanHan.class) {
                if (mLanHan == null) {
                    mLanHan = new LanHan();
                }
            }
        }
        return mLanHan;
    }

}

//静态内部类式 推荐使用
class Manager {

    private Manager() {
    }

    public static Manager getInstance() {//静态方法是第一次调用的时候才会加载，而静态变量是类加载时就加载
        return Holder.mManager;
    }

    private static class Holder {
        private static Manager mManager = new Manager();
    }
}

//枚举 稍占内存
enum SingleEnum {
    SINGLE_INSTANCE;
}

//使用容器的方式
class SingletonManager {
    private SingletonManager() {
    }

    private static Map<String, Object> container = new HashMap<String, Object>();

    public static void putInstance(String key, Object object) {
        if (!container.containsKey(key)) {
            container.put(key, object);
        }
    }

    public static Object getInstance(String key) {
        return container.get(key);
    }
}
//容器式2
class SingleContainer {
    private static Map<String,Object> container=new HashMap<>();
    private SingleContainer(){

    }
     static {
        container.put("ActivityManager",new SingleContainer());
    }
    public static <T> T getService(Object key){
    return (T) container.get(key);
    }
}
//容器类-衍生
class SingleContainer2 {
    private static SingleContainer2 singleContainer2;
    private SingleContainer2(){

    }
     static {
         singleContainer2=new SingleContainer2();
    }
    public static SingleContainer2 getService(Object key){
    return singleContainer2;
    }
}


