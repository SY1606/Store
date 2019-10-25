package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.contract.YouContract;
import com.science.com.rchs.di.model.DaiModel;
import com.science.com.rchs.di.model.YouModel;

import java.lang.ref.SoftReference;

public class YouPresenter implements YouContract.YouPresenter<YouContract.YouView> {

    YouContract.YouModel youModel;
    YouContract.YouView youView;
    private SoftReference<YouContract.YouView> softReference;


    @Override
    public void attachView(YouContract.YouView youView) {
        this.youView = youView;
        softReference = new SoftReference<>(youView);
        youModel = new YouModel();
    }

    @Override
    public void detachView(YouContract.YouView youView) {
        softReference.clear();
    }

    @Override
    public void requestYouData(String token, int type) {
        youModel.reponseYouData(token, type, new YouContract.YouModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                youView.showDaiData(message);
            }
        });
    }
}
