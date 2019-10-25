package com.science.com.rchs.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.science.com.rchs.R;
import com.science.com.rchs.http.UserManage;
import com.science.com.rchs.net.StatusBarUtil;

public class SplashActivity extends AppCompatActivity {

    private static final int GO_HOME = 0;//去主页
    private static final int GO_LOGIN = 1;//去登录页


    /**
     * 跳转判断
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME://去主页
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case GO_LOGIN://去登录页
                    Intent intent2 = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent2);
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        StatusBarUtil.setRootViewFitsSystemWindows(SplashActivity.this, true);
        StatusBarUtil.setTranslucentStatus(SplashActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(SplashActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(SplashActivity.this, 0x55000000);
        }

        if (UserManage.getInstance().hasUserInfo(this))//自动登录判断，SharePrefences中有数据，则跳转到主页，没数据则跳转到登录页
        {
            mHandler.sendEmptyMessageDelayed(GO_HOME, 3000);
        } else {
            mHandler.sendEmptyMessageAtTime(GO_LOGIN, 3000);
        }
    }
}
