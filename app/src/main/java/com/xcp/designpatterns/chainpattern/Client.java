package com.xcp.designpatterns.chainpattern;

/**
 * Created by 许成谱 on 2019/6/19 10:58.
 * qq:1550540124
 * 热爱生活每一天！
 * 责任链设计模式
 * 角色：抽象处理者--Handler
 *      具体处理者--WXSystem、QQSystem、RongYaoSystem
 */
public class Client {
    public static void main(String[] args) {
        WXSystem wxSystem = new WXSystem();
        QQSystem qqSystem = new QQSystem();
        RongYaoSystem rongYaoSystem = new RongYaoSystem();
        //设置下一任处理者
        wxSystem.nextHanler=qqSystem;
        qqSystem.nextHanler=rongYaoSystem;

        UserInfo userInfo = wxSystem.handleRequest("TOM", "123456");
        System.out.print(userInfo);
    }
}
