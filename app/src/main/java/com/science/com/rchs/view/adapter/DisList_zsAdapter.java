package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bill;
import com.science.com.rchs.data.bean.Zhe;
import com.science.com.rchs.di.contract.DisListContract;
import com.science.com.rchs.di.presenter.DisListPresenter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DisList_zsAdapter extends BaseAdapter implements DisListContract.DisListView{


    int type=2;
    private Context context;
    private List<Zhe.DataBean.ListBean> list;
    private int YI_ITEM=0;
    private int ER_ITEM=1;
    private int SAN_ITEM=2;
    private DisListContract.DisListPresenter disListPresenter;
    private String number;
    private String time;

    public DisList_zsAdapter(Context context, List<Zhe.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {

      String date = String.valueOf(System.currentTimeMillis()/1000L);
        Calendar.getInstance().getTimeInMillis();
        new Date().getTime();

        Log.i("adga",date);
        if(list.get(position).getNumber().length()<=list.get(position).getNumber().length()){
            return YI_ITEM;
        }else if(list.get(position).getEnd_timestamp().length()<date.length()){
            return ER_ITEM;
        }else {
            return SAN_ITEM;
        }

    }


    @Override
    public View getView(int position, View view, ViewGroup parent) {

        SharedPreferences sp = context.getSharedPreferences("login", Context.MODE_PRIVATE);
       String token = sp.getString("token", "");

        disListPresenter = new DisListPresenter();
        disListPresenter.attachView(this);
        disListPresenter.requestDisListData(token,type);

        int type = getItemViewType(position);
        if (type == YI_ITEM) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.item_lingwan,null);
                viewHolder =new  ViewHolder();
                viewHolder.title3 = view.findViewById(R.id.title3);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.title3.setText(list.get(position).getTitle());


            return view;
        } else if (type == ER_ITEM) {
            ViewHolder1 viewHolder1;
            if (view == null) {
                view = View.inflate(context, R.layout.item_guoqi, null);
                viewHolder1 = new ViewHolder1();
                viewHolder1.title4 = view.findViewById(R.id.title4);
                view.setTag(viewHolder1);
            } else {
                viewHolder1 = (ViewHolder1) view.getTag();
            }

            viewHolder1.title4.setText(list.get(position).getTitle());
            return view;
        }else {
            ViewHolder2 viewHolder2;
            if (view == null) {
                view = View.inflate(context, R.layout.item04, null);
                viewHolder2 = new ViewHolder2();
                viewHolder2.title3 = view.findViewById(R.id.title3);
                viewHolder2.shengyu3 = view.findViewById(R.id.shengyu3);
                view.setTag(viewHolder2);
            } else {
                viewHolder2 = (ViewHolder2) view.getTag();
            }

            viewHolder2.title3.setText(list.get(position).getTitle());
            viewHolder2.shengyu3.setText("剩余"+list.get(position).getNumber()+""+"张");

            return view;
        }


    }

    @Override
    public void showDisListData(String message) {
        Gson gson = new Gson();
        Zhe zhe = gson.fromJson(message,Zhe.class);
        List<Zhe.DataBean.ListBean> date = (List<Zhe.DataBean.ListBean>) zhe.getData();
        for (int i=0;i<date.size();i++){
            number = date.get(i).getNumber();
            time = date.get(i).getEnd_timestamp();

        }

    }

    class ViewHolder {
        TextView title3;

    }
    class ViewHolder1 {
        TextView title4;
    }
    class ViewHolder2 {
        TextView title3;
        Button shengyu3;

    }

}
