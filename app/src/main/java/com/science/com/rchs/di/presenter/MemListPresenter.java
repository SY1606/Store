package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.model.MemListModel;

import java.lang.ref.SoftReference;

public class MemListPresenter implements MemListContract.MemListPresenter<MemListContract.MemListView> {

    MemListContract.MemListModel memListModel;
    MemListContract.MemListView memListView;
    private SoftReference<MemListContract.MemListView> softReference;

    @Override
    public void attachView(MemListContract.MemListView memListView) {
        this.memListView = memListView;
        softReference = new SoftReference<>(memListView);
        memListModel = new MemListModel();
    }

    @Override
    public void detachView(MemListContract.MemListView memListView) {
        softReference.clear();
    }

    @Override
    public void requestMemListData(String token) {
        memListModel.reponseMemListData(token, new MemListContract.MemListModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                memListView.showPhotoData(message);
            }
        });
    }
}
