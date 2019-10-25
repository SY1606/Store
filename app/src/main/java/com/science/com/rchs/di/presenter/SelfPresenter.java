package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.SelfContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.SelfModel;

import java.lang.ref.SoftReference;

public class SelfPresenter implements SelfContract.SelfPresenter<SelfContract.SelfView> {

    SelfContract.SelfModel selfModel;
    SelfContract.SelfView selfView ;
    private SoftReference<SelfContract.SelfView> softReference;



    @Override
    public void attachView(SelfContract.SelfView selfView) {
        this.selfView = selfView;
        softReference = new SoftReference<>(selfView);
        selfModel = new SelfModel();
    }

    @Override
    public void detachView(SelfContract.SelfView selfView) {
        softReference.clear();
    }

    @Override
    public void requestSelfData(String token, int store_id) {
        selfModel.reponseSelfData(token, store_id, new SelfContract.SelfModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                selfView.showSelfData(message);
            }
        });
    }
}
