package com.science.com.rchs.view.activity_set;

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
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.ChooseStore;
import com.science.com.rchs.di.contract.ChooseStoreContract;
import com.science.com.rchs.di.presenter.ChooseStorePresenter;
import com.science.com.rchs.net.StatusBarUtil;

import com.science.com.rchs.view.activity.HomeActivity;
import com.science.com.rchs.view.adapter.ChooseStoreAdapter;

import java.util.List;


public class ChooseStoreActivity extends AppCompatActivity implements ChooseStoreContract.ChooseStoreView{


    private RecyclerView choose_store;
    private ChooseStoreContract.ChooseStorePresenter chooseStorePresenter;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_store);

        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent  intent = new Intent(ChooseStoreActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });


        SharedPreferences sp =getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");
        Log.i("xxxxxx",token+"");


        choose_store = findViewById(R.id.choose_store);
        chooseStorePresenter = new ChooseStorePresenter();
        chooseStorePresenter.attachView(this);
        chooseStorePresenter.requestChooseStoreData(token);

        StatusBarUtil.setRootViewFitsSystemWindows(ChooseStoreActivity.this,true);
        StatusBarUtil.setTranslucentStatus(ChooseStoreActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(ChooseStoreActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(ChooseStoreActivity.this,0x55000000);
        }


    }

    @Override
    public void showChooseStoreData(String message) {

        Gson gson = new Gson();
        ChooseStore store = gson.fromJson(message,ChooseStore.class);
        List<ChooseStore.DataBean> beans = store.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooseStoreActivity.this,LinearLayoutManager.VERTICAL,false);
        choose_store.setLayoutManager(linearLayoutManager);

        ChooseStoreAdapter chooseStoreAdapter = new ChooseStoreAdapter(R.layout.item_choosestore, beans);
        choose_store.setAdapter(chooseStoreAdapter);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ChooseStoreActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
}
