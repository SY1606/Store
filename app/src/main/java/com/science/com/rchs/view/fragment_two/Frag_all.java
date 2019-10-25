package com.science.com.rchs.view.fragment_two;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.HList;
import com.science.com.rchs.data.bean.Recoder;
import com.science.com.rchs.di.contract.CRecoderContract;
import com.science.com.rchs.di.contract.DaiContract;
import com.science.com.rchs.di.presenter.DaiPresenter;
import com.science.com.rchs.di.presenter.RecoderPresenter;
import com.science.com.rchs.view.adapter.AllAdapter;

import java.util.ArrayList;
import java.util.List;


public class Frag_all extends Fragment implements DaiContract.DaiView {


    private String token;
    int coupon_type=0;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_all, container, false);
        SharedPreferences sp =getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");

        listView = view.findViewById(R.id.listView);
        DaiContract.DaiPresenter daiPresenter = new DaiPresenter();
        daiPresenter.attachView(this);
        daiPresenter.requestDaiData(token,coupon_type);
        return view;
    }

    @Override
    public void showDaiData(String message) {
        Gson gson = new Gson();
        HList hList = gson.fromJson(message,HList.class);
        ArrayList<HList.DataBean> dataBeans = (ArrayList<HList.DataBean>) hList.getData();
        AllAdapter allAdapter = new AllAdapter(getContext(),dataBeans);
        listView.setAdapter(allAdapter);

    }
}
