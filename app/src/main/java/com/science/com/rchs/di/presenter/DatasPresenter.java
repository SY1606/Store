package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.DatasContract;
import com.science.com.rchs.di.model.DatasModel;

import java.lang.ref.SoftReference;

import okhttp3.MultipartBody;

public class DatasPresenter implements DatasContract.DatasPresenter<DatasContract.DatasView> {

    DatasContract.DatasModel datasModel;
    DatasContract.DatasView datasView;
    private SoftReference<DatasContract.DatasView> softReference;

    @Override
    public void attachView(DatasContract.DatasView datasView) {
        this.datasView = datasView;
        softReference = new SoftReference<>(datasView);
        datasModel = new DatasModel();
    }

    @Override
    public void detachView(DatasContract.DatasView datasView) {
        softReference.clear();
    }

    @Override
    public void requestPhotoData(String token,String stream) {
        datasModel.reponsePhotoData(token,stream,new DatasContract.DatasModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                datasView.showPhotoData(message);
            }
        });
    }

    @Override
    public void requestBianData(String token, String coupon_id) {
        datasModel.reponseBianData(token, coupon_id, new DatasContract.DatasModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                datasView.showBianData(message);
            }
        });
    }
}
