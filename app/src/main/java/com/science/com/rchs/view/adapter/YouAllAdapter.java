package com.science.com.rchs.view.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.HList;

import java.util.List;

public class YouAllAdapter extends BaseQuickAdapter<HList.DataBean,BaseViewHolder> {
    public YouAllAdapter(int layoutResId, @Nullable List<HList.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HList.DataBean item) {
        helper.setText(R.id.names,item.getTitle());
        helper.setText(R.id.codes,item.getCode()+"");
        helper.setText(R.id.times,item.getUpdated_at());
    }
}
