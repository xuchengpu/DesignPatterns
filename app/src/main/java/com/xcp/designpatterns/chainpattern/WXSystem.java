package com.xcp.designpatterns.chainpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2019/6/19 11:19.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class WXSystem extends Handler<UserInfo> {
    private List<UserInfo> userInfos;

    public WXSystem() {
        this.userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("张三", "123456", 12));
        userInfos.add(new UserInfo("李四", "123456", 18));
        userInfos.add(new UserInfo("王五", "123456", 22));
    }

    @Override
    public UserInfo handleRequest(String name, String password) {
        for (UserInfo userInfo : userInfos) {
            if (userInfo.getmName().equals(name) && userInfo.getmPassWord().equals(password)) {
                return userInfo;
            }
        }
        //当自己处理过后或者自己处理不了时，交给下一个处理者
        if (nextHanler != null) {
            return nextHanler.handleRequest(name, password);
        }
        //最后没有处理者时就走到这里最终的一步
        return null;
    }
}
