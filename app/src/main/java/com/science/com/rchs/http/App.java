package com.science.com.rchs.http;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengAdHandler;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;


import static anet.channel.bytes.a.TAG;

public class App extends Application {



    public static final int FLUSH_MAIN_ACTIVITY=1;

    private String token;
    private final Handler handler = new Handler();


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        UMConfigure.init(this, "5d5b4d493fc195d0320006c9", "Umeng", UMConfigure.DEVICE_TYPE_PHONE, "84ca658ed4bdca340aa23cab6f4b8e4f");

        PushAgent mPushAgent = PushAgent.getInstance(this);

        UmengMessageHandler umengMessageHandler = new UmengMessageHandler(){
            @Override
            public void dealWithCustomMessage(Context context, UMessage uMessage) {
               handler.post(new Runnable() {
                   @Override
                   public void run() {

                       Log.i("eadgsds",uMessage.custom);
                       Toast.makeText(context, uMessage.custom, Toast.LENGTH_LONG).show();
                   }
               });
            }
        };
        mPushAgent.setMessageHandler(umengMessageHandler);


        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                Log.i("sacadadf", String.valueOf(mPushAgent));
                Log.i(TAG,"注册成功：deviceToken：-------->  " + deviceToken);
            }
            @Override
            public void onFailure(String s, String s1) {
                Log.e(TAG,"注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });

    }

}
