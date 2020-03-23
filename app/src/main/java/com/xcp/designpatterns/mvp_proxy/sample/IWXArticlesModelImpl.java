package com.xcp.designpatterns.mvp_proxy.sample;

import com.xcp.designpatterns.mvp_proxy.ErrorInfo;
import com.xcp.designpatterns.mvp_proxy.MySubscriber;
import com.xcp.designpatterns.mvp_proxy.ResponseCallBack;
import com.xcp.designpatterns.mvp_proxy.RetrofitClient;
import com.xcp.designpatterns.mvp_proxy.WXArticlesBean;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 许成谱 on 2019/6/17 15:31.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class IWXArticlesModelImpl implements WXArticleContract.IWXArticleM {

    @Override
    public void getArticles(final ResponseCallBack response) {
        RetrofitClient.getServiceApi()
                .getWXArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MySubscriber(new ResponseCallBack<List<WXArticlesBean>>() {
                    @Override
                    public void onError(ErrorInfo errorInfo) {
                        response.onError(errorInfo);
                    }

                    @Override
                    public void onSuccess(List<WXArticlesBean> result) {
                        response.onSuccess(result);
                    }


                    @Override
                    public void onBizError(ErrorInfo errorInfo) {
                        response.onBizError(errorInfo);
                    }
                }));
    }
}
