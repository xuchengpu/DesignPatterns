package com.xcp.designpatterns.chainpattern;

/**
 * Created by 许成谱 on 2019/6/19 11:19.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class QQSystem extends Handler<UserInfo>{
    private UserInfo[] userInfos;

    public QQSystem() {
        this.userInfos = new UserInfo[3];
        userInfos[0]=new UserInfo("赵六","123456",12);
        userInfos[1]=new UserInfo("田七","123456",18);
        userInfos[2]=new UserInfo("郑八","123456",22);
    }


    @Override
    public UserInfo handleRequest(String name, String password) {
        for (UserInfo userInfo : userInfos) {
            if (userInfo.getmName().equals(name) && userInfo.getmPassWord().equals(password)) {
                return userInfo;
            }
        }
        //当自己处理过后或者自己处理不了时，交给下一个处理者
        if(nextHanler!=null) {
            return nextHanler.handleRequest(name,password);
        }
        //最后没有处理者时就走到这里最终的一步
        return null;
    }
}
