package com.science.com.rchs.view.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.science.com.rchs.data.bean.Store;

import java.util.List;

public class Frag_setAdapter extends BaseQuickAdapter<Store.DataBean,BaseViewHolder> {
    public Frag_setAdapter(int layoutResId, @Nullable List<Store.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Store.DataBean item) {

    }
}
