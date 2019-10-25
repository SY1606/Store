package com.science.com.rchs.view.activity_guest;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Guke;
import com.science.com.rchs.di.contract.GukeContract;
import com.science.com.rchs.di.presenter.GukePresenter;
import com.science.com.rchs.net.HorizontalBarView;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.weidgt.DataWheelView;
import com.science.com.rchs.weidgt.FoodCalView;
import com.science.com.rchs.weidgt.WeightWheelView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TimeActivity extends AppCompatActivity implements GukeContract.GukeView {
    private FoodCalView fcv_food;
    private int month;
    private int day;
    private int oldCalDate = -1;
    private ArrayList<FoodCalView.BarData> innerFoodCalData = new ArrayList<>();
    private ArrayList<DataWheelView.BarData> innerDateData = new ArrayList<>();
    private TextView tv_food_date;
    private DataWheelView dwv_data;
    private double oldDate;
    private TextView tv_date;
    private WeightWheelView wwv_mater;
    private String chooseWeight;
    private TextView tv_weight;
    private GukeContract.GukePresenter gukePresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        ButterKnife.bind(this);
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        gukePresenter = new GukePresenter();
        gukePresenter.attachView(this);
        gukePresenter.requestGukeData(token);




    }

    @Override
    public void showGukeData(String message) {

        Gson gson = new Gson();
        Guke guke = gson.fromJson(message, Guke.class);

        Guke.DataBean dataBean = guke.getData();

        int count1 = dataBean.getTodayCount();
        int count2 = dataBean.getThreeCount();
        int count3 = dataBean.getSevenCount();

        StatusBarUtil.setRootViewFitsSystemWindows(TimeActivity.this, true);
        StatusBarUtil.setTranslucentStatus(TimeActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(TimeActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(TimeActivity.this, 0x55000000);
        }
        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        StatusBarUtil.setRootViewFitsSystemWindows(TimeActivity.this, true);
        StatusBarUtil.setTranslucentStatus(TimeActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(TimeActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(TimeActivity.this, 0x55000000);
        }
        HorizontalBarView horizontalbar = (HorizontalBarView) findViewById(R.id.horizontalbar);
        ArrayList<HorizontalBarView.HoBarEntity> hoBarEntities = new ArrayList<>();
        HorizontalBarView.HoBarEntity hoBarEntity = new HorizontalBarView.HoBarEntity();
        hoBarEntity.content = "今天";
        hoBarEntity.count = count1;

        hoBarEntities.add(hoBarEntity);
        HorizontalBarView.HoBarEntity hoBarEntity1 = new HorizontalBarView.HoBarEntity();
        hoBarEntity1.content = "3天内";
        hoBarEntity1.count = count2;

        hoBarEntities.add(hoBarEntity1);
        HorizontalBarView.HoBarEntity hoBarEntity2 = new HorizontalBarView.HoBarEntity();
        hoBarEntity2.content = "7天内";
        hoBarEntity2.count = count3;
        hoBarEntities.add(hoBarEntity2);
        //HorizontalBarView.HoBarEntity hoBarEntity3 = new HorizontalBarView.HoBarEntity();
        //hoBarEntity3.content = "1000元以上";
        //hoBarEntity3.count = 120;
        //hoBarEntities.add(hoBarEntity3);
        horizontalbar.setHoBarData(hoBarEntities);
    }
}
