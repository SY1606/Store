package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.StarRecord;
import com.science.com.rchs.data.bean.Stars;
import com.science.com.rchs.di.contract.StarContract;
import com.science.com.rchs.di.contract.TixianContract;
import com.science.com.rchs.di.presenter.StarPresenter;
import com.science.com.rchs.di.presenter.TixianPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.adapter.QueryAdapter;

import java.util.ArrayList;
import java.util.List;


public class T_QueryActivity extends AppCompatActivity implements TixianContract.TixianView,StarContract.StarView {

    private String token;
    private TixianContract.TixianPresenter tixianPresenter;
    private String mchId;
    private StarContract.StarPresenter starPresenter;
    private ListView lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t__query);
        StatusBarUtil.setRootViewFitsSystemWindows(T_QueryActivity.this,true);
        StatusBarUtil.setTranslucentStatus(T_QueryActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(T_QueryActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(T_QueryActivity.this,0x55000000);
        }

        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        lists = findViewById(R.id.lists);
        SharedPreferences sp =getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        starPresenter = new StarPresenter();
        starPresenter.attachView(this);
        starPresenter.requestStarData(token);


    }

    @Override
    public void showTixianData(String message) {
        Gson gson = new Gson();
        StarRecord starRecord = gson.fromJson(message,StarRecord.class);
        ArrayList<StarRecord.DataBean> dataBeans = (ArrayList<StarRecord.DataBean>) starRecord.getData();
        QueryAdapter queryAdapter = new QueryAdapter(T_QueryActivity.this,dataBeans);
        lists.setAdapter(queryAdapter);
    }

    @Override
    public void showStarData(String message) {

        Gson gson = new Gson();
        Stars stars = gson.fromJson(message, Stars.class);
        List<Stars.DataBean> dataBeans = stars.getData();
        for (int i = 0; i < dataBeans.size(); i++) {
            mchId = dataBeans.get(i).getMerc_id();
            Log.i("rrytyt",dataBeans.get(i).getMerc_id());
        }
        tixianPresenter = new TixianPresenter();
        tixianPresenter.attachView(this);

        tixianPresenter.requestTixianData(token,mchId);
        Log.i("fafa",token);
        Log.i("easfas",mchId+"");
    }
}
