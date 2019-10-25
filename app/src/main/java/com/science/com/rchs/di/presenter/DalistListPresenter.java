package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.DalisListContract;
import com.science.com.rchs.di.contract.StoreContract;
import com.science.com.rchs.di.model.DalistListModel;


import java.lang.ref.SoftReference;

public class DalistListPresenter implements DalisListContract.DalisListPresenter<DalisListContract.DalisListView> {

    DalisListContract.DalisListModel dalisListModel;
    DalisListContract.DalisListView dalisListView;
    private SoftReference<DalisListContract.DalisListView> softReference;


    @Override
    public void attachView(DalisListContract.DalisListView dalisListView) {
        this.dalisListView = dalisListView;
        softReference = new SoftReference<>(dalisListView);
        dalisListModel = new DalistListModel();
    }

    @Override
    public void detachView(DalisListContract.DalisListView dalisListView) {
        softReference.clear();
    }

    @Override
    public void requestDalisListData(String token, int startTime, int endTime) {
        dalisListModel.reponseDalisListData(token, startTime, endTime, new DalisListContract.DalisListModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                dalisListView.showDalisListData(message);
            }
        });
    }
}
