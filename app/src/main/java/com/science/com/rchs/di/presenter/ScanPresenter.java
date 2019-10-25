package com.science.com.rchs.di.presenter;


import com.science.com.rchs.di.contract.ScanContract;

import com.science.com.rchs.di.model.ScanModel;

import java.lang.ref.SoftReference;

public class ScanPresenter implements ScanContract.ScanPresenter<ScanContract.ScanView> {

    ScanContract.ScanModel scanModel;
    ScanContract.ScanView scanView ;
    private SoftReference<ScanContract.ScanView> softReference;


    @Override
    public void attachView(ScanContract.ScanView scanView) {
        this.scanView = scanView;
        softReference = new SoftReference<>(scanView);
        scanModel = new ScanModel();
    }

    @Override
    public void detachView(ScanContract.ScanView scanView) {
        softReference.clear();
    }

    @Override
    public void requestScanPayData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type) {
        scanModel.reponseScanPayData(token, store_id, total, pay_method, pay_code, pay_type, new ScanContract.ScanModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                scanView.showScanPayData(message);
            }
        });
    }

    @Override
    public void requestScanData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type) {
        scanModel.reponseScanData(token, store_id, total, pay_method, pay_code, pay_type, new ScanContract.ScanModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                scanView.showScanData(message);
            }
        });
    }

    @Override
    public void requestBangData(String token, String device_token,int store_id, String client_agent) {
        scanModel.reponseBandData(token, device_token,store_id, client_agent, new ScanContract.ScanModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                scanView.showBandData(message);
            }
        });
    }

    @Override
    public void requestScan_payData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type, String coupon_code) {
        scanModel.requestScan_payData(token, store_id, total, pay_method, pay_code, pay_type, coupon_code, new ScanContract.ScanModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                scanView.showScan_PayData(message);
            }
        });
    }

    @Override
    public void requestScan_paySData(String token, int store_id, String total, String pay_method, String pay_code, String pay_type, String coupon_code) {
        scanModel.requestScan_paySData(token, store_id, total, pay_method, pay_code, pay_type, coupon_code, new ScanContract.ScanModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                scanView.showScan_PaySData(message);
            }
        });
    }

    @Override
    public void requestCodesData(String token, String coupon_code) {
        scanModel.reponseCodesData(token, coupon_code, new ScanContract.ScanModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                scanView.showCodesData(message);
            }
        });
    }
}
