package com.yayayouji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;


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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);


    }
}
