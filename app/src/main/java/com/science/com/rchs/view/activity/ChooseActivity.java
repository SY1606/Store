package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.science.com.rchs.R;

import com.science.com.rchs.di.contract.ChooseStoreContract;



import com.science.com.rchs.http.ActivityCollectorUtil;
import com.science.com.rchs.net.StatusBarUtil;



import java.util.List;


public class ChooseActivity extends AppCompatActivity {

    private RecyclerView choose_store;
    private ChooseStoreContract.ChooseStorePresenter chooseStorePresenter;
    private String token;
    private String name;
    private int id;
    private SimpleCursorAdapter mSimpleCursorAdapter;
    private SQLiteDatabase mDbWriter;
    private SQLiteDatabase mDbReader;
    private MySQLite mMySQLite;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectorUtil.addActivity(this);
        setContentView(R.layout.activity_choose);

        mListView = (ListView) findViewById(R.id.myListview);
       // SharedPreferences sp =getSharedPreferences("login",Context.MODE_PRIVATE);
        //token = sp.getString("token","");

        //choose_store = findViewById(R.id.choose_store);
        //chooseStorePresenter = new ChooseStorePresenter();
        //chooseStorePresenter.attachView(this);
        //chooseStorePresenter.requestChooseStoreData(token);

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(ChooseActivity.this,true);
        StatusBarUtil.setTranslucentStatus(ChooseActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(ChooseActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(ChooseActivity.this,0x55000000);
        }
    }


    //@Override
    //public void showChooseStoreData(String message) {

    //}

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectorUtil.removeActivity(this);
    }
}
