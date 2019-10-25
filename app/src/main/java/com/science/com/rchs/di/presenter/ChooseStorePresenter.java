package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChooseStoreContract;
import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.model.ChooseStoreModel;
import com.science.com.rchs.di.model.DaiModel;

import java.lang.ref.SoftReference;

public class ChooseStorePresenter implements ChooseStoreContract.ChooseStorePresenter<ChooseStoreContract.ChooseStoreView> {

    ChooseStoreContract.ChooseStoreModel chooseStoreModel;
    ChooseStoreContract.ChooseStoreView chooseStoreView;
    private SoftReference<ChooseStoreContract.ChooseStoreView> softReference;


    @Override
    public void attachView(ChooseStoreContract.ChooseStoreView chooseStoreView) {
        this.chooseStoreView = chooseStoreView;
        softReference = new SoftReference<>(chooseStoreView);
        chooseStoreModel = new ChooseStoreModel();
    }

    @Override
    public void detachView(ChooseStoreContract.ChooseStoreView chooseStoreView) {
        softReference.clear();
    }

    @Override
    public void requestChooseStoreData(String token) {
        chooseStoreModel.reponseChooseStoreData(token, new ChooseStoreContract.ChooseStoreModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                chooseStoreView.showChooseStoreData(message);
            }
        });
    }
}
