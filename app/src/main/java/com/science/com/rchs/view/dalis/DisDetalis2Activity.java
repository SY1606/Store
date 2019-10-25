package com.science.com.rchs.view.dalis;

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
import com.science.com.rchs.view.activity.Bianji1Activity;
import com.science.com.rchs.view.activity.BianjiActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DisDetalis2Activity extends AppCompatActivity implements XinxiContract.XinxiView {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.bianji)
    TextView bianji;
    @BindView(R.id.man)
    TextView man;
    @BindView(R.id.numbers)
    TextView numbers;
    @BindView(R.id.numbers1)
    TextView numbers1;
    @BindView(R.id.numbers2)
    TextView numbers2;
    @BindView(R.id.youxiaoqi)
    TextView youxiaoqi;
    @BindView(R.id.ends)
    TextView ends;
    private XinxiContract.XinxiPresenter xinxiPresenter;
    private String end_timestamp;
    private String begin_timestamp;
    private String coupon_id;
    private String name;
    private String logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dis_detalis2);
        ButterKnife.bind(this);
        StatusBarUtil.setRootViewFitsSystemWindows(DisDetalis2Activity.this, true);
        StatusBarUtil.setTranslucentStatus(DisDetalis2Activity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(DisDetalis2Activity.this, true)) {
            StatusBarUtil.setStatusBarColor(DisDetalis2Activity.this, 0x55000000);
        }


        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");

        Intent intent = getIntent();
        logo = intent.getStringExtra("log");

        name = intent.getStringExtra("title");
        man.setText(name);
        coupon_id = intent.getStringExtra("coupon_id");

        begin_timestamp = intent.getStringExtra("times");
        youxiaoqi.setText("有效期:"+ begin_timestamp);

        end_timestamp = intent.getStringExtra("times_end");
        ends.setText("  -  "+ end_timestamp);

        xinxiPresenter = new XinxiPresenter();
        xinxiPresenter.attachView(this);
        xinxiPresenter.requestXinxiData(token, coupon_id);

    }

    @OnClick({R.id.fan, R.id.bianji})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                finish();
                break;
            case R.id.bianji:

                Intent intent = new Intent(DisDetalis2Activity.this,Bianji1Activity.class);

                intent.putExtra("logo",logo);
                intent.putExtra("names",name);
                intent.putExtra("start",begin_timestamp);
                intent.putExtra("end",end_timestamp);
                intent.putExtra("id",coupon_id);

                Log.i("ssss",begin_timestamp);
                Log.i("wwww",end_timestamp);
                Log.i("aaaa",coupon_id);
                startActivity(intent);

                break;
        }
    }

    @Override
    public void showXinxiData(String message) {
        Gson gson = new Gson();
        Xinxi xinxi = gson.fromJson(message, Xinxi.class);
        Xinxi.DataBean dataBean = xinxi.getData();

        numbers.setText(dataBean.getNumber() + "");
        numbers1.setText(dataBean.getReceiveNum() + "");
        numbers2.setText(dataBean.getUseNum() + "");
    }
}
