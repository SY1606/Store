package com.science.com.rchs.view.adapter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Recoder;

import java.util.ArrayList;
import java.util.List;

public class CRecoderAdapter extends BaseQuickAdapter<Recoder.DataBean.ListBean,BaseViewHolder> {
    public CRecoderAdapter(int layoutResId, @Nullable ArrayList<Recoder.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Recoder.DataBean.ListBean item) {
        helper.setText(R.id.corder_money,item.getChange_money()+"");
        Log.i("aerax",item.getCard_number()+"");
        helper.setText(R.id.time,"交易时间:"+item.getCreated_at()+"");
        helper.setText(R.id.corder_number,"会员卡号:"+item.getCard_number()+"");
        Log.i("corder_number",item.getCard_number()+"");
        //helper.setText(R.id.number,"会员卡号:"+item.getCard_number()+"");
        //SimpleDraweeView simpleDraweeView = helper.getView(R.id.imagehead);
        //simpleDraweeView.setImageURI(item.getHeadimgurl());
    }
}
