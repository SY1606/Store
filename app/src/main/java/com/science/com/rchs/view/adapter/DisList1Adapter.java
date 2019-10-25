package com.science.com.rchs.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.science.com.rchs.R;
import com.science.com.rchs.data.bean.Bill;
import com.science.com.rchs.data.bean.DisList;
import com.science.com.rchs.data.bean.HList;
import com.science.com.rchs.di.contract.DisListContract;
import com.science.com.rchs.view.activity.OrderDalisActivity;
import com.science.com.rchs.view.activity_set.DisDetalisActivity;
import com.science.com.rchs.view.dalis.DisDetalis1Activity;
import com.science.com.rchs.view.dalis.DisDetalis2Activity;
import com.science.com.rchs.view.dalis.DisDetalis3Activity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DisList1Adapter extends BaseAdapter implements DisListContract.DisListView{

    private Context context;
    private ArrayList<DisList.DataBean.ListBean> list;
    private int YI_ITEM=0;
    private int ER_ITEM=1;
    private int SAN_ITEM=2;

    private String format;
    private String format1;
    private String format3;
    private String format4;
    private String format5;
    private String format6;
    private int coupon_type;

    public DisList1Adapter(Context context, ArrayList<DisList.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
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
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if(list.get(position).getCoupon_type().equals("1")){
            return YI_ITEM;
        }else if(list.get(position).getCoupon_type().equals("3")){
            return ER_ITEM;
        }else {
            return SAN_ITEM;
        }
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        int type = getItemViewType(position);
        if (type == YI_ITEM) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.item02, null);
                viewHolder = new DisList1Adapter.ViewHolder();
                viewHolder.title1 = view.findViewById(R.id.title1);
                viewHolder.shengyu1 = view.findViewById(R.id.shengyu1);
                viewHolder.quan1 = view.findViewById(R.id.quan1);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();



            }

            viewHolder.shengyu1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DisDetalis1Activity.class);
                    intent.putExtra("logo",list.get(position).getLogo_url());
                    intent.putExtra("coupon_id",list.get(position).getCoupon_id()+"");
                    intent.putExtra("title", list.get(position).getTitle());
                    intent.putExtra("shengyu", "剩余" + list.get(position).getNumber() + "" + "张");

                    String key = list.get(position).getBegin_timestamp()+"";
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Long lt = new Long(key);
                    Date date = new Date(lt*1000L);
                    format = formatter.format(date);

                    String keys = list.get(position).getEnd_timestamp()+"";
                    SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                    Long lts = new Long(keys);
                    Date dates = new Date(lts*1000l);
                    format1 = formatters.format(dates);


                    intent.putExtra("times",format);
                    intent.putExtra("times_end",format1);
                    context.startActivity(intent);
                }
            });
            viewHolder.quan1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DisDetalis1Activity.class);
                    intent.putExtra("coupon_id",list.get(position).getCoupon_id()+"");
                    intent.putExtra("title", list.get(position).getTitle());
                    intent.putExtra("shengyu", "剩余" + list.get(position).getNumber() + "" + "张");
                    intent.putExtra("logo",list.get(position).getLogo_url());
                    String key = list.get(position).getBegin_timestamp()+"";
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Long lt = new Long(key);
                    Date date = new Date(lt*1000L);
                    format = formatter.format(date);

                    String keys = list.get(position).getEnd_timestamp()+"";
                    SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                    Long lts = new Long(keys);
                    Date dates = new Date(lts*1000l);
                    format1 = formatters.format(dates);


                    intent.putExtra("times",format);
                    intent.putExtra("times_end",format1);
                    context.startActivity(intent);
                }

            });


            viewHolder.title1.setText(list.get(position).getTitle());
            viewHolder.shengyu1.setText("剩余" + list.get(position).getNumber() + "" + "张");

            return view;
        } else if (type == ER_ITEM) {
            ViewHolder1 viewHolder1;
                if (view == null) {
                    view = View.inflate(context, R.layout.item03, null);
                    viewHolder1 = new ViewHolder1();
                    viewHolder1.title2 = view.findViewById(R.id.title2);
                    viewHolder1.shengyu2 = view.findViewById(R.id.shengyu2);
                    viewHolder1.quan2 = view.findViewById(R.id.quan2);
                    view.setTag(viewHolder1);
                } else {
                    viewHolder1 = (ViewHolder1) view.getTag();
                }

                viewHolder1.shengyu2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, DisDetalis2Activity.class);
                        intent.putExtra("coupon_id",list.get(position).getCoupon_id()+"");
                        intent.putExtra("title", list.get(position).getTitle());
                        intent.putExtra("shengyu", "剩余" + list.get(position).getNumber() + "" + "张");
                        intent.putExtra("log",list.get(position).getLogo_url());
                        String key = list.get(position).getBegin_timestamp()+"";
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Long lt = new Long(key);
                        Date date = new Date(lt*1000L);
                        format3 = formatter.format(date);


                        String keys = list.get(position).getEnd_timestamp()+"";
                        SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                        Long lts = new Long(keys);
                        Date dates = new Date(lts*1000L);
                        format4 = formatters.format(dates);


                        intent.putExtra("times",format3);
                        intent.putExtra("times_end",format4);

                        context.startActivity(intent);
                    }
                });

                viewHolder1.quan2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, DisDetalis2Activity.class);
                        intent.putExtra("coupon_id",list.get(position).getCoupon_id()+"");
                        intent.putExtra("title", list.get(position).getTitle());
                        intent.putExtra("shengyu", "剩余" + list.get(position).getNumber() + "" + "张");
                        intent.putExtra("log",list.get(position).getLogo_url());
                        String key = list.get(position).getBegin_timestamp()+"";
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Long lt = new Long(key);
                        Date date = new Date(lt*1000L);
                        format3 = formatter.format(date);


                        String keys = list.get(position).getEnd_timestamp()+"";
                        SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                        Long lts = new Long(keys);
                        Date dates = new Date(lts*1000L);
                        format4 = formatters.format(dates);


                        intent.putExtra("times",format3);
                        intent.putExtra("times_end",format4);

                        context.startActivity(intent);
                    }
                });



                viewHolder1.title2.setText(list.get(position).getTitle());
                viewHolder1.shengyu2.setText("剩余" + list.get(position).getNumber() + "" + "张");
                return view;
            }else {
                ViewHolder2 viewHolder2;
            if (view == null) {
                view = View.inflate(context, R.layout.item04, null);
                viewHolder2 = new ViewHolder2();
                viewHolder2.title3 = view.findViewById(R.id.title3);
                viewHolder2.shengyu3 = view.findViewById(R.id.shengyu3);
                viewHolder2.quan3 = view.findViewById(R.id.quan3);
                view.setTag(viewHolder2);
            } else {
                viewHolder2 = (ViewHolder2) view.getTag();
            }

            viewHolder2.shengyu3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DisDetalis3Activity.class);
                    intent.putExtra("coupon_id",list.get(position).getCoupon_id()+"");
                    intent.putExtra("title", list.get(position).getTitle());
                    intent.putExtra("shengyu", "剩余" + list.get(position).getNumber() + "" + "张");
                    intent.putExtra("logo",list.get(position).getLogo_url());
                    String key = list.get(position).getBegin_timestamp()+"";
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Long lt = new Long(key);
                    Date date = new Date(lt*1000L);
                    format5 = formatter.format(date);


                    String keys = list.get(position).getEnd_timestamp()+"";
                    SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                    Long lts = new Long(keys);
                    Date dates = new Date(lts*1000L);
                    format6 = formatters.format(dates);


                    intent.putExtra("times",format5);
                    intent.putExtra("times_end",format6);
                    context.startActivity(intent);
                }
            });

            viewHolder2.quan3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DisDetalis3Activity.class);
                    intent.putExtra("coupon_id",list.get(position).getCoupon_id()+"");
                    intent.putExtra("title", list.get(position).getTitle());
                    intent.putExtra("shengyu", "剩余" + list.get(position).getNumber() + "" + "张");
                    intent.putExtra("logo",list.get(position).getLogo_url());
                    String key = list.get(position).getBegin_timestamp()+"";
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Long lt = new Long(key);
                    Date date = new Date(lt*1000L);
                    format5 = formatter.format(date);


                    String keys = list.get(position).getEnd_timestamp()+"";
                    SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
                    Long lts = new Long(keys);
                    Date dates = new Date(lts*1000L);
                    format6 = formatters.format(dates);


                    intent.putExtra("times",format5);
                    intent.putExtra("times_end",format6);
                    context.startActivity(intent);
                }
            });



            viewHolder2.title3.setText(list.get(position).getTitle());
            viewHolder2.shengyu3.setText("剩余" + list.get(position).getNumber() + "" + "张");
            return view;
        }

    }

    @Override
    public void showDisListData(String message) {
        Gson gson = new Gson();
        DisList disList = gson.fromJson(message,DisList.class);
        ArrayList<DisList.DataBean.ListBean> beans = (ArrayList<DisList.DataBean.ListBean>) disList.getData().getList();
        for (int i=0;i<beans.size();i++){
            coupon_type = Integer.parseInt(beans.get(i).getCoupon_type());

        }
    }

    class ViewHolder {
        LinearLayout quan1;
        TextView title1;
        TextView shengyu1;
    }
    class ViewHolder1 {
        LinearLayout quan2;
        TextView title2;
        TextView shengyu2;
    }
    class ViewHolder2 {
        LinearLayout quan3;
        TextView title3;
        TextView shengyu3;
    }
}
