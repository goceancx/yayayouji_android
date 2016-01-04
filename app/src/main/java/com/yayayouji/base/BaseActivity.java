package com.yayayouji.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by oceancx on 15/10/24.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
