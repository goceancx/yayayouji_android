package com.yayayouji.module.travelnote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.yayayouji.R;

import java.util.ArrayList;

/**
 * 2015年10月24日01:04:48
 * 万事开头难 做个好App
 * <p/>
 * 首页 要做的事情就是提供各个模块的入口
 * 但是游记模块是主模块 因此还要有游记模块的功能
 * 游记模块主要是记录东西
 * 因此要有搜索
 * 有数据列表
 * 有详情
 * 有编辑页
 */
public class YYTravelNote extends AppCompatActivity {


    Toolbar toolbar;
    RecyclerView travelNotes_rv;
    TravelNotesAdapter tnAdapter;
    ArrayList<TravelNote> TravelNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travelnote);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimaryTextIcon));
        toolbar.setTitle(R.string.travelnote);


        travelNotes_rv = (RecyclerView) findViewById(R.id.travelnotes_rv);
        travelNotes_rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        travelNotes_rv.setAdapter(tnAdapter);


    }

    private class TravelNotesAdapter extends RecyclerView.Adapter<TravelNoteVH> {
        @Override
        public TravelNoteVH onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(TravelNoteVH holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    private class TravelNoteVH extends RecyclerView.ViewHolder {
        public TravelNoteVH(View itemView) {
            super(itemView);
        }
    }
}
