package com.yayayouji.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yayayouji.R;
import com.yayayouji.base.BaseActivity;

/**
 * Created by oceancx on 16/3/6.
 */
public class QuestionMain extends BaseActivity {


    private Toolbar qm_toolbar;
    private RecyclerView qm_rv;
    private QuestionMainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_main_aty);
        qm_toolbar = (Toolbar) findViewById(R.id.qm_toolbar);

        setSupportActionBar(qm_toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setTitle("");

        qm_rv = (RecyclerView) findViewById(R.id.qm_rv);
        mAdapter = new QuestionMainAdapter();
        qm_rv.setLayoutManager(new LinearLayoutManager(this));
        qm_rv.setAdapter(mAdapter);
    }

    private class VH extends RecyclerView.ViewHolder {


        public VH(View itemView) {
            super(itemView);
        }
    }

    private class QuestionMainAdapter extends RecyclerView.Adapter<VH> {
        @Override
        public VH onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.qm_card_item, parent, false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(VH holder, int position) {
            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = (int) v.getTag();
                    /**
                     * 进入问题详情页
                     */
                    Intent intent = new Intent(QuestionMain.this, HomePageCardDetail.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }
}
