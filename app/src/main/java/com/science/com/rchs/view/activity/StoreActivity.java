package com.science.com.rchs.view.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;

import com.science.com.rchs.data.bean.Storess;
import com.science.com.rchs.di.contract.StoreContract;
import com.science.com.rchs.di.presenter.StorePresenter;
import com.science.com.rchs.http.DatePickerDialog;
import com.science.com.rchs.http.DateUtils;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.activity_bill.DalisListActivity;
import com.science.com.rchs.view.adapter.StoreAdapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;




public class StoreActivity extends AppCompatActivity implements StoreContract.StoreView {

    private StoreContract.StorePresenter storePresenter;
    private RecyclerView recy_store;
    private TextView shai;
    private String token;
    StoreAdapter storeAdapter;

    private Button end_time;
    private Button start_time;
    private int startTime;
    private int endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);




        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        storePresenter = new StorePresenter();
        storePresenter.attachView(this);
        storePresenter.requestStoreData(token);

        storePresenter.requestStoresData(token,startTime,endTime);
        recy_store = findViewById(R.id.recy_store);

        ImageView fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(StoreActivity.this, true);
        StatusBarUtil.setTranslucentStatus(StoreActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(StoreActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(StoreActivity.this, 0x55000000);
        }

        shai = findViewById(R.id.shai);
        shai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final View p = View.inflate(StoreActivity.this, R.layout.pop_chai, null);
                final PopupWindow popupWindow = new PopupWindow(p, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                popupWindow.showAsDropDown(shai, 10, 40);
                backgroundAlpha(0.6f);



                popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        backgroundAlpha(1.0f);
                    }
                });

                TextView quxaio = p.findViewById(R.id.quxaio);
                TextView queding = p.findViewById(R.id.queding);
                start_time = p.findViewById(R.id.start_time);

                end_time = p.findViewById(R.id.end_time);

                //当前日期
                SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日");

                Calendar calendar = Calendar.getInstance();
              String  date =df.format(calendar.getTime());
                end_time.setText(date);
                start_time.setText(date);
                startTime = Integer.parseInt(String.valueOf(DateUtils.getStringToDate(date)/1000L));
                endTime = Integer.parseInt(String.valueOf(DateUtils.getStringToDate(date) / 1000L));

                Log.i("axcaxa",date);

                //开始日期
                start_time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        DatePickerDialog datePickerDialog = new DatePickerDialog(StoreActivity.this, new DatePickerDialog.PositiveBtnClick() {
                            @Override
                            public void onPositiveBtnClick(String year, String month, String day) {

                                String endTime = year+month+day;

                                start_time.setText(endTime);

                                Log.i("wdas",endTime);
                                startTime = Integer.parseInt(String.valueOf(DateUtils.getStringToDate(endTime)/1000L));
                            }
                        });

                        datePickerDialog.show();
                    }
                });

                //结束日期
                end_time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog datePickerDialogs = new DatePickerDialog(StoreActivity.this, new DatePickerDialog.PositiveBtnClick() {
                            @Override
                            public void onPositiveBtnClick(String year, String month, String day) {
                                String startTime = year + month + day;
                                end_time.setText(startTime);
                                endTime = Integer.parseInt(String.valueOf(DateUtils.getStringToDate(startTime) / 1000L));
                            }
                        });

                        datePickerDialogs.show();
                    }
                });


                quxaio.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        popupWindow.dismiss();
                        backgroundAlpha(1.0f);
                    }
                });
                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (startTime==endTime){
                            ToastUtil.showToast(StoreActivity.this,"开始时间不能等于结束时间",Toast.LENGTH_SHORT);
                        }else if (startTime>endTime) {
                            ToastUtil.showToast(StoreActivity.this,"开始时间不能大于结束时间",Toast.LENGTH_SHORT);

                        }else {
                            storePresenter.requestStoresData(token, startTime, endTime);
                            storePresenter.requestStoreData(token);
                            popupWindow.dismiss();
                        }


                    }
                });
            }
        });

}


    @Override
    public void showStoreData(String message) {
    }

    @Override
    public void showStoresData(String message) {

        Gson gson = new Gson();
        Storess store = gson.fromJson(message,Storess.class);
        List<Storess.DataBean> beans = store.getData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StoreActivity.this,LinearLayoutManager.VERTICAL,false);
        recy_store.setLayoutManager(linearLayoutManager);
        StoreAdapter storeAdapter = new StoreAdapter(R.layout.item_store, beans);
        recy_store.setAdapter(storeAdapter);



    }


    private void backgroundAlpha(float f) {
        WindowManager.LayoutParams lp =getWindow().getAttributes();
        lp.alpha = f;
        getWindow().setAttributes(lp);
    }
}
