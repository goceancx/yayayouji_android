package com.yayayouji.module.travelnote.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yayayouji.R;
import com.yayayouji.base.BaseFragment;

/**
 * 游记首页
 * Created by oceancx on 16/3/20.
 */
public class YaYaTravelNoteFg extends BaseFragment {


    RecyclerView yt_rv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.yaya_travel_note_fg, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        yt_rv = (RecyclerView) findViewById(R.id.yaya_travel_note_fg_rv);
        yt_rv.setAdapter(new TravelNoteAdapter());
        yt_rv.setLayoutManager(new LinearLayoutManager(getActivity()));


    }

    private class TravelNoteAdapter extends RecyclerView.Adapter<VH> {
        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yaya_travel_note_card_item, parent, false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }


    private class VH extends RecyclerView.ViewHolder {
        public VH(View itemView) {
            super(itemView);
        }
    }
}
