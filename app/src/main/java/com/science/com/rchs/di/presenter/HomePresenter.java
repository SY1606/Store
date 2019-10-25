package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.HomeContract;
import com.science.com.rchs.di.contract.MemListContract;
import com.science.com.rchs.di.model.HomeModel;
import com.science.com.rchs.di.model.MemListModel;

import java.lang.ref.SoftReference;

public class HomePresenter implements HomeContract.HomePresenter<HomeContract.HomeView> {

    HomeContract.HomeModel homeModel;
    HomeContract.HomeView homeView;
    private SoftReference<HomeContract.HomeView> softReference;


    @Override
    public void attachView(HomeContract.HomeView homeView) {
        this.homeView = homeView;
        softReference = new SoftReference<>(homeView);
        homeModel = new HomeModel();
    }

    @Override
    public void detachView(HomeContract.HomeView homeView) {
        softReference.clear();
    }

    @Override
    public void requestHomeData(String token) {
        homeModel.reponseHomeData(token, new HomeContract.HomeModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                homeView.showHomeData(message);
            }
        });
    }

    @Override
    public void requestChongzhiData(String token) {
        homeModel.reponseChongzhiData(token, new HomeContract.HomeModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                homeView.showChongzhiData(message);
            }
        });
    }

    @Override
    public void requestStoresData(String token, int store_id) {
        homeModel.reponseStoreData(token, store_id, new HomeContract.HomeModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                homeView.showStoresData(message);
            }
        });
    }

    @Override
    public void requestBandData(String token, String device_token, int store_id, String client_agent) {
        homeModel.reponseBandData(token, device_token, store_id, client_agent, new HomeContract.HomeModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                homeView.showBangData(message);
            }
        });
    }
}
