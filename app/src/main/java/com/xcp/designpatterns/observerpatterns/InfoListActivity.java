package com.xcp.designpatterns.observerpatterns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.xcp.designpatterns.R;

import java.util.ArrayList;
import java.util.List;

public class InfoListActivity extends AppCompatActivity implements Observer<UserInfo> {
    private ListView listView;
    private List<UserInfo> userInfos;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);
        listView = findViewById(R.id.listview);
        userInfos = new ArrayList<>();
        adapter = new MyAdapter();
        listView.setAdapter(adapter);
        DataBaseManager.getManager().register(this);

    }

    public void add(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void updata(UserInfo userInfo) {
        if (adapter != null) {
            userInfos.add(userInfo);
            adapter.notifyDataSetChanged();
        }
    }



    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return userInfos.size();
        }

        @Override
        public Object getItem(int position) {
            return userInfos.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(InfoListActivity.this).inflate(R.layout.item_userinfo, parent, false);
            TextView textView = view.findViewById(R.id.textview);
            textView.setText(userInfos.get(position).getName() + "\n" + userInfos.get(position).getAge());
            return view;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        DataBaseManager.getManager().unRegister(this);
    }
}
