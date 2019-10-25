package com.science.com.rchs.view.activity_bill;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.google.gson.Gson;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DalistList;
import com.science.com.rchs.di.contract.DalisListContract;
import com.science.com.rchs.di.presenter.DalistListPresenter;
import com.science.com.rchs.http.DatePickerDialog;
import com.science.com.rchs.http.DateUtils;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.activity.StoreActivity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DalisListActivity extends AppCompatActivity implements DalisListContract.DalisListView {

    @BindView(R.id.shai)
    TextView shai;
    @BindView(R.id.baocun)
    Button baocun;
    @BindView(R.id.weixin_money)
    TextView weixinMoney;
    @BindView(R.id.pay_money)
    TextView payMoney;
    @BindView(R.id.leiji)
    TextView leiji;
    @BindView(R.id.weixin_number)
    TextView weixinNumber;
    @BindView(R.id.pay_number)
    TextView payNumber;
    @BindView(R.id.number)
    TextView number;
    @BindView(R.id.xiaofei)
    TextView xiaofei;
    @BindView(R.id.chongzhi)
    TextView chongzhi;
    @BindView(R.id.kaquan)
    TextView kaquan;
    @BindView(R.id.stattimes)
    TextView stattimes;
    @BindView(R.id.endtimes)
    TextView endtimes;
    @BindView(R.id.tongji)
    TextView tongji;
    private DalisListContract.DalisListPresenter dalisListPresenter;
    private String token;
    private DalistList.DataBean dataBean;
    private ImageView fan;

    private Button start_time;
    private Button end_time;
    private TimePickerView pvTime;

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int endTime;
    private int startTime;
    private String startTimes;
    private String endTimes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dalis_list);
        ButterKnife.bind(this);
        SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        dalisListPresenter = new DalistListPresenter();
        dalisListPresenter.attachView(this);

        Long  time = System.currentTimeMillis();  //当前时间的时间戳
        long zero = time/(1000*3600*24)*(1000*3600*24) - TimeZone.getDefault().getRawOffset();
        System.out.println(new Timestamp(zero));//今天零点零分零秒
        System.out.println(zero/1000);
        int startTime = (int) (zero/1000);
        Log.i("aeeaa",startTime+"");

        int keys = startTime;
        SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lts = new Long(keys);
        Date dates = new Date(lts*1000L);
        String formats = formatters.format(dates);
        stattimes.setText("开始时间："+formats);

        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),23,59,59);
        long tt = calendar.getTime().getTime()/1000;
        System.out.println(tt);
        int endTime = (int) tt;
        Log.i("afafaxa",endTime+"");

        int key = endTime;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lt = new Long(key);
        Date date = new Date(lt*1000L);
        String format = formatter.format(date);
        endtimes.setText("结束时间："+format);

        dalisListPresenter.requestDalisListData(token,startTime, endTime);



        fan = findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(DalisListActivity.this, true);
        StatusBarUtil.setTranslucentStatus(DalisListActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(DalisListActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(DalisListActivity.this, 0x55000000);
        }

    }

    @OnClick({R.id.shai, R.id.baocun})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.baocun:
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "zhangphil.jpg");
                Bitmap bitmap = screenShot(DalisListActivity.this);
                try {
                    if (!file.exists())
                        file.createNewFile();

                    boolean ret = save(bitmap, file, Bitmap.CompressFormat.JPEG, true);
                    if (ret) {
                        Toast.makeText(getApplicationContext(), "截图已保持至 " + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case R.id.shai:
                /*this.getSupportFragmentManager().beginTransaction().replace(R.id.fragments, new Frag_shai())
                        .commit();*/

                final View p = View.inflate(DalisListActivity.this, R.layout.pop_chai, null);
                final PopupWindow popupWindow = new PopupWindow(p, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
                //popupWindow.showAtLocation(parent, Gravity.RIGHT | Gravity.BOTTOM, 10,10);//显示位置
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
                        DatePickerDialog datePickerDialog = new DatePickerDialog(DalisListActivity.this, new DatePickerDialog.PositiveBtnClick() {
                            @Override
                            public void onPositiveBtnClick(String year, String month, String day) {

                                endTimes = year+month+day;

                                start_time.setText(endTimes);

                                Log.i("wdas", endTimes);
                                startTime = Integer.parseInt(String.valueOf(DateUtils.getStringToDate(endTimes)/1000L));
                                Log.i("axaa",startTime+"");
                            }
                        });

                        datePickerDialog.show();
                    }
                });

                //结束日期
                end_time.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatePickerDialog datePickerDialogs = new DatePickerDialog(DalisListActivity.this, new DatePickerDialog.PositiveBtnClick() {
                            @Override
                            public void onPositiveBtnClick(String year, String month, String day) {
                                startTimes = year + month + day;
                                end_time.setText(startTimes);
                                endTime = Integer.parseInt(String.valueOf(DateUtils.getStringToDate(startTimes) / 1000L));
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
                            ToastUtil.showToast(DalisListActivity.this,"开始时间不能等于结束时间",Toast.LENGTH_SHORT);
                        }else if (startTime>endTime) {
                            ToastUtil.showToast(DalisListActivity.this,"开始时间不能大于结束时间",Toast.LENGTH_SHORT);

                        }else {
                            dalisListPresenter.requestDalisListData(token, startTime, endTime);
                            String endTimes  = DateUtils.getDateToString(startTime*1000L);
                            String startTimes = DateUtils.getDateToString(endTime*1000L);
                            stattimes.setText("开始时间："+endTimes);
                            endtimes.setText("结束时间："+startTimes);
                            Log.i("aaxaa",startTime+"");
                            Log.i("gggg",endTime+"");
                            popupWindow.dismiss();

                        }
                    }
                });
                break;
        }
    }

    public static boolean save(Bitmap src, File file, Bitmap.CompressFormat format, boolean recycle) {
        if (isEmptyBitmap(src))
            return false;

        OutputStream os;
        boolean ret = false;
        try {
            os = new BufferedOutputStream(new FileOutputStream(file));
            ret = src.compress(format, 100, os);
            if (recycle && !src.isRecycled())
                src.recycle();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ret;
    }


    /**
     * 获取当前屏幕截图，不包含状态栏（Status Bar）。
     *
     * @param activity activity
     * @return Bitmap
     */
    public Bitmap screenShot(Activity activity) {
        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bmp = view.getDrawingCache();
        int statusBarHeight = getStatusBarHeight(DalisListActivity.this);
        int width = (int) getDeviceDisplaySize(DalisListActivity.this)[0];
        int height = (int) getDeviceDisplaySize(DalisListActivity.this)[1];

        Bitmap ret = Bitmap.createBitmap(bmp, 0, statusBarHeight, width, height - statusBarHeight);
        view.destroyDrawingCache();

        return ret;
    }

    public static float[] getDeviceDisplaySize(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        float[] size = new float[2];
        size[0] = width;
        size[1] = height;

        return size;
    }

    public static int getStatusBarHeight(DalisListActivity context) {
        int height = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            height = context.getResources().getDimensionPixelSize(resourceId);
        }

        return height;
    }

    /**
     * Bitmap对象是否为空。
     */
    public static boolean isEmptyBitmap(Bitmap src) {
        return src == null || src.getWidth() == 0 || src.getHeight() == 0;
    }


    @Override
    public void showDalisListData(String message) {
        Gson gson = new Gson();
        DalistList dalistList = gson.fromJson(message, DalistList.class);
        dataBean = dalistList.getData();


        weixinMoney.setText(dataBean.getWxTotal() + "");
        payMoney.setText(dataBean.getAliTotal() + "");
        leiji.setText(dataBean.getTotal() + "");
        weixinNumber.setText(dataBean.getWxCount() + "");
        payNumber.setText(dataBean.getAliCount() + "");
        number.setText(dataBean.getCount() + "");
        xiaofei.setText(dataBean.getMemberConsumptionRecordTotal() + "");
        chongzhi.setText(dataBean.getMemberCumulativeTotal() + "");
        kaquan.setText(dataBean.getCouponCount() + "");


    }

    private void backgroundAlpha(float f) {
        WindowManager.LayoutParams lp =getWindow().getAttributes();
        lp.alpha = f;
        getWindow().setAttributes(lp);
    }
}
