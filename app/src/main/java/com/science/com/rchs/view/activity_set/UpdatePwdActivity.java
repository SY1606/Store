package com.science.com.rchs.view.activity_set;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Forget;
import com.science.com.rchs.data.bean.Send;
import com.science.com.rchs.data.bean.Shops;
import com.science.com.rchs.di.contract.ForgetContract;
import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.contract.SendContract;
import com.science.com.rchs.di.contract.ShopsContract;
import com.science.com.rchs.di.presenter.ForgetPresenter;
import com.science.com.rchs.di.presenter.SendPresenter;
import com.science.com.rchs.di.presenter.ShopsPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.activity.ForgetActivity;
import com.science.com.rchs.view.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class UpdatePwdActivity extends AppCompatActivity implements SendContract.SendView, ForgetContract.ForgetView, ShopsContract.ShopsView {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.yanzhengs)
    TextView yanzhengs;
    @BindView(R.id.phones)
    TextView phones;
    @BindView(R.id.queding)
    Button queding;
    @BindView(R.id.n_pass)
    EditText nPass;
    @BindView(R.id.n_pwd)
    EditText nPwd;
    @BindView(R.id.na_pwd)
    EditText naPwd;
    @BindView(R.id.che1)
    CheckBox che1;
    @BindView(R.id.che2)
    CheckBox che2;

    private MyCountDownTimer myCountDownTimer;
    private MemListContract.MemListPresenter memListPresenter;
    private String token;

    private SendContract.SendPresenter sendPresenter;
    private String password;
    private String passwordtwo;
    private String signcode;
    private ForgetContract.ForgetPresenter forgetPresenter;
    private String phone;
    private ShopsContract.ShopsPresenter shopsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pwd);
        ButterKnife.bind(this);
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        StatusBarUtil.setRootViewFitsSystemWindows(UpdatePwdActivity.this, true);
        StatusBarUtil.setTranslucentStatus(UpdatePwdActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(UpdatePwdActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(UpdatePwdActivity.this, 0x55000000);
        }


        che1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    nPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());

                } else {

                    nPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });

        che2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    naPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    naPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());


                }
            }
        });

        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        sendPresenter = new SendPresenter();
        sendPresenter.attachView(this);

        forgetPresenter = new ForgetPresenter();
        forgetPresenter.attachView(this);

        shopsPresenter = new ShopsPresenter();
        shopsPresenter.attachView(this);
        shopsPresenter.requestShopsData(token);
    }

    @OnClick({R.id.fan, R.id.yanzhengs, R.id.queding})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                finish();
                break;
            case R.id.yanzhengs:
                myCountDownTimer.start();
                phone = phones.getText().toString();
                sendPresenter.requestSendData(phone);
                break;
            case R.id.queding:

                phone = phones.getText().toString();
                password = nPwd.getText().toString().trim();
                passwordtwo = naPwd.getText().toString().trim();
                signcode = nPass.getText().toString().trim();

                forgetPresenter.requestForgetData(phone, password, passwordtwo, signcode);
                break;
        }


    }

    @Override
    public void showSendData(String message) {
        Gson gson = new Gson();
        Send send = gson.fromJson(message, Send.class);
        int code = send.getCode();
        String messages = send.getMessage();

        Toast.makeText(UpdatePwdActivity.this, messages, Toast.LENGTH_SHORT);
        myCountDownTimer.start();

    }

    @Override
    public void showForgetData(String message) {
        Gson gson = new Gson();
        Forget forget = gson.fromJson(message, Forget.class);
       int code = forget.getCode();
        String messages = forget.getMessage();
        if (code == 0) {

            ToastUtil.showToast(UpdatePwdActivity.this, messages, Toast.LENGTH_SHORT);
            Intent intent2 = new Intent(UpdatePwdActivity.this, LoginActivity.class);
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent2);
        } else if (code!=0){
            ToastUtil.showToast(UpdatePwdActivity.this, messages, Toast.LENGTH_SHORT);

        }else if (!password.equals(passwordtwo)){
            Toast.makeText(UpdatePwdActivity.this,"两次输入的密码不一样,请重新输入",Toast.LENGTH_SHORT).show();
        }else if (nPwd.getText().toString().length()>6||nPwd.getText().toString().length()<20){
            ToastUtil.showToast(UpdatePwdActivity.this, "密码长度6-20位", Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(UpdatePwdActivity.this, messages, Toast.LENGTH_SHORT);

        }
    }

    @Override
    public void showShopsData(String message) {
        Gson gson = new Gson();
        Shops shops = gson.fromJson(message, Shops.class);
        Shops.DataBean dataBeans = shops.getData();
        phone = dataBeans.getPhone();
        phones.setText(phone);
    }


    private class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            yanzhengs.setClickable(false);
            yanzhengs.setText(l / 1000 + "秒");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给Button设置文字
            yanzhengs.setText("重新获取");
            //设置可点击
            yanzhengs.setClickable(true);
        }
    }
}
