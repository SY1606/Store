package com.science.com.rchs.view.activity;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;
import com.yzy.voice.VoicePlay;


public class Ti_SActivity extends AppCompatActivity {

    private Button mlogin;
    private String number;
    private TextView moneys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ti__s);
        StatusBarUtil.setRootViewFitsSystemWindows(Ti_SActivity.this,true);
        StatusBarUtil.setTranslucentStatus(Ti_SActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(Ti_SActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(Ti_SActivity.this,0x55000000);
        }

        moneys = findViewById(R.id.moneys);
        mlogin = findViewById(R.id.mlogin);
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        double  number = getIntent().getDoubleExtra("ress",0);
        moneys.setText("￥"+number + "");
        Log.i("jyjyjyj",number+"");
    }

}
