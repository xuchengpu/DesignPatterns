package com.xcp.designpatterns.mvp;

import java.util.List;

/**
 * Created by 许成谱 on 2018/10/27 14:26.
 * qq:1550540124
 * 热爱生活每一天！
 */
public interface ArticleViewInterface {
    void showArticle(List<String> datas);
    void showProgress();
    void hideProgress();
}
