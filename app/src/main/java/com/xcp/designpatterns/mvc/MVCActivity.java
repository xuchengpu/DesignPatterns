package com.xcp.designpatterns.mvc;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.xcp.designpatterns.R;
import com.xcp.designpatterns.R2;
import com.xcp.designpatterns.base.BaseActivity;
import com.xcp.designpatterns.mvp.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 相当于controller层，负责接收流入的请求，它通过view来接收用户的输入，再通过model去处理用户的数据，然后从model接收处理结果，再传递给view。相当于model和view之间的协调者。
 * R.layout.activity_mvc相当于view层，在java中可以直接与model交互。它是直接面向用户的UI，负责展示从controller层和model层传递过来的数据，也接收用户的输入，交给controller去调动model去处理。
 */
public class MVCActivity extends BaseActivity implements Model.onStateChangedListener {

    @BindView(R2.id.iv_mvc)
    ImageView ivMvc;
    @BindView(R2.id.btn_load)
    Button btnLoad;
    @BindView(R2.id.btn_clear)
    Button btnClear;
    private Model mModel;

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mvc;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        //初始化一些的工作
        mModel = new Model(this);
        mModel.setonStateChangedListener(this);
        ivMvc.setImageBitmap(mModel.getBitmap());

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onStateChanged(Bitmap bitmap) {
        //此处（controller）接收model中的数据，传递给view去显示
        ivMvc.setImageBitmap(bitmap);
    }

    @OnClick({R.id.btn_load, R.id.btn_clear})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_load:
                mModel.loadImage();
                break;
            case R.id.btn_clear:
                mModel.clear();
                break;
        }
    }
}
