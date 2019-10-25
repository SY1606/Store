package com.science.com.rchs.di.presenter;

import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.di.contract.SearchContract;
import com.science.com.rchs.di.model.BillModel;
import com.science.com.rchs.di.model.SearchModel;

import java.lang.ref.SoftReference;

public class SearchPresenter implements SearchContract.SearchPresenter<SearchContract.SearchView> {

    SearchContract.SearchModel searchModel;
    SearchContract.SearchView searchView ;
    private SoftReference<SearchContract.SearchView> softReference;



    @Override
    public void attachView(SearchContract.SearchView searchView) {
        this.searchView = searchView;
        softReference = new SoftReference<>(searchView);
        searchModel = new SearchModel();
    }

    @Override
    public void detachView(SearchContract.SearchView searchView) {
        softReference.clear();
    }

    @Override
    public void requestSearchData(String token, String phone) {
        searchModel.reponseSearchData(token, phone, new SearchContract.SearchModel.CallBack() {
            @Override
            public void onCallBack(String message) {
                searchView.showSearchData(message);
            }
        });
    }
}
