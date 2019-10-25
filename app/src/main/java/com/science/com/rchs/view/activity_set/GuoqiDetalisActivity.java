package com.science.com.rchs.view.activity_set;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.activity_guest.TimeActivity;


public class GuoqiDetalisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guoqi_detalis);
        StatusBarUtil.setRootViewFitsSystemWindows(GuoqiDetalisActivity.this,true);
        StatusBarUtil.setTranslucentStatus(GuoqiDetalisActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(GuoqiDetalisActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(GuoqiDetalisActivity.this,0x55000000);
        }
    }
}
