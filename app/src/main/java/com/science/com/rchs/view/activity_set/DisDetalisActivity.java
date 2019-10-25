package com.science.com.rchs.view.activity_set;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Xinxi;
import com.science.com.rchs.di.contract.XinxiContract;
import com.science.com.rchs.di.presenter.XinxiPresenter;
import com.science.com.rchs.net.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DisDetalisActivity extends AppCompatActivity implements XinxiContract.XinxiView {

    @BindView(R.id.qaun)
    TextView qaun;
    @BindView(R.id.man)
    TextView man;
    @BindView(R.id.youxiaoqi)
    TextView youxiaoqi;
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.numbers)
    TextView numbers;
    @BindView(R.id.numbers1)
    TextView numbers1;
    @BindView(R.id.numbers2)
    TextView numbers2;
    private XinxiContract.XinxiPresenter xinxiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis_detalis);
        ButterKnife.bind(this);
        StatusBarUtil.setRootViewFitsSystemWindows(DisDetalisActivity.this, true);
        StatusBarUtil.setTranslucentStatus(DisDetalisActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(DisDetalisActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(DisDetalisActivity.this, 0x55000000);
        }

        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        man.setText(name);
        String coupon_id = intent.getStringExtra("coupon_id");

        xinxiPresenter = new XinxiPresenter();
        xinxiPresenter.attachView(this);
        xinxiPresenter.requestXinxiData(token, coupon_id);


        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showXinxiData(String message) {
        Gson gson = new Gson();
        Xinxi xinxi = gson.fromJson(message, Xinxi.class);
        Xinxi.DataBean dataBean = xinxi.getData();

        numbers.setText(dataBean.getNumber()+"");
        numbers1.setText(dataBean.getReceiveNum()+"");
        numbers2.setText(dataBean.getUseNum()+"");
    }
}
