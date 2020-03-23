package com.xcp.designpatterns.mvp_proxy.presenter_proxy;

import com.xcp.designpatterns.mvp_proxy.base.BaseView;

/**
 * Created by 许成谱 on 2019/6/17 14:47.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class IActivityPresenterProxyImpl<V extends BaseView> extends IPrensenterProxyImpl<V> implements IActivityPresenterProxy {
    public IActivityPresenterProxyImpl(V view) {
        super(view);
    }
}
