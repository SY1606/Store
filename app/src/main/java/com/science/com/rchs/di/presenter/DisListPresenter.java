package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.DisListContract;
import com.science.com.rchs.di.model.DisListModel;

import java.lang.ref.SoftReference;

public class DisListPresenter implements DisListContract.DisListPresenter<DisListContract.DisListView> {

    DisListContract.DisListModel disListModel;
    DisListContract.DisListView disListView;
    private SoftReference<DisListContract.DisListView> softReference;

    @Override
    public void attachView(DisListContract.DisListView disListView) {
        this.disListView = disListView;
        softReference = new SoftReference<>(disListView);
        disListModel = new DisListModel();
    }

    @Override
    public void detachView(DisListContract.DisListView disListView) {
        softReference.clear();
    }

    @Override
    public void requestDisListData(String token, int type) {
        disListModel.reponseDisListData(token, type, new DisListContract.DisListModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                disListView.showDisListData(message);
            }
        });
    }

}
