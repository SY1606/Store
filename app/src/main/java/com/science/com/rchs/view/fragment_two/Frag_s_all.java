package com.science.com.rchs.view.fragment_two;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;
import com.science.com.rchs.R;
import com.science.com.rchs.di.contract.WinContract;
import com.science.com.rchs.di.presenter.WeiPresenter;
import com.science.com.rchs.view.activity_set.ChooseStActivity;
import com.science.com.rchs.view.adapter.ChooseSrAdapter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class Frag_s_all extends Fragment implements OnDateSetListener, WinContract.WinView {

    @BindView(R.id.start_time)
    Button start_time;
    @BindView(R.id.end_time)
    Button end_time;
    @BindView(R.id.choose)
    TextView choose;
    Unbinder unbinder;
    TimePickerDialog mDialogAll;
    @BindView(R.id.mlogin)
    Button mlogin;
    @BindView(R.id.chooes)
    RelativeLayout chooes;
    @BindView(R.id.all)
    TextView all;

    private TimePickerView pvTime;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int startTime;
    private int endTime;
    private WinContract.WinPresenter winPresenter;
    private String token;

    String type = "1";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_s_all, container, false);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferences sp = getActivity().getSharedPreferences("login", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        winPresenter = new WeiPresenter();
        winPresenter.attachView(this);


        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        mDialogAll = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("Cancel")
                .setSureStringId("Sure")
                .setTitleStringId("TimePicker")
                .setYearText("Year")
                .setMonthText("Month")
                .setDayText("Day")
                .setHourText("Hour")
                .setMinuteText("Minute")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis())
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();

        initTimePicker();
        return view;

    }


    @Override
    public void onDateSet(TimePickerDialog timePickerDialog, long millseconds) {
        String text = getDateToString(millseconds);
        end_time.setText(text);

        StringToTimestamp(text);
    }

    private void StringToTimestamp(String text) {
        endTime = 0;
        try {
            endTime = (int) ((Timestamp.valueOf(text).getTime()) / 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (endTime == 0) {
            System.out.println("String转10位时间戳失败");
        }
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.start_time, R.id.end_time, R.id.choose, R.id.mlogin, R.id.chooes})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.chooes:
                Intent intent1 = new Intent(getActivity(), ChooseStActivity.class);
                startActivity(intent1);
                getActivity().finish();
                break;

            case R.id.mlogin:
                if (startTime > endTime) {
                    Toast.makeText(getActivity(), "开始时间不能大于结束时间", Toast.LENGTH_SHORT).show();
                } else if (startTime == endTime) {
                    Toast.makeText(getActivity(), "开始时间不能等于结束时间", Toast.LENGTH_SHORT).show();
                } else {
                    winPresenter.requestWinData(token, type, startTime, endTime);
                    getActivity().finish();
                }
                break;
            case R.id.start_time:

                pvTime.show(view);

                break;
            case R.id.end_time:
                mDialogAll.show(getActivity().getSupportFragmentManager(), "all");
                break;
            case R.id.choose:
                Intent intent = new Intent(getActivity(), ChooseSrAdapter.class);
                startActivity(intent);
                break;
        }
    }

    private void initTimePicker() {
        pvTime = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {

                start_time.setText(getTime(date));

                StringToTimestamps(getTime(date));
            }


            private String getTime(Date date) {

                Log.d("getTime()", "choice date millis: " + date.getTime());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                return format.format(date);

            }

        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {

                    }
                })
                .setType(new boolean[]{true, true, true, true, true, true})
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .addOnCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                })
                .build();

        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
                dialogWindow.setDimAmount(0.1f);
            }
        }

        SharedPreferences sps = getActivity().getSharedPreferences("ids", Context.MODE_PRIVATE);
        String name = sps.getString("names", "");

        if (all.equals("")) {
            all.equals("afadfsdf");
        } else {
            all.setText(name);
        }
    }

    private void StringToTimestamps(String time) {
        startTime = 0;
        try {
            startTime = (int) ((Timestamp.valueOf(time).getTime()) / 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (startTime == 0) {
            System.out.println("String转10位时间戳失败");
        }
    }

    @Override
    public void showWinData(String message) {

    }
}
