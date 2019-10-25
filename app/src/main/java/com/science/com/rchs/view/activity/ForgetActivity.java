package com.science.com.rchs.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
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
import com.science.com.rchs.di.contract.SendContract;
import com.science.com.rchs.di.contract.ShopsContract;
import com.science.com.rchs.di.presenter.ForgetPresenter;
import com.science.com.rchs.di.presenter.SendPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.activity_set.UpdatePwdActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ForgetActivity extends AppCompatActivity implements ForgetContract.ForgetView, SendContract.SendView, ShopsContract.ShopsView {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.che1)
    CheckBox che1;
    @BindView(R.id.che2)
    CheckBox che2;
    @BindView(R.id.mlogin)
    Button mlogin;
    @BindView(R.id.huoqu)
    TextView huoqu;
    MyCountDownTimer myCountDownTimer;
    @BindView(R.id.new_pass)
    EditText newPass;
    @BindView(R.id.n_pass)
    EditText nPass;
    @BindView(R.id.na_pass)
    EditText naPass;
    @BindView(R.id.f_phone)
    EditText fPhone;
    @BindView(R.id.yz)
    TextView yz;
    private String password;
    private String passwordtwo;
    private String signcode;
    private SendContract.SendPresenter sendPresenter;
    private String phone;
    private ForgetContract.ForgetPresenter forgetPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        ButterKnife.bind(this);
        myCountDownTimer = new MyCountDownTimer(60000, 1000);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(ForgetActivity.this, true);
        StatusBarUtil.setTranslucentStatus(ForgetActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(ForgetActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(ForgetActivity.this, 0x55000000);
        }

        TextView rrr = findViewById(R.id.rrr);
        sendPresenter = new SendPresenter();
        sendPresenter.attachView(this);

        forgetPresenter = new ForgetPresenter();
        forgetPresenter.attachView(this);

        //sendPresenter.requestSendData(phone);
        che1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    newPass.setTransformationMethod(PasswordTransformationMethod.getInstance());

                } else {

                    newPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                }
            }
        });

        che2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    nPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    nPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());


                }
            }
        });

    }

    @OnClick({R.id.fan, R.id.mlogin, R.id.huoqu, R.id.new_pass, R.id.n_pass})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                finish();
                break;

            case R.id.mlogin:
                phone = fPhone.getText().toString();
                password = newPass.getText().toString().trim();
                passwordtwo = nPass.getText().toString().trim();
                signcode = naPass.getText().toString().trim();
                /*if (TextUtils.isEmpty(password)||TextUtils.isEmpty(passwordtwo)||phone.equals("")||signcode.equals("")){
                    Toast.makeText(ForgetActivity.this,"空的",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(passwordtwo)){
                    Toast.makeText(ForgetActivity.this,"两次输入的密码不一样,请重新输入",Toast.LENGTH_SHORT).show();

                }else {

        }*/
                forgetPresenter.requestForgetData(phone, password, passwordtwo, signcode);
                Log.i("aaaa",phone+"");

                break;
            case R.id.new_pass:

                break;
            case R.id.n_pass:

                break;
            case R.id.huoqu:
                phone = fPhone.getText().toString();


                sendPresenter.requestSendData(phone);
                break;
        }
    }
    @Override
    public void showSendData(String message) {
        Gson gson = new Gson();
        Send send = gson.fromJson(message, Send.class);
       int code = send.getCode();
       String messages = send.getMessage();
        if (code == 500) {
            ToastUtil.showToast(ForgetActivity.this,messages,Toast.LENGTH_SHORT);

        } else if (code==400){
            ToastUtil.showToast(ForgetActivity.this,messages,Toast.LENGTH_SHORT);
        }else {
            myCountDownTimer.start();
            ToastUtil.showToast(ForgetActivity.this,messages,Toast.LENGTH_SHORT);

        }
    }
    @Override
    public void showForgetData(String message) {
        Gson gson = new Gson();
        Forget forget = gson.fromJson(message, Forget.class);
       int code = forget.getCode();
        String messages = forget.getMessage();
        if (code == 0) {
            Intent intent = new Intent(ForgetActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
            ToastUtil.showToast(ForgetActivity.this, messages, Toast.LENGTH_SHORT);
        } else if (code!=0){
            ToastUtil.showToast(ForgetActivity.this, messages, Toast.LENGTH_SHORT);
        }else if (!password.equals(passwordtwo)){
            Toast.makeText(ForgetActivity.this,"两次输入的密码不一样,请重新输入",Toast.LENGTH_SHORT).show();
        }else if (newPass.getText().toString().length()>6||newPass.getText().toString().length()<20){
            ToastUtil.showToast(ForgetActivity.this, "密码长度6-20位", Toast.LENGTH_SHORT);
        } else {
            ToastUtil.showToast(ForgetActivity.this, messages, Toast.LENGTH_SHORT);
        }
    }



    @Override
    public void showShopsData(String message) {
        Gson gson = new Gson();
        Shops shops = gson.fromJson(message, Shops.class);
        Shops.DataBean dataBeans = shops.getData();
        String phones = dataBeans.getPhone();

        //mtextName.setText(phones);
    }



    private class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            huoqu.setClickable(false);
            huoqu.setText(l / 1000 + "秒");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给Button设置文字
            huoqu.setText("重新获取");
            //设置可点击
            huoqu.setClickable(true);
        }
    }

}
