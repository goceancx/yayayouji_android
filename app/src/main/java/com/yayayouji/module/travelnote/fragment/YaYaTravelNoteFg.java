package com.yayayouji.module.travelnote.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yayayouji.R;
import com.yayayouji.base.BaseFragment;
import com.yayayouji.global.YaYaBundleKey;
import com.yayayouji.module.travelnote.YaYaTravelNoteDetail;

/**
 * 游记首页
 * Created by oceancx on 16/3/20.
 */
public class YaYaTravelNoteFg extends BaseFragment {

    RecyclerView yt_rv;
    TravelNoteAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.yaya_travel_note_fg, container, false);
        yt_rv = (RecyclerView) v.findViewById(R.id.yaya_travel_note_fg_rv);
        adapter = new TravelNoteAdapter();
        yt_rv.setAdapter(adapter);
        yt_rv.setLayoutManager(new LinearLayoutManager(yt_rv.getContext()));

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    private void gotoTravelNoteDetailActivity(int pos) {
        Intent intent = new Intent(getActivity(), YaYaTravelNoteDetail.class);
        Bundle bundle = new Bundle();
        bundle.putInt(YaYaBundleKey.POS, pos);
        startActivity(intent, bundle);
    }


    public class TravelNoteAdapter extends RecyclerView.Adapter<TravelNoteAdapter.VH> {

        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.getTag();
                    gotoTravelNoteDetailActivity(pos);
                }
            });
        }


        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yaya_travel_note_card_item, parent, false);
            return new VH(view);
        }

        @Override
        public int getItemCount() {
            return 20;
        }


        public class VH extends RecyclerView.ViewHolder {
            public VH(View itemView) {
                super(itemView);
            }
        }
    }

    class TravelNoteItem {
        private int view_count;
        private String main_image_url;
        private String title;
        private String face_image_url;
        private String face_icon_image_url;
    }


}
