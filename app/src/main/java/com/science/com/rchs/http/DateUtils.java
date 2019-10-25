package com.science.com.rchs.http;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /*获取系统时间 格式为："yyyy/MM/dd "*/

     SimpleDateFormat sss = null;

    public static String getCurrentDate() {
        Date d = new Date();
        SimpleDateFormat  sss = new SimpleDateFormat("yyyy年MM月dd日");
        return sss.format(d);
    }

    /*时间戳转换成字符窜*/
    public static String getDateToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat  sss = new SimpleDateFormat("yyyy年MM月dd日");
        return sss.format(d);
    }

    /*将字符串转为时间戳*/
    public static long getStringToDate(String time) {
        SimpleDateFormat  sss = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();
        try{
            date = sss.parse(time);
        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
}
