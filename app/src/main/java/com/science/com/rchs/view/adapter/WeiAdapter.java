package com.science.com.rchs.view.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.science.com.rchs.data.bean.WeiBean;

import java.util.List;

public class WeiAdapter extends BaseQuickAdapter<WeiBean.DataBean,BaseViewHolder> {
    public WeiAdapter(int layoutResId, @Nullable List<WeiBean.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WeiBean.DataBean item) {

    }

}
