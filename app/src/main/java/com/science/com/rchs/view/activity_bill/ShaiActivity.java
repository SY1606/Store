package com.science.com.rchs.view.activity_bill;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;

import com.science.com.rchs.view.fragment_two.Frag_s_all;
import com.science.com.rchs.view.fragment_two.Frag_s_pay;
import com.science.com.rchs.view.fragment_two.Frag_s_tui;
import com.science.com.rchs.view.fragment_two.Frag_s_wei;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShaiActivity extends AppCompatActivity {

    @BindView(R.id.leixing)
    TextView leixing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shai);
        ButterKnife.bind(this);
        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        StatusBarUtil.setRootViewFitsSystemWindows(ShaiActivity.this, true);
        StatusBarUtil.setTranslucentStatus(ShaiActivity.this);

        if (!StatusBarUtil.setStatusBarDarkTheme(ShaiActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(ShaiActivity.this, 0x55000000);
        }

        final FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        final Frag_s_all frag_s_all = new Frag_s_all();
        final Frag_s_wei frag_s_wei = new Frag_s_wei();
        final Frag_s_pay frag_s_pay = new Frag_s_pay();
        final Frag_s_tui frag_s_tui = new Frag_s_tui();
        transaction.add(R.id.frag_myfocus, frag_s_all);
        transaction.add(R.id.frag_myfocus, frag_s_wei);
        transaction.add(R.id.frag_myfocus, frag_s_pay);
        transaction.add(R.id.frag_myfocus, frag_s_tui);
        transaction.show(frag_s_all).hide(frag_s_wei).hide(frag_s_pay).hide(frag_s_tui);
        transaction.commit();

        RadioGroup rg_focus = findViewById(R.id.rg_focus);
        rg_focus.check(R.id.a11);
        rg_focus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.a11:
                        transaction1.show(frag_s_all).hide(frag_s_wei).hide(frag_s_pay).hide(frag_s_tui);
                        break;
                    case R.id.pay:
                        transaction1.show(frag_s_pay).hide(frag_s_all).hide(frag_s_wei).hide(frag_s_tui);
                        break;
                    case R.id.weixin:
                        transaction1.show(frag_s_wei).hide(frag_s_all).hide(frag_s_pay).hide(frag_s_tui);
                        break;
                    case R.id.tui:
                        transaction1.show(frag_s_tui).hide(frag_s_wei).hide(frag_s_all).hide(frag_s_pay);
                        break;
                }
                transaction1.commit();
            }
        });
    }
}
