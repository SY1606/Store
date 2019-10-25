package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.MemList;
import com.science.com.rchs.data.bean.Xiaofei;
import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.contract.XiaofeiContract;
import com.science.com.rchs.di.presenter.MemListPresenter;
import com.science.com.rchs.di.presenter.XiaofeiPresenter;
import com.science.com.rchs.keyword.KeyboardUtil;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConsumeActivity extends AppCompatActivity implements XiaofeiContract.XiaofeiView, MemListContract.MemListView {

    @BindView(R.id.money)
    EditText money;
    @BindView(R.id.number)
    EditText number;
    @BindView(R.id.sao)
    Button sao;
    @BindView(R.id.record)
    TextView record;
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.cum_money)
    TextView cumMoney;
    @BindView(R.id.yu)
    TextView yu;
    @BindView(R.id.mlogin)
    Button mlogin;

    private int REQUEST_CODE_SCAN = 111;
    private String token;
    String remark = "会员卡消费";
    private XiaofeiContract.XiaofeiPresenter xiaofeiPresenter;

    private String card_number;
    private MemListContract.MemListPresenter memListPresenter;
    private String value;
    private String messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consume);
        ButterKnife.bind(this);

        money.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                String text = s.toString();

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        money.setText(s.subSequence(0, 1));
                        money.setSelection(1);
                        return;
                    }
                }

                if (text.contains(".")) {
                    int index = text.indexOf(".");
                    if (index + 3 < text.length()) {
                        text = text.substring(0, index + 3);
                        money.setText(text);
                        money.setSelection(text.length());
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });


        money.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        xiaofeiPresenter = new XiaofeiPresenter();
        xiaofeiPresenter.attachView(this);


        memListPresenter = new MemListPresenter();
        memListPresenter.attachView(this);
        memListPresenter.requestMemListData(token);

        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(ConsumeActivity.this, CRecordActivity.class);
                startActivity(intent3);
            }
        });

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(ConsumeActivity.this, true);
        StatusBarUtil.setTranslucentStatus(ConsumeActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(ConsumeActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(ConsumeActivity.this, 0x55000000);
        }


        /*keyboardUtil.setOnOkClick(new KeyboardUtil.OnOkClick() {
            @Override
            public void onOkClick() {
                if (money.getText().toString().equals("")) {
                    Toast.makeText(ConsumeActivity.this, "请输入收款金额", Toast.LENGTH_SHORT).show();
                } else if (number.getText().toString().equals("")) {
                    ToastUtil.showToast(ConsumeActivity.this, "请输入会员卡号", Toast.LENGTH_SHORT);

                } else {

                }
            }
        });*/
        sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AndPermission.with(ConsumeActivity.this)
                        .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                        .onGranted(new Action() {
                            @Override
                            public void onAction(List<String> permissions) {
                                Intent intent = new Intent(ConsumeActivity.this, CaptureActivity.class);
                                /*ZxingConfig是配置类
                                 *可以设置是否显示底部布局，闪光灯，相册，
                                 * 是否播放提示音  震动
                                 * 设置扫描框颜色等
                                 * 也可以不传这个参数
                                 * */
                                ZxingConfig config = new ZxingConfig();
                                // config.setPlayBeep(false);//是否播放扫描声音 默认为true
                                //  config.setShake(false);//是否震动  默认为true
                                // config.setDecodeBarCode(false);//是否扫描条形码 默认为true
//                                config.setReactColor(R.color.colorAccent);//设置扫描框四个角的颜色 默认为白色
//                                config.setFrameLineColor(R.color.colorAccent);//设置扫描框边框颜色 默认无色
//                                config.setScanLineColor(R.color.colorAccent);//设置扫描线的颜色 默认白色
                                //config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                                startActivityForResult(intent, REQUEST_CODE_SCAN);
                            }
                        }).onDenied(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        Uri packageURI = Uri.parse("package:" + getPackageName());
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        startActivity(intent);

                        Toast.makeText(ConsumeActivity.this, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                    }
                }).start();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Constant.CODED_CONTENT);
                number.setText(content);
            }
        }
    }

    @OnClick({R.id.fan, R.id.cum_money,R.id.mlogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                finish();
                break;
            case R.id.cum_money:
                break;
            case R.id.mlogin:
                if (money.getText().toString().equals("")) {
                    Toast.makeText(ConsumeActivity.this, "请输入金额", Toast.LENGTH_SHORT).show();
                } else if (number.getText().toString().equals("")) {
                    ToastUtil.showToast(ConsumeActivity.this, "请输入会员卡号", Toast.LENGTH_SHORT);

                } else {
                    double values = Double.parseDouble(money.getText().toString());
                    value = String.valueOf(values * -1);
                    card_number = number.getText().toString();
                    xiaofeiPresenter.requestXiaofeiData(token, card_number, value, remark);
                }
                break;
        }
    }

    @Override
    public void showXiaofeiData(String message) {

        Gson gson = new Gson();
        Xiaofei xiaofei = gson.fromJson(message, Xiaofei.class);
        int errcode = xiaofei.getCode();
        String messages = xiaofei.getMessage();
        if (errcode== 400) {
            Toast.makeText(ConsumeActivity.this, messages, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(ConsumeActivity.this, messages, Toast.LENGTH_SHORT).show();
            money.getText().clear();
            number.getText().clear();
        }
    }


    @Override
    public void showPhotoData(String message) {
        Gson gson = new Gson();
        MemList memList = gson.fromJson(message, MemList.class);
        final List<MemList.DataBean> beans = memList.getData();
        for (int i = 0; i < beans.size(); i++) {
            String yue = beans.get(i).getBalance();
        }
    }
}

