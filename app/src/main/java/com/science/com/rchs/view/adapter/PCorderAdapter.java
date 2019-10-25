package com.science.com.rchs.view.adapter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.PRecoder;

import java.util.List;

public class PCorderAdapter extends BaseQuickAdapter<PRecoder.DataBean.ListBean,BaseViewHolder> {
    public PCorderAdapter(int layoutResId, @Nullable List<PRecoder.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PRecoder.DataBean.ListBean item) {
        helper.setText(R.id.moneys,item.getChange_money()+"");
        helper.setText(R.id.times,"交易时间:"+item.getCreated_at()+"");
        helper.setText(R.id.numbers,"会员卡号:"+item.getCard_number()+"");


    }
}
