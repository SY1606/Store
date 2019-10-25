package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaMuxer;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Open;
import com.science.com.rchs.di.contract.OpenContract;
import com.science.com.rchs.di.presenter.OpenPresenter;
import com.science.com.rchs.net.SavePhoto;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;

import java.text.ParseException;
import java.util.concurrent.atomic.AtomicBoolean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class OpenActivity extends AppCompatActivity implements OpenContract.OpenView {

    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.record)
    TextView record;
    @BindView(R.id.cao)
    LinearLayout cao;
    private ImageView images;
    String type = "phone";
    private String token;
    private OpenContract.OpenPresenter openPresenter;
    private ImageView iamge1;


    private static final int RECORDER_CODE = 0;
    private static final String TAG = "TAG";

    int width;
    int height;
    int dpi;

    MediaProjectionManager projectionManager;
    MediaProjection mediaProjection;
    MediaCodec mediaCodec;
    MediaMuxer mediaMuxer;

    Surface surface;
    VirtualDisplay virtualDisplay;
    private MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
    private int videoTrackIndex = -1;

    String filePath;
    private AtomicBoolean mQuit = new AtomicBoolean(false);
    private boolean muxerStarted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        ButterKnife.bind(this);

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(OpenActivity.this, true);
        StatusBarUtil.setTranslucentStatus(OpenActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(OpenActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(OpenActivity.this, 0x55000000);
        }

        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        images = findViewById(R.id.images);

        openPresenter = new OpenPresenter();
        openPresenter.attachView(this);
        openPresenter.requestOpenData(token, type);
    }

    @Override
    public void showOpenData(String message) {
        Gson gson = new Gson();
        Open open = gson.fromJson(message, Open.class);
        Open.DataBean bean = open.getData();
        Glide.with(this).load(bean.getQrcodeUrl()).into(images);
    }

    @OnClick({R.id.fan, R.id.record})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                finish();
                break;
            case R.id.record:
                ToastUtil.showToast(OpenActivity.this, "以保存到相册", Toast.LENGTH_SHORT);
                String[] PERMISSIONS = {
                        "android.permission.READ_EXTERNAL_STORAGE",
                        "android.permission.WRITE_EXTERNAL_STORAGE"};
                //检测是否有写的权限
                int permission = ContextCompat.checkSelfPermission(OpenActivity.this,
                        "android.permission.WRITE_EXTERNAL_STORAGE");
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    // 没有写的权限，去申请写的权限，会弹出对话框
                    ActivityCompat.requestPermissions(OpenActivity.this, PERMISSIONS, 1);
                }
                try {
                    //创建savephoto类保存图片
                    SavePhoto savePhoto = new SavePhoto(OpenActivity.this);
                    savePhoto.SaveBitmapFromView(cao);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
        }
    }

}
