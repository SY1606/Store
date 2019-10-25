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

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.data.bean.HList;
import com.science.com.rchs.data.bean.Zhe;
import com.science.com.rchs.di.contract.DisListContract;
import com.science.com.rchs.di.presenter.DisListPresenter;
import com.science.com.rchs.view.adapter.DisList_zAdapter;
import com.science.com.rchs.view.adapter.DisList_zsAdapter;

import java.util.ArrayList;
import java.util.List;


public class Frag04 extends Fragment implements DisListContract.DisListView{

    //private RecyclerView recy_frag04;
    int type=2;
    private DisListContract.DisListPresenter disListPresenter;
    private RecyclerView listView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag04, container, false);

        SharedPreferences sp =getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
        String token = sp.getString("token","");
        //recy_frag04 = view.findViewById(R.id.recy_frag04);

        listView = view.findViewById(R.id.ListView);
        disListPresenter = new DisListPresenter();
        disListPresenter.attachView(this);
        disListPresenter.requestDisListData(token,type);
        return view;
    }

    @Override
    public void showDisListData(String message) {
        Gson gson = new Gson();
        Zhe disList = gson.fromJson(message,Zhe.class);
        //List<Zhe.DataBean.ListBean> beans = disList.getData().getList();
        ArrayList<Zhe.DataBean.ListBean> beans1 = (ArrayList<Zhe.DataBean.ListBean>) disList.getData().getList();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        listView.setLayoutManager(linearLayoutManager);


        DisList_zAdapter disList_zAdapter = new DisList_zAdapter(R.layout.item04,beans1);
        //DisList_zsAdapter disList_zAdapter = new DisList_zsAdapter(getContext(), beans1);
        listView.setAdapter(disList_zAdapter);
    }
}
