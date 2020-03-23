package com.xcp.designpatterns.mvp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2018/10/27 14:38.
 * qq:1550540124
 * 热爱生活每一天！
 * 对于一个结构化的app来说，model角色主要是提供数据的存储功能。
 * presenter需要通过model层存储、获取数据，model就像是一个数据仓库。更直白的说，model是封装了数据库DAO或者网络获取数据的角色，或者两种数据获取方式的集合。
 */
public class ArticleModelImpl implements ArticleModel<List<String>> {
    private List<String> mCacheArticle;

    public ArticleModelImpl() {
        this.mCacheArticle = new ArrayList<>();
    }

    @Override
    public void saveArticles(List<String> datas) {
        mCacheArticle.addAll(datas);
    }

    @Override
    public void getArticlesFromCache(DataListener<List<String>> listener) {
        listener.onComplete(mCacheArticle);
    }
}
