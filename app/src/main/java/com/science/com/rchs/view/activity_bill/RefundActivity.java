package com.science.com.rchs.view.activity_bill;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.activity.T_QueryActivity;


public class RefundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund);

        StatusBarUtil.setRootViewFitsSystemWindows(RefundActivity.this,true);
        StatusBarUtil.setTranslucentStatus(RefundActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(RefundActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(RefundActivity.this,0x55000000);
        }
    }
}
