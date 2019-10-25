package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bill;
import com.science.com.rchs.view.activity.OrderDalis1Activity;
import com.science.com.rchs.view.activity.OrderDalisActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillAdapter {

    /*private String format;
    private String format2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    /*public BillAdapter(List<Bill.DataBean.ListBean> data) {
        super(data);
        addItemType(Bill.DataBean.ListBean.IMG,R.layout.item_weixin1);
        addItemType(Bill.DataBean.ListBean.TEXT,R.layout.item_pay1);
    }


    @Override
    protected void convert(BaseViewHolder helper, Bill.DataBean.ListBean item) {
        switch (helper.getItemViewType()){
            case  Bill.DataBean.ListBean.IMG :
                    RelativeLayout weixin1 = helper.getView(R.id.weixin1);
                    String key = item.getCreatetime();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Long lt = new Long(key);
                    Date date = new Date(lt * 1000L);
                    format = formatter.format(date);
                    //TextView money = helper.getView(R.id.money);
                    helper.setText(R.id.money,item.getTotal_fee()+"");
                    TextView number = helper.getView(R.id.number);
                    number.setText("订单编号:"+item.getOut_trade_no()+"");
                    TextView time = helper.getView(R.id.time);
                    time.setText("交易时间:" + format);

                helper.getView(R.id.weixin1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, OrderDalisActivity.class);
                        intent.putExtra("order", item.getOut_trade_no() + "");
                        intent.putExtra("times", format);
                        intent.putExtra("moneys",item.getTotal_fee()+ "");
                        mContext.startActivity(intent);
                    }
                });

                break;
            case  Bill.DataBean.ListBean.TEXT:
                    String keys = item.getCreatetime();
                    SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Long lts = new Long(keys);
                    Date dates = new Date(lts * 1000L);
                    format2 = formatters.format(dates);

                    RelativeLayout pay1 = helper.getView(R.id.pay1);

                    TextView money2 = helper.getView(R.id.money2);
                    money2.setText(item.getTotal_fee()+"");
                    TextView number2 = helper.getView(R.id.number2);
                    number2.setText("订单编号:"+item.getOut_trade_no()+"");
                    TextView time2 = helper.getView(R.id.time2);
                    time2.setText("交易时间:" + format2);

                helper.getView(R.id.pay1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mContext, OrderDalis1Activity.class);
                        intent.putExtra("order", item.getOut_trade_no() + "");
                        intent.putExtra("times", format2);
                        intent.putExtra("moneys",item.getTotal_fee()+ "");
                        mContext.startActivity(intent);
                    }
                });

                break;
        }
    }*/
}
