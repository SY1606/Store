package com.science.com.rchs.view.activity_set;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.ChooseStore;
import com.science.com.rchs.di.contract.ChooseStoreContract;
import com.science.com.rchs.di.presenter.ChooseStorePresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.adapter.ChooseSrAdapter;
import com.science.com.rchs.view.adapter.ChooseStoreAdapter;

import java.util.List;

public class ChooseStActivity extends AppCompatActivity implements ChooseStoreContract.ChooseStoreView{

    private RecyclerView choose_store;
    private ChooseStoreContract.ChooseStorePresenter chooseStorePresenter;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_st);

        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        SharedPreferences sp =getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");
        Log.i("xxxxxx", token +"");

        choose_store = findViewById(R.id.choose_store);
        chooseStorePresenter = new ChooseStorePresenter();
        chooseStorePresenter.attachView(this);
        chooseStorePresenter.requestChooseStoreData(token);

        StatusBarUtil.setRootViewFitsSystemWindows(ChooseStActivity.this,true);
        StatusBarUtil.setTranslucentStatus(ChooseStActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(ChooseStActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(ChooseStActivity.this,0x55000000);
        }



    }

    @Override
    public void showChooseStoreData(String message) {
        Gson gson = new Gson();
        ChooseStore store = gson.fromJson(message,ChooseStore.class);
        List<ChooseStore.DataBean> beans = store.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ChooseStActivity.this,LinearLayoutManager.VERTICAL,false);
        choose_store.setLayoutManager(linearLayoutManager);
        ChooseSrAdapter chooseSrAdapter = new ChooseSrAdapter(R.layout.item_choosestore, beans);
        choose_store.setAdapter(chooseSrAdapter);
    }
}
