package com.science.com.rchs.di.model;

import android.util.Log;

import com.science.com.rchs.di.contract.StoreContract;
import com.science.com.rchs.di.contract.StoreDContract;
import com.science.com.rchs.net.ApiService;
import com.science.com.rchs.net.Contant;
import com.science.com.rchs.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class StoreDModel implements StoreDContract.StoreDModel {


    @Override
    public void reponseStoreDData(String token, int store_id, final CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiService(Contant.Re, ApiService.class)
                .getStoreContent(token)
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
                        Log.i("StoreD","失败:"+errorMsg);
                    }
                });
    }
}
