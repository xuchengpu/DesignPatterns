package com.xcp.designpatterns.adapter;

import android.content.Context;

import com.xcp.designpatterns.R;
import com.xcp.designpatterns.utils.recycleview.BaseAdapter;

import java.util.List;

/**
 * Created by 许成谱 on 2018/10/22 17:15.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class ChapterAdapter extends BaseAdapter<String> {


    public ChapterAdapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, List<String> datas, int position) {
        holder.setText(R.id.tv_chapter, datas.get(position));
    }

}
