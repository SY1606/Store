package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.StarContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.StarModel;

import java.lang.ref.SoftReference;

public class StarPresenter implements StarContract.StarPresenter<StarContract.StarView> {

    StarContract.StarModel starModel;
    StarContract.StarView starView ;
    private SoftReference<StarContract.StarView> softReference;


    @Override
    public void attachView(StarContract.StarView starView) {
        this.starView = starView;
        softReference = new SoftReference<>(starView);
        starModel = new StarModel();
    }

    @Override
    public void detachView(StarContract.StarView starView) {
        softReference.clear();
    }

    @Override
    public void requestStarData(String token) {
        starModel.reponseStarData(token, new StarContract.StarModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                starView.showStarData(message);
            }
        });
    }
}
