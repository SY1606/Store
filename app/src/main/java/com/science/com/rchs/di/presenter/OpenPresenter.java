package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.OpenContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.OpenModel;

import java.lang.ref.SoftReference;

public class OpenPresenter implements OpenContract.OpenPresenter<OpenContract.OpenView> {

    OpenContract.OpenModel openModel;
    OpenContract.OpenView openView ;
    private SoftReference<OpenContract.OpenView> softReference;


    @Override
    public void attachView(OpenContract.OpenView openView) {
        this.openView = openView;
        softReference = new SoftReference<>(openView);
        openModel = new OpenModel();
    }

    @Override
    public void detachView(OpenContract.OpenView openView) {
        softReference.clear();
    }

    @Override
    public void requestOpenData(String token, String phone) {
        openModel.reponseOpenData(token,phone, new OpenContract.OpenModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                openView.showOpenData(message);
            }
        });
    }
}
