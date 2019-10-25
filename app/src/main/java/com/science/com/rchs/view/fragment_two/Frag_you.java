package com.science.com.rchs.view.fragment_two;

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
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.HList;
import com.science.com.rchs.di.contract.YouAllContract;
import com.science.com.rchs.di.contract.YouContract;
import com.science.com.rchs.di.presenter.YouAllPresenter;
import com.science.com.rchs.di.presenter.YouPresenter;
import com.science.com.rchs.view.adapter.DaiAdapter;
import com.science.com.rchs.view.adapter.YouAllAdapter;

import java.util.List;


public class Frag_you extends Fragment implements YouAllContract.YouAllView {

    private YouAllContract.YouAllPresenter youPresenter;
    private RecyclerView frag_you;
    int coupon_type=3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_you, container, false);


        SharedPreferences sp =getActivity().getSharedPreferences("login",Context.MODE_PRIVATE);
        String token = sp.getString("token","");

        frag_you = view.findViewById(R.id.frag_you);
        youPresenter = new YouAllPresenter();
        youPresenter.attachView(this);
        youPresenter.requestYouAllData(token,coupon_type);
        return view;
    }


    @Override
    public void showYouAllData(String message) {
        Gson gson = new Gson();
        HList hList =gson.fromJson(message,HList.class);
        List<HList.DataBean> beans = hList.getData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        frag_you.setLayoutManager(linearLayoutManager);

        YouAllAdapter youAllAdapter = new YouAllAdapter(R.layout.item_you, beans);
        frag_you.setAdapter(youAllAdapter);
    }
}
