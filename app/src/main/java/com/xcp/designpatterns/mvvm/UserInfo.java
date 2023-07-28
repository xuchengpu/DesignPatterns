package com.xcp.designpatterns.mvvm;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.xcp.designpatterns.BR;

/**
 * Created by 许成谱 on 2018/10/30 14:33.
 * qq:1550540124
 * 热爱生活每一天！
 * model层 ：与MVC、MVP一样，主要封装数据存储或操作的一些逻辑，与两者不同的是，model会提供一系列的实体类用作与UI进行绑定，viewmodel
 * 会在修改这些数据后将数据变化告诉view层并使UI刷新
 */
public class UserInfo extends BaseObservable {
    public String mUser;
    public String mPassword;

    public UserInfo(String mUser, String mPassword) {
        this.mUser = mUser;
        this.mPassword = mPassword;
    }

    public UserInfo() {
    }

    @Bindable
    public String getmUser() {
        return mUser;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
        notifyPropertyChanged(BR.mUser);
    }
    @Bindable
    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
        notifyPropertyChanged(BR.mPassword);
    }
}
