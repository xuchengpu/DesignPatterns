package com.xcp.designpatterns.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by 许成谱 on 2018/10/27 12:19.
 * qq:1550540124
 * 热爱生活每一天！
 * 中间者基类：提供绑定与解绑的方法，实现与view（Activity）生命周期的绑定，使用弱引用，
 * 确保在发生crash时仍然不会产生内存泄露
 */
public abstract class BasePresenter<T> {

    private WeakReference<T> mViewReference;
    protected T view;

    //绑定 对应在oncreate()中调用
    public void attach(T view) {
        mViewReference = new WeakReference<T>(view);
        this.view=mViewReference.get();
    }

    //解绑 对应在ondestory()中调用
    public void detach() {
        if (mViewReference != null) {
            mViewReference.clear();
            mViewReference = null;
        }
    }

    //是否绑定view
    public boolean isAttach() {
        return mViewReference != null && mViewReference.get() != null;
    }
}
