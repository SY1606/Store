package com.science.com.rchs.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.ChooseStore;

import com.science.com.rchs.di.contract.ChooseDStoreContract;
import com.science.com.rchs.di.presenter.ChooseDStorePresenter;
import com.science.com.rchs.view.activity.HomeActivity;
import com.science.com.rchs.view.activity_set.ChooseStoreActivity;
import com.science.com.rchs.view.fragment_two.Frag_s_all;

import java.util.List;

public class ChooseStoreAdapter extends BaseQuickAdapter<ChooseStore.DataBean,BaseViewHolder> implements ChooseDStoreContract.ChooseDStoreView {

    private int store_id;
    private ChooseDStoreContract.ChooseStoreDPresenter chooseStoreDPresenter;
    private String token;
    private String name;
    public ChooseStoreAdapter(int layoutResId, @Nullable List<ChooseStore.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final ChooseStore.DataBean item) {
        chooseStoreDPresenter = new ChooseDStorePresenter();
        chooseStoreDPresenter.attachView(this);
        SharedPreferences sp =mContext.getSharedPreferences("login",Context.MODE_PRIVATE);
        token = sp.getString("token","");

        helper.setText(R.id.store,item.getName());

        helper.getView(R.id.store).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                refresh();
                if (Activity.class.isInstance(mContext)){
                    Activity activity = (Activity) mContext;
                    activity.finish();
                }
            }
            private void refresh() {
                SharedPreferences sp = mContext.getSharedPreferences("ids",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                editor.putInt("id",item.getId());
                editor.putString("names",item.getName());
                Intent intent = new Intent(mContext, HomeActivity.class);
                intent.putExtra("id", 1);
                mContext.startActivity(intent);
                editor.commit();
            }
        });
    }

    @Override
    public void showChooseDStoreData(String message) {
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();

    }
}
