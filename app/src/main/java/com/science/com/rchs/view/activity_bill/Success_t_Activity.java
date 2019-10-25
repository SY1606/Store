package com.science.com.rchs.view.activity_bill;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;


public class Success_t_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_t_);

        StatusBarUtil.setRootViewFitsSystemWindows(Success_t_Activity.this,true);
        StatusBarUtil.setTranslucentStatus(Success_t_Activity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(Success_t_Activity.this, true)) {
            StatusBarUtil.setStatusBarColor(Success_t_Activity.this,0x55000000);
        }
    }
}
