package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.contract.WinContract;
import com.science.com.rchs.di.model.ChatModel;
import com.science.com.rchs.di.model.WinModel;

import java.lang.ref.SoftReference;

public class WeiPresenter implements WinContract.WinPresenter<WinContract.WinView> {

    WinContract.WinView winView;
    WinContract.WinModel winModel ;
    private SoftReference<WinContract.WinView> softReference;

    @Override
    public void attachView(WinContract.WinView winView) {
        this.winView = winView;
        softReference = new SoftReference<>(winView);
        winModel = new WinModel();
    }
    
    @Override
    public void detachView(WinContract.WinView winView) {
        softReference.clear();
    }

    @Override
    public void requestWinData(String token, String type, int startTime, int endTime) {
        winModel.reponseWinData(token, type, startTime, endTime, new WinContract.WinModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                winView.showWinData(message);
            }
        });
    }
}
