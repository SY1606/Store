package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.ChatModel;

import java.lang.ref.SoftReference;

public class BillPresenter implements BillContract.BillPresenter<BillContract.BillView> {

    BillContract.BillModel billModel;
    BillContract.BillView billView ;
    private SoftReference<BillContract.BillView> softReference;



    @Override
    public void attachView(BillContract.BillView billView) {
        this.billView = billView;
        softReference = new SoftReference<>(billView);
        billModel = new BillModel();
    }

    @Override
    public void detachView(BillContract.BillView billView) {
        softReference.clear();
    }

    @Override
    public void requestBillData(String token) {
        billModel.reponseBillData(token, new BillContract.BillModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                billView.showBillData(message);
            }
        });
    }

    @Override
    public void requestStarsData(String token) {
        billModel.reponseStarsData(token, new BillContract.BillModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                billView.showStarsData(message);
            }
        });
    }
}
