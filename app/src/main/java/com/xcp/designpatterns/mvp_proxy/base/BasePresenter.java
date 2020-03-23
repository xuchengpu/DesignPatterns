package com.xcp.designpatterns.mvp_proxy.base;

import com.xcp.designpatterns.mvp_proxy.model_proxy.ModelProxy;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 许成谱 on 2019/6/17 10:06.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class BasePresenter<V extends BaseView> {

    private SoftReference<V> mView;
    private ModelProxy modelProxy;
    private V viewProxy;


    public BasePresenter() {
        modelProxy =new ModelProxy<>(this);
        modelProxy.createModels();
    }

    public void attach(V view) {
        mView = new SoftReference<V>(view);
        //使用动态代理，实现每次调用之前判空
        viewProxy= (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                V v = mView.get();
                if(v!=null) {
                   return method.invoke(v,args);
                }
                return null;
            }
        });
    }

    public void Detach() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }

    }

    public V getView() {
        return viewProxy;
    }
}
