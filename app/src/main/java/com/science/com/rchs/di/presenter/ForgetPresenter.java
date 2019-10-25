package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.ForgetContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.ForgetModel;

import java.lang.ref.SoftReference;

public class ForgetPresenter implements ForgetContract.ForgetPresenter<ForgetContract.ForgetView> {

    ForgetContract.ForgetModel forgetModel;
    ForgetContract.ForgetView forgetView ;
    private SoftReference<ForgetContract.ForgetView> softReference;


    @Override
    public void attachView(ForgetContract.ForgetView forgetView) {
        this.forgetView = forgetView;
        softReference = new SoftReference<>(forgetView);
        forgetModel = new ForgetModel();
    }

    @Override
    public void detachView(ForgetContract.ForgetView forgetView) {
        softReference.clear();
    }

    @Override
    public void requestForgetData(String phone, String password, String passwordtwo, String signcode) {
        forgetModel.reponseForgetData(phone, password, passwordtwo, signcode, new ForgetContract.ForgetModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                forgetView.showForgetData(message);
            }
        });
    }
}
