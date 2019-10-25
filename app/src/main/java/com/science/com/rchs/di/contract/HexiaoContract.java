package com.science.com.rchs.di.contract;

public interface HexiaoContract {

    public interface HexiaoView{
        public void showHexiaoData(String message);
    }

    public interface HexiaoPresenter<HexiaoView>{
        public void attachView(HexiaoView hexiaoView);
        public void detachView(HexiaoView hexiaoView);

        public void requestHexiaoData(String token, String code);
    }

    public interface HexiaoModel{
        public void reponseHexiaoData(String token,String code,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
