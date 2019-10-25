package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;


public class Success_PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success__pay);

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(Success_PayActivity.this,true);
        StatusBarUtil.setTranslucentStatus(Success_PayActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(Success_PayActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(Success_PayActivity.this,0x55000000);
        }
    }
}
