package com.science.com.rchs.di.model;

import android.util.Log;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.ForgetContract;
import com.science.com.rchs.net.ApiService;
import com.science.com.rchs.net.Contant;
import com.science.com.rchs.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ForgetModel implements ForgetContract.ForgetModel {


    @Override
    public void reponseForgetData(String phone, String password, String passwordtwo, String signcode, final CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiService(Contant.Re,ApiService.class)
                .getForgetContent(phone,password,passwordtwo,signcode)
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
                        Log.i("Forget","失败:"+errorMsg);
                    }
                });
    }
}
