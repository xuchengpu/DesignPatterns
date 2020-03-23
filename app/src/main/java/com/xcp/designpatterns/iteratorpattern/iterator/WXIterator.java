package com.xcp.designpatterns.iteratorpattern.iterator;

import java.util.List;

/**
 * Created by 许成谱 on 2019/6/19 11:51.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class WXIterator implements IIterator<UserInfo> {
    private List<UserInfo> mUserInfos;
    private int index = 0;

    public WXIterator(List<UserInfo> userInfos) {
        this.mUserInfos = userInfos;
    }

    @Override
    public UserInfo next() {
        return mUserInfos.get(index++);
    }

    @Override
    public boolean hasNext() {

        return index < mUserInfos.size();
    }
}
