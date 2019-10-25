package com.science.com.rchs.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.science.com.rchs.R;
import com.science.com.rchs.net.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ColorActivity extends AppCompatActivity {

    @BindView(R.id.color010)
    ImageView color010;
    @BindView(R.id.color020)
    ImageView color020;
    @BindView(R.id.color030)
    ImageView color030;
    @BindView(R.id.color040)
    ImageView color040;
    @BindView(R.id.color050)
    ImageView color050;
    @BindView(R.id.color060)
    ImageView color060;
    @BindView(R.id.color070)
    ImageView color070;
    @BindView(R.id.color080)
    ImageView color080;
    @BindView(R.id.color081)
    ImageView color081;
    @BindView(R.id.color082)
    ImageView color082;
    @BindView(R.id.color090)
    ImageView color090;
    @BindView(R.id.color100)
    ImageView color100;
    @BindView(R.id.fan)
    ImageView fan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        ButterKnife.bind(this);


        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(ColorActivity.this, true);
        StatusBarUtil.setTranslucentStatus(ColorActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(ColorActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(ColorActivity.this, 0x55000000);
        }
    }

    @OnClick({R.id.color010, R.id.color020, R.id.color030, R.id.color040, R.id.color050, R.id.color060, R.id.color070, R.id.color080, R.id.color081, R.id.color082, R.id.color090, R.id.color100,R.id.fan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                Intent intent = new Intent(ColorActivity.this, NewDiscountActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.color010:
                Intent intent1 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent1.putExtra("color010", "Color010");
                startActivity(intent1);
                finish();
                break;
            case R.id.color020:
                Intent intent2 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent2.putExtra("color020", "Color020");
                startActivity(intent2);
                finish();
                break;
            case R.id.color030:
                Intent intent3 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent3.putExtra("color030", "Color030");
                startActivity(intent3);
                finish();
                break;
            case R.id.color040:
                Intent intent4 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent4.putExtra("color040", "Color040");
                startActivity(intent4);
                finish();
                break;
            case R.id.color050:
                Intent intent5 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent5.putExtra("color050", "Color050");
                startActivity(intent5);
                finish();
                break;
            case R.id.color060:
                Intent intent6 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent6.putExtra("color060", "Color060");
                startActivity(intent6);
                finish();
                break;
            case R.id.color070:
                Intent intent7 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent7.putExtra("color070", "Color070");
                startActivity(intent7);
                finish();
                break;
            case R.id.color080:
                Intent intent8 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent8.putExtra("color080", "Color080");
                startActivity(intent8);
                finish();
                break;
            case R.id.color081:
                Intent intent9 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent9.putExtra("color081", "Color081");
                startActivity(intent9);
                finish();
                break;
            case R.id.color082:
                Intent intent10 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent10.putExtra("color082", "Color082");
                startActivity(intent10);
                finish();
                break;
            case R.id.color090:
                Intent intent11 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent11.putExtra("color090", "Color090");
                startActivity(intent11);
                finish();
                break;
            case R.id.color100:
                Intent intent12 = new Intent(ColorActivity.this, NewDiscountActivity.class);
                intent12.putExtra("color100", "Color100");
                startActivity(intent12);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ColorActivity.this, NewDiscountActivity.class);
        startActivity(intent);
        finish();
    }
}
