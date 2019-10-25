package com.science.com.rchs.view.activity_bill;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;

public class RefundMoneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refund_money);

        StatusBarUtil.setRootViewFitsSystemWindows(RefundMoneyActivity.this,true);
        StatusBarUtil.setTranslucentStatus(RefundMoneyActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(RefundMoneyActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(RefundMoneyActivity.this,0x55000000);
        }
    }
}
