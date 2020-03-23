package com.xcp.designpatterns.chainpattern;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 许成谱 on 2019/6/19 11:20.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class UserInfo implements Parcelable {
    private String mName;
    private String mPassWord;
    private int mAge;

    public UserInfo(String mName, String mPassWord, int mAge) {
        this.mName = mName;
        this.mPassWord = mPassWord;
        this.mAge = mAge;
    }

    protected UserInfo(Parcel in) {
        mName = in.readString();
        mPassWord = in.readString();
        mAge = in.readInt();
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mPassWord);
        dest.writeInt(mAge);
    }
}
