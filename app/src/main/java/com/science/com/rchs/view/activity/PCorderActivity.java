package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.PRecoder;
import com.science.com.rchs.data.bean.Recoder;
import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.contract.PCorderContract;
import com.science.com.rchs.di.presenter.PCorderPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.adapter.CRecoderAdapter;
import com.science.com.rchs.view.adapter.PCorderAdapter;
import com.science.com.rchs.view.fragment.Frag_check;

import java.util.ArrayList;
import java.util.List;

public class PCorderActivity extends AppCompatActivity implements PCorderContract.PCorderView {

    private PCorderContract.PCorderPresenter pCorderPresenter;
    private String token;
    private RecyclerView recycler;
    private ImageView fan;
    private String phone;
    private RelativeLayout fee;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcorder);

        fan = findViewById(R.id.fan);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(PCorderActivity.this, true);
        StatusBarUtil.setTranslucentStatus(PCorderActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(PCorderActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(PCorderActivity.this, 0x55000000);
        }
        recycler = findViewById(R.id.recycler);


        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SharedPreferences sps = getSharedPreferences("hhhh",MODE_PRIVATE);
        phone = sps.getString("phone","");

        fee = findViewById(R.id.fee);
        pCorderPresenter = new PCorderPresenter();
        pCorderPresenter.attachView(this);
        pCorderPresenter.requestPCorderData(token, phone);
        Log.i("grgfgf", phone +"");
    }

    @Override
    public void showPCorderData(String message) {
        Gson gson = new Gson();
        PRecoder pRecoder = gson.fromJson(message,PRecoder.class);
        ArrayList<PRecoder.DataBean.ListBean> beans = (ArrayList<PRecoder.DataBean.ListBean>) pRecoder.getData().getList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PCorderActivity.this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(linearLayoutManager);
        //linearLayoutManager.setStackFromEnd(true);
        //linearLayoutManager.setReverseLayout(true);
        PCorderAdapter pCorderAdapter = new PCorderAdapter(R.layout.item_pcorder, beans);
        recycler.setAdapter(pCorderAdapter);




        if (beans.size() == 0) {
            fee.setVisibility(View.VISIBLE);
            recycler.setVisibility(View.GONE);
        }else {
            fee.setVisibility(View.GONE);
            recycler.setVisibility(View.VISIBLE);
            pCorderAdapter.notifyDataSetChanged();
        }
    }
}
