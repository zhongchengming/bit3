package com.ylzInfo.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * todo
 * <p>
 * @Author LeifChen
 * @Date 2020-07-01
 */
public class CommUtil {
    public static String dateToString(Date createdTime){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String dateString = formatter.format(createdTime);
        return dateString;
    }
    public static boolean isNumber(String o){
        return  (Pattern.compile("[0-9]*")).matcher(String.valueOf(o)).matches();
    }
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
