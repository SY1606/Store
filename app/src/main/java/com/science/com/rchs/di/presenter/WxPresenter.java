package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.contract.WxContract;
import com.science.com.rchs.di.model.ChatModel;
import com.science.com.rchs.di.model.WxModel;

import java.lang.ref.SoftReference;

public class WxPresenter implements WxContract.WxPresenter<WxContract.WxView> {

    WxContract.WxModel wxModel;
    WxContract.WxView wxView ;
    private SoftReference<WxContract.WxView> softReference;

    @Override
    public void attachView(WxContract.WxView wxView) {
        this.wxView = wxView;
        softReference = new SoftReference<>(wxView);
        wxModel = new WxModel();
    }

    @Override
    public void detachView(WxContract.WxView wxView) {

        softReference.clear();
    }

    @Override
    public void requestWxData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type, String coupon_code) {
        wxModel.reponseWxData(token, store_id, total, pay_method, pay_code, pay_type, coupon_code, new WxContract.WxModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                wxView.showWxData(message);
            }
        });
    }

    @Override
    public void requestCodesData(String token, String coupon_code) {
        wxModel.reponseCodesData(token, coupon_code, new WxContract.WxModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                wxView.showCodesData(message);
            }
        });
    }
}
