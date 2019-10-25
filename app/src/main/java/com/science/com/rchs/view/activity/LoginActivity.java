package com.science.com.rchs.view.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;
import com.science.com.rchs.R;

import com.science.com.rchs.data.bean.Bang;
import com.science.com.rchs.data.bean.LoginBean;
import com.science.com.rchs.di.contract.LoginContract;
import com.science.com.rchs.di.contract.ScanContract;
import com.science.com.rchs.di.presenter.LoginPresenter;
import com.science.com.rchs.di.presenter.ScanPresenter;
import com.science.com.rchs.http.PermissionsUtils;
import com.science.com.rchs.http.UserManage;
import com.science.com.rchs.keyword.ButtonUtil;

import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.SystemBarTintManager;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.weidgt.LoginButton;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.yzq.zxinglibrary.common.Constant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static anet.channel.bytes.a.TAG;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView,ScanContract.ScanView {

    @BindView(R.id.medit_phone)
    EditText meditPhone;
    @BindView(R.id.medit_pass)
    EditText meditPass;
    @BindView(R.id.yin)
    CheckBox yin;
    @BindView(R.id.forget)
    TextView forget;
    @BindView(R.id.mlogin)
    Button mlogin;
    @BindView(R.id.mlogins)
    Button mlogins;

    private String grant_type = "mch";
    private String password;

    private String mch_seller_number;
    private SharedPreferences.Editor edit;
    public static SharedPreferences sp;
    final String[] permiss = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.INTERNET};

    int page = 1;
    String client_agent = "android";
    Context context = LoginActivity.this;
    private LoginContract.LoginPresenter loginPresenter;

    long t1 = 0;//记录上一次单击的时间，初始值为0
    private String messages;
    private String token;


    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private static long lastClickTime;
    ScanContract.ScanPresenter scanPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        PushAgent.getInstance(this).onAppStart();
        Fresco.initialize(this);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        scanPresenter = new ScanPresenter();
        scanPresenter.attachView(this);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        meditPhone.setText(sp.getString("mch_seller_number", ""));
        meditPass.setText(sp.getString("password", ""));
        token = sp.getString("token", "");

        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);

        Intent intent = getIntent();
        String password  = intent.getStringExtra("mima");
        //String zhanghao = intent.getStringExtra("zhanghao");
        meditPass.setText(password);
        //meditPhone.setText(zhanghao);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(intent);
            }
        });

        //loginPresenter.requestLoginData(grant_type,mch_seller_number,password);
        //隐藏密码
        yin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    meditPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    meditPass.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }
            }
        });
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(LoginActivity.this, true);
        StatusBarUtil.setTranslucentStatus(LoginActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(LoginActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(LoginActivity.this, 0x55000000);
        }


    }


    @OnClick({R.id.medit_phone, R.id.medit_pass, R.id.yin, R.id.forget, R.id.mlogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.medit_phone:
                break;
            case R.id.medit_pass:
                break;
            case R.id.forget:
                break;
            case R.id.mlogin:
                PermissionsUtils.getInstance().chekPermissions(LoginActivity.this, permiss, new PermissionsUtils.IPermissionsResult() {
                    @Override
                    public void passPermissons() {

                        UMConfigure.init(LoginActivity.this, "5d5b4d493fc195d0320006c9", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "84ca658ed4bdca340aa23cab6f4b8e4f");
                        PushAgent mPushAgent = PushAgent.getInstance(LoginActivity.this);
                        mPushAgent.register(new IUmengRegisterCallback() {
                            @Override
                            public void onSuccess(String device_token) {

                                //device_token = deviceToken;
                                //ScanContract.ScanPresenter scanPresenter = new ScanPresenter();
                                //scanPresenter.attachView(this);


                                //scanPresenter.requestBangData(token,device_token,client_agent);

                                mch_seller_number = meditPhone.getText().toString();
                                password = meditPass.getText().toString();

                                loginPresenter.requestLoginData(grant_type, mch_seller_number, password);
                                UserManage.getInstance().saveUserInfo(LoginActivity.this, mch_seller_number, password);

                                Log.i(TAG,"注册成功：deviceToken：-------->  " + device_token);
                            }
                            @Override
                            public void onFailure(String s, String s1) {
                                Log.e(TAG,"注册失败：-------->  " + "s:" + s + ",s1:" + s1);
                            }
                        });


                    }

                    @Override
                    public void forbitPermissons() {
                    }
                });

                break;
        }
    }

    @Override
    public void showData(final String message) {

        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(message, LoginBean.class);
        int code = loginBean.getCode();
        Object data = loginBean.getData();
        if (code == 0) {
            ToastUtil.showToast(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT);
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
            HashMap<Object,Object> hashMap = new HashMap((Map)data);
            token = (String) hashMap.get("access_token");
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("token", token);
            edit.putString("mch_seller_number", mch_seller_number);
            edit.putString("password", password);
            edit.commit();
        }else {
            ToastUtil.showToast(LoginActivity.this, "用户名/密码不正确", Toast.LENGTH_SHORT);

        }

    }

    @Override
    public void showScanData(String message) {

    }

    @Override
    public void showScanPayData(String message) {

    }

    @Override
    public void showBandData(String message) {
    }

    @Override
    public void showCodesData(String message) {

    }

    @Override
    public void showScan_PayData(String message) {

    }

    @Override
    public void showScan_PaySData(String message) {

    }
}
