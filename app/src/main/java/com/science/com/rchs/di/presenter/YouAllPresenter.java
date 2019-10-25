package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.contract.YouAllContract;
import com.science.com.rchs.di.model.DaiModel;
import com.science.com.rchs.di.model.YouAllModel;

import java.lang.ref.SoftReference;

public class YouAllPresenter implements YouAllContract.YouAllPresenter<YouAllContract.YouAllView> {

    YouAllContract.YouAllModel youAllModel;
    YouAllContract.YouAllView youAllView;
    private SoftReference<YouAllContract.YouAllView> softReference;


    @Override
    public void attachView(YouAllContract.YouAllView youAllView) {
        this.youAllView = youAllView;
        softReference = new SoftReference<>(youAllView);
        youAllModel = new YouAllModel();
    }

    @Override
    public void detachView(YouAllContract.YouAllView youAllView) {
        softReference.clear();
    }

    @Override
    public void requestYouAllData(String token, int coupon_type) {
        youAllModel.reponseYouAllData(token, coupon_type, new YouAllContract.YouAllModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                youAllView.showYouAllData(message);
            }
        });
    }
}
