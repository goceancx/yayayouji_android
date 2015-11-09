package com.yayayouji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.yayayouji.global.G;

/**
 * Created by oceancx on 15/10/24.
 * <p/>
 * 此页面摘取 游记 读书 音乐 电影 各种内容 来展示给用户 也叫用户首页
 * <p/>
 * 其他页面可由navView来进入
 */
public class YaYaYouJi extends AppCompatActivity {
    ExpandableListView exlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yayayouji);
        exlv = (ExpandableListView) findViewById(R.id.exlv);
        exlv.setAdapter(new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return G.countryGroup.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return G.countries[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return null;
            }

            @Override
            public Object getChild(int i, int i1) {
                return null;
            }

            @Override
            public long getGroupId(int i) {
                return 0;
            }

            @Override
            public long getChildId(int i, int i1) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                if (view == null)
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_expandable_list_item_1, viewGroup, false);
                TextView view1 = (TextView) view;
                view1.setText(G.countryGroup[i]);
                return view1;
            }

            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                if (view == null)
                    view = LayoutInflater.from(viewGroup.getContext()).inflate(android.R.layout.simple_expandable_list_item_1, viewGroup, false);
                TextView view1 = (TextView) view;
                view1.setText(G.countries[i][i1]);
                return view1;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return false;
            }
        });

    }
}
