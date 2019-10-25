package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.ChatContract;
import com.science.com.rchs.di.contract.TixianContract;
import com.science.com.rchs.di.model.ChatModel;
import com.science.com.rchs.di.model.TixianModel;

import java.lang.ref.SoftReference;

public class TixianPresenter implements TixianContract.TixianPresenter<TixianContract.TixianView> {

    TixianContract.TixianModel tixianModel;
    TixianContract.TixianView tixianView ;
    private SoftReference<TixianContract.TixianView> softReference;


    @Override
    public void attachView(TixianContract.TixianView tixianView) {
        this.tixianView = tixianView;
        softReference = new SoftReference<>(tixianView);
        tixianModel = new TixianModel();
    }

    @Override
    public void detachView(TixianContract.TixianView tixianView) {
        softReference.clear();
    }

    @Override
    public void requestTixianData(String token, String mchId) {
        tixianModel.reponseTixianData(token, mchId, new TixianContract.TixianModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                tixianView.showTixianData(message);
            }
        });
    }
}
