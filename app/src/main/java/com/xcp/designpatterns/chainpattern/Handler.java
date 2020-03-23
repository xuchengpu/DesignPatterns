package com.xcp.designpatterns.chainpattern;

/**
 * Created by 许成谱 on 2019/6/19 16:19.
 * qq:1550540124
 * 热爱生活每一天！
 * 切记，责任链提现的是一种层层传递的思想，切勿生搬硬套。
 * 本例中的泛型 及handleRequest的形参返回值等都是可以灵活调节的
 */
public abstract class Handler<T> {
    protected Handler<T> nextHanler;

    public abstract T handleRequest(String name, String password);
}
