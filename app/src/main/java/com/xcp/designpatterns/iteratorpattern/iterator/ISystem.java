package com.xcp.designpatterns.iteratorpattern.iterator;

/**
 * Created by 许成谱 on 2019/6/19 11:48.
 * qq:1550540124
 * 热爱生活每一天！
 * 统一查询系统的规范
 */
public interface ISystem {
    IIterator<UserInfo> iterator();
}
