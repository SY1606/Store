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

public class Success2Activity extends AppCompatActivity {

    private TextView moneys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success2);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(Success2Activity.this, true);
        StatusBarUtil.setTranslucentStatus(Success2Activity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(Success2Activity.this, true)) {
            StatusBarUtil.setStatusBarColor(Success2Activity.this, 0x55000000);
        }

        moneys = findViewById(R.id.moneys);
      Button mlogin = findViewById(R.id.mlogin);
        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

      String  number = String.valueOf(getIntent().getDoubleExtra("ress",0));
      moneys.setText("￥" + number + "");
        Log.i("llll", number + "");
    }
}
