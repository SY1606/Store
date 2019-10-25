package com.science.com.rchs.di.model;

import android.util.Log;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.contract.ScanContract;
import com.science.com.rchs.net.ApiService;
import com.science.com.rchs.net.Contant;
import com.science.com.rchs.net.RetrofitUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class ScanModel implements ScanContract.ScanModel {

    @Override
    public void reponseScanData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type, final CallBack callBack) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                connectTimeout(300,TimeUnit.SECONDS)
                .readTimeout(300,TimeUnit.SECONDS)
                .writeTimeout(300,TimeUnit.SECONDS).
                build();
        FormBody formBody = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .method("POST",formBody)
                .url(Contant.Ress+"?token="+token+"&store_id="+store_id+"&total="+total+"&pay_method="+pay_method+"&pay_code="+pay_code+"&pay_type="+pay_type)
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
        });
    }

        /*RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getScantent(token,store_id,total,pay_method,pay_code,pay_type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String response = responseBody.string();
                        callBack.onCallBack(response);
                    }

                });*/


    @Override
    public void reponseBandData(String token, String device_token,int store_id,String client_agent, CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getBangContent(token,device_token,store_id,client_agent)
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
                        Log.i("Bang","失败:"+errorMsg);
                    }
                });
    }

    @Override
    public void reponseScanPayData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type, CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getScanPaytent(token,store_id,total,pay_method,pay_code,pay_type)
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
                        Log.i("ScanPay","失败:"+errorMsg);
                    }
                });
    }

    @Override
    public void requestScan_payData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type, String coupon_code, CallBack callBack) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                connectTimeout(300,TimeUnit.SECONDS)
                .readTimeout(300,TimeUnit.SECONDS)
                .writeTimeout(300,TimeUnit.SECONDS).
                        build();
        FormBody formBody = new FormBody.Builder().build();
        Request request = new Request.Builder()
                .method("POST",formBody)
                .url(Contant.Ress+"?token="+token+"&store_id="+store_id+"&total="+total+"&pay_method="+pay_method+"&pay_code="+pay_code+"&pay_type="+pay_type+"&coupon_code="+coupon_code)
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
        });

        /*RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getScan_Paytent(token,store_id,total,pay_method,pay_code,"coupon",coupon_code)
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
                        Log.i("Saaaaa","失败:"+errorMsg);
                    }
                });*/
    }

    @Override
    public void requestScan_paySData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type, String coupon_code, CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getScan_PayStent(token,store_id,total,pay_method,pay_code,"coupon",coupon_code)
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
                        Log.i("ggggggg","失败:"+errorMsg);
                    }
                });
    }


    @Override
    public void reponseCodesData(String token, String coupon_code, CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getCodesContent(token,coupon_code)
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
                        Log.i("Codes","失败:"+errorMsg);
                    }
                });
    }

}
