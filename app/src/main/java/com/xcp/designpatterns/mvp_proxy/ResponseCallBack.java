package com.xcp.designpatterns.mvp_proxy;

/**
 * Created by 许成谱 on 2019/6/17 15:34.
 * qq:1550540124
 * 热爱生活每一天！
 */
public interface ResponseCallBack<T> {
    void onError(ErrorInfo errorInfo);

    void onSuccess(T result);

    void onBizError(ErrorInfo errorInfo);
}
