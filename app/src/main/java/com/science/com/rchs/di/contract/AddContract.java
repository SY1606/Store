package com.science.com.rchs.di.contract;

public interface AddContract {

    public interface AddView{
        public void showAddData(String message);
        public void showAddZheData(String message);
        public void showAddYouData(String message);

    }

    public interface AddPresenter<AddView>{
        public void attachView(AddView addView);
        public void detachView(AddView addView);

        public void requestAddData(String token,String logo_url,String color,String begin_timestamp,String end_timestamp,String notice,String description,int quantity,String least_cost,String reduce_cost);
        public void requestAddZheData(String token,String logo_url,String color,String begin_timestamp,String end_timestamp,String notice,String description,int quantity,String discount);
        public void requestAddYouData(String token,String logo_url,String color,String begin_timestamp,String end_timestamp,String notice,String description,int quantity,String default_detail);

    }

    public interface AddModel{
        public void reponseAddData(String token,String logo_url,String color,String begin_timestamp,String end_timestamp,String notice,String description,int quantity,String least_cost,String reduce_cost, CallBack callBack);
        public void reponseAddZheData(String token,String logo_url,String color,String begin_timestamp,String end_timestamp,String notice,String description,int quantity,String discount,CallBack callBack);
        public void reponseAddYouData(String token,String logo_url,String color,String begin_timestamp,String end_timestamp,String notice,String description,int quantity,String default_detail,CallBack callBack);

        public interface CallBack{
            public void onCallBack(String message);
        }
    }
}
