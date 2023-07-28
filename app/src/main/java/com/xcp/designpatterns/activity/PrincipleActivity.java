package com.xcp.designpatterns.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.xcp.designpatterns.R;
import com.xcp.designpatterns.R2;
import com.xcp.designpatterns.base.BaseActivity;
import com.xcp.designpatterns.mvp.BasePresenter;
import com.xcp.designpatterns.principle.openclose.DiskCache;
import com.xcp.designpatterns.principle.openclose.DoubleCache;
import com.xcp.designpatterns.principle.openclose.ImageLoader;
import com.xcp.designpatterns.principle.openclose.MemoryCache;

import butterknife.BindView;

public class PrincipleActivity extends BaseActivity {

    @BindView(R2.id.iv_principle)
    ImageView ivPrinciple;
    private String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540213554705&di=8027086a3a638c20e8df937171194e7c&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201409%2F02%2F20140902073153_tSmie.jpeg";

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_principle;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        //没有设计模式时
        ImageLoader imageLoader=new ImageLoader();
        imageLoader.setImageCache(new MemoryCache());//内存缓存
        imageLoader.setImageCache(new DiskCache(this));//磁盘缓存
        imageLoader.setImageCache(new DoubleCache(this));//双缓存
//        imageLoader.setImageCache(new ImageCache() {//用户自己实现自己的缓存
//            @Override
//            public Bitmap get(String key) {
//                return null;
//            }
//
//            @Override
//            public void put(String key, Bitmap bitmap) {
//
//            }
//        });
        imageLoader.displayImage(url,ivPrinciple);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
