package com.science.com.rchs.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;

public class Ti_fActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti_f);
        StatusBarUtil.setRootViewFitsSystemWindows(Ti_fActivity.this,true);
        StatusBarUtil.setTranslucentStatus(Ti_fActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(Ti_fActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(Ti_fActivity.this,0x55000000);
        }

        Button button = findViewById(R.id.mlogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
