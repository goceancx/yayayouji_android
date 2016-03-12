package com.yayayouji.main;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.yayayouji.R;

/**
 * Created by oceancx on 16/3/11.
 */
public class QuestionMainLayout extends CoordinatorLayout {

    int[] qmIds = {R.id.qm_title_tv, R.id.qm_card_ll, R.id.qm_rv};
    int fab_id = R.id.qm_fab, qm_blue_bg = R.id.qm_blue_bg;
    View[] views = new View[3];
    boolean first = true;
    boolean secFirst = true;
    boolean thirdFirst = true;

    public QuestionMainLayout(Context context) {
        super(context);
    }

    public QuestionMainLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public QuestionMainLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        int[] tops = new int[3];
        for (int i = 0; i < 3; i++) {
            views[i] = findViewById(qmIds[i]);
            if (i > 0) {
                tops[i] = tops[i - 1] + views[i - 1].getMeasuredHeight();
            } else {
                tops[0] = findViewById(R.id.qm_toolbar).getMeasuredHeight();
            }

            if (i == 2) {
                views[i].offsetTopAndBottom(tops[0]);
                views[i].setPadding(0, tops[i] - tops[0] + 48, 0, 0);
                if (first) {
                    RecyclerView rv = (RecyclerView) views[i];
                    rv.scrollToPosition(0);
                    first = false;
                }
            } else {
                views[i].offsetTopAndBottom(tops[i]);
            }
        }

        for (int i = 2; i >= 1; i--) {
            if (i == 1 && secFirst) {
                secFirst = false;
                views[i].layout(views[i].getLeft(), views[i].getTop() + views[i].getPaddingTop(), views[i].getRight(), views[i].getBottom());
            }
            if (i == 2 && thirdFirst) {
                thirdFirst = false;
                views[i].layout(views[i].getLeft(), views[i].getTop() + views[i].getPaddingTop(), views[i].getRight(), views[i].getBottom());
            }
        }
    }


}
