package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(MainActivity.this,true);
        StatusBarUtil.setTranslucentStatus(MainActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(MainActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(MainActivity.this,0x55000000);
        }

    }
}
