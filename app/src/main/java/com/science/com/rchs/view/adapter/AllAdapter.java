package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bill;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.data.bean.HList;
import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.presenter.DaiPresenter;
import com.science.com.rchs.view.dalis.DisDetalis1Activity;
import com.science.com.rchs.view.dalis.DisDetalis2Activity;
import com.science.com.rchs.view.dalis.DisDetalis3Activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AllAdapter extends BaseAdapter implements DaiContract.DaiView {

    private Context context;
    private ArrayList<HList.DataBean> list;
    private int YI_ITEM=0;
    private int ER_ITEM=1;
    private int SAN_ITEM=2;
    private String token;
    private int coupon_type;


    public AllAdapter(Context context, ArrayList<HList.DataBean> list) {
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

        if(list.get(position).getCoupon_type().equals("1")){
            return YI_ITEM;
        }else if(list.get(position).getCoupon_type().equals("3")){
            return ER_ITEM;
        }else {
            return SAN_ITEM;
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        SharedPreferences sp = context.getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        DaiContract.DaiPresenter daiPresenter = new DaiPresenter();
        daiPresenter.attachView(this);
        daiPresenter.requestDaiData(token,coupon_type);
        int type = getItemViewType(position);
        if (type == YI_ITEM) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.item_dai, null);
                viewHolder = new ViewHolder();
                viewHolder.names = view.findViewById(R.id.names);
                viewHolder.codes = view.findViewById(R.id.codes);
                viewHolder.times = view.findViewById(R.id.times);
                view.setTag(viewHolder);
            } else {
                viewHolder = (AllAdapter.ViewHolder) view.getTag();
            }


            viewHolder.names.setText(list.get(position).getTitle());
            viewHolder.codes.setText(list.get(position).getCode()+"");
            viewHolder.times.setText(list.get(position).getUpdated_at());

            return view;
        } else if (type == ER_ITEM) {
            ViewHolder1 viewHolder1;
            if (view == null) {
                view = View.inflate(context, R.layout.item_you, null);
                viewHolder1 = new ViewHolder1();
                viewHolder1.names = view.findViewById(R.id.names);
                viewHolder1.codes = view.findViewById(R.id.codes);
                viewHolder1.times = view.findViewById(R.id.times);
                view.setTag(viewHolder1);
            } else {
                viewHolder1 = (ViewHolder1) view.getTag();
            }

            viewHolder1.names.setText(list.get(position).getTitle());
            viewHolder1.codes.setText(list.get(position).getCode()+"");
            viewHolder1.times.setText(list.get(position).getUpdated_at());
            return view;
        }else {
            ViewHolder2 viewHolder2;
            if (view == null) {
                view = View.inflate(context, R.layout.item_zhe, null);
                viewHolder2 = new ViewHolder2();
                viewHolder2.names = view.findViewById(R.id.names);
                viewHolder2.codes = view.findViewById(R.id.codes);
                viewHolder2.times = view.findViewById(R.id.times);
                view.setTag(viewHolder2);
            } else {
                viewHolder2 = (ViewHolder2) view.getTag();
            }

            viewHolder2.names.setText(list.get(position).getTitle());
            viewHolder2.codes.setText(list.get(position).getCode()+"");
            viewHolder2.times.setText(list.get(position).getUpdated_at());
            return view;
        }
    }

    @Override
    public void showDaiData(String message) {
        Gson gson = new Gson();
        HList hList  = gson.fromJson(message,HList.class);
        List<HList.DataBean> dataBeans = hList.getData();
        for (int i=0;i<dataBeans.size();i++){
            coupon_type = Integer.parseInt(dataBeans.get(i).getCoupon_type());

        }
    }


    class ViewHolder {
        TextView names;
        TextView codes;
        TextView times;
    }
    class ViewHolder1 {
        TextView names;
        TextView codes;
        TextView times;
    }
    class ViewHolder2 {
        TextView names;
        TextView codes;
        TextView times;
    }
}
