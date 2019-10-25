package com.science.com.rchs.di.contract;

public interface StarContract {

    public interface StarView{
        public void showStarData(String message);
    }

    public interface StarPresenter<StarView>{
        public void attachView(StarView starView);
        public void detachView(StarView starView);

        public void requestStarData(String token);
    }

    public interface StarModel{
        public void reponseStarData(String token, CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
