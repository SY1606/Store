package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.GukeContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.GukeModel;

import java.lang.ref.SoftReference;

public class GukePresenter implements GukeContract.GukePresenter<GukeContract.GukeView> {

    GukeContract.GukeModel gukeModel;
    GukeContract.GukeView gukeView ;
    private SoftReference<GukeContract.GukeView> softReference;


    @Override
    public void attachView(GukeContract.GukeView gukeView) {
        this.gukeView = gukeView;
        softReference = new SoftReference<>(gukeView);
        gukeModel = new GukeModel();
    }

    @Override
    public void detachView(GukeContract.GukeView gukeView) {
        softReference.clear();
    }

    @Override
    public void requestGukeData(String token) {
        gukeModel.reponseGukeData(token, new GukeContract.GukeModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                gukeView.showGukeData(message);
            }
        });
    }
}
