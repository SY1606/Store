package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.contract.StoreContract;
import com.science.com.rchs.di.model.MemListModel;
import com.science.com.rchs.di.model.StoreModel;

import java.lang.ref.SoftReference;

public class StorePresenter implements StoreContract.StorePresenter<StoreContract.StoreView> {

    StoreContract.StoreModel storeModel;
    StoreContract.StoreView storeView;
    private SoftReference<StoreContract.StoreView> softReference;

    @Override
    public void attachView(StoreContract.StoreView storeView) {
        this.storeView = storeView;
        softReference = new SoftReference<>(storeView);
        storeModel = new StoreModel();
    }

    @Override
    public void detachView(StoreContract.StoreView storeView) {
        softReference.clear();
    }

    @Override
    public void requestStoreData(String token) {
        storeModel.reponseStoreData(token, new StoreContract.StoreModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                storeView.showStoreData(message);
            }
        });
    }

    @Override
    public void requestStoresData(String token, int startTime, int endTime) {
        storeModel.reponseStoresData(token, startTime, endTime, new StoreContract.StoreModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                storeView.showStoresData(message);
            }
        });
    }
}
