package com.xcp.designpatterns.mvp_proxy.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.xcp.designpatterns.mvp_proxy.presenter_proxy.IActivityPresenterProxyImpl;

/**
 * Created by 许成谱 on 2019/6/17 9:13.
 * qq:1550540124
 * 热爱生活每一天！
 * 可创建多个presenter
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private IActivityPresenterProxyImpl proxy;//绑定解绑等操作封装到代理类中

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        proxy = new IActivityPresenterProxyImpl(this);
        proxy.attach();
        initView();
        initData();
        initListener();
    }

    protected abstract int getContentView();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initListener();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        proxy.detach();
    }
}
