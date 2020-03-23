package com.xcp.designpatterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xcp.designpatterns.activity.PrincipleActivity;
import com.xcp.designpatterns.adapter.ChapterAdapter;
import com.xcp.designpatterns.base.BaseActivity;
import com.xcp.designpatterns.mvc.MVCActivity;
import com.xcp.designpatterns.mvp.BasePresenter;
import com.xcp.designpatterns.mvp.MVPActivity;
import com.xcp.designpatterns.mvvm.MVVMActivity;
import com.xcp.designpatterns.utils.recycleview.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.recycleview)
    RecyclerView recyclerView;
    private List<String> chapters;
    private ChapterAdapter chapterAdapter;

    @Override
    protected BasePresenter getPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setData();
        chapterAdapter = new ChapterAdapter(this, chapters, R.layout.item_chapter);
        recyclerView.setAdapter(chapterAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
    }

    private void setData() {
        chapters = new ArrayList<>();
        chapters.add("六大设计原则");
        chapters.add("MVC示例");
        chapters.add("MVP示例");
        chapters.add("MVVM示例");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        chapterAdapter.setOnItemClickListener(new BaseAdapter.ItemClickListener() {
            @Override
            public void onClick(int positon) {
                Class activityClass = null;
                switch (positon) {
                    case 0:
                        activityClass = PrincipleActivity.class;
                        break;
                    case 1:
                        activityClass = MVCActivity.class;
                        break;
                    case 2:
                        activityClass = MVPActivity.class;
                        break;
                    case 3:
                        activityClass = MVVMActivity.class;
                        break;
                }
                if (activityClass != null) {
                    Intent intent = new Intent(MainActivity.this, activityClass);
                    startActivity(intent);
                }

            }
        });
    }
}
