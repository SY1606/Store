package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.contract.PCorderContract;
import com.science.com.rchs.di.model.ChatModel;
import com.science.com.rchs.di.model.PCorderModel;

import java.lang.ref.SoftReference;

public class PCorderPresenter implements PCorderContract.PCorderPresenter<PCorderContract.PCorderView> {

    PCorderContract.PCorderModel pCorderModel;
    PCorderContract.PCorderView pCorderView ;
    private SoftReference<PCorderContract.PCorderView> softReference;


    @Override
    public void attachView(PCorderContract.PCorderView pCorderView) {
        this.pCorderView = pCorderView;
        softReference = new SoftReference<>(pCorderView);
        pCorderModel = new PCorderModel();
    }

    @Override
    public void detachView(PCorderContract.PCorderView pCorderView) {
        softReference.clear();
    }

    @Override
    public void requestPCorderData(String token, String phone) {
        pCorderModel.reponsePCorderData(token, phone, new PCorderContract.PCorderModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                pCorderView.showPCorderData(message);
            }
        });
    }
}
