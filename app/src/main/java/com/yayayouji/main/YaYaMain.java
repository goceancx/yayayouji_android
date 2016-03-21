package com.yayayouji.main;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yayayouji.R;
import com.yayayouji.base.BaseActivity;

/**
 * 丫丫首页
 * <p/>
 * 各个模块都是Activity
 * Created by oceancx on 16/3/20.
 */
public class YaYaMain extends BaseActivity {


    String[] imgUrls = {
            "http://file12.mafengwo.net/M00/9F/C9/wKgBpU4dhneBIobOAAoG55h1z3M18.groupinfo.w310.jpeg",
            "http://file20.mafengwo.net/M00/53/1C/wKgB3FGm0_KAAb0jAAsiMNT3qxk91.groupinfo.w310.jpeg",
            "http://file21.mafengwo.net/M00/84/A7/wKgB3FDDBtiAVy4eAAYWxt_hcCI30.groupinfo.w310.jpeg",
            "http://file8.mafengwo.net/M00/5B/53/wKgByU-wzDyDnPtKAAV5PZnbn5E13.groupinfo.w310.jpeg",
            "http://file20.mafengwo.net/M00/56/86/wKgB3FCnYfSAakS4AEDJhY9X1uY78.groupinfo.w310.jpeg",
            "http://file2.mafengwo.net/M00/F0/20/wKgBm04aKIebqGk-AAO_gCGGYd446.groupinfo.w310.jpeg",
            "http://file7.mafengwo.net/M00/35/02/wKgByU_y59O-tALrAAnjKaOeV8A92.groupinfo.w310.jpeg",
            "http://file25.mafengwo.net/M00/00/C0/wKgB4lL1Cf-AfYmCAAiYubWpl_477.groupinfo.w310.jpeg",
            "http://file21.mafengwo.net/M00/F5/A9/wKgB3FCXWPWAPm-sAAsuXZDHX9I53.groupinfo.w310.jpeg",
            "http://file4.mafengwo.net/M00/62/DB/wKgBm04Y_87Yc7tzAAGHhkE54og84.groupinfo.w310.jpeg",
            "http://file26.mafengwo.net/M00/38/EB/wKgB4lKmoyOAdJwWAAyyRmElAAY57.groupinfo.w310.jpeg",
            "http://file21.mafengwo.net/M00/EB/ED/wKgB21B0QATdrQ4-AAa9V_96uas78.groupinfo.w310.jpeg",
            "http://file21.mafengwo.net/M00/09/A9/wKgB3FGQec2AS-h_AAeihwnYS0s27.groupinfo.w310.jpeg",
            "http://file11.mafengwo.net/M00/88/92/wKgBpU5vqrqzYZA2AADAVWvzNbQ83.groupinfo.w310.jpeg",
            "http://file5.mafengwo.net/M00/93/3A/wKgBjE8JK4SXf8qzAAJarVYv5FQ06.groupinfo.w310.jpeg",
            "http://file21.mafengwo.net/M00/3F/DF/wKgB21BhzeLuPpMqAANYKIcG8rY42.groupinfo.w310.jpeg",
            "http://file20.mafengwo.net/M00/EB/F6/wKgB21B0QAbQEM5hAAPrmtdMmAM50.groupinfo.w310.jpeg",
            "http://file26.mafengwo.net/M00/C2/A7/wKgB4lL01xaATftwAB3UyYP1EAo031.groupinfo.w310.gif",
            "http://file20.mafengwo.net/M00/AB/D6/wKgB3FE6tyuAIAKOABIwyEpGtIo08.groupinfo.w310.jpeg",
            "http://file26.mafengwo.net/M00/BA/E5/wKgB4lOaYk-APVAIAADv55bSLfU73.groupinfo.w310.jpeg"
    };
    ActionBarDrawerToggle mDrawerToggle;
    Toolbar ym_toolbar;

    RecyclerView yaya_main_rv;
    boolean once = false;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yaya_main_aty);

        ym_toolbar = (Toolbar) findViewById(R.id.ym_toolbar);
        initTitle(ym_toolbar);

        setUpDrawerToggle();

        yaya_main_rv = (RecyclerView) findViewById(R.id.yaya_main_rv);
        final YaYaMainRecyclerAdapter adapter = new YaYaMainRecyclerAdapter();
        yaya_main_rv.setAdapter(adapter);
        yaya_main_rv.setLayoutManager(new LinearLayoutManager(this));

        pager = (ViewPager) findViewById(R.id.header_pager);
        pager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgUrls.length;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView im = new ImageView(container.getContext());
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                container.addView(im, params);
                im.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(container.getContext()).load(imgUrls[position]).into(im);
                return im;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((ImageView) object);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return true;
            }
        });

//        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.ym_collapsingtoolbar);
//        collapsingToolbarLayout.setTitleEnabled(false);
//        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.ym_appbar);
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            boolean isShow = false;
//            int scrollRange = -1;
//
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (scrollRange == -1) {
//                    scrollRange = appBarLayout.getTotalScrollRange();
//                }
//                if (scrollRange + verticalOffset == 0) {
//                    collapsingToolbarLayout.setTitle("首页");
//
//                    isShow = true;
//                } else if (isShow) {
//                    collapsingToolbarLayout.setTitle("");
//                    isShow = false;
//                }
//            }
//        });


    }

    private void setUpDrawerToggle() {
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.ym_drawer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, ym_toolbar,
                R.string.travelnote,
                R.string.travelnote) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void initTitle(Toolbar toolbar) {
        toolbar.setTitle("首页");
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayShowHomeEnabled(true);
        ab.setHomeButtonEnabled(true);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ym_menu, menu);
        return true;
    }


    private class YaYaMainRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


        Context context;
        private int TYPE_HEADER = 1;

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            context = parent.getContext();
            View view = LayoutInflater.from(context).inflate(R.layout.yaya_main_item, parent, false);
            return new VH(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//             holder.image

            VH vh = (VH) holder;
            Glide.with(context).load(imgUrls[position]).into(vh.image);
        }

        @Override
        public int getItemCount() {
            return imgUrls.length;
        }
    }

    private class VH extends RecyclerView.ViewHolder {
        ImageView image;

        public VH(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.picture_img);
        }
    }
}
