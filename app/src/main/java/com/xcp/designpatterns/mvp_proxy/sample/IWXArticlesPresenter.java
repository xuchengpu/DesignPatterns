package com.xcp.designpatterns.mvp_proxy.sample;

import com.xcp.designpatterns.mvp_proxy.ErrorInfo;
import com.xcp.designpatterns.mvp_proxy.Inject;
import com.xcp.designpatterns.mvp_proxy.ResponseCallBack;
import com.xcp.designpatterns.mvp_proxy.WXArticlesBean;
import com.xcp.designpatterns.mvp_proxy.base.BasePresenter;

import java.util.List;

/**
 * Created by 许成谱 on 2019/6/17 10:57.
 * qq:1550540124
 * 热爱生活每一天！
 * 可创建多个model
 */
public class IWXArticlesPresenter extends BasePresenter<WXArticleContract.IWXArticleV> implements WXArticleContract.IWXArticleP {
    @Inject
    private IWXArticlesModelImpl model;
    @Inject
    private IWXArticlesModelImpl model2;

    @Override
    public void getArticles() {
        model.getArticles(new ResponseCallBack<List<WXArticlesBean>>() {
            @Override
            public void onError(ErrorInfo errorInfo) {
                getView().onError(errorInfo);
            }

            @Override
            public void onSuccess(List<WXArticlesBean> result) {
                getView().onSuccess(result);
            }

            @Override
            public void onBizError(ErrorInfo errorInfo) {
                getView().onError(errorInfo);
            }
        });
        model2.getArticles(new ResponseCallBack<List<WXArticlesBean>>() {
            @Override
            public void onError(ErrorInfo errorInfo) {
                getView().onError(errorInfo);
            }

            @Override
            public void onSuccess(List<WXArticlesBean> result) {
                getView().onSuccess(result);
            }

            @Override
            public void onBizError(ErrorInfo errorInfo) {
                getView().onError(errorInfo);
            }
        });
    }
}
