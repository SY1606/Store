package com.science.com.rchs.view.activity;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.LoginFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bang;
import com.science.com.rchs.data.bean.ChooseD;
import com.science.com.rchs.data.bean.Scan;
import com.science.com.rchs.data.bean.ScanPay;
import com.science.com.rchs.data.bean.Scans;
import com.science.com.rchs.di.contract.ChooseDStoreContract;
import com.science.com.rchs.di.contract.ScanContract;
import com.science.com.rchs.di.presenter.ChooseDStorePresenter;
import com.science.com.rchs.di.presenter.ScanPresenter;
import com.science.com.rchs.keyword.KeyboardUtil;
import com.science.com.rchs.keyword.MyKeyBoardView;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static anet.channel.bytes.a.TAG;


public class SacnActivity extends AppCompatActivity implements ScanContract.ScanView, ChooseDStoreContract.ChooseDStoreView {

    private EditText jine;
    private KeyboardUtil keyboardUtil;
    private MyKeyBoardView keyboard_view;
    private TextView you;
    private int REQUEST_CODE_SCAN = 111;
    private TextView restult;
    private ImageView fan;
    private String token;
    private ScanContract.ScanPresenter scanPresenter;
    int store_id;
    private String total;
    private String pay_code;
    String pay_method = "unknow";
    String pay_type = "base";
    ChooseDStoreContract.ChooseStoreDPresenter chooseStoreDPresenter;
    private String pay_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sacn);
        jine = findViewById(R.id.jine);


        chooseStoreDPresenter = new ChooseDStorePresenter();
        chooseStoreDPresenter.attachView(this);


        SharedPreferences sps = getSharedPreferences("ids", Context.MODE_PRIVATE);
        store_id = sps.getInt("id", 0);

        chooseStoreDPresenter.requestChooseDStoreData(token, store_id);


        jine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        jine.setText(s.subSequence(0, 1));
                        jine.setSelection(1);
                        return;
                    }
                }

                if (text.contains(".")) {
                    int index = text.indexOf(".");
                    if (index + 3 < text.length()) {
                        text = text.substring(0, index + 3);
                        jine.setText(text);
                        jine.setSelection(text.length());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        SharedPreferences sp =getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");



        fan = findViewById(R.id.fan);
        keyboardUtil = new KeyboardUtil(this);
        keyboard_view = findViewById(R.id.keyboard_view);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(SacnActivity.this, true);
        StatusBarUtil.setTranslucentStatus(SacnActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(SacnActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(SacnActivity.this, 0x55000000);
        }
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        you = findViewById(R.id.you);
        you.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jine.getText().toString().equals("")){
                    Toast.makeText(SacnActivity.this,"请输入收款金额",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(SacnActivity.this,Scan_hActivity.class);
                    intent.putExtra("aaa",jine.getText().toString().trim());
                    startActivity(intent);
                }
            }
        });

       SharedPreferences spss = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = spss.getString("token", "");

        scanPresenter = new ScanPresenter();
        scanPresenter.attachView(this);



        jine.setInputType(InputType.TYPE_NULL);
        jine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyboardUtil.attachTo(jine);
            }
        });
        keyboardUtil.attachTo(jine);
        keyboardUtil.setOnOkClick(new KeyboardUtil.OnOkClick() {
            @Override
            public void onOkClick() {
                if (jine.getText().toString().equals("")){
                    Toast.makeText(SacnActivity.this,"请输入收款金额",Toast.LENGTH_SHORT).show();
                }else if (jine.getText().toString().equals("0")){
                    Toast.makeText(SacnActivity.this,"不能为0",Toast.LENGTH_SHORT).show();
                }else {
                    AndPermission.with(SacnActivity.this)
                            .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                            .onGranted(new Action() {
                                @Override
                                public void onAction(List<String> permissions) {
                                    Intent intent = new Intent(SacnActivity.this, CaptureActivity.class);
                                    ZxingConfig config = new ZxingConfig();

                                    intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                                    startActivityForResult(intent, REQUEST_CODE_SCAN);
                                    total = jine.getText().toString();

                                }
                            }) .onDenied(new Action() {
                        @Override
                        public void onAction(List<String> permissions) {
                            Uri packageURI = Uri.parse("package:" + getPackageName());
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                            startActivity(intent);

                            Toast.makeText(SacnActivity.this, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                        }
                    }).start();
                }
            }

        });



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



    @Override
    public void showScanPayData(String message) {
       /* Gson gson = new Gson();
        ScanPay scan = gson.fromJson(message,ScanPay.class);
        String messages = scan.getMessage();
        int code = scan.getCode();
        if (code==0){
            jine.getText().clear();
            Intent intent = new Intent(SacnActivity.this,SuccessActivity.class);
            intent.putExtra("ress",total);
            jine.getText().clear();
            startActivity(intent);

        }else {
            //ToastUtil.showToast(SacnActivity.this,messages,Toast.LENGTH_SHORT);
            //Intent intent = new Intent(SacnActivity.this,Ti_fActivity.class);
            //startActivity(intent);
        }*/
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                pay_code = data.getStringExtra(Constant.CODED_CONTENT);
                scanPresenter.requestScanData(token,store_id,total,pay_method,pay_code,pay_type);
                Log.i("xxxx",token);
                Log.i("ddddd",store_id+"");
                Log.i("kkkk",total+"");
                Log.i("aaaa",pay_method);
                Log.i("vvvv",pay_code);
                Log.i("hhhh",pay_type);

            }
        }
    }

    @Override
    public void showChooseDStoreData(String message) {
        Gson gson = new Gson();
        ChooseD chooseD = gson.fromJson(message, ChooseD.class);

        List<ChooseD.DataBean> dataBeans = chooseD.getData();
            store_id = dataBeans.get(0).getId();
    }

    @Override
    public void showScanData(String message) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                Scan scans = gson.fromJson(message, Scan.class);
                int code = scans.getCode();
                String messages = scans.getMessage();
                if (code == 0) {
                    Intent intent = new Intent(SacnActivity.this, SuccessActivity.class);
                    intent.putExtra("ress", total);
                    jine.getText().clear();
                    startActivity(intent);
                    Log.i("dxcda", message);
                } else {
                    ToastUtil.showToast(SacnActivity.this, messages, Toast.LENGTH_SHORT);
                }

            }
        });

        /*if (code==500){
            ToastUtil.showToast(SacnActivity.this,messages,Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(SacnActivity.this,messages,Toast.LENGTH_SHORT);

        }*/

        //Object data = scans.getData();
        /*if (code==0){
            ToastUtil.showToast(SacnActivity.this,"支付成功",Toast.LENGTH_SHORT);
            //HashMap<Object,Object> hashMap = new HashMap((Map)data);
            //pay_status = (String) hashMap.get("pay_status");
            Log.i("Scans1",message);

        }else if (code==500){
            ToastUtil.showToast(SacnActivity.this,"支付失败请重试",Toast.LENGTH_SHORT);
            Log.i("Scans1",message);
        }*/
        /*if (code==0&&pay_status.equals("loading")){
            ToastUtil.showToast(SacnActivity.this,"正在支付中",Toast.LENGTH_SHORT);
        }else if (code==0&&pay_status.equals("scan")){
            ToastUtil.showToast(SacnActivity.this,"支付成功",Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(SacnActivity.this,"失败",Toast.LENGTH_SHORT);
        }*/


        /*if (code==0&&status1.equals("loading")){
            ToastUtil.showToast(SacnActivity.this,"正在支付中",Toast.LENGTH_SHORT);
        }else if (code==0&&status1.equals("scan")){
            ToastUtil.showToast(SacnActivity.this,"支付成功",Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(SacnActivity.this,"失败",Toast.LENGTH_SHORT);
        }*/

        /*Gson gson = new Gson();
        Scan scan = gson.fromJson(message,Scan.class);
        String messages = scan.getMessage();
        int code = scan.getCode();
        ToastUtil.showToast(SacnActivity.this,messages,Toast.LENGTH_SHORT);
        if (code==0){
            //ToastUtil.showToast(SacnActivity.this,messages,Toast.LENGTH_SHORT);
            Intent intent = new Intent(SacnActivity.this,SuccessActivity.class);
            intent.putExtra("ress",total);
            jine.getText().clear();
            startActivity(intent);
        }else {
            ToastUtil.showToast(SacnActivity.this,messages,Toast.LENGTH_SHORT);
        }
        /*else {

            //Intent intent = new Intent(SacnActivity.this,Ti_fActivity.class);
            //startActivity(intent);
        }*/

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        scanPresenter.detachView(this);
    }
}
