package com.xcp.designpatterns.iteratorpattern.original;

import java.util.List;

/**
 * Created by 许成谱 on 2019/6/19 10:58.
 * qq:1550540124
 * 热爱生活每一天！
 * 普通的写法
 */
public class Client {
    public static void main(String[] args) {

        UserInfo userInfo = queryWXUserInfo("张三", "123456");
        if (userInfo == null) {
            userInfo = queryQQUserInfo("张三", "123456");
        }
        if (userInfo == null) {
            //登录失败
        }

    }




    //以下两个方法代码结构类似，重复添加显得冗余，因此可考虑用迭代器模式重构
    private static UserInfo queryWXUserInfo(String name, String password) {
        WXSystem wxSystem = new WXSystem();
        List<UserInfo> userInfos = wxSystem.getUserInfos();
        for (UserInfo userInfo : userInfos) {
            if (userInfo.getmName().equals(name) && userInfo.getmPassWord().equals(password)) {
                return userInfo;
            }
        }
        return null;
    }

    private static UserInfo queryQQUserInfo(String name, String password) {
        QQSystem qqSystem = new QQSystem();
        UserInfo[] userInfos = qqSystem.getUserInfos();
        for (UserInfo userInfo : userInfos) {
            if (userInfo.getmName().equals(name) && userInfo.getmPassWord().equals(password)) {
                return userInfo;
            }
        }
        return null;
    }
}
