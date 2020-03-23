package com.xcp.designpatterns.iteratorpattern.iterator;

/**
 * Created by 许成谱 on 2019/6/19 11:53.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class QQIterator implements IIterator<UserInfo> {
    private UserInfo[] mUserInfos;
    private int index = 0;

    public QQIterator(UserInfo[] userInfos) {
        this.mUserInfos = userInfos;
    }

    @Override
    public UserInfo next() {
        return mUserInfos[index++];
    }

    @Override
    public boolean hasNext() {

        return index < mUserInfos.length;
    }
}
