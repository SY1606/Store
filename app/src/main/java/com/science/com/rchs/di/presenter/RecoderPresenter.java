package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.CRecoderContract;
import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.model.CRecoderModel;
import com.science.com.rchs.di.model.MemListModel;

import java.lang.ref.SoftReference;

public class RecoderPresenter implements CRecoderContract.CRecoderPresenter<CRecoderContract.CRecoderView> {

    CRecoderContract.CRecoderModel cRecoderModel;
    CRecoderContract.CRecoderView cRecoderView;
    private SoftReference<CRecoderContract.CRecoderView> softReference;



    @Override
    public void attachView(CRecoderContract.CRecoderView cRecoderView) {
        this.cRecoderView = cRecoderView;
        softReference = new SoftReference<>(cRecoderView);
        cRecoderModel = new CRecoderModel();
    }

    @Override
    public void detachView(CRecoderContract.CRecoderView cRecoderView) {
        softReference.clear();
    }

    @Override
    public void requestCRecoderData(String token) {
        cRecoderModel.reponseCRecoderData(token,new CRecoderContract.CRecoderModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                cRecoderView.showCRecoderData(message);
            }
        });

    }
}
