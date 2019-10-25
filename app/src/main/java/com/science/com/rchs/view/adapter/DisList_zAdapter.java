package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.data.bean.Zhe;
import com.science.com.rchs.di.contract.DisListContract;
import com.science.com.rchs.di.presenter.DisListPresenter;
import com.science.com.rchs.view.dalis.DisDetalis3Activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DisList_zAdapter extends BaseQuickAdapter<Zhe.DataBean.ListBean,BaseViewHolder> implements DisListContract.DisListView {

    private String format1;
    private String format;
    int type=2;
    public DisList_zAdapter(int layoutResId, @Nullable List<Zhe.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final Zhe.DataBean.ListBean item) {
        /*SharedPreferences sp = getSharedPreferences("login", Context.MODE_PRIVATE);
       String token = sp.getString("token", "");


        disListPresenter = new DisListPresenter();
        disListPresenter.attachView(this);

        disListPresenter.requestDisListData(token,type);*/
        helper.setText(R.id.title3,item.getTitle());
        helper.setText(R.id.shengyu3,"剩余"+item.getNumber()+""+"张");

        helper.getView(R.id.shengyu3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DisDetalis3Activity.class);
                intent.putExtra("coupon_id",item.getCoupon_id());
                intent.putExtra("logo",item.getLogo_url());
                Log.i("aaxcxa",item.getEnd_timestamp());
                intent.putExtra("title",item.getTitle());



                String key = item.getBegin_timestamp();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Long lt = new Long(key);
                Date date = new Date(lt*1000L);
                format = formatter.format(date);

                Log.i("saaaa",format);



                String keys = item.getEnd_timestamp();
                Log.i("afaxax",item.getEnd_timestamp());
                //String keys = "1569081600";
                SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                Long lts = new Long(keys);
                Date dates = new Date(lts*1000L);
                format1 = formatters.format(dates);
                Log.i("rrrr",format1);
                intent.putExtra("times",format);
                intent.putExtra("times_end",format1);

                mContext.startActivity(intent);
            }
        });

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DisDetalis3Activity.class);
                intent.putExtra("coupon_id",item.getCoupon_id());
                Log.i("aaxcxa",item.getEnd_timestamp());
                intent.putExtra("title",item.getTitle());
                intent.putExtra("logo",item.getLogo_url());

                String key = item.getBegin_timestamp();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Long lt = new Long(key);
                Date date = new Date(lt*1000L);
                format = formatter.format(date);

                Log.i("saaaa",format);



                String keys = item.getEnd_timestamp();
                Log.i("afaxax",item.getEnd_timestamp());
                //String keys = "1569081600";
                SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                Long lts = new Long(keys);
                Date dates = new Date(lts*1000L);
                format1 = formatters.format(dates);
                Log.i("rrrr",format1);
                intent.putExtra("times",format);
                intent.putExtra("times_end",format1);

                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public void showDisListData(String message) {
        Gson gson = new Gson();
        Zhe disList = gson.fromJson(message,Zhe.class);
        //List<Zhe.DataBean.ListBean> beans = disList.getData().getList();
        //ArrayList<Zhe.DataBean.ListBean> beans1 = (ArrayList<Zhe.DataBean.ListBean>) disList.getData().getList();

        List<Zhe.DataBean.ListBean> beans = disList.getData().getList();
        for (int i=0;i<beans.size();i++){
            String coupon_id = beans.get(i).getCoupon_id();
           String logo_url = beans.get(i).getLogo_url();
            Log.i("efxaxca",beans.get(i).getLogo_url());
        }


    }
}
