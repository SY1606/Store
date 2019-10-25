package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.XiaofeiContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.XiaofeiModel;

import java.lang.ref.SoftReference;

public class XiaofeiPresenter implements XiaofeiContract.XiaofeiPresenter<XiaofeiContract.XiaofeiView> {

    XiaofeiContract.XiaofeiModel xiaofeiModel;
    XiaofeiContract.XiaofeiView xiaofeiView ;
    private SoftReference<XiaofeiContract.XiaofeiView> softReference;


    @Override
    public void attachView(XiaofeiContract.XiaofeiView xiaofeiView) {
        this.xiaofeiView = xiaofeiView;
        softReference = new SoftReference<>(xiaofeiView);
        xiaofeiModel = new XiaofeiModel();
    }

    @Override
    public void detachView(XiaofeiContract.XiaofeiView xiaofeiView) {
        softReference.clear();
    }

    @Override
    public void requestXiaofeiData(String token, String card_number, String value, String remark) {
        xiaofeiModel.reponseXiaofeiData(token, card_number, value, remark, new XiaofeiContract.XiaofeiModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                xiaofeiView.showXiaofeiData(message);
            }
        });
    }
}
