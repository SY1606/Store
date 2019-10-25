package com.science.com.rchs.view.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.frag_two.Frag01;
import com.science.com.rchs.view.frag_two.Frag02;
import com.science.com.rchs.view.frag_two.Frag03;
import com.science.com.rchs.view.frag_two.Frag04;


public class DiscountListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount_list);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(DiscountListActivity.this, true);
        StatusBarUtil.setTranslucentStatus(DiscountListActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(DiscountListActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(DiscountListActivity.this, 0x55000000);
        }

        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        final Frag01 frag01 = new Frag01();
        final Frag02 frag02 = new Frag02();
        final Frag03 frag03 = new Frag03();
        final Frag04 frag04 = new Frag04();
        transaction.add(R.id.frag_myfocus,frag01);
        transaction.add(R.id.frag_myfocus,frag02);
        transaction.add(R.id.frag_myfocus,frag03);
        transaction.add(R.id.frag_myfocus,frag04);
        transaction.show(frag01).hide(frag02).hide(frag03).hide(frag04);
        transaction.commit();


        RadioGroup rg_focus = findViewById(R.id.rg_focus);
        rg_focus.check(R.id.a11);
        rg_focus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId){
                    case R.id.a11:
                        transaction1.show(frag01).hide(frag02).hide(frag03).hide(frag04);
                        break;
                    case R.id.dai:
                        transaction1.show(frag02).hide(frag01).hide(frag04).hide(frag03);
                        break;
                    case R.id.you:
                        transaction1.show(frag03).hide(frag01).hide(frag02).hide(frag04);
                        break;
                    case R.id.zhe:
                        transaction1.show(frag04).hide(frag01).hide(frag02).hide(frag03);
                        break;
                }
                transaction1.commit();
            }
        });

    }
}
