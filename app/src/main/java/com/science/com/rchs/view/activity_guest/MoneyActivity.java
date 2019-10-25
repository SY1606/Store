package com.science.com.rchs.view.activity_guest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Money;
import com.science.com.rchs.di.contract.MoneyContract;
import com.science.com.rchs.di.presenter.MoneyPresenter;
import com.science.com.rchs.net.HorizontalBarView;
import com.science.com.rchs.net.StatusBarUtil;

import java.util.ArrayList;

public class MoneyActivity extends AppCompatActivity implements MoneyContract.MoneyView {

    private MoneyContract.MoneyPresenter moneyPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");

        moneyPresenter = new MoneyPresenter();
        moneyPresenter.attachView(this);
        moneyPresenter.requestMoneyData(token);



    }

    @Override
    public void showMoneyData(String message) {
        Gson gson = new Gson();
        Money money = gson.fromJson(message,Money.class);

        Money.DataBean dataBean = money.getData();
        int count1 = dataBean.getOneHundredMoney();
        int count2 = dataBean.getOneThousandmoney();
        int count3 = dataBean.getTwoThousandmoney();
        int count4 = dataBean.getFiveHundredMoney();

        StatusBarUtil.setRootViewFitsSystemWindows(MoneyActivity.this,true);
        StatusBarUtil.setTranslucentStatus(MoneyActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(MoneyActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(MoneyActivity.this,0x55000000);
        }
        HorizontalBarView horizontalbar = (HorizontalBarView)findViewById(R.id.horizontalbar);
        ArrayList<HorizontalBarView.HoBarEntity> hoBarEntities = new ArrayList<>();
        HorizontalBarView.HoBarEntity hoBarEntity = new HorizontalBarView.HoBarEntity();
        hoBarEntity.content = "0-100元";
        hoBarEntity.count = count1;
        hoBarEntities.add(hoBarEntity);
        HorizontalBarView.HoBarEntity hoBarEntity1 = new HorizontalBarView.HoBarEntity();
        hoBarEntity1.content = "100-500元";
        hoBarEntity1.count = count2;
        hoBarEntities.add(hoBarEntity1);
        HorizontalBarView.HoBarEntity hoBarEntity2 = new HorizontalBarView.HoBarEntity();
        hoBarEntity2.content = "500-1000元";
        hoBarEntity2.count = count3;
        hoBarEntities.add(hoBarEntity2);
        HorizontalBarView.HoBarEntity hoBarEntity3 = new HorizontalBarView.HoBarEntity();
        hoBarEntity3.content = "1000元以上";
        hoBarEntity3.count = count4;
        hoBarEntities.add(hoBarEntity3);
        horizontalbar.setHoBarData(hoBarEntities);
    }
}
