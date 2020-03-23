package com.xcp.designpatterns.mvvm;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/**
 * Created by 许成谱 on 2018/10/30 14:28.
 * qq:1550540124
 * 热爱生活每一天！
 * viewmodel层，为view层提供一个可供其显示的数据模型并且同时搜集处理这些数据
 */
public class LoginModel {
    private static final String DEF_USER = "111", DEF_PASSWORD = "123";
    public final UserInfo mUserInfo = new UserInfo("用户名","密码");
    private final OnLoginListener mListener;

    public LoginModel(OnLoginListener mListener) {
        this.mListener = mListener;
    }

    public interface OnLoginListener {
        void success();

        void fail();
    }

    public TextWatcher getUserTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable user) {
                mUserInfo.setmUser(user.toString().trim());
            }
        };
    }

    public TextWatcher getPasswordTextWatcher() {
        return new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable password) {
                mUserInfo.setmPassword(password.toString().trim());
            }
        };
    }

    public void onLoginClick(View view) {
        if (mUserInfo.getmPassword().equals(DEF_PASSWORD) && mUserInfo.getmUser().equals(DEF_USER)) {
            mListener.success();
        } else {
            mListener.fail();
        }
    }


}
