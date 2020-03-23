package com.xcp.designpatterns.mvp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xcp.designpatterns.R;
import com.xcp.designpatterns.base.BaseActivity;
import com.xcp.designpatterns.utils.recycleview.BaseAdapter;
import com.xcp.designpatterns.utils.recycleview.WrapRecycleview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 在mvp里代表view层，它含有一个presenter成员变量，通常view需要实现一个逻辑接口，将view上的操作转交给presenter去进行实现，最后presenter调用view逻辑接口将结果返回给view元素
 */
public class MVPActivity extends BaseActivity<ArticleViewInterface, ArticlePresenter> implements ArticleViewInterface {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recycleview)
    WrapRecycleview recycleview;
    private List<String> datas;
    private BaseAdapter<String> articleAdapter;

    @Override
    protected ArticlePresenter getPresenter() {
        return new ArticlePresenter();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {


    }

    @Override
    protected void initData() {
        datas = new ArrayList<>();
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        articleAdapter = new BaseAdapter<String>(this, datas, R.layout.item_article) {
            @Override
            public void convert(ViewHolder holder, List<String> datas, int position) {
                holder.setText(R.id.tv_article, datas.get(position));
            }
        };
        recycleview.setAdapter(articleAdapter);

        basePresenter.fetchArticles();
    }

    @Override
    protected void initListener() {
        articleAdapter.setOnItemClickListener(new BaseAdapter.ItemClickListener() {
            @Override
            public void onClick(int positon) {
                Toast.makeText(MVPActivity.this, datas.get(positon), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showArticle(List<String> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        articleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
