package com.xcp.aopdemo;

import android.widget.Toast;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Created by 许成谱 on 2018/12/20 18:17.
 * qq:1550540124
 * 热爱生活每一天！
 * 处理切点
 */
@Aspect
public class CheckNetAspectJ {
    /**
     * 找到处理的切点
     * * *(..)  可以处理所有的方法
     */
    @Pointcut("execution(@com.xcp.aopdemo.CheckNet * *(..))")
    public void checkNetBehavior(){

    }

    /**
     * 处理切面
     * @param joinPoint
     * @return
     */
    @Around("checkNetBehavior()")
    public Object checkNetState(ProceedingJoinPoint joinPoint) throws Throwable {
//        Toast.makeText(MyApplication.getContext(), "跳转到面向切面编程的方法里了", Toast.LENGTH_SHORT).show();
        //1、获取注解
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();
        CheckNet checkNet = signature.getMethod().getAnnotation(CheckNet.class);
        if(checkNet!=null) {
            //2、判断有没有网络
            if(!CheckNetUtil.isNetworkAvailable(MyApplication.getContext())) {
                // 3.没有网络不要往下执行
                Toast.makeText(MyApplication.getContext(),"请检查您的网络",Toast.LENGTH_LONG).show();
                return null;
            }
        }
        return joinPoint.proceed();
    }
}
