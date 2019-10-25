package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;


public class DeleteCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplie);

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(DeleteCodeActivity.this,true);
        StatusBarUtil.setTranslucentStatus(DeleteCodeActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(DeleteCodeActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(DeleteCodeActivity.this,0x55000000);
        }
    }
}
