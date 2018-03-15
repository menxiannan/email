package com.mxn.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Geenk-MXN
 * @create 2018-03-14 15:13
 */

public class DateUtils {

    private static final String ONE = "yyyy-MM-dd HH:mm:ss";


    public static String getFormatDate(Date formatDate) {
        if (null != formatDate) {
            SimpleDateFormat sdf = new SimpleDateFormat(ONE);
            return sdf.format(formatDate);
        }
        return null;
    }
}
