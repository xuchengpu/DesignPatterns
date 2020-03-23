package com.xcp.designpatterns.mvp;

import java.util.List;

/**
 * Created by 许成谱 on 2018/10/27 14:24.
 * qq:1550540124
 * 热爱生活每一天！
 * 中间者：主要作用是沟通view和model的桥梁，它从model层检索数据后，返回给view层，是的view和model层之间没有耦合，也将业务逻辑从view角色上剥离出来。
 * 与view和model之间的通讯都是通过接口进行的。因此，当需求改动时，只要对应的view或者model、presenter实现了相关的接口，一个类改变了，其他两个类可以不变。充分解耦。高扩展。
 */
public class ArticlePresenter extends BasePresenter<ArticleViewInterface> implements IArticlePresenter {
    private ArticleModel articleModel;//在内存中操作的相关model
    private IHttpModel httpModel;
    public ArticlePresenter() {
        articleModel = new ArticleModelImpl();
        httpModel = new HttpModelImpl();
    }

    @Override
    public void fetchArticles() {
        view.showProgress();
        httpModel.request(new DataListener<List<String>>() {
            @Override
            public void onComplete(List<String> strings) {
                view.showArticle(strings);
                view.hideProgress();
                articleModel.saveArticles(strings);
            }
        });
    }

    @Override
    public void getArticlesFromCache() {
        articleModel.getArticlesFromCache(new DataListener<List<String>>() {

            @Override
            public void onComplete(List<String> strings) {
                view.showArticle(strings);
            }
        });
    }
}
