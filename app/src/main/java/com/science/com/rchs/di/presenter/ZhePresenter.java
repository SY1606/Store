package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.YouContract;
import com.science.com.rchs.di.contract.ZheContract;
import com.science.com.rchs.di.model.YouModel;
import com.science.com.rchs.di.model.ZheModel;

import java.lang.ref.SoftReference;

public class ZhePresenter implements ZheContract.ZhePresenter<ZheContract.ZheView> {

    ZheContract.ZheModel zheModel;
    ZheContract.ZheView zheView;
    private SoftReference<ZheContract.ZheView> softReference;

    @Override
    public void attachView(ZheContract.ZheView zheView) {
        this.zheView = zheView;
        softReference = new SoftReference<>(zheView);
        zheModel = new ZheModel();
    }

    @Override
    public void detachView(ZheContract.ZheView zheView) {
        softReference.clear();
    }

    @Override
    public void requestZheData(String token, int coupon_type) {
        zheModel.reponseZheData(token, coupon_type, new ZheContract.ZheModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                zheView.showZheData(message);
            }
        });
    }
}
