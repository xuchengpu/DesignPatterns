package com.xcp.designpatterns.mvp_proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 许成谱 on 2019/6/17 12:35.
 * qq:1550540124
 * 热爱生活每一天！
 */
@Target(ElementType.FIELD)//作用于成员变量
@Retention(RetentionPolicy.RUNTIME)//运行时注解，用于反射
public @interface Inject {

}
