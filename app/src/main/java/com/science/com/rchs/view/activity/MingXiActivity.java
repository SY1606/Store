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
import com.science.com.rchs.view.fragment_two.Frag_all;
import com.science.com.rchs.view.fragment_two.Frag_dai;
import com.science.com.rchs.view.fragment_two.Frag_you;
import com.science.com.rchs.view.fragment_two.Frag_zhe;

public class MingXiActivity extends AppCompatActivity {

    private ImageView fan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ming_xi);
        //沉浸式状态栏

        fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        StatusBarUtil.setRootViewFitsSystemWindows(MingXiActivity.this,true);
        StatusBarUtil.setTranslucentStatus(MingXiActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(MingXiActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(MingXiActivity.this,0x55000000);
        }
        final FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        final Frag_all frag_all = new Frag_all();
        final Frag_dai frag_dai = new Frag_dai();
        final Frag_you frag_you = new Frag_you();
        final Frag_zhe frag_zhe = new Frag_zhe();
        transaction.add(R.id.frag_myfocus,frag_all);
        transaction.add(R.id.frag_myfocus,frag_dai);
        transaction.add(R.id.frag_myfocus,frag_you);
        transaction.add(R.id.frag_myfocus,frag_zhe);
        transaction.show(frag_all).hide(frag_dai).hide(frag_you).hide(frag_zhe);
        transaction.commit();



        RadioGroup rg_focus = findViewById(R.id.rg_focus);
        rg_focus.check(R.id.a11);
        rg_focus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId){
                    case R.id.a11:
                        transaction1.show(frag_all).hide(frag_dai).hide(frag_you).hide(frag_zhe);
                        break;
                    case R.id.dai:
                        transaction1.show(frag_dai).hide(frag_you).hide(frag_all).hide(frag_zhe);
                        break;
                    case R.id.you:
                        transaction1.show(frag_you).hide(frag_all).hide(frag_dai).hide(frag_zhe);
                        break;
                    case R.id.zhe:
                        transaction1.show(frag_zhe).hide(frag_dai).hide(frag_you).hide(frag_all);
                        break;
                }
                transaction1.commit();
            }
        });
    }
}
