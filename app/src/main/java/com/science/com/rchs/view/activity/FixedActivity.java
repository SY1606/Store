package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.ChooseD;
import com.science.com.rchs.data.bean.Self;
import com.science.com.rchs.di.contract.ChooseDStoreContract;
import com.science.com.rchs.di.contract.SelfContract;
import com.science.com.rchs.di.presenter.ChooseDStorePresenter;
import com.science.com.rchs.di.presenter.SelfPresenter;
import com.science.com.rchs.net.SavePhoto;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;

import java.text.ParseException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;


public class FixedActivity extends AppCompatActivity implements SelfContract.SelfView, ChooseDStoreContract.ChooseDStoreView {

    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.texts)
    TextView texts;
    @BindView(R.id.baocun)
    TextView baocun;
    @BindView(R.id.textss)
    TextView textss;
    @BindView(R.id.fucks)
    LinearLayout fucks;
    private SelfContract.SelfPresenter selfPresenter;
    private int store_id;
    private String token;
    private String money;
    private ChooseDStoreContract.ChooseStoreDPresenter chooseStoreDPresenter;
    private String url;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed);
        ButterKnife.bind(this);



        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(FixedActivity.this, true);
        StatusBarUtil.setTranslucentStatus(FixedActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(FixedActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(FixedActivity.this, 0x55000000);
        }


        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        chooseStoreDPresenter = new ChooseDStorePresenter();
        chooseStoreDPresenter.attachView(this);
        SharedPreferences spsss = getSharedPreferences("ids", Context.MODE_PRIVATE);
        store_id = spsss.getInt("id", 0);

        chooseStoreDPresenter.requestChooseDStoreData(token, store_id);

        selfPresenter = new SelfPresenter();
        selfPresenter.attachView(this);

        Intent intent = getIntent();
        money = intent.getStringExtra("afadfa");
        texts.setText(money);
        selfPresenter.requestSelfData(token, store_id);


    }

    @OnClick({R.id.image, R.id.add, R.id.fan, R.id.baocun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.image:
                break;
            case R.id.add:
                Intent intent = new Intent(FixedActivity.this, AddCodeActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.fan:
                finish();
                break;
            case R.id.baocun:

                ToastUtil.showToast(FixedActivity.this, "已保存到相册", Toast.LENGTH_SHORT);
                String[] PERMISSIONS = {
                        "android.permission.READ_EXTERNAL_STORAGE",
                        "android.permission.WRITE_EXTERNAL_STORAGE"};
                //检测是否有写的权限
                int permission = ContextCompat.checkSelfPermission(FixedActivity.this,
                        "android.permission.WRITE_EXTERNAL_STORAGE");
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    // 没有写的权限，去申请写的权限，会弹出对话框
                    ActivityCompat.requestPermissions(FixedActivity.this, PERMISSIONS, 1);
                }
                try {
                    //创建savephoto类保存图片
                    SavePhoto savePhoto = new SavePhoto(FixedActivity.this);
                    savePhoto.SaveBitmapFromView(fucks);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
        }

}



    @Override
    public void showChooseDStoreData(String message) {
        Gson gson = new Gson();
        ChooseD chooseD = gson.fromJson(message, ChooseD.class);
        List<ChooseD.DataBean> dataBeans = chooseD.getData();
        //store_id = dataBeans.get(0).getId();
        String name = dataBeans.get(0).getName();

        textss.setText(name);

    }

    @Override
    public void showSelfData(String message) {

        Gson gson = new Gson();
        Self self = gson.fromJson(message, Self.class);
        Self.DataBean dataBean = self.getData();
        url = dataBean.getUrl();
        bitmap = QRCodeEncoder.syncEncodeQRCode(url + "?money=" + money, 700);
        image.setImageBitmap(bitmap);

    }
}
