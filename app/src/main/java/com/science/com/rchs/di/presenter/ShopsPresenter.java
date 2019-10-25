package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.ShopsContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.ShopModel;

import java.lang.ref.SoftReference;

public class ShopsPresenter implements ShopsContract.ShopsPresenter<ShopsContract.ShopsView> {

    ShopsContract.ShopsModel shopsModel;
    ShopsContract.ShopsView shopsView ;
    private SoftReference<ShopsContract.ShopsView> softReference;


    @Override
    public void attachView(ShopsContract.ShopsView shopsView) {
        this.shopsView = shopsView;
        softReference = new SoftReference<>(shopsView);
        shopsModel = new ShopModel();
    }

    @Override
    public void detachView(ShopsContract.ShopsView shopsView) {
        softReference.clear();
    }

    @Override
    public void requestShopsData(String token) {
        shopsModel.reponseShopsData(token, new ShopsContract.ShopsModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                shopsView.showShopsData(message);
            }
        });
    }
}
