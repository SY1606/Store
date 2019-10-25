package com.science.com.rchs.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.science.com.rchs.R;
import com.science.com.rchs.keyword.SwitchButton;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class StarPayActivity extends AppCompatActivity {

    @BindView(R.id.tixain)
    RelativeLayout tixain;
    @BindView(R.id.query)
    RelativeLayout query;
    @BindView(R.id.zz)
    TextView zz;
    @BindView(R.id.hh)
    TextView hh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_pay);
        ButterKnife.bind(this);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(StarPayActivity.this, true);
        StatusBarUtil.setTranslucentStatus(StarPayActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(StarPayActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(StarPayActivity.this, 0x55000000);
        }
        tixain = findViewById(R.id.tixain);
        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SwitchButton switchButton = findViewById(R.id.switchButton);


        /*switchButton.setOnToggleChanged(new SwitchButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                ToastUtil.showToast(StarPayActivity.this,"开启",Toast.LENGTH_SHORT);
            }
        });*/
        switchButton.setOnToggleChanged(new SwitchButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean off) {
                hh.setVisibility(View.VISIBLE);
                zz.setVisibility(View.GONE);
                tixain.setVisibility(View.GONE);            }
        });


        /*swithcButton = findViewById(R.id.swithcButton);
        swithcButton.setSwitchListener(new SwitchView_Super.SwitchListener() {
            @Override
            public void close() {
                //Toast.makeText(StarPayActivity.this, "关闭", Toast.LENGTH_SHORT).show();
                hh.setVisibility(View.VISIBLE);
                zz.setVisibility(View.GONE);
                tixain.setVisibility(View.GONE);
            }

            @Override
            public void open() {
                //Toast.makeText(StarPayActivity.this, "开启", Toast.LENGTH_SHORT).show();
                zz.setVisibility(View.VISIBLE);
                hh.setVisibility(View.GONE);
                tixain.setVisibility(View.VISIBLE);
            }
        });*/
    }

    @OnClick({R.id.tixain, R.id.query})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tixain:
                Intent intent = new Intent(StarPayActivity.this, TixianActivity.class);
                startActivity(intent);
                break;
            case R.id.query:
                Intent intent1 = new Intent(StarPayActivity.this, T_QueryActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
