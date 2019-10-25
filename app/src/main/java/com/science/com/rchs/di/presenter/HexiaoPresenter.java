package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.HexiaoContract;
import com.science.com.rchs.di.model.HexiaoModel;

import java.lang.ref.SoftReference;

public class HexiaoPresenter implements HexiaoContract.HexiaoPresenter<HexiaoContract.HexiaoView> {

    HexiaoContract.HexiaoModel hexiaoModel;
    HexiaoContract.HexiaoView hexiaoView ;
    private SoftReference<HexiaoContract.HexiaoView> softReference;



    @Override
    public void attachView(HexiaoContract.HexiaoView hexiaoView) {
        this.hexiaoView = hexiaoView;
        softReference = new SoftReference<>(hexiaoView);
        hexiaoModel = new HexiaoModel();
    }

    @Override
    public void detachView(HexiaoContract.HexiaoView hexiaoView) {
        softReference.clear();
    }

    @Override
    public void requestHexiaoData(String token, String code) {
        hexiaoModel.reponseHexiaoData(token, code, new HexiaoContract.HexiaoModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                hexiaoView.showHexiaoData(message);
            }
        });
    }
}
