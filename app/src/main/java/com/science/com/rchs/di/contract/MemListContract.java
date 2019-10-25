package com.science.com.rchs.di.contract;

import okhttp3.MultipartBody;

public interface MemListContract {

    public interface MemListView{
        public void showPhotoData(String message);
    }

    public interface MemListPresenter<MemListView>{
        public void attachView(MemListView memListView);
        public void detachView(MemListView memListView);

        public void requestMemListData(String token);
    }

    public interface MemListModel{
        public void reponseMemListData(String token,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
