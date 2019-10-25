package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.StoreContract;
import com.science.com.rchs.di.contract.StoreDContract;
import com.science.com.rchs.di.model.StoreDModel;


import java.lang.ref.SoftReference;

public class StoreDPresenter implements StoreDContract.StoreDPresenter<StoreDContract.StoreDView> {

    StoreDContract.StoreDModel storeDModel;
    StoreDContract.StoreDView storeDView;
    private SoftReference<StoreDContract.StoreDView> softReference;

    @Override
    public void attachView(StoreDContract.StoreDView storeDView) {
        this.storeDView = storeDView;
        softReference = new SoftReference<>(storeDView);
        storeDModel = new StoreDModel();
    }

    @Override
    public void detachView(StoreDContract.StoreDView storeDView) {
        softReference.clear();
    }

    @Override
    public void requestStoreDData(String token, int store_id) {
        storeDModel.reponseStoreDData(token, store_id, new StoreDContract.StoreDModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                storeDView.showStoreDData(message);
            }
        });
    }
}
