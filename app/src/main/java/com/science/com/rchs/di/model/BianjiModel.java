package com.science.com.rchs.di.model;

import android.util.Log;

import com.science.com.rchs.di.contract.BianjiContract;
import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.net.ApiService;
import com.science.com.rchs.net.Contant;
import com.science.com.rchs.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class BianjiModel implements BianjiContract.BianjiModel {


    @Override
    public void reponseBianjiData(String token, String coupon_id, String type, String logo_url, String color, String notice, String description,String begin_timestamp,String end_timestamp, CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getBianjiContent(token,coupon_id,type,logo_url,color,notice,description,begin_timestamp,end_timestamp)
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
                        Log.i("DisList","失败:"+errorMsg);
                    }
                });
    }
}
