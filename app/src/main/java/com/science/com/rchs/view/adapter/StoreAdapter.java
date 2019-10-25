package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Store;
import com.science.com.rchs.data.bean.Storess;
import com.science.com.rchs.view.activity.HomeActivity;
import com.science.com.rchs.view.fragment.Frag_set;

import java.util.List;

public class StoreAdapter extends BaseQuickAdapter<Storess.DataBean,BaseViewHolder> {

    public StoreAdapter(int layoutResId, @Nullable List<Storess.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final Storess.DataBean item) {
        helper.setText(R.id.name,item.getName());
        helper.setText(R.id.money,(double)item.getActualTotal()+"");
        Log.i("asafa",item.getActualTotal()+"");
        helper.setText(R.id.number,item.getOrderCount()+"");

        SharedPreferences sp = mContext.getSharedPreferences("store",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("srore_id",item.getId());
        editor.commit();

    }
}
