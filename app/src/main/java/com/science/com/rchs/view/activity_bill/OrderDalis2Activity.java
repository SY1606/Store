package com.science.com.rchs.view.activity_bill;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.OrderDalis;
import com.science.com.rchs.di.contract.OrderDalisContract;
import com.science.com.rchs.di.presenter.OrderDalisPresenter;
import com.science.com.rchs.net.ScreenCaptureUtil;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.view.activity.OrderDalis1Activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDalis2Activity extends AppCompatActivity implements OrderDalisContract.OrderDalisView {

    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.bianhao)
    TextView bianhao;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.baocun)
    Button baocun;
    private String orderNumber;
    private TextView ids;
    private OrderDalisContract.OrderDalisPresenter orderDalisPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_dalis2);
        ButterKnife.bind(this);
        ids = findViewById(R.id.ids);


        StatusBarUtil.setRootViewFitsSystemWindows(OrderDalis2Activity.this, true);
        StatusBarUtil.setTranslucentStatus(OrderDalis2Activity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(OrderDalis2Activity.this, true)) {
            StatusBarUtil.setStatusBarColor(OrderDalis2Activity.this, 0x55000000);
        }
        Intent intent = getIntent();
        orderNumber = intent.getStringExtra("order2");
        bianhao.setText(orderNumber);
        String times = intent.getStringExtra("times");
        time.setText(times);
        String moneys = intent.getStringExtra("moneys");
        money.setText(moneys);

        ImageView imageView = findViewById(R.id.fan);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        orderDalisPresenter = new OrderDalisPresenter();
        orderDalisPresenter.attachView(this);
        orderDalisPresenter.requestOrderDalisData(token, orderNumber);
    }

    @OnClick(R.id.baocun)
    public void onViewClicked() {
        //截屏
        Bitmap screen = ScreenCaptureUtil.getInstance().getScreen(OrderDalis2Activity.this);
        String content = "";
        if (null != screen) {
            //show_screen.setVisibility(View.VISIBLE);
            //showImage.setImageBitmap(screen);
            Animation animation = AnimationUtils.loadAnimation(OrderDalis2Activity.this, R.anim.scaleanimation);
            animation.setFillAfter(true);
            //showImage.startAnimation(animation);
            content = "已保存到相册";
        } else {
            content = "截屏失败";
        }
        Toast.makeText(OrderDalis2Activity.this, content, Toast.LENGTH_SHORT).show();

    }


    @Override
    public void showOrderDalisData(String message) {
        Gson gson = new Gson();
        OrderDalis orderDalis = gson.fromJson(message, OrderDalis.class);
        OrderDalis.DataBean dataBean = orderDalis.getData();
        String id = dataBean.getTransaction_id();
        ids.setText(id);
    }
}
