package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.SendContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.SendModel;

import java.lang.ref.SoftReference;

public class SendPresenter implements SendContract.SendPresenter<SendContract.SendView> {

    SendContract.SendModel sendModel;
    SendContract.SendView sendView ;
    private SoftReference<SendContract.SendView> softReference;


    @Override
    public void attachView(SendContract.SendView sendView) {
        this.sendView = sendView;
        softReference = new SoftReference<>(sendView);
        sendModel = new SendModel();
    }

    @Override
    public void detachView(SendContract.SendView SendView) {
        softReference.clear();
    }

    @Override
    public void requestSendData(String phone) {
        sendModel.reponseSendData(phone, new SendContract.SendModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                sendView.showSendData(message);
            }
        });
    }
}
