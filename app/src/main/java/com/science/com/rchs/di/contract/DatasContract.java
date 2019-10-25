package com.science.com.rchs.di.contract;

import okhttp3.MultipartBody;

public interface DatasContract {
    public interface DatasView{
        public void showPhotoData(String message);
        public void showBianData(String message);
    }

    public interface DatasPresenter<PhotoView>{
        public void attachView(PhotoView photoView);
        public void detachView(PhotoView photoView);

        public void requestPhotoData(String token,String stream);
        public void requestBianData(String token,String coupon_id);
    }

    public interface DatasModel{
        public void reponsePhotoData(String token,String stream, CallBack callBack);
        public void reponseBianData(String token,String coupon_id, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
