package com.xcp.designpatterns.iteratorpattern.iterator;

/**
 * Created by 许成谱 on 2019/6/19 11:20.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class UserInfo {
    private String mName;
    private String mPassWord;
    private int mAge;

    public UserInfo(String mName, String mPassWord, int mAge) {
        this.mName = mName;
        this.mPassWord = mPassWord;
        this.mAge = mAge;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPassWord() {
        return mPassWord;
    }

    public void setmPassWord(String mPassWord) {
        this.mPassWord = mPassWord;
    }

    public int getmAge() {
        return mAge;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "mName='" + mName + '\'' +
                ", mPassWord='" + mPassWord + '\'' +
                ", mAge=" + mAge +
                '}';
    }
}
