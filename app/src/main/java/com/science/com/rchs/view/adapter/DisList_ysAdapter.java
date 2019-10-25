package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.data.bean.HList;
import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.contract.YouContract;
import com.science.com.rchs.di.presenter.DaiPresenter;
import com.science.com.rchs.di.presenter.YouPresenter;

import java.util.ArrayList;
import java.util.List;

public class DisList_ysAdapter extends BaseAdapter implements YouContract.YouView{

    private Context context;
    private ArrayList<DisList.DataBean.ListBean> list;
    private int YI_ITEM = 0;
    private int ER_ITEM = 1;
    private int SAN_ITEM = 2;
    private String token;
    int type;
    private String number;

    public DisList_ysAdapter(Context context, ArrayList<DisList.DataBean.ListBean> list) {
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


        if (list.get(position).getNumber().length()>1) {
            return YI_ITEM;
        } else if (list.get(position).getNumber().length()<=0) {
            return ER_ITEM;
        } else {
            return SAN_ITEM;
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
       YouContract.YouPresenter youPresenter = new YouPresenter();
        youPresenter.attachView(this);
        youPresenter.requestYouData(token,type);
        int type = getItemViewType(position);
        if (type == YI_ITEM) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.item03, null);
                viewHolder = new ViewHolder();
                viewHolder.title2 = view.findViewById(R.id.title2);
                viewHolder.shengyu2 = view.findViewById(R.id.shengyu2);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }


            viewHolder.title2.setText(list.get(position).getTitle());
            viewHolder.shengyu2.setText("剩余"+list.get(position).getNumber()+""+"张");
            return view;
        } else if (type == ER_ITEM) {
           ViewHolder1 viewHolder1;
            if (view == null) {
                view = View.inflate(context, R.layout.item_lingwan, null);
                viewHolder1 = new ViewHolder1();
                viewHolder1.title3 = view.findViewById(R.id.title3);
                viewHolder1.shengyu3 = view.findViewById(R.id.shengyu3);
                view.setTag(viewHolder1);
            } else {
                viewHolder1 = (ViewHolder1) view.getTag();
            }

            viewHolder1.title3.setText(list.get(position).getTitle());
            viewHolder1.shengyu3.setText("剩余"+list.get(position).getNumber()+""+"张");
            return view;
        } else {
            ViewHolder2 viewHolder2;
            if (view == null) {
                view = View.inflate(context, R.layout.item_guoqi, null);
                viewHolder2 = new ViewHolder2();
                viewHolder2.title4 = view.findViewById(R.id.title4);
                viewHolder2.shengyu4 = view.findViewById(R.id.shengyu4);
                view.setTag(viewHolder2);
            } else {
                viewHolder2 = (ViewHolder2) view.getTag();
            }

            viewHolder2.title4.setText(list.get(position).getTitle());
            viewHolder2.shengyu4.setText("剩余"+list.get(position).getNumber()+""+"张");
            return view;
        }
    }

    @Override
    public void showDaiData(String message) {
        Gson gson = new Gson();
        DisList disList = gson.fromJson(message,DisList.class);
        ArrayList<DisList.DataBean.ListBean> beans = (ArrayList<DisList.DataBean.ListBean>) disList.getData().getList();
        for (int i=0;i<beans.size();i++){
            number = beans.get(i).getNumber();
        }
    }


    class ViewHolder {
        TextView title2;
        TextView shengyu2;
    }

    class ViewHolder1 {
        TextView title3;
        TextView shengyu3;

    }

    class ViewHolder2 {
        TextView title4;
        TextView shengyu4;
    }
}