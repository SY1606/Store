package com.science.com.rchs.view.adapter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.view.dalis.DisDetalis1Activity;
import com.science.com.rchs.view.dalis.DisDetalis2Activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DisList_yAdapter extends BaseQuickAdapter<DisList.DataBean.ListBean,BaseViewHolder>{
    private String format1;
    private String format;
    public DisList_yAdapter(int layoutResId, @Nullable List<DisList.DataBean.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final DisList.DataBean.ListBean item) {
        helper.setText(R.id.title2,item.getTitle());
        helper.setText(R.id.shengyu2,"剩余"+item.getNumber()+""+"张");

        helper.getView(R.id.shengyu2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DisDetalis2Activity.class);
                intent.putExtra("coupon_id",item.getCoupon_id());
                intent.putExtra("title",item.getTitle());
                intent.putExtra("log",item.getLogo_url());
                String key = item.getBegin_timestamp();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Long lt = new Long(key);
                Date date = new Date(lt*1000L);
                format = formatter.format(date);


                String keys = item.getEnd_timestamp();
                SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                Long lts = new Long(keys);
                Date dates = new Date(lts*1000L);
                format1 = formatters.format(dates);


                intent.putExtra("times",format);
                intent.putExtra("times_end",format1);

                mContext.startActivity(intent);


            }
        });

        helper.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DisDetalis2Activity.class);
                intent.putExtra("coupon_id",item.getCoupon_id());
                intent.putExtra("title",item.getTitle());
                intent.putExtra("log",item.getLogo_url());
                String key = item.getBegin_timestamp();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Long lt = new Long(key);
                Date date = new Date(lt*1000L);
                format = formatter.format(date);


                String keys = item.getEnd_timestamp();
                SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                Long lts = new Long(keys);
                Date dates = new Date(lts*1000L);
                format1 = formatters.format(dates);


                intent.putExtra("times",format);
                intent.putExtra("times_end",format1);

                mContext.startActivity(intent);


            }
        });
    }
}
