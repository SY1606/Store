package com.science.com.rchs.view.activity;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bian1;
import com.science.com.rchs.data.bean.Photo;
import com.science.com.rchs.di.contract.BianjiContract;
import com.science.com.rchs.di.contract.DatasContract;
import com.science.com.rchs.di.presenter.BianjiPresenter;
import com.science.com.rchs.di.presenter.DatasPresenter;
import com.science.com.rchs.http.DatePickerDialog;
import com.science.com.rchs.http.DateUtils;
import com.science.com.rchs.http.PermissionsUtils;
import com.science.com.rchs.net.ImageUtils;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.SystemBarTintManager;
import com.science.com.rchs.net.ToastUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Bianji1Activity extends AppCompatActivity implements BianjiContract.BianjiView, DatasContract.DatasView {

    @BindView(R.id.image_head)
    SimpleDraweeView imageHead;
    @BindView(R.id.mlogin)
    Button mlogin;
    @BindView(R.id.choosetime)
    TextView choosetime;
    @BindView(R.id.endtime)
    TextView endTime;
    @BindView(R.id.susm)
    EditText susm;
    @BindView(R.id.sytx)
    EditText sytx;
    @BindView(R.id.fan)
    ImageView fan;
    @BindView(R.id.bian)
    TextView bian;
    private String coupon_id;
    private Bitmap bitmap;
    private File file;
    String type = "general_coupon";
    private String token;

    private DatasContract.DatasPresenter datasPresenter;

    final String[] permiss = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};
    private static int REQUEST_PERMISSION_CODE = 6;
    private String logo_url;
    private String stream;
    private BianjiContract.BianjiPresenter bianjiPresenter;
    String color = "Color010";
    private String begin_timestamp;
    private String end_timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bianji1);
        ButterKnife.bind(this);
        applyKitKatTranslucency();
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(Bianji1Activity.this, true);
        StatusBarUtil.setTranslucentStatus(Bianji1Activity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(Bianji1Activity.this, true)) {
            StatusBarUtil.setStatusBarColor(Bianji1Activity.this, 0x55000000);
        }


        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        datasPresenter = new DatasPresenter();
        datasPresenter.attachView(this);

        Intent intent = getIntent();
         logo_url = intent.getStringExtra("logo");
        // Log.i("aaxca", logo_url + "");
        imageHead.setImageURI(Uri.parse(logo_url));


        coupon_id = intent.getStringExtra("id");

        String name = intent.getStringExtra("names");
        bian.setText(name);
        String begin_timestamp = intent.getStringExtra("start");
        choosetime.setText(begin_timestamp);

        String end_timestamp = intent.getStringExtra("end");
        endTime.setText(end_timestamp);

        bianjiPresenter = new BianjiPresenter();
        bianjiPresenter.attachView(this);


    }

    @Override
    public void showBianjiData(String message) {
        Gson gson = new Gson();
        Bian1 bian1 = gson.fromJson(message, Bian1.class);
        int code = bian1.getCode();
        String messages = bian1.getMessage();
        if (code == 0) {
            ToastUtil.showToast(Bianji1Activity.this, messages, Toast.LENGTH_SHORT);
        } else {
            ToastUtil.showToast(Bianji1Activity.this, messages, Toast.LENGTH_SHORT);

        }
    }

    @OnClick({R.id.image_head, R.id.choosetime, R.id.endtime, R.id.mlogin, R.id.fan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fan:
                finish();
                break;
            case R.id.mlogin:

                String notice = susm.getText().toString().trim();
                String description = sytx.getText().toString().trim();

                bianjiPresenter.requestBianjiData(token, coupon_id, type, logo_url, color, notice, description,begin_timestamp,end_timestamp);

                break;
            case R.id.choosetime:
                DatePickerDialog datePickerDialog = new DatePickerDialog(Bianji1Activity.this, new DatePickerDialog.PositiveBtnClick() {

                    @Override
                    public void onPositiveBtnClick(String year, String month, String day) {

                        String endTime = year + month + day;

                        choosetime.setText(endTime);

                        Log.i("wdas", endTime);
                        begin_timestamp = String.valueOf(DateUtils.getStringToDate(endTime) / 1000L);
                        Log.i("axaa", begin_timestamp);
                    }
                });

                datePickerDialog.show();

                break;
            case R.id.endtime:
                DatePickerDialog datePickerDialogs = new DatePickerDialog(Bianji1Activity.this, new DatePickerDialog.PositiveBtnClick() {

                    @Override
                    public void onPositiveBtnClick(String year, String month, String day) {
                        String startTime = year + month + day;
                        endTime.setText(startTime);
                        end_timestamp = String.valueOf(DateUtils.getStringToDate(startTime) / 1000L);
                    }
                });

                datePickerDialogs.show();
                break;
            case R.id.image_head:
                //读写权限
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
                    }
                }

                View p = View.inflate(Bianji1Activity.this, R.layout.pip, null);
                final PopupWindow popupWindow = new PopupWindow(p, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                popupWindow.showAtLocation(view, Gravity.RIGHT | Gravity.BOTTOM, 10, 10);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);

                backgroundAlpha(0.6f);
                Button xiangji = p.findViewById(R.id.xiangji);
                Button xiangce = p.findViewById(R.id.xiangce);
                Button quxiao = p.findViewById(R.id.quxiao);


                //照相机
                xiangji.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PermissionsUtils.getInstance().chekPermissions(Bianji1Activity.this, permiss, new PermissionsUtils.IPermissionsResult() {
                            @Override
                            public void passPermissons() {
                                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                intent.addCategory("android.intent.category.DEFAULT");
                                startActivityForResult(intent, 101);
                                popupWindow.dismiss();
                                backgroundAlpha(1.0f);
                            }

                            @Override
                            public void forbitPermissons() {

                            }
                        });
                    }
                });

                //相册
                xiangce.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PermissionsUtils.getInstance().chekPermissions(Bianji1Activity.this, permiss, new PermissionsUtils.IPermissionsResult() {
                            @Override
                            public void passPermissons() {
                                Intent intent = new Intent(Intent.ACTION_PICK);
                                intent.setType("image/*");
                                startActivityForResult(intent, 202);
                                popupWindow.dismiss();
                                backgroundAlpha(1.0f);
                            }

                            @Override
                            public void forbitPermissons() {

                            }
                        });
                    }
                });
                //取消
                quxiao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                        backgroundAlpha(1.0f);
                    }
                });
                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        backgroundAlpha(1.0f);
                    }
                });
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        } else if (requestCode == 101) {
            bitmap = data.getParcelableExtra("data");
            imageHead.setImageBitmap(bitmap);


            //将bitmap类型转换成uri
            Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, null, null));
            addHeaderPhoto(uri);


        }
        if (requestCode == 202) {
            Uri uri = data.getData();
            addHeaderPhoto(uri);
            imageHead.setImageURI(uri);

        } else if (data == null) {
            return;
        }
        datasPresenter.requestPhotoData(token, "data:image/jpg;base64," + stream);

    }

    private void addHeaderPhoto(Uri uri) {
        //将uri类型转换成file
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String string = cursor.getString(columnIndex);
        file = new File(string);
        stream = ImageUtils.bitmapToString(String.valueOf(file));

    }


    //上传头像
    @Override
    public void showPhotoData(String message) {
        ToastUtil.showToast(Bianji1Activity.this, message, Toast.LENGTH_SHORT);
        Gson gson = new Gson();
        Photo photo = gson.fromJson(message, Photo.class);
        int code = photo.getCode();
        String messages = photo.getMessage();
        Object data = photo.getData();

        if (code == 0) {
            HashMap<Object, Object> hashMap = new HashMap((Map) data);
            logo_url = (String) hashMap.get("url");
            ToastUtil.showToast(Bianji1Activity.this, messages, Toast.LENGTH_SHORT);
        } else {
            ToastUtil.showToast(Bianji1Activity.this, messages, Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void showBianData(String message) {

    }

    private void backgroundAlpha(float f) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = f;
        getWindow().setAttributes(lp);
    }

    private void applyKitKatTranslucency() {

        // KitKat translucent navigation/status bar.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
            SystemBarTintManager mTintManager = new SystemBarTintManager(this);
            mTintManager.setStatusBarTintEnabled(true);

            mTintManager.setStatusBarTintResource(R.color.colorBlue_Three);//通知栏所需颜色
        }


    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }


}