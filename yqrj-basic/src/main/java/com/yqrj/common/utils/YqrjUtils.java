package com.yqrj.common.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.util.StrUtil;

public class YqrjUtils {
    public final static String FORMAT1 = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT2 = "yyyy-MM-dd";
    public final static String FORMAT3 = "yyyyMMddHHmmss";
    public final static String FORMAT4 = "yyyyMMdd";
    public final static String FORMAT5 = "yyyy/MM/dd";

    /*
     * 获取单据号
     */
    public synchronized static String getOnlyKey() {
        String result = "";
        try {
            Long time = System.currentTimeMillis();
            result = time + "";// String.valueOf(time).substring(3);
            Thread.sleep(1);
        } catch (Exception e) {

        }
        return result;
    }

    /**
     * 生产合同编号
     * @param code
     * @param maxCount
     * @return
     */
    public static String contracttCode(String code, Integer maxCount) {
        if (maxCount == null || maxCount < 0) {
            maxCount = 0;
        }
        // 20190702B0001999999
        SimpleDateFormat format = new SimpleDateFormat(FORMAT4);
        String str = format.format(new Date());
        maxCount = maxCount + 1;
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(6);
        //设置最小整数位数
        nf.setMinimumIntegerDigits(6);

        String countStr = str + code + nf.format(maxCount);
        System.out.println("合同编号: " + countStr);
        return countStr;
    }

    /**
     * 转成 yyyy-MM-dd HH:mm:ss
     * 
     * @param day
     * @return
     */
    private synchronized static String iFormatDate(Date day, String format) {
        if (day == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(day);
    }

    public static String formatDate(Date day, String format) {
        return iFormatDate(day, format);
    }

    public static String formatDate(Date day) {
        return iFormatDate(day, FORMAT1);
    }

    public static String errorString(Throwable ex) {
        StringBuilder sb = new StringBuilder();
        sb.append(ex.toString());
        for (StackTraceElement e : ex.getStackTrace()) {
            sb.append(e.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * 填充字符
     * 
     * @param src     原字符串
     * @param chars   填充字符
     * @param len     填充后的总长度
     * @param isRight 是否右填充，false 左填充 true右填充
     * @return
     */
    public static String fillChar(String src, String chars, int len, boolean isRight) {
        String result = "";
        if (src.length() >= len) {
            return src;
        } else {
            StringBuilder stringBuilder = new StringBuilder("");
            for (int i = 0; i < len - src.length(); i++) {
                stringBuilder.append(chars);
            }
            if (isRight) {
                result = src + stringBuilder.toString();
            } else {
                result = stringBuilder.append(src).toString();
            }
        }

        return result;
    }

    public static String defaultFillChar(String src) {
        if (src == null) {
            src = "1";
        }
        return fillChar(src, "0", 6, false);
    }

    /**
     * 将元数据前补零，补后的总长度为指定的长度，以字符串的形式返回 @param sourceDate @param formatLength @return
     * 重组后的数据
     */
    public static String frontCompWithZore(int sourceDate, int formatLength) {
        /*
         * 0 指前面补充零 formatLength 字符总长度为 formatLength d 代表为正数。
         */
        String newString = String.format("%0" + formatLength + "d", sourceDate);
        return newString;
    }

    /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    public static void main(String[] args) {
        System.out.println(getWeekOfDate(new Date()));
    }

    /**
     * 判断字符串是否可以转化为json对象
     * @param content
     * @return
     */
    public static JSONObject getJsonObject(String content) {
        //TODO 此处应该注意，不要使用StringUtils.isEmpty(),因为当content为"  "空格字符串时，JSONObject.parseObject可以解析成功，
        if (StrUtil.isBlank(content))
            return null;
        try {
            JSONObject jsonStr = JSONObject.parseObject(content);
            return jsonStr;
        } catch (Exception e) {
            return null;
        }
    }
}
