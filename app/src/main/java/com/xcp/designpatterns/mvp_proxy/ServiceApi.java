package com.xcp.designpatterns.mvp_proxy;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 许成谱 on 2019/6/17 11:18.
 * qq:1550540124
 * 热爱生活每一天！
 */
public interface ServiceApi {
    @GET("wxarticle/chapters/json")
    Observable<RequestResult<List<WXArticlesBean>>> getWXArticles();
}
