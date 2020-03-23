package com.xcp.designpatterns.iteratorpattern.iterator;

/**
 * Created by 许成谱 on 2019/6/19 11:49.
 * qq:1550540124
 * 热爱生活每一天！
 * 迭代器统一规范
 */
public interface IIterator<T> {

    T next();

    boolean hasNext();
}
