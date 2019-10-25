package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.QRcodeContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.QRcodeModel;

import java.lang.ref.SoftReference;

public class QRcodePresenter implements QRcodeContract.QRcodePresenter<QRcodeContract.QRcodeView> {

    QRcodeContract.QRcodeModel qRcodeModel;
    QRcodeContract.QRcodeView qRcodeView ;
    private SoftReference<QRcodeContract.QRcodeView> softReference;



    @Override
    public void attachView(QRcodeContract.QRcodeView qRcodeView) {
        this.qRcodeView = qRcodeView;
        softReference = new SoftReference<>(qRcodeView);
        qRcodeModel = new QRcodeModel();
    }

    @Override
    public void detachView(QRcodeContract.QRcodeView qRcodeView) {
        softReference.clear();
    }

    @Override
    public void requestQRcodeData(String token) {
        qRcodeModel.reponseQRcodeData(token, new QRcodeContract.QRcodeModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                qRcodeView.showQRcodeData(message);
            }
        });
    }
}
