package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.HList;

import java.util.List;

public class DaiAdapter extends BaseQuickAdapter<HList.DataBean,BaseViewHolder> {
    public DaiAdapter(int layoutResId, @Nullable List<HList.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HList.DataBean item) {
        helper.setText(R.id.names,item.getTitle());
        helper.setText(R.id.codes,item.getCode()+"");
        helper.setText(R.id.times,item.getUpdated_at());
        SharedPreferences sp = mContext.getSharedPreferences("code",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("codes",item.getCode()+"");
        editor.commit();
    }
}
