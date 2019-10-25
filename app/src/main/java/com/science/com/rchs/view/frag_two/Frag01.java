package com.science.com.rchs.view.frag_two;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.data.bean.Recoder;
import com.science.com.rchs.di.contract.DisListContract;
import com.science.com.rchs.di.presenter.DisListPresenter;


import com.science.com.rchs.view.adapter.DisList1Adapter;

import java.util.ArrayList;
import java.util.List;


public class Frag01 extends Fragment implements DisListContract.DisListView {

    private DisListContract.DisListPresenter disListPresenter;
    private int type=0;
    private String token;
    private ListView recy_01;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag01, container, false);


        SharedPreferences sp =getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");

        recy_01 = view.findViewById(R.id.recy_01);
        disListPresenter = new DisListPresenter();
        disListPresenter.attachView(this);
        disListPresenter.requestDisListData(token,type);

        return view;
    }

    @Override
    public void showDisListData(String message) {
        Gson gson = new Gson();
        DisList disList = gson.fromJson(message,DisList.class);
        ArrayList<DisList.DataBean.ListBean> beans = (ArrayList<DisList.DataBean.ListBean>) disList.getData().getList();
        DisList1Adapter disList1Adapter = new DisList1Adapter(getContext(), beans);
        recy_01.setAdapter(disList1Adapter);
    }
}
