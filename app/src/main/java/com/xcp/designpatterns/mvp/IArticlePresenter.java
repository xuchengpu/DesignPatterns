package com.xcp.designpatterns.mvp;

/**
 * Created by 许成谱 on 2018/10/27 15:32.
 * qq:1550540124
 * 热爱生活每一天！
 */
public interface IArticlePresenter {
    //从网络获取文章
    void fetchArticles();

    //从磁盘加载文章
    void getArticlesFromCache();

}
