package com.xcp.designpatterns.mvp_proxy.sample;

import com.xcp.designpatterns.mvp_proxy.ErrorInfo;
import com.xcp.designpatterns.mvp_proxy.ResponseCallBack;
import com.xcp.designpatterns.mvp_proxy.base.BaseModel;
import com.xcp.designpatterns.mvp_proxy.base.BaseView;

/**
 * Created by 许成谱 on 2019/6/17 10:08.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class WXArticleContract {
    public interface IWXArticleV<T> extends BaseView {
        void onLoading();

        void onError(ErrorInfo errorInfo);

        void onSuccess(T data);

        void stopLoading();
    }

    public interface IWXArticleM extends BaseModel {
        void getArticles(ResponseCallBack response);
    }

    public interface IWXArticleP {
        void getArticles();
    }
}
