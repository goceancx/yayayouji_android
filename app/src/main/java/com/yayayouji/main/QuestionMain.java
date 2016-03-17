package com.yayayouji.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yayayouji.R;
import com.yayayouji.base.BaseActivity;

/**
 * Created by oceancx on 16/3/6.
 */
public class QuestionMain extends BaseActivity {

    ActionBar ab;
    String title = "我想买一套FRESH，T字部位出油脱皮，两颊皮薄，毛孔有点大，应该买什么系列的？";
    Button qm_card_ll_focus_bt;

    private Toolbar qm_toolbar;
    private RecyclerView qm_rv;
    private QuestionMainAdapter mAdapter;
    private LinearLayout qm_card_ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_main_aty);
        qm_toolbar = (Toolbar) findViewById(R.id.qm_toolbar);

        setSupportActionBar(qm_toolbar);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);

        qm_rv = (RecyclerView) findViewById(R.id.qm_rv);
        mAdapter = new QuestionMainAdapter();
        qm_rv.setLayoutManager(new LinearLayoutManager(this));
        qm_rv.setAdapter(mAdapter);


        qm_card_ll = (LinearLayout) findViewById(R.id.qm_card_ll);
        qm_card_ll_focus_bt = (Button) findViewById(R.id.qm_card_ll_focus_bt);
        final TextView tv = (TextView) qm_card_ll.findViewById(R.id.qm_card_ll_tv);
        String content = getString(R.string.qm_content);
        final String ori = tv.getText().toString();


        qm_card_ll_focus_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.question_main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
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
