package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BianjiContract;
import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.model.BianjiModel;
import com.science.com.rchs.di.model.ChatModel;

import java.lang.ref.SoftReference;

public class BianjiPresenter implements BianjiContract.BianjiPresenter<BianjiContract.BianjiView> {

    BianjiContract.BianjiModel bianjiModel;
    BianjiContract.BianjiView bianjiView ;
    private SoftReference<BianjiContract.BianjiView> softReference;


    @Override
    public void attachView(BianjiContract.BianjiView bianjiView) {
        this.bianjiView = bianjiView;
        softReference = new SoftReference<>(bianjiView);
        bianjiModel = new BianjiModel();
    }

    @Override
    public void detachView(BianjiContract.BianjiView bianjiView) {
        softReference.clear();
    }

    @Override
    public void requestBianjiData(String token, String coupon_id, String type, String logo_url, String color, String notice, String description,String begin_timestamp,String end_timestamp) {
        bianjiModel.reponseBianjiData(token, coupon_id, type, logo_url, color, notice, description,begin_timestamp,end_timestamp, new BianjiContract.BianjiModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                bianjiView.showBianjiData(message);
            }
        });
    }
}
