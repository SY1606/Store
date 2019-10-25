package com.science.com.rchs.view.activity;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.MainActivity;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Self;
import com.science.com.rchs.di.contract.QRcodeContract;
import com.science.com.rchs.di.contract.SelfContract;
import com.science.com.rchs.di.contract.StoreContract;
import com.science.com.rchs.di.presenter.SelfPresenter;

import com.science.com.rchs.net.SavePhoto;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;


public class SelfActivity extends AppCompatActivity implements SelfContract.SelfView {
    private static final int REQUEST_CODE_SAVE_IMG = 10;
    private static final String TAG = "MainActivity";
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.baocun)
    TextView baocun;
    @BindView(R.id.erweima)
    ImageView erweima;
    @BindView(R.id.xxx)
    RelativeLayout xxx;


    private QRcodeContract.QRcodePresenter qRcodePresenter;
    private String token;

    private Bitmap bitmap;
    private SelfContract.SelfPresenter selfPresenter;
    private StoreContract.StorePresenter storePresenter;
    private String url;
    private int store_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self);
        ButterKnife.bind(this);

        StatusBarUtil.setRootViewFitsSystemWindows(SelfActivity.this, true);
        StatusBarUtil.setTranslucentStatus(SelfActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(SelfActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(SelfActivity.this, 0x55000000);
        }
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        selfPresenter = new SelfPresenter();
        selfPresenter.attachView(this);
        SharedPreferences sps = getSharedPreferences("ids", Context.MODE_PRIVATE);
        store_id = sps.getInt("id", 0);
        selfPresenter.requestSelfData(token, store_id);
        Log.i("gaxaca", store_id + "");

        baocun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(SelfActivity.this,"已保存到相册",Toast.LENGTH_SHORT);
                String[] PERMISSIONS = {
                        "android.permission.READ_EXTERNAL_STORAGE",
                        "android.permission.WRITE_EXTERNAL_STORAGE" };
                //检测是否有写的权限
                int permission = ContextCompat.checkSelfPermission(SelfActivity.this,
                        "android.permission.WRITE_EXTERNAL_STORAGE");
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    // 没有写的权限，去申请写的权限，会弹出对话框
                    ActivityCompat.requestPermissions(SelfActivity.this, PERMISSIONS,1);
                }
                try {
                    //创建savephoto类保存图片
                    SavePhoto savePhoto = new SavePhoto(SelfActivity.this);
                    savePhoto.SaveBitmapFromView(xxx);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }

        });

    }

            @OnClick({R.id.fan})
            public void onViewClicked(View view) {
                switch (view.getId()) {
                    case R.id.fan:
                        finish();
                        break;
                }

            }


            //支付码
            @Override
            public void showSelfData(String message) {

                Gson gson = new Gson();
                Self self = gson.fromJson(message, Self.class);
                Self.DataBean dataBean = self.getData();
                url = dataBean.getUrl();
                Bitmap bitmap = QRCodeEncoder.syncEncodeQRCode(url, 230);
                erweima.setImageBitmap(bitmap);
            }

}
