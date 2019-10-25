package com.science.com.rchs.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;
import com.yzy.voice.VoicePlay;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SuccessActivity extends AppCompatActivity {

    @BindView(R.id.moneys)
    TextView moneys;
    private Button mlogin;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ButterKnife.bind(this);

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(SuccessActivity.this, true);
        StatusBarUtil.setTranslucentStatus(SuccessActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(SuccessActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(SuccessActivity.this, 0x55000000);
        }
        mlogin = findViewById(R.id.mlogin);
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        number = getIntent().getStringExtra("ress");
        moneys.setText("￥"+number + "");
        Log.i("llllll",number+"");
    }
}
