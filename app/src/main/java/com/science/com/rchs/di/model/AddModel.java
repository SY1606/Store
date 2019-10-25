package com.science.com.rchs.di.model;

import android.util.Log;

import com.science.com.rchs.di.contract.AddContract;
import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.net.ApiService;
import com.science.com.rchs.net.Contant;
import com.science.com.rchs.net.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class AddModel implements AddContract.AddModel {


    @Override
    public void reponseAddData(String token, String logo_url, String color, String begin_timestamp, String end_timestamp, String notice, String description, int quantity, String least_cost, String reduce_cost, final CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getAddContent(token,logo_url,color,begin_timestamp,end_timestamp,notice,description,quantity,least_cost,reduce_cost)
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
                        Log.i("Add","失败:"+errorMsg);
                    }
                });
    }

    @Override
    public void reponseAddZheData(String token, String logo_url, String color, String begin_timestamp, String end_timestamp, String notice, String description, int quantity, String discount, final CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getAAddZheContent(token,logo_url,color,begin_timestamp,end_timestamp,notice,description,quantity,discount)
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
                        Log.i("AddZhe","失败:"+errorMsg);
                    }
                });
    }

    @Override
    public void reponseAddYouData(String token, String logo_url, String color, String begin_timestamp, String end_timestamp, String notice, String description, int quantity, String default_detail, CallBack callBack) {
        RetrofitUtils.getRetrofitUtils().getApiServiceHeader(Contant.Re,token,ApiService.class)
                .getAAddYouContent(token,logo_url,color,begin_timestamp,end_timestamp,notice,description,quantity,default_detail)
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
                        Log.i("AddZhes","失败:"+errorMsg);
                    }
                });
    }
}
