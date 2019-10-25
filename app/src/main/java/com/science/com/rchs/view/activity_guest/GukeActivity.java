package com.science.com.rchs.view.activity_guest;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Guke;
import com.science.com.rchs.data.bean.Week;
import com.science.com.rchs.di.contract.GukeContract;
import com.science.com.rchs.di.contract.WeekContract;
import com.science.com.rchs.di.presenter.WeekPresenter;
import com.science.com.rchs.net.HorizontalBarView;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.activity_bill.Success_t_Activity;
import com.science.com.rchs.weidgt.DataWheelView;
import com.science.com.rchs.weidgt.FoodCalView;
import com.science.com.rchs.weidgt.WeightWheelView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GukeActivity extends AppCompatActivity implements WeekContract.WeekView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guke);
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        StatusBarUtil.setRootViewFitsSystemWindows(GukeActivity.this,true);
        StatusBarUtil.setTranslucentStatus(GukeActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(GukeActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(GukeActivity.this,0x55000000);
        }
        ImageView fans = findViewById(R.id.fan);
        fans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        StatusBarUtil.setRootViewFitsSystemWindows(GukeActivity.this,true);
        StatusBarUtil.setTranslucentStatus(GukeActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(GukeActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(GukeActivity.this,0x55000000);
        }

        WeekContract.WeekPresenter weekPresenter = new WeekPresenter();
        weekPresenter.attachView(this);
        weekPresenter.requestWeekData(token);
    }

    @Override
    public void showWeekData(String message) {
            Gson gson = new Gson();
            Week week = gson.fromJson(message,Week.class);
            Week.DataBean dataBean = week.getData();

            int count1 = dataBean.get_$1().getCount();
        int count2 = dataBean.get_$2().getCount();
        int count3 = dataBean.get_$3().getCount();
        int count4 = dataBean.get_$4().getCount();
        int count5 = dataBean.get_$5().getCount();
        int count6 = dataBean.get_$6().getCount();
        int count7 = dataBean.get_$7().getCount();

        HorizontalBarView horizontalbar = (HorizontalBarView)findViewById(R.id.horizontalbar);
        ArrayList<HorizontalBarView.HoBarEntity> hoBarEntities = new ArrayList<>();
        HorizontalBarView.HoBarEntity hoBarEntity = new HorizontalBarView.HoBarEntity();
        hoBarEntity.content = "周一";
        hoBarEntity.count = count1;
        hoBarEntities.add(hoBarEntity);


        HorizontalBarView.HoBarEntity hoBarEntity1 = new HorizontalBarView.HoBarEntity();
        hoBarEntity1.content = "周二";
        hoBarEntity1.count = count2;
        hoBarEntities.add(hoBarEntity1);


        HorizontalBarView.HoBarEntity hoBarEntity2 = new HorizontalBarView.HoBarEntity();
        hoBarEntity2.content = "周三";
        hoBarEntity2.count = count3;
        hoBarEntities.add(hoBarEntity2);


        HorizontalBarView.HoBarEntity hoBarEntity3 = new HorizontalBarView.HoBarEntity();
        hoBarEntity3.content = "周四";
        hoBarEntity3.count = count4;
        hoBarEntities.add(hoBarEntity3);


        HorizontalBarView.HoBarEntity hoBarEntity4 = new HorizontalBarView.HoBarEntity();
        hoBarEntity4.content = "周五";
        hoBarEntity4.count = count5;
        hoBarEntities.add(hoBarEntity4);


        HorizontalBarView.HoBarEntity hoBarEntity5 = new HorizontalBarView.HoBarEntity();
        hoBarEntity5.content = "周六";
        hoBarEntity5.count = count6;
        hoBarEntities.add(hoBarEntity5);


        HorizontalBarView.HoBarEntity hoBarEntity6 = new HorizontalBarView.HoBarEntity();
        hoBarEntity6.content = "周日";
        hoBarEntity6.count = count7;
        hoBarEntities.add(hoBarEntity6);
        horizontalbar.setHoBarData(hoBarEntities);

    }
}
