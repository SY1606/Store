package com.science.com.rchs.di.model;

import android.util.Log;

import com.science.com.rchs.di.contract.LoginContract;
import com.science.com.rchs.net.ApiService;
import com.science.com.rchs.net.Contant;
import com.science.com.rchs.net.RetrofitUtils;

import java.io.IOException;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class LoginModel implements LoginContract.LoginModel {
    @Override
    public void reponseLoginData(String grant_type, String mch_seller_number, String password, final CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiService(Contant.Re,ApiService.class)
                .getLoginContent(grant_type, mch_seller_number, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String response = responseBody.string();
                        callBack.onCallBack(response);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        String errorMsg = throwable.getMessage();
                        Log.i("Login","失败:"+errorMsg);
                    }
                }) ;
        /*.subscribe(new Consumer<Login>() {
                    @Override
                    public void accept(Login message) throws Exception {
                        callBack.onCallBack(message);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        String errorMsg = throwable.getMessage();
                        Log.i("Login","失败:"+errorMsg);
                    }
                });*/

        /*OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody formBody = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .method("POST",formBody)
                .url(Contant.Login+"?grant_type"+grant_type+"&meditPhone="+mch_seller_number+"&meditPass="+password)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                String responseData = e.getMessage();
                callBack.onCallBack(responseData);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseData = response.body().string();
                callBack.onCallBack(responseData);
            }
        });*/

    }
}
