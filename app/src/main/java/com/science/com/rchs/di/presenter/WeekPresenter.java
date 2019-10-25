package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.GukeContract;
import com.science.com.rchs.di.contract.WeekContract;
import com.science.com.rchs.di.model.GukeModel;
import com.science.com.rchs.di.model.WeekModel;

import java.lang.ref.SoftReference;

public class WeekPresenter implements WeekContract.WeekPresenter<WeekContract.WeekView> {

    WeekContract.WeekModel weekModel;
    WeekContract.WeekView weekView ;
    private SoftReference<WeekContract.WeekView> softReference;


    @Override
    public void attachView(WeekContract.WeekView weekView) {
        this.weekView = weekView;
        softReference = new SoftReference<>(weekView);
        weekModel = new WeekModel();
    }

    @Override
    public void detachView(WeekContract.WeekView weekView) {
            softReference.clear();
    }

    @Override
    public void requestWeekData(String token) {
        weekModel.reponseWeekData(token, new WeekContract.WeekModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                weekView.showWeekData(message);
            }
        });
    }
}
