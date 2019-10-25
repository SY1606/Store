package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;


public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(RecordActivity.this,true);
        StatusBarUtil.setTranslucentStatus(RecordActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(RecordActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(RecordActivity.this,0x55000000);
        }
    }
}
