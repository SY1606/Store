package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChooseDStoreContract;

import com.science.com.rchs.di.model.ChooseStoreDModel;


import java.lang.ref.SoftReference;

public class ChooseDStorePresenter implements ChooseDStoreContract.ChooseStoreDPresenter<ChooseDStoreContract.ChooseDStoreView> {

    ChooseDStoreContract.ChooseStoreDModel chooseStoreDModel;
    ChooseDStoreContract.ChooseDStoreView chooseDStoreView;
    private SoftReference<ChooseDStoreContract.ChooseDStoreView> softReference;


    @Override
    public void attachView(ChooseDStoreContract.ChooseDStoreView chooseDStoreView) {
        this.chooseDStoreView = chooseDStoreView;
        softReference = new SoftReference<>(chooseDStoreView);
        chooseStoreDModel = new ChooseStoreDModel();
    }

    @Override
    public void detachView(ChooseDStoreContract.ChooseDStoreView chooseDStoreView) {
        softReference.clear();
    }

    @Override
    public void requestChooseDStoreData(String token, int store_id) {
        chooseStoreDModel.reponseChooseDStoreData(token, store_id, new ChooseDStoreContract.ChooseStoreDModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                chooseDStoreView.showChooseDStoreData(message);
            }
        });
    }
}
