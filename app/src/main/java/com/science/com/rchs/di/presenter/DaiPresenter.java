package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.model.DaiModel;


import java.lang.ref.SoftReference;

public class DaiPresenter implements DaiContract.DaiPresenter<DaiContract.DaiView> {

    DaiContract.DaiModel daiModel;
    DaiContract.DaiView daiView;
    private SoftReference<DaiContract.DaiView> softReference;


    @Override
    public void attachView(DaiContract.DaiView daiView) {
        this.daiView = daiView;
        softReference = new SoftReference<>(daiView);
        daiModel = new DaiModel();
    }

    @Override
    public void detachView(DaiContract.DaiView daiView) {
        softReference.clear();
    }

    @Override
    public void requestDaiData(String token, int coupon_type) {
        daiModel.reponseDaiData(token, coupon_type, new DaiContract.DaiModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                daiView.showDaiData(message);
            }
        });
    }
}
