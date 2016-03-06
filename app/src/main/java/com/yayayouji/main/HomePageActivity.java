package com.yayayouji.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yayayouji.R;
import com.yayayouji.base.BaseActivity;

/**
 * Created by oceancx on 16/3/6.
 */
public class HomePageActivity extends BaseActivity {


    RecyclerView home_page_rv;

    HomePageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_aty);

        home_page_rv = (RecyclerView) findViewById(R.id.home_page_rv);
        mAdapter = new HomePageAdapter();
        home_page_rv.setLayoutManager(new LinearLayoutManager(this));
        home_page_rv.setAdapter(mAdapter);

    }


    private class VH extends RecyclerView.ViewHolder {


        public VH(View itemView) {
            super(itemView);
        }
    }

    private class HomePageAdapter extends RecyclerView.Adapter<VH> {
        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_page_card_item, parent, false);
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
}
