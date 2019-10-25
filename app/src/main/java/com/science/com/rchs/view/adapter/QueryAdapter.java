package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.data.bean.StarRecord;
import com.science.com.rchs.data.bean.Stars;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QueryAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<StarRecord.DataBean> list;
    private String format3;
    private String format4;

    public QueryAdapter(Context context, ArrayList<StarRecord.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    private int YI_ITEM = 0;
    private int ER_ITEM = 1;

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
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return YI_ITEM;
        } else {
            return ER_ITEM;
        }
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        int type = getItemViewType(position);
        if (type == YI_ITEM) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.item_success, null);
                viewHolder = new ViewHolder();
                viewHolder.money = view.findViewById(R.id.money);
                viewHolder.shouxu = view.findViewById(R.id.shouxu);
                viewHolder.daozhang = view.findViewById(R.id.daozhang);
                viewHolder.time = view.findViewById(R.id.time);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            /*String key = list.get(position).getOrd_no() + "";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Long lt = new Long(key);
            Date date = new Date(lt);
            format3 = formatter.format(date);*/

            //viewHolder.money.setText(list.get(position).getTxn_amt() + "");
            viewHolder.shouxu.setText("提现手续费:" + list.get(position).getCorg_fee() + "");
            viewHolder.daozhang.setText("实际到账金额:" + list.get(position).getTransfer_amt() + "");
            viewHolder.time.setText(list.get(position).getOrd_no()+"");
            return view;
        }else {
            ViewHolder1 viewHolder1;
            if (view==null){
                view = View.inflate(context, R.layout.item_fail, null);
                viewHolder1 = new ViewHolder1();
                viewHolder1.money1 = view.findViewById(R.id.money1);
                viewHolder1.shouxu1 = view.findViewById(R.id.shouxu1);
                viewHolder1.daozhang1 = view.findViewById(R.id.daozhang1);
                viewHolder1.time1 = view.findViewById(R.id.time1);
                view.setTag(viewHolder1);
            }else{
                viewHolder1 = (ViewHolder1) view.getTag();
            }
            /*String keys = list.get(position).getOrd_no() + "";
            SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
            Long lts = new Long(keys);
            Date dates = new Date(lts);
            format4 = formatters.format(dates);*/

            //viewHolder1.money1.setText(list.get(position).getTxn_amt() + "");
            viewHolder1.shouxu1.setText("提现手续费:" + list.get(position).getCorg_fee() + "");
            viewHolder1.daozhang1.setText("实际到账金额:" + list.get(position).getTransfer_amt() + "");
            viewHolder1.time1.setText(list.get(position).getOrd_no()+"");
            return view;
        }
    }

    class ViewHolder {
        TextView money;
        TextView shouxu;
        TextView daozhang;
        TextView time;
    }
    class ViewHolder1 {
        TextView money1;
        TextView shouxu1;
        TextView daozhang1;
        TextView time1;
    }
}



