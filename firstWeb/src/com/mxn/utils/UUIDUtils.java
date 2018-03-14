package com.mxn.utils;

import java.util.UUID;

/**
 * 生成随机字符串
 * @author Geenk-MXN
 * @create 2018-03-12 17:02
 */

public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
