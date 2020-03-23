package com.xcp.designpatterns.iteratorpattern.original;

/**
 * Created by 许成谱 on 2019/6/19 11:19.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class QQSystem {
    private UserInfo[] userInfos;

    public QQSystem() {
        this.userInfos = new UserInfo[3];
        userInfos[0]=new UserInfo("赵六","123456",12);
        userInfos[1]=new UserInfo("田七","123456",18);
        userInfos[2]=new UserInfo("郑八","123456",22);
    }

    public UserInfo[] getUserInfos() {
        return userInfos;
    }
}
