package com.science.com.rchs.view.activity;

import android.Manifest;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.science.com.rchs.MainActivity;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Add;
import com.science.com.rchs.data.bean.AddYou;
import com.science.com.rchs.data.bean.AddZhe;
import com.science.com.rchs.data.bean.Photo;
import com.science.com.rchs.datepicker.CustomDatePicker;
import com.science.com.rchs.datepicker.DateFormatUtils;
import com.science.com.rchs.di.contract.AddContract;
import com.science.com.rchs.di.contract.DatasContract;
import com.science.com.rchs.di.dialog.SelectDateDialog;
import com.science.com.rchs.di.presenter.AddPresenter;
import com.science.com.rchs.di.presenter.DatasPresenter;
import com.science.com.rchs.http.DatePickerDialog;
import com.science.com.rchs.http.DateUtils;
import com.science.com.rchs.http.PermissionsUtils;
import com.science.com.rchs.net.Base64;
import com.science.com.rchs.net.ImageUtils;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.frag_three.BottomStyleDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import study.com.wheelviewlibrary.listener.SelectInterface;



public class NewDiscountActivity extends AppCompatActivity implements DatasContract.DatasView, AddContract.AddView {

    @BindView(R.id.image_head)
    SimpleDraweeView imageHead;
    @BindView(R.id.choosetime)
    TextView choosetime;
    @BindView(R.id.endtime)
    TextView endtime;
    SimpleDraweeView imageColor;
    @BindView(R.id.image_kaquan)
    TextView imageKaquan;
    @BindView(R.id.rela_quan)
    RelativeLayout relaQuan;
    @BindView(R.id.jmje)
    RelativeLayout jmje;
    @BindView(R.id.rela_mjje)
    RelativeLayout relaMjje;
    @BindView(R.id.rela_yjje)
    RelativeLayout relaYjje;
    @BindView(R.id.rela_yhzk)
    RelativeLayout relaYhzk;
    @BindView(R.id.mlogin)
    Button mlogin;
    @BindView(R.id.kuncun_number)
    EditText kuncunNumber;
    @BindView(R.id.jmme)
    EditText jmme;
    @BindView(R.id.susm)
    EditText susm;
    @BindView(R.id.mjje)
    EditText mjje;
    @BindView(R.id.sytx)
    EditText sytx;
    @BindView(R.id.yh)
    TextView yh;
    @BindView(R.id.bianji)
    EditText bianji;
    @BindView(R.id.mlogin1)
    Button mlogin1;
    @BindView(R.id.mlogin3)
    Button mlogin3;
    @BindView(R.id.bian)
    EditText bian;

    private Unbinder unbinder;

    final String[] permiss = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA};
    private static int REQUEST_PERMISSION_CODE = 6;
    private DatasContract.DatasPresenter datasPresenter;
    private List list = new ArrayList();

    TimePickerDialog mDialogAll;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String startext;
    private String endstext;
    private Bitmap bitmap;
    private File  file;
    private AddContract.AddPresenter addPresenter;
    private String token;
    private String color;
    private String begin_timestamp;
    private String end_timestamp;

    private String stream;
    private String logo_url;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_discount);
        unbinder = ButterKnife.bind(this);
        ButterKnife.bind(this);

        //initTimerPicker();

        bian.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        bian.setText(s.subSequence(0, 1));
                        bian.setSelection(1);
                        return;
                    }
                }

                if (text.contains(".")) {
                    int index = text.indexOf(".");
                    if (index + 3 < text.length()) {
                        text = text.substring(0, index + 3);
                        bian.setText(text);
                        bian.setSelection(text.length());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        bianji.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        bianji.setText(s.subSequence(0, 1));
                        bianji.setSelection(1);
                        return;
                    }
                }

                if (text.contains(".")) {
                    int index = text.indexOf(".");
                    if (index + 3 < text.length()) {
                        text = text.substring(0, index + 3);
                        bianji.setText(text);
                        bianji.setSelection(text.length());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        jmme.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        jmme.setText(s.subSequence(0, 1));
                        jmme.setSelection(1);
                        return;
                    }
                }

                if (text.contains(".")) {
                    int index = text.indexOf(".");
                    if (index + 3 < text.length()) {
                        text = text.substring(0, index + 3);
                        jmme.setText(text);
                        jmme.setSelection(text.length());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mjje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        mjje.setText(s.subSequence(0, 1));
                        mjje.setSelection(1);
                        return;
                    }
                }

                if (text.contains(".")) {
                    int index = text.indexOf(".");
                    if (index + 3 < text.length()) {
                        text = text.substring(0, index + 3);
                        mjje.setText(text);
                        mjje.setSelection(text.length());
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        color = "Color010";

        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        datasPresenter = new DatasPresenter();
        datasPresenter.attachView(this);

        addPresenter = new AddPresenter();
        addPresenter.attachView(this);



        relaQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backgroundAlpha(0.6f);

                BottomStyleDialog.dialogShow(NewDiscountActivity.this, list, true, 2, new BottomStyleDialog.ResultEditListener() {
                    @Override
                    public void SureListener(String s) {
                        backgroundAlpha(1.0f);
                        imageKaquan.setText(s);
                        if (s.equals("代金券")) {
                            jmje.setVisibility(View.VISIBLE);
                            relaMjje.setVisibility(View.VISIBLE);
                            relaYjje.setVisibility(View.GONE);
                            relaYhzk.setVisibility(View.GONE);
                            mlogin1.setVisibility(View.GONE);
                            mlogin3.setVisibility(View.GONE);
                            mlogin.setVisibility(View.VISIBLE);

                        } else if (s.equals("优惠券")) {
                            jmje.setVisibility(View.GONE);
                            relaMjje.setVisibility(View.GONE);
                            relaYjje.setVisibility(View.VISIBLE);
                            relaYhzk.setVisibility(View.GONE);
                            mlogin.setVisibility(View.GONE);
                            mlogin3.setVisibility(View.GONE);
                            mlogin1.setVisibility(View.VISIBLE);
                        } else {
                            jmje.setVisibility(View.GONE);
                            relaMjje.setVisibility(View.GONE);
                            relaYjje.setVisibility(View.GONE);
                            relaYhzk.setVisibility(View.VISIBLE);
                            mlogin.setVisibility(View.GONE);
                            mlogin1.setVisibility(View.GONE);
                            mlogin3.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });


        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(NewDiscountActivity.this, true);
        StatusBarUtil.setTranslucentStatus(NewDiscountActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(NewDiscountActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(NewDiscountActivity.this, 0x55000000);
        }


        for (int i = 0; i < 1; i++) {
            list.add("优惠券");
            list.add("代金券");
            list.add("折扣券");
        }

    }

    @OnClick({R.id.image_head, R.id.choosetime, R.id.endtime, R.id.image_color, R.id.mlogin, R.id.mlogin1, R.id.mlogin3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mlogin:
                if (kuncunNumber.getText().toString().equals("") || jmme.getText().toString().equals("") || mjje.equals("")) {
                    Toast.makeText(NewDiscountActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    int  quantity = Integer.parseInt(kuncunNumber.getText().toString());
                    double reduce_cost = Double.parseDouble(jmme.getText().toString());
                    double least_cost = Double.parseDouble(mjje.getText().toString());
                    String notice = susm.getText().toString().trim();
                    String description = sytx.getText().toString().trim();
                    addPresenter.requestAddData(token, logo_url, color, begin_timestamp, end_timestamp, notice, description, quantity, String.valueOf(least_cost), String.valueOf(reduce_cost));
                }
                break;

            case R.id.mlogin1:
                if (kuncunNumber.getText().toString().equals("")){
                    Toast.makeText(NewDiscountActivity.this, "库存数量不能为空", Toast.LENGTH_SHORT).show();

                }else if (bian.getText().toString().equals("")){
                    ToastUtil.showToast(NewDiscountActivity.this,"请输入优惠金额",Toast.LENGTH_SHORT);
                }else {
                    int  quantity = Integer.parseInt(kuncunNumber.getText().toString());//库存数量
                    String notice = susm.getText().toString().trim();                   //使用提醒
                    double default_detail = Double.parseDouble(bian.getText().toString().trim());           //优惠金额
                    String description = sytx.getText().toString().trim();              //使用说明
                    addPresenter.requestAddYouData(token, logo_url, color, begin_timestamp, end_timestamp, notice, description, quantity,  String.valueOf(default_detail));

                    Log.i("asfasf",default_detail+"");
                }


                break;

            case R.id.mlogin3:
                if (kuncunNumber.getText().toString().equals("") ) {
                    Toast.makeText(NewDiscountActivity.this, "请填写库存数量", Toast.LENGTH_SHORT).show();
                } else if ( bianji.getText().toString().equals("")){
                    ToastUtil.showToast(NewDiscountActivity.this,"请输入优惠折扣",Toast.LENGTH_SHORT);

                }else {
                    int  quantity = Integer.parseInt(kuncunNumber.getText().toString());
                    double discount = Double.parseDouble(bianji.getText().toString().trim());
                    String notice = susm.getText().toString().trim();
                    String description = sytx.getText().toString().trim();
                    addPresenter.requestAddZheData(token, logo_url, color, begin_timestamp, end_timestamp, notice, description, quantity, String.valueOf(discount));
                    Log.i("afaxaf", String.valueOf(discount));
                }
                break;
            case R.id.image_color:
                Intent intent = new Intent(NewDiscountActivity.this, ColorActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.choosetime:

                DatePickerDialog datePickerDialog = new DatePickerDialog(NewDiscountActivity.this, new DatePickerDialog.PositiveBtnClick() {
                    @Override
                    public void onPositiveBtnClick(String year, String month, String day) {
                        String endTime = year+month+day;
                        choosetime.setText(endTime);
                        begin_timestamp = String.valueOf(DateUtils.getStringToDate(endTime)/1000L);
                    }
                });

                datePickerDialog.show();

                break;
            case R.id.endtime:
                DatePickerDialog datePickerDialogs = new DatePickerDialog(NewDiscountActivity.this, new DatePickerDialog.PositiveBtnClick() {
                    @Override
                    public void onPositiveBtnClick(String year, String month, String day) {
                        String startTime = year+month+day;
                        endtime.setText(startTime);
                        end_timestamp = String.valueOf(DateUtils.getStringToDate(startTime)/1000L);

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

                View p = View.inflate(NewDiscountActivity.this, R.layout.pip, null);
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
                        PermissionsUtils.getInstance().chekPermissions(NewDiscountActivity.this, permiss, new PermissionsUtils.IPermissionsResult() {
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
                        PermissionsUtils.getInstance().chekPermissions(NewDiscountActivity.this, permiss, new PermissionsUtils.IPermissionsResult() {
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
        datasPresenter.requestPhotoData(token,"data:image/jpg;base64,"+stream);

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
        Gson gson = new Gson();
        Photo photo = gson.fromJson(message, Photo.class);
        int code = photo.getCode();
        String messages = photo.getMessage();
        Object data = photo.getData();

        if (code==0){
            HashMap<Object,Object> hashMap = new HashMap((Map)data);
            logo_url = (String) hashMap.get("url");

            ToastUtil.showToast(NewDiscountActivity.this,"上传成功",Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(NewDiscountActivity.this,messages,Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void showBianData(String message) {

    }


    @Override
    public void showAddData(String message) {
        Gson gson = new Gson();
        Add addZhe = gson.fromJson(message,Add.class);
        String messages = addZhe.getMessage();
        int code = addZhe.getCode();
        if (code==0){
            ToastUtil.showToast(NewDiscountActivity.this,"创建成功",Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(NewDiscountActivity.this,messages,Toast.LENGTH_SHORT);

        }


    }

    @Override
    public void showAddZheData(String message) {
        Gson gson = new Gson();
        AddZhe addZhe = gson.fromJson(message,AddZhe.class);
        String messages = addZhe.getMessage();
        int code = addZhe.getCode();
        if (code==0){
            ToastUtil.showToast(NewDiscountActivity.this,"创建成功",Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(NewDiscountActivity.this,messages,Toast.LENGTH_SHORT);

        }

    }

    @Override
    public void showAddYouData(String message) {
        Gson gson = new Gson();
        AddYou addYou = gson.fromJson(message,AddYou.class);
        int code = addYou.getCode();
        String messages = addYou.getMessage();
        if (code==0){
            ToastUtil.showToast(NewDiscountActivity.this,"创建成功",Toast.LENGTH_SHORT);
        }else {
            ToastUtil.showToast(NewDiscountActivity.this,"创建成功",Toast.LENGTH_SHORT);

        }
    }

    private void backgroundAlpha(float f) {
        WindowManager.LayoutParams lp =getWindow().getAttributes();
        lp.alpha = f;
        getWindow().setAttributes(lp);
    }
}
