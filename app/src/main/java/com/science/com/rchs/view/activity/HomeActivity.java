package com.science.com.rchs.view.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.ChooseD;
import com.science.com.rchs.di.contract.ChooseDStoreContract;
import com.science.com.rchs.di.contract.ScanContract;
import com.science.com.rchs.di.presenter.ChooseDStorePresenter;
import com.science.com.rchs.di.presenter.ScanPresenter;
import com.science.com.rchs.http.TTSUtils;
import com.science.com.rchs.net.StatusBarUtil;
import com.science.com.rchs.net.SystemBarTintManager;
import com.science.com.rchs.view.fragment.Frag_bill;
import com.science.com.rchs.view.fragment.Frag_gather;
import com.science.com.rchs.view.fragment.Frag_guest;
import com.science.com.rchs.view.fragment.Frag_set;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;
import com.yzq.zxinglibrary.common.Constant;
import com.yzy.voice.VoicePlay;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static anet.channel.bytes.a.TAG;


public class HomeActivity extends AppCompatActivity implements ScanContract.ScanView,ChooseDStoreContract.ChooseDStoreView  {

    private RadioButton gather;
    private RadioButton bill;
    private RadioButton guest;
    private RadioButton set;
    private int mCustomVariable;
    private static final String Frag_gather = "frag_gather";
    private static final String Frag_bill = "frag_bill";
    private static final String Frag_guest = "frag_guest";
    private static final String Frag_set = "frag_set";
    private List<Fragment> fragmentList = new ArrayList<>();
    private boolean isExit;
    private long firstTime=0;
    String client_agent = "android";
    private boolean run = false;
    private final Handler handler = new Handler();
    private ScanContract.ScanPresenter scanPresenter;
    private String token;
    private Handler handlers;
    private int store_id;
    private ChooseDStoreContract.ChooseStoreDPresenter chooseStoreDPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!isTaskRoot()) {
            final Intent intent = getIntent();
            final String intentAction = intent.getAction();
            if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && intentAction != null &&
                    intentAction.equals(Intent.ACTION_MAIN)) {
                finish();
                return;
            }
        }
        setContentView(R.layout.activity_home);
        //沉浸式状态栏
        StatusBarUtil.setRootViewFitsSystemWindows(HomeActivity.this, true);
        StatusBarUtil.setTranslucentStatus(HomeActivity.this);
        if (!StatusBarUtil.setStatusBarDarkTheme(HomeActivity.this, true)) {
            StatusBarUtil.setStatusBarColor(HomeActivity.this, 0x55000000);
        }

        TTSUtils.init(this);

        PushAgent mPushAgent = PushAgent.getInstance(this);


        applyKitKatTranslucency();
        SharedPreferences sp =getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");

        chooseStoreDPresenter = new ChooseDStorePresenter();
        chooseStoreDPresenter.attachView(this);


        SharedPreferences sps = getSharedPreferences("ids", Context.MODE_PRIVATE);

        store_id = sps.getInt("id",0);

        chooseStoreDPresenter.requestChooseDStoreData(token, store_id);
        scanPresenter = new ScanPresenter();
        scanPresenter.attachView(this);


        UMConfigure.init(this, "5d5b4d493fc195d0320006c9", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "84ca658ed4bdca340aa23cab6f4b8e4f");
         mPushAgent = PushAgent.getInstance(this);

        mPushAgent.setNotificationPlaySound(MsgConstant.NOTIFICATION_PLAY_SDK_ENABLE);
        mPushAgent.setDisplayNotificationNumber(5);//通知栏按数量显示
        handlers = new Handler(getMainLooper());

        UmengMessageHandler umengMessageHandler = new UmengMessageHandler(){
            @Override
            public void dealWithNotificationMessage(Context context, UMessage uMessage) {
                super.dealWithNotificationMessage(context,uMessage);

                //TTSUtils.speak(uMessage.text);q
                VoicePlay.with(HomeActivity.this).play(uMessage.text);
                //Toast.makeText(context, uMessage.sound, Toast.LENGTH_LONG).show();
                /*handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });*/

            }
            @Override
            public void dealWithCustomMessage(Context context, UMessage uMessage) {
                //super.dealWithCustomMessage(context,uMessage);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub

                        Log.i("asfggds",uMessage.custom);
                        Toast.makeText(context, uMessage.custom, Toast.LENGTH_LONG).show();
                        /*boolean isClickOrDismissed = true;
                        if (isClickOrDismissed) {
                            //自定义消息的点击统计
                            UTrack.getInstance(getApplicationContext()).trackMsgClick(uMessage);
                            Log.i("dafawassca",uMessage.custom);
                        } else {
                            //自定义消息的忽略统计
                            UTrack.getInstance(getApplicationContext()).trackMsgDismissed(uMessage);
                        }*/

                    }
                });
            }
        };
        mPushAgent.setMessageHandler(umengMessageHandler);


        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String device_token) {

                //device_token = deviceToken;
                //ScanContract.ScanPresenter scanPresenter = new ScanPresenter();
                //scanPresenter.attachView(this);
                scanPresenter.requestBangData(token,device_token,store_id,client_agent);


            }
            @Override
            public void onFailure(String s, String s1) {
            }
        });

        gather = findViewById(R.id.gather);
        bill = findViewById(R.id.bill);
        guest = findViewById(R.id.guest);
        set = findViewById(R.id.set);



        final FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        final Frag_gather frag_gather = new Frag_gather();
        final Frag_bill frag_bill = new Frag_bill();
        final Frag_guest frag_guest = new Frag_guest();
        final Frag_set frag_set = new Frag_set();
        transaction.add(R.id.mframe, frag_gather);
        transaction.add(R.id.mframe, frag_bill);
        transaction.add(R.id.mframe, frag_guest);
        transaction.add(R.id.mframe, frag_set);
        transaction.show(frag_gather);
        transaction.hide(frag_bill);
        transaction.hide(frag_guest);
        transaction.hide(frag_set);

        transaction.commit();


        //默认选中第一个
        RadioGroup rg = findViewById(R.id.rg);
        rg.check(rg.getChildAt(0).getId());

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (i) {
                    case R.id.gather:
                        transaction1.show(frag_gather).hide(frag_bill).hide(frag_guest).hide(frag_set);
                        break;
                    case R.id.bill:
                        transaction1.show(frag_bill).hide(frag_gather).hide(frag_guest).hide(frag_set);
                        break;
                    case R.id.guest:
                        transaction1.show(frag_guest).hide(frag_bill).hide(frag_gather).hide(frag_set);
                        break;
                    case R.id.set:
                        transaction1.show(frag_set).hide(frag_bill).hide(frag_guest).hide(frag_gather);
                        break;
                }
                transaction1.commit();
            }

        });

        //一秒刷新一次
        run = true;
        handler.postDelayed(task, 1000);
    }

    private final Runnable task = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (run) {

                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }

    /*@Override
        public boolean onKeyUp(int keyCode, KeyEvent event) {

            switch (keyCode){
                case KeyEvent.KEYCODE_BACK:
                    long secondTime=System.currentTimeMillis();
                    if(secondTime-firstTime>2000){
                        Toast.makeText(HomeActivity.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
                        firstTime=secondTime;
                        return true;
                    }else{
                        System.exit(0);
                    }
                    break;
            }

            return super.onKeyUp(keyCode, event);

        }*/
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


    @Override
    public void showScanData(String message) {

    }

    @Override
    public void showScanPayData(String message) {

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
    public void showChooseDStoreData(String message) {
        Gson gson = new Gson();
        ChooseD chooseD = gson.fromJson(message, ChooseD.class);

        List<ChooseD.DataBean> dataBeans = chooseD.getData();
        store_id = dataBeans.get(0).getId();

    }
}
