package com.yvan.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Function：
 *
 * @author YangWang
 * @date 2019-02-25
 * Created by YangWang on 2019-02-25 22:47.
 */
public class DateUtils {
    public static String getTime(){
        Date now = new Date();
        DateFormat format = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss:SSS");
        return format.format(now);
    }
}
