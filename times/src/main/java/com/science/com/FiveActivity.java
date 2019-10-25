package com.science.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.science.com.em.DateChooseWheelViewDialog;
import com.science.com.times.R;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FiveActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mStartDateButton;
    private Button mEndDateButton;
    private Button mDateValidButton;
    private TextView mShowContentTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        mStartDateButton = (Button) this.findViewById(R.id.start_date_btn);
        mEndDateButton = (Button) this.findViewById(R.id.end_date_btn);
        mDateValidButton = (Button) this.findViewById(R.id.date_valid_btn);
        mShowContentTextView = (TextView) this.findViewById(R.id.show_content_tv);

        mStartDateButton.setOnClickListener(this);
        mEndDateButton.setOnClickListener(this);
        mDateValidButton.setOnClickListener(this);
    }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.start_date_btn://开始时间
                    DateChooseWheelViewDialog startDateChooseDialog = new DateChooseWheelViewDialog(FiveActivity.this, new DateChooseWheelViewDialog.DateChooseInterface() {
                        @Override
                        public void getDateTime(String time, boolean longTimeChecked) {
                            mShowContentTextView.setText(time);

                            Log.i("ereara",time);

                            StringToTimestamp(time);
                        }

                        private void StringToTimestamp(String time) {
                            int times = 0;
                            try {
                                times = (int) ((Timestamp.valueOf(time).getTime())/10000);
                                Log.i("etafsdfsd",times+"");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if(times==0){
                                System.out.println("String转10位时间戳失败");
                            }
                        }




                    });

                    startDateChooseDialog.setDateDialogTitle("开始时间");
                    startDateChooseDialog.showDateChooseDialog();
                    break;
                case R.id.end_date_btn://结束时间
                    DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(FiveActivity.this,
                            new DateChooseWheelViewDialog.DateChooseInterface() {
                                @Override
                                public void getDateTime(String time, boolean longTimeChecked) {
                                    mShowContentTextView.setText(time);
                                }
                            });
                    endDateChooseDialog.setTimePickerGone(true);
                    endDateChooseDialog.setDateDialogTitle("结束时间");
                    endDateChooseDialog.showDateChooseDialog();
                    break;
                case R.id.date_valid_btn://身份证有效期
                    DateChooseWheelViewDialog dateValidChooseDialog = new DateChooseWheelViewDialog(FiveActivity.this,
                            new DateChooseWheelViewDialog.DateChooseInterface() {
                                @Override
                                public void getDateTime(String time, boolean longTimeChecked) {
                                    if (longTimeChecked) {
                                        mShowContentTextView.setText("长期  ");
                                    } else {
                                        mShowContentTextView.setText(time);
                                    }
                                }
                            });
                    dateValidChooseDialog.setTimePickerGone(true);
                    dateValidChooseDialog.showLongTerm(true);
                    dateValidChooseDialog.setDateDialogTitle("身份证到期时间");
                    dateValidChooseDialog.showDateChooseDialog();
                    break;
                default:
                    break;
            }


        }
}
