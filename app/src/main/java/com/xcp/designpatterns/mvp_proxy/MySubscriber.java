package com.xcp.designpatterns.mvp_proxy;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by 许成谱 on 2019/6/17 16:16.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class MySubscriber<R> implements Observer<RequestResult<R>> {
    protected ResponseCallBack<R> mResponseCallback;

    public MySubscriber(ResponseCallBack responseCallBack) {
        this.mResponseCallback=responseCallBack;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(RequestResult<R> result) {
        if (result.getErrorCode().equals("0")) {
            mResponseCallback.onSuccess(result.getData());
        } else {
            mResponseCallback.onBizError(new ErrorInfo(result.getErrorCode(), result.getErrorMsg()));
        }
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof SocketTimeoutException) {
            mResponseCallback.onError(new ErrorInfo("-1", "网络请求超时，请重试"));
        } else if (e instanceof ConnectException) {
            mResponseCallback.onError(new ErrorInfo("-1", "网络中断，请检查您的网络后重试"));
        } else if (e instanceof NullPointerException) {
            mResponseCallback.onError(new ErrorInfo("-100", "网络错误，请检查您的网络后重试"));
        } else if (e instanceof HttpException) {
            mResponseCallback.onError(new ErrorInfo("-1", "网络中断，请检查您的网络后重试"));
        } else if (e instanceof UnknownHostException) {
            mResponseCallback.onError(new ErrorInfo("-1", "网络错误，请检查您的网络后重试"));
        } else {
            mResponseCallback.onError(new ErrorInfo("-100", e.getMessage()));//先这样
        }
    }

    @Override
    public void onComplete() {

    }
}
