package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;

import com.science.com.rchs.data.bean.Recoder;
import com.science.com.rchs.di.contract.CRecoderContract;
import com.science.com.rchs.di.presenter.RecoderPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.adapter.CRecoderAdapter;
import com.science.com.rchs.view.fragment.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class CRecordActivity extends AppCompatActivity implements CRecoderContract.CRecoderView {

    private CRecoderContract.CRecoderPresenter cRecoderPresenter;

    private RecyclerView recycler;
    private String token;
    private ImageView fan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crecord);

        recycler = findViewById(R.id.recycler);
        fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SharedPreferences sp =getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");

        cRecoderPresenter = new RecoderPresenter();
        cRecoderPresenter.attachView(this);
        cRecoderPresenter.requestCRecoderData(token);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(CRecordActivity.this, true);
        StatusBarUtil.setTranslucentStatus(CRecordActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(CRecordActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(CRecordActivity.this, 0x55000000);
        }

    }

    @Override
    public void showCRecoderData(String message) {
        Gson gson = new Gson();
        Recoder recoder = gson.fromJson(message,Recoder.class);

        ArrayList<Recoder.DataBean.ListBean> beans = (ArrayList<Recoder.DataBean.ListBean>) recoder.getData().getList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CRecordActivity.this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setStackFromEnd(false);
        linearLayoutManager.setReverseLayout(false);


        CRecoderAdapter cRecoderAdapter = new CRecoderAdapter(R.layout.item_crecord, beans);
        recycler.setAdapter(cRecoderAdapter);

        SpaceItemDecoration decoration = new SpaceItemDecoration(this, 10);
        recycler.addItemDecoration(decoration);
    }
}
