package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Hexiao;
import com.science.com.rchs.data.bean.Hexiaos;
import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.contract.HexiaoContract;
import com.science.com.rchs.di.presenter.HexiaoPresenter;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import freemarker.template.utility.ObjectFactory;

public class HexiaoActivity extends AppCompatActivity implements HexiaoContract.HexiaoView{

    @BindView(R.id.mingxi)
    TextView mingxi;
    @BindView(R.id.codes)
    TextView codes;
    @BindView(R.id.hexiaos)
    EditText hexiaos;
    @BindView(R.id.view10)
    View view10;
    @BindView(R.id.sao)
    Button sao;
    @BindView(R.id.queding)
    Button queding;
    @BindView(R.id.fan)
    ImageView fan;
    private int REQUEST_CODE_SCAN = 111;
    private HexiaoContract.HexiaoPresenter hexiaoPresenter;
    private String token;
    private DaiContract.DaiPresenter daiPresenter;
    private String messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexiao);
        ButterKnife.bind(this);

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(HexiaoActivity.this, true);
        StatusBarUtil.setTranslucentStatus(HexiaoActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(HexiaoActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(HexiaoActivity.this, 0x55000000);
        }

        SharedPreferences sp =getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");


        hexiaoPresenter = new HexiaoPresenter();
        hexiaoPresenter.attachView(this);


    }

    @OnClick({R.id.mingxi, R.id.sao, R.id.queding,R.id.fan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mingxi:
                Intent intent = new Intent(HexiaoActivity.this, MingXiActivity.class);
                startActivity(intent);
                break;
            case R.id.fan:
                finish();
                break;
            case R.id.sao:
                AndPermission.with(HexiaoActivity.this)
                        .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                        .onGranted(new Action() {
                            @Override
                            public void onAction(List<String> permissions) {
                                Intent intent = new Intent(HexiaoActivity.this, CaptureActivity.class);
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

                        Toast.makeText(HexiaoActivity.this, "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                    }
                }).start();

                break;
            case R.id.queding:
               String code = hexiaos.getText().toString();
                hexiaoPresenter.requestHexiaoData(token, code);
                Log.i("asaaf",token);
                Log.i("eeee", code +"");
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                hexiaos.setText(content);
            }
        }
    }

    @Override
    public void showHexiaoData(String message) {
        Gson gson = new Gson();
        Hexiaos hexiao = gson.fromJson(message,Hexiaos.class);
        int codes = hexiao.getCode();
        String messages= hexiao.getMessage();
        Object data = hexiao.getData();
        if (codes==0){
            ToastUtil.showToast(HexiaoActivity.this,"核销成功",Toast.LENGTH_SHORT);
            hexiaos.getText().clear();
        }else if (hexiaos.getText().toString().equals("")){
            ToastUtil.showToast(HexiaoActivity.this,"请输入核销码",Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(HexiaoActivity.this,messages,Toast.LENGTH_SHORT);
        }
    }
}
