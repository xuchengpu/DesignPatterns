package com.xcp.designpatterns.mvp;

/**
 * Created by 许成谱 on 2018/10/27 14:37.
 * qq:1550540124
 * 热爱生活每一天！
 * 存储文章的接口
 */
public interface ArticleModel<T> {
    void saveArticles(T datas);
    void getArticlesFromCache(DataListener<T> listener);
}
