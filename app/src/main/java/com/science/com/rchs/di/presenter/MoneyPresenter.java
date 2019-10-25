package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.GukeContract;
import com.science.com.rchs.di.contract.MoneyContract;
import com.science.com.rchs.di.model.GukeModel;
import com.science.com.rchs.di.model.MoneyModel;

import java.lang.ref.SoftReference;

public class MoneyPresenter implements MoneyContract.MoneyPresenter<MoneyContract.MoneyView> {

    MoneyContract.MoneyModel moneyModel;
    MoneyContract.MoneyView moneyView ;
    private SoftReference<MoneyContract.MoneyView> softReference;

    @Override
    public void attachView(MoneyContract.MoneyView moneyView) {
        this.moneyView = moneyView;
        softReference = new SoftReference<>(moneyView);
        moneyModel = new MoneyModel();
    }

    @Override
    public void detachView(MoneyContract.MoneyView moneyView) {
        softReference.clear();
    }

    @Override
    public void requestMoneyData(String token) {
        moneyModel.reponseMoneyData(token, new MoneyContract.MoneyModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                moneyView.showMoneyData(message);
            }
        });
    }
}
