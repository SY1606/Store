package com.science.com.rchs.view.adapter;

import android.content.Context;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bill;
import com.science.com.rchs.di.contract.BillContract;
import com.science.com.rchs.net.ToastUtil;
import com.science.com.rchs.view.activity.OrderDalis1Activity;
import com.science.com.rchs.view.activity.OrderDalisActivity;
import com.science.com.rchs.view.activity_bill.OrderDalis2Activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import recycler.coverflow.RecyclerCoverFlow;

public class BillsAdapter extends RecyclerView.Adapter {

    private Context mcontext;
    private List<Bill.DataBean.ListBean> list;
    public static final int TYPE_LEFT_IMAGE = 0;
    public static final int TYPE_RIGHT_IMAGE = 1;
    public static final int TYPE_RIGHT_TEXT = 2;
    public static final int TYPE_LEFT_TEXT = 3;
    public static final int TUI = 4;

    public BillsAdapter(Context mcontext, List<Bill.DataBean.ListBean> list) {
        this.mcontext = mcontext;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int type) {

        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (type) {
            case TYPE_LEFT_IMAGE:
                //条目布局
                view = LayoutInflater.from(mcontext).inflate(R.layout.item_weixin1, null);
                holder = new TextViewHolder(view);
                break;
            case TYPE_RIGHT_IMAGE:
                view = LayoutInflater.from(mcontext).inflate(R.layout.item_pay1, null);
                holder = new ImageViewHolder(view);
                break;
            case TYPE_RIGHT_TEXT:
                //条目布局
                view = LayoutInflater.from(mcontext).inflate(R.layout.item_weixin1, null);
                holder = new TEXTHolder(view);
                break;
            case TYPE_LEFT_TEXT:
                //条目布局
                view = LayoutInflater.from(mcontext).inflate(R.layout.item_pay1, null);
                holder = new IMAGEHOLDER(view);
                break;
            case TUI:
                //条目布局
                view = LayoutInflater.from(mcontext).inflate(R.layout.item_weixin2, null);
                holder = new TUIHOLDER(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Bill.DataBean.ListBean listBean= list.get(i);

        String key = listBean.getCreatetime()+"";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lt = new Long(key);
        Date date = new Date(lt*1000L);
        String  format = formatter.format(date);


        if (viewHolder instanceof TextViewHolder) {
            ((TextViewHolder) viewHolder).money.setText(listBean.getTotal_fee()+"");
            ((TextViewHolder) viewHolder).number.setText("订单编号:"+listBean.getOut_trade_no()+"");
            ((TextViewHolder) viewHolder).time.setText("交易时间："+format);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext,OrderDalisActivity.class);
                    intent.putExtra("order1",listBean.getOut_trade_no()+"");
                    intent.putExtra("times",format);
                    intent.putExtra("moneys","￥"+listBean.getTotal_fee()+"");
                    mcontext.startActivity(intent);
                }
            });
        }


        String keys = listBean.getCreatetime()+"";
        SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long lts = new Long(keys);
        Date dates = new Date(lts*1000L);
        String  formats = formatters.format(dates);
        //在里面设置各自的适配器  和显示的布局
        if (viewHolder instanceof ImageViewHolder) {
            ((ImageViewHolder) viewHolder).money2.setText(listBean.getTotal_fee()+"");
            ((ImageViewHolder) viewHolder).number2.setText("订单编号:"+listBean.getOut_trade_no()+"");
            ((ImageViewHolder) viewHolder).time2.setText("交易时间："+formats);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext,OrderDalis1Activity.class);
                    intent.putExtra("order",listBean.getOut_trade_no()+"");
                    intent.putExtra("times",format);
                    intent.putExtra("moneys","￥"+listBean.getTotal_fee()+"");
                    mcontext.startActivity(intent);
                }
            });
        }


        if (viewHolder instanceof TEXTHolder){
            String keyss = listBean.getCreatetime()+"";
            SimpleDateFormat formatterss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long ltss = new Long(keyss);
            Date datess = new Date(ltss*1000L);
            String  formatss = formatterss.format(datess);

            ((TEXTHolder) viewHolder).money.setText(listBean.getTotal_fee()+"");
            ((TEXTHolder) viewHolder).number.setText("订单编号:"+listBean.getOut_trade_no()+"");
            ((TEXTHolder) viewHolder).time.setText("交易时间："+formatss);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext,OrderDalisActivity.class);
                    intent.putExtra("order1",listBean.getOut_trade_no()+"");
                    intent.putExtra("times",format);
                    intent.putExtra("moneys","￥"+listBean.getTotal_fee()+"");
                    mcontext.startActivity(intent);
                }
            });

        }

        if (viewHolder instanceof IMAGEHOLDER){
            String key1 = listBean.getCreatetime()+"";
            SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long lt1 = new Long(key1);
            Date date1 = new Date(lt1*1000L);
            String  formatss = formatter1.format(date1);

            ((IMAGEHOLDER) viewHolder).money2.setText(listBean.getTotal_fee()+"");
            ((IMAGEHOLDER) viewHolder).number2.setText("订单编号:"+listBean.getOut_trade_no()+"");
            ((IMAGEHOLDER) viewHolder).time2.setText("交易时间："+formatss);

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext,OrderDalis2Activity.class);
                    intent.putExtra("order2",listBean.getOut_trade_no()+"");
                    intent.putExtra("times",format);
                    intent.putExtra("moneys","￥"+listBean.getTotal_fee()+"");
                    mcontext.startActivity(intent);
                }
            });
        }


        if (viewHolder instanceof TUIHOLDER){
            String key2 = listBean.getCreatetime()+"";
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long lt2 = new Long(key2);
            Date date2 = new Date(lt2*1000L);
            String  formatss = formatter2.format(date2);

            ((TUIHOLDER) viewHolder).money1.setText(listBean.getTotal_fee()+"");
            ((TUIHOLDER) viewHolder).number1.setText("订单编号:"+listBean.getOut_trade_no()+"");
            ((TUIHOLDER) viewHolder).time1.setText("交易时间："+formatss);
        }
    }

    private class TextViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout weixin1;
        TextView money;;
        TextView number;
        TextView time;
        public TextViewHolder(View itemView) {
            super(itemView);
            weixin1 = itemView.findViewById(R.id.weixin1);
            money = itemView.findViewById(R.id.money);
            number = itemView.findViewById(R.id.number);
            time = itemView.findViewById(R.id.time);

            /*weixin1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mcontext,OrderDalisActivity.class);
                    intent.putExtra("order",list.get(1).getOut_trade_no()+"");
                    intent.putExtra("times",format);
                    intent.putExtra("moneys","￥"+list.get(1).getTotal_fee()+"");
                    mcontext.startActivity(intent);

                }
            });*/


        }
    }

    private class ImageViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout pay1;
        TextView money2;;
        TextView number2;
        TextView time2;

        public ImageViewHolder(View itemView) {
            super(itemView);
            pay1 = itemView.findViewById(R.id.pay1);
            money2 = itemView.findViewById(R.id.money2);
            number2 = itemView.findViewById(R.id.number2);
            time2 = itemView.findViewById(R.id.time2);
        }
    }

    private class TEXTHolder extends RecyclerView.ViewHolder {
        TextView money;;
        TextView number;
        TextView time;

        public TEXTHolder(View itemView) {
            super(itemView);
            money = itemView.findViewById(R.id.money);
            number = itemView.findViewById(R.id.number);
            time = itemView.findViewById(R.id.time);
        }
    }

    private class IMAGEHOLDER extends RecyclerView.ViewHolder {
        TextView money2;;
        TextView number2;
        TextView time2;

        public IMAGEHOLDER(View itemView) {
            super(itemView);
            money2 = itemView.findViewById(R.id.money2);
            number2 = itemView.findViewById(R.id.number2);
            time2 = itemView.findViewById(R.id.time2);
        }
    }

    private class TUIHOLDER extends RecyclerView.ViewHolder {
        TextView money1;;
        TextView number1;
        TextView time1;

        public TUIHOLDER(View itemView) {
            super(itemView);
            money1 = itemView.findViewById(R.id.money1);
            number1 = itemView.findViewById(R.id.number1);
            time1= itemView.findViewById(R.id.time1);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        String service = list.get(position).getService();
        String status = list.get(position).getStatus();
        if (service.equals("wx_jsapi")) {
            return TYPE_LEFT_IMAGE;
        } else if (service.equals("ali_jsapi")){
            return TYPE_RIGHT_IMAGE;
        }else if (service.equals("wx_scan")){
            return TYPE_RIGHT_TEXT;
        }else if (service.equals("ali_scan")){
            return TYPE_LEFT_TEXT;
        }else if (status.equals("2")&&service.equals("wx_jsapi")&&service.equals("wx_scan")){
            return TUI;
        }else {
            return 0;
        }


    }

    /*private Context context;
    private ArrayList<Bill.DataBean.ListBean> list;
    private int YI_ITEM=0;
    private int ER_ITEM=1;
    private int SAN_ITEM=2;
    private int SI_ITEM=3;
    private String format;
    private String format1;
    private String format2;
    private String service;
    private int status;


    public BillsAdapter(Context context,ArrayList<Bill.DataBean.ListBean> listBeans) {
        this.context = context;
        this.list = listBeans;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2==0){
            return YI_ITEM;
        }else if(position%2==1){
            return ER_ITEM;
        }else {
            return SAN_ITEM;
        }
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        int type = getItemViewType(position);
        if (type==YI_ITEM){
            ViewHolder viewHolder;
            if (view==null){
                view =View.inflate(context,R.layout.item_weixin1,null);
                viewHolder = new ViewHolder();
                viewHolder.money = view.findViewById(R.id.money);
                viewHolder.number = view.findViewById(R.id.number);
                viewHolder.time = view.findViewById(R.id.time);
                viewHolder.weixin1 = view.findViewById(R.id.weixin1);
                view.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) view.getTag();
            }

            viewHolder.weixin1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,OrderDalisActivity.class);
                    intent.putExtra("order",list.get(position).getOut_trade_no()+"");
                    intent.putExtra("times",format);
                    intent.putExtra("moneys","￥"+list.get(position).getTotal_fee()+"");
                    context.startActivity(intent);
                }
            });


            String key = list.get(position).getCreatetime()+"";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long lt = new Long(key);
            Date date = new Date(lt*1000L);
            format = formatter.format(date);

            viewHolder.money.setText(list.get(position).getTotal_fee()+"");
            viewHolder.number.setText("订单编号:"+list.get(position).getOut_trade_no()+"");
            viewHolder.time.setText("交易时间:"+ format);

            return view;
        }else if (type ==ER_ITEM){
            ViewHolder1 viewHolder1;
            if (view==null){
                view =View.inflate(context,R.layout.item_pay1,null);
                viewHolder1 = new ViewHolder1();
                viewHolder1.money2 = view.findViewById(R.id.money2);
                viewHolder1.number2 = view.findViewById(R.id.number2);
                viewHolder1.time2 = view.findViewById(R.id.time2);
                view.setTag(viewHolder1);
            }else {
                viewHolder1 = (ViewHolder1) view.getTag();
            }
            String key = list.get(position).getCreatetime()+"";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long lt = new Long(key);
            Date date = new Date(lt*1000L);
            format1 = formatter.format(date);

            viewHolder1.money2.setText(list.get(position).getTotal_fee()+"");
            viewHolder1.number2.setText("订单编号:"+list.get(position).getOut_trade_no()+"");
            viewHolder1.time2.setText("交易时间:"+ format1);

            return view;
        } else {
            ViewHolder3 viewHolder3;
            if (view==null){
                view =View.inflate(context,R.layout.item_pay2,null);
                viewHolder3 = new ViewHolder3();
                viewHolder3.money3 = view.findViewById(R.id.money3);
                viewHolder3.number3 = view.findViewById(R.id.number3);
                viewHolder3.time3 = view.findViewById(R.id.time3);
                view.setTag(viewHolder3);
            }else {
                viewHolder3 = (ViewHolder3) view.getTag();
            }

            String key = list.get(position).getCreatetime()+"";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Long lt = new Long(key);
            Date date = new Date(lt);
            String format = formatter.format(date);
            viewHolder3.money3.setText(list.get(position).getTotal_fee()+"");
            viewHolder3.number3.setText("订单编号:"+list.get(position).getOut_trade_no()+"");
            viewHolder3.time3.setText("交易时间:"+format);

            return view;
        }

    }

    @Override
    public void showBillData(String message) {
        Gson gson = new Gson();
        Bill bill = gson.fromJson(message,Bill.class);
        List<Bill.DataBean.ListBean> datebean = bill.getData().getList();
        for (int i=0;i<datebean.size();i++){
            status = Integer.parseInt(datebean.get(i).getStatus());
            service = datebean.get(i).getService();
        }

    }

    @Override
    public void showStarsData(String message) {

    }

    class ViewHolder{
        RelativeLayout weixin1;
        TextView money;
        TextView number;
        TextView time;
    }
    class ViewHolder1{
        TextView money2;
        TextView number2;
        TextView time2;
    }
    class ViewHolder2{
        RelativeLayout pay1;
        TextView money2;
        TextView number2;
        TextView time2;
    }
    class ViewHolder3{
        TextView money3;
        TextView number3;
        TextView time3;
    }*/

}
