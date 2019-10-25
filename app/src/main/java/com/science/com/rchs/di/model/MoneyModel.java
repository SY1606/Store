package com.science.com.rchs.di.model;

import android.util.Log;

import com.science.com.rchs.di.contract.GukeContract;
import com.science.com.rchs.di.contract.MoneyContract;
import com.science.com.rchs.net.ApiService;
import com.science.com.rchs.net.Contant;
import com.science.com.rchs.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class MoneyModel implements MoneyContract.MoneyModel {


    @Override
    public void reponseMoneyData(String token, final CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getMoneyContent(token)
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
                        Log.i("Money","失败:"+errorMsg);
                    }
                });
    }
}