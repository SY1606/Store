package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;
import com.scwang.smartrefresh.layout.api.RefreshContent;

public class ChongActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chong);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(ChongActivity.this,true);
        StatusBarUtil.setTranslucentStatus(ChongActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(ChongActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(ChongActivity.this,0x55000000);
        }
    }

}
