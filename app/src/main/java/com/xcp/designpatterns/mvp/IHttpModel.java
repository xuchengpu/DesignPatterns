package com.xcp.designpatterns.mvp;

import java.util.List;

/**
 * Created by 许成谱 on 2018/10/27 15:52.
 * qq:1550540124
 * 热爱生活每一天！
 */
public interface IHttpModel {
    void request(DataListener<List<String>> listener);
}
