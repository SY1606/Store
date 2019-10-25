package com.science.com.rchs.di.contract;

public interface SearchContract {

    public interface SearchView{
        public void showSearchData(String message);
    }

    public interface SearchPresenter<SearchView>{
        public void attachView(SearchView searchView);
        public void detachView(SearchView searchView);

        public void requestSearchData(String token,String phone);
    }

    public interface SearchModel{
        public void reponseSearchData(String token,String phone, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
