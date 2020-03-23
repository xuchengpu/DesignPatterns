package com.xcp.designpatterns.mvp_proxy.sample;

import android.widget.TextView;
import android.widget.Toast;

import com.xcp.designpatterns.R;
import com.xcp.designpatterns.mvp_proxy.ErrorInfo;
import com.xcp.designpatterns.mvp_proxy.Inject;
import com.xcp.designpatterns.mvp_proxy.WXArticlesBean;
import com.xcp.designpatterns.mvp_proxy.base.BaseActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MVPProxyActivity extends BaseActivity implements WXArticleContract.IWXArticleV<List<WXArticlesBean>> {

    @BindView(R.id.tv_response)
    TextView tvResponse;
    @Inject
    private IWXArticlesPresenter presenter;
    @Inject
    private IWXArticlesPresenter presenter2;

    @Override
    protected int getContentView() {
        return R.layout.activity_mvpproxy;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void initData() {
        presenter.getArticles();
        presenter2.getArticles();
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onLoading() {

    }

    @Override
    public void onError(ErrorInfo errorInfo) {
        Toast.makeText(MVPProxyActivity.this, "请求出错："+errorInfo.getErrorMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(List<WXArticlesBean> data) {

        tvResponse.setText(tvResponse.getText()+data.get(0).toString());
    }

    @Override
    public void stopLoading() {

    }
}
