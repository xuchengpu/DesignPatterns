package com.xcp.designpatterns.iteratorpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2019/6/19 11:19.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class WXSystem implements ISystem{
    private List<UserInfo> userInfos;

    public WXSystem() {
        this.userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("张三","123456",12));
        userInfos.add(new UserInfo("李四","123456",18));
        userInfos.add(new UserInfo("王五","123456",22));
    }



    @Override
    public IIterator<UserInfo> iterator() {
        return new WXIterator(userInfos);
    }
}
