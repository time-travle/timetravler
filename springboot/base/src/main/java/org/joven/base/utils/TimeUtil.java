/**
 * Project Name: blog project
 * File Name: TimeUtil
 * Package Name: org.joven.base.common
 * Date: 2019/11/8 22:41
 * Copyright (c) 2019,All Rights Reserved.
 */
package org.joven.base.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * CreateBy Administrator
 * Date: 2019/11/8 22:41
 * Version:
 * Remark:
 */
public class TimeUtil {
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private final static long minute = 60 * 1000;// 1分钟
    private final static long hour = 60 * minute;// 1小时
    private final static long day = 24 * hour;// 1天
    private final static long month = 31 * day;// 月
    private final static long year = 12 * month;// 年

    private TimeUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * @param @return 设定文件
     * @return Long 返回类型
     * @throws @Title: getCurrentSystemTime
     * @Description: 获取当前系统时间
     */
    public static Long getCurrentSystemTime() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * 取出当前的日期格式yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentTimeStr() {
        Calendar curCalendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(curCalendar.getTime());
    }

    /**
     * 将时间戳转成格式化时间
     *
     * @param milliseconds
     */
    public static String getFormatTime(long milliseconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(new Date(milliseconds));
    }

    /**
     * 将时间戳转成格式化时间
     *
     * @param milliseconds
     */
    public static String getFormatTimeYY(long milliseconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date(milliseconds));
    }

    /**
     * 返回文字描述的日期
     *
     * @param date
     * @return
     */
    public static String getTimeFormatText(long date) {
        if (date == 0) {
            return "";
        }
        date = date * 1000;
        long diff = new Date().getTime() - date;
        long r = 0;
        if (diff > year) {
            r = (diff / year);
            return r + "年前";
        }
        if (diff > month) {
            r = (diff / month);
            return r + "月前";
        }
        if (diff > day) {
            r = (diff / day);
            return r + "天前";
        }
        if (diff > hour) {
            r = (diff / hour);
            return r + "小时前";
        }
        if (diff > minute) {
            r = (diff / minute);
            return r + "分钟前";
        }
        return "刚刚";
    }

    /**
     * 将时间戳转成格式化时间
     *
     * @param milliseconds
     */
    public static String getFormatTimeHHMM(long milliseconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        return sdf.format(new Date(milliseconds));
    }

    /**
     * 将时间戳转成格式化时间
     *
     * @param milliseconds
     */
    public static String getFormatTime24(long milliseconds) {
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm");
        return sdf.format(new Date(milliseconds));
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 字符串的日期格式的计算
     */
    public static int daysBetween(String smdate, String bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 截取Date(1418784200000-0000)的固定长度
     */
    public static String spliteTime(String dateStr) {
        String sequence = dateStr.replace("/Date(", "");
        return sequence.substring(0, 13).trim();
    }

    /**
     * 获取分秒格式化字符串
     *
     * @param duration
     * @return
     */
    public static String getFormatMiniteSecString(int duration) {
        int minutes = duration % (60 * 60) / 60;// 分钟时长
        int seconds = duration % 60;// 秒时长
        return String.format("%d'%d''", minutes, seconds);
    }

    /**
     * 格式化时间字符串
     * <p/>
     * 显示规则大于1天,显示天. 大于1小时,显示1=小时. 大于1分钟, 显示分钟 其中,大于7天以上的均显示7天前
     *
     * @param time
     * @return
     */
    public static String getFormatTimeString(long time) {

        Long currentTime = new Date().getTime() / 1000;// 获得当前时间
        Long diffTime = currentTime - time;// 当前时间减去创建时间,得到时间差
        long diffDay = diffTime / (24 * 3600); // 得到天数
        long diffHour = diffTime % (24 * 3600) / 3600; // 得到小时数
        long diffMinute = diffTime % 3600 / 60; // 得到分钟数

        String result = null;

        if (diffDay >= 1) {
            if (diffDay >= 7) {
                result = "7天前";
            } else {
                result = diffDay + "天前";
            }
        } else if (diffHour >= 1) {
            result = diffHour + "小时前";
        } else if (diffMinute >= 1) {
            result = diffMinute + "分钟前";
        } else {
            result = "";
        }
        return result;
    }

    /**
     * 将时间戳转为时间字符串
     * <p>
     * 格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param millis 毫秒时间戳
     * @return 时间字符串
     */
    public static String millis2String(long millis) {
        return new SimpleDateFormat(DEFAULT_PATTERN, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * 将时间戳转为时间字符串
     * <p>
     * 格式为pattern
     * </p>
     *
     * @param millis  毫秒时间戳
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String millis2String(long millis, String pattern) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(millis));
    }

    /**
     * 将时间字符串转为时间戳
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return 毫秒时间戳
     */
    public static long string2Millis(String time) {
        return string2Millis(time, DEFAULT_PATTERN);
    }

    /**
     * 将时间字符串转为时间戳
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 毫秒时间戳
     */
    public static long string2Millis(String time, String pattern) {
        try {
            return new SimpleDateFormat(pattern, Locale.getDefault()).parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 将时间字符串转为Date类型
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return Date类型
     */
    public static Date string2Date(String time) {
        return string2Date(time, DEFAULT_PATTERN);
    }

    /**
     * 将时间字符串转为Date类型
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return Date类型
     */
    public static Date string2Date(String time, String pattern) {
        return new Date(string2Millis(time, pattern));
    }

    /**
     * 将Date类型转为时间字符串
     * <p>
     * 格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param date Date类型时间
     * @return 时间字符串
     */
    public static String date2String(Date date) {
        return date2String(date, DEFAULT_PATTERN);
    }

    /**
     * 将Date类型转为时间字符串
     * <p>
     * 格式为pattern
     * </p>
     *
     * @param date    Date类型时间
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String date2String(Date date, String pattern) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
    }

    /**
     * 将Date类型转为时间戳
     *
     * @param date Date类型时间
     * @return 毫秒时间戳
     */
    public static long date2Millis(Date date) {
        return date.getTime();
    }

    /**
     * 将时间戳转为Date类型
     *
     * @param millis 毫秒时间戳
     * @return Date类型时间
     */
    public static Date millis2Date(long millis) {
        return new Date(millis);
    }

    /**
     * 获取两个时间差（单位：unit）
     * <p>
     * time0和time1格式都为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time0 时间字符串0
     * @param time1 时间字符串1
     * @param unit  单位类型
     *              <ul>
     *              <li>{@link ConstUtils.TimeUnit#MSEC}: 毫秒</li>
     *              <li>{@link ConstUtils.TimeUnit#SEC }: 秒</li>
     *              <li>{@link ConstUtils.TimeUnit#MIN }: 分</li>
     *              <li>{@link ConstUtils.TimeUnit#HOUR}: 小时</li>
     *              <li>{@link ConstUtils.TimeUnit#DAY }: 天</li>
     *              </ul>
     * @return unit时间戳
     */
    public static long getTimeSpan(String time0, String time1, ConstUtils.TimeUnit unit) {
        return getTimeSpan(time0, time1, unit, DEFAULT_PATTERN);
    }

    /**
     * 获取两个时间差（单位：unit）
     * <p>
     * time0和time1格式都为format
     * </p>
     *
     * @param time0   时间字符串0
     * @param time1   时间字符串1
     * @param unit    单位类型
     *                <ul>
     *                <li>{@link ConstUtils.TimeUnit#MSEC}: 毫秒</li>
     *                <li>{@link ConstUtils.TimeUnit#SEC }: 秒</li>
     *                <li>{@link ConstUtils.TimeUnit#MIN }: 分</li>
     *                <li>{@link ConstUtils.TimeUnit#HOUR}: 小时</li>
     *                <li>{@link ConstUtils.TimeUnit#DAY }: 天</li>
     *                </ul>
     * @param pattern 时间格式
     * @return unit时间戳
     */
    public static long getTimeSpan(String time0, String time1, ConstUtils.TimeUnit unit, String pattern) {
        return ConvertUtils.millis2TimeSpan(Math.abs(string2Millis(time0, pattern) - string2Millis(time1, pattern)),
                unit);
    }

    /**
     * 获取两个时间差（单位：unit）
     *
     * @param date0 Date类型时间0
     * @param date1 Date类型时间1
     * @param unit  单位类型
     *              <ul>
     *              <li>{@link ConstUtils.TimeUnit#MSEC}: 毫秒</li>
     *              <li>{@link ConstUtils.TimeUnit#SEC }: 秒</li>
     *              <li>{@link ConstUtils.TimeUnit#MIN }: 分</li>
     *              <li>{@link ConstUtils.TimeUnit#HOUR}: 小时</li>
     *              <li>{@link ConstUtils.TimeUnit#DAY }: 天</li>
     *              </ul>
     * @return unit时间戳
     */
    public static long getTimeSpan(Date date0, Date date1, ConstUtils.TimeUnit unit) {
        return ConvertUtils.millis2TimeSpan(Math.abs(date2Millis(date0) - date2Millis(date1)), unit);
    }

    /**
     * 获取两个时间差（单位：unit）
     *
     * @param millis0 毫秒时间戳0
     * @param millis1 毫秒时间戳1
     * @param unit    单位类型
     *                <ul>
     *                <li>{@link ConstUtils.TimeUnit#MSEC}: 毫秒</li>
     *                <li>{@link ConstUtils.TimeUnit#SEC }: 秒</li>
     *                <li>{@link ConstUtils.TimeUnit#MIN }: 分</li>
     *                <li>{@link ConstUtils.TimeUnit#HOUR}: 小时</li>
     *                <li>{@link ConstUtils.TimeUnit#DAY }: 天</li>
     *                </ul>
     * @return unit时间戳
     */
    public static long getTimeSpan(long millis0, long millis1, ConstUtils.TimeUnit unit) {
        return ConvertUtils.millis2TimeSpan(Math.abs(millis0 - millis1), unit);
    }

    /**
     * 获取合适型两个时间差
     * <p>
     * time0和time1格式都为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time0     时间字符串0
     * @param time1     时间字符串1
     * @param precision 精度
     *                  <p>
     *                  precision = 0，返回null
     *                  </p>
     *                  <p>
     *                  precision = 1，返回天
     *                  </p>
     *                  <p>
     *                  precision = 2，返回天和小时
     *                  </p>
     *                  <p>
     *                  precision = 3，返回天、小时和分钟
     *                  </p>
     *                  <p>
     *                  precision = 4，返回天、小时、分钟和秒
     *                  </p>
     *                  <p>
     *                  precision >= 5，返回天、小时、分钟、秒和毫秒
     *                  </p>
     * @return 合适型两个时间差
     */
    public static String getFitTimeSpan(String time0, String time1, int precision) {
        return ConvertUtils.millis2FitTimeSpan(
                Math.abs(string2Millis(time0, DEFAULT_PATTERN) - string2Millis(time1, DEFAULT_PATTERN)), precision);
    }

    /**
     * 获取合适型两个时间差
     * <p>
     * time0和time1格式都为pattern
     * </p>
     *
     * @param time0     时间字符串0
     * @param time1     时间字符串1
     * @param precision 精度
     *                  <p>
     *                  precision = 0，返回null
     *                  </p>
     *                  <p>
     *                  precision = 1，返回天
     *                  </p>
     *                  <p>
     *                  precision = 2，返回天和小时
     *                  </p>
     *                  <p>
     *                  precision = 3，返回天、小时和分钟
     *                  </p>
     *                  <p>
     *                  precision = 4，返回天、小时、分钟和秒
     *                  </p>
     *                  <p>
     *                  precision >= 5，返回天、小时、分钟、秒和毫秒
     *                  </p>
     * @param pattern   时间格式
     * @return 合适型两个时间差
     */
    public static String getFitTimeSpan(String time0, String time1, int precision, String pattern) {
        return ConvertUtils.millis2FitTimeSpan(Math.abs(string2Millis(time0, pattern) - string2Millis(time1, pattern)),
                precision);
    }

    /**
     * 获取合适型两个时间差
     *
     * @param date0     Date类型时间0
     * @param date1     Date类型时间1
     * @param precision 精度
     *                  <p>
     *                  precision = 0，返回null
     *                  </p>
     *                  <p>
     *                  precision = 1，返回天
     *                  </p>
     *                  <p>
     *                  precision = 2，返回天和小时
     *                  </p>
     *                  <p>
     *                  precision = 3，返回天、小时和分钟
     *                  </p>
     *                  <p>
     *                  precision = 4，返回天、小时、分钟和秒
     *                  </p>
     *                  <p>
     *                  precision >= 5，返回天、小时、分钟、秒和毫秒
     *                  </p>
     * @return 合适型两个时间差
     */
    public static String getFitTimeSpan(Date date0, Date date1, int precision) {
        return ConvertUtils.millis2FitTimeSpan(Math.abs(date2Millis(date0) - date2Millis(date1)), precision);
    }

    /**
     * 获取合适型两个时间差
     *
     * @param millis0   毫秒时间戳1
     * @param millis1   毫秒时间戳2
     * @param precision 精度
     *                  <p>
     *                  precision = 0，返回null
     *                  </p>
     *                  <p>
     *                  precision = 1，返回天
     *                  </p>
     *                  <p>
     *                  precision = 2，返回天和小时
     *                  </p>
     *                  <p>
     *                  precision = 3，返回天、小时和分钟
     *                  </p>
     *                  <p>
     *                  precision = 4，返回天、小时、分钟和秒
     *                  </p>
     *                  <p>
     *                  precision >= 5，返回天、小时、分钟、秒和毫秒
     *                  </p>
     * @return 合适型两个时间差
     */
    public static String getFitTimeSpan(long millis0, long millis1, int precision) {
        return ConvertUtils.millis2FitTimeSpan(Math.abs(millis0 - millis1), precision);
    }

    /**
     * 获取当前毫秒时间戳
     *
     * @return 毫秒时间戳
     */
    public static long getNowTimeMills() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前时间字符串
     * <p>
     * 格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @return 时间字符串
     */
    public static String getNowTimeString() {
        return millis2String(System.currentTimeMillis(), DEFAULT_PATTERN);
    }

    /**
     * 获取当前时间字符串
     * <p>
     * 格式为pattern
     * </p>
     *
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String getNowTimeString(String pattern) {
        return millis2String(System.currentTimeMillis(), pattern);
    }

    /**
     * 获取当前Date
     *
     * @return Date类型时间
     */
    public static Date getNowTimeDate() {
        return new Date();
    }

    /**
     * 获取与当前时间的差（单位：unit）
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @param unit 单位类型
     *             <ul>
     *             <li>{@link ConstUtils.TimeUnit#MSEC}:毫秒</li>
     *             <li>{@link ConstUtils.TimeUnit#SEC }:秒</li>
     *             <li>{@link ConstUtils.TimeUnit#MIN }:分</li>
     *             <li>{@link ConstUtils.TimeUnit#HOUR}:小时</li>
     *             <li>{@link ConstUtils.TimeUnit#DAY }:天</li>
     *             </ul>
     * @return unit时间戳
     */
    public static long getTimeSpanByNow(String time, ConstUtils.TimeUnit unit) {
        return getTimeSpan(getNowTimeString(), time, unit, DEFAULT_PATTERN);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param unit    单位类型
     *                <ul>
     *                <li>{@link ConstUtils.TimeUnit#MSEC}: 毫秒</li>
     *                <li>{@link ConstUtils.TimeUnit#SEC }: 秒</li>
     *                <li>{@link ConstUtils.TimeUnit#MIN }: 分</li>
     *                <li>{@link ConstUtils.TimeUnit#HOUR}: 小时</li>
     *                <li>{@link ConstUtils.TimeUnit#DAY }: 天</li>
     *                </ul>
     * @param pattern 时间格式
     * @return unit时间戳
     */
    public static long getTimeSpanByNow(String time, ConstUtils.TimeUnit unit, String pattern) {
        return getTimeSpan(getNowTimeString(), time, unit, pattern);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     *
     * @param date Date类型时间
     * @param unit 单位类型
     *             <ul>
     *             <li>{@link ConstUtils.TimeUnit#MSEC}: 毫秒</li>
     *             <li>{@link ConstUtils.TimeUnit#SEC }: 秒</li>
     *             <li>{@link ConstUtils.TimeUnit#MIN }: 分</li>
     *             <li>{@link ConstUtils.TimeUnit#HOUR}: 小时</li>
     *             <li>{@link ConstUtils.TimeUnit#DAY }: 天</li>
     *             </ul>
     * @return unit时间戳
     */
    public static long getTimeSpanByNow(Date date, ConstUtils.TimeUnit unit) {
        return getTimeSpan(new Date(), date, unit);
    }

    /**
     * 获取与当前时间的差（单位：unit）
     *
     * @param millis 毫秒时间戳
     * @param unit   单位类型
     *               <ul>
     *               <li>{@link ConstUtils.TimeUnit#MSEC}: 毫秒</li>
     *               <li>{@link ConstUtils.TimeUnit#SEC }: 秒</li>
     *               <li>{@link ConstUtils.TimeUnit#MIN }: 分</li>
     *               <li>{@link ConstUtils.TimeUnit#HOUR}: 小时</li>
     *               <li>{@link ConstUtils.TimeUnit#DAY }: 天</li>
     *               </ul>
     * @return unit时间戳
     */
    public static long getTimeSpanByNow(long millis, ConstUtils.TimeUnit unit) {
        return getTimeSpan(System.currentTimeMillis(), millis, unit);
    }

    /**
     * 获取合适型与当前时间的差
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time      时间字符串
     * @param precision 精度
     *                  <p>
     *                  precision = 0，返回null
     *                  </p>
     *                  <p>
     *                  precision = 1，返回天
     *                  </p>
     *                  <p>
     *                  precision = 2，返回天和小时
     *                  </p>
     *                  <p>
     *                  precision = 3，返回天、小时和分钟
     *                  </p>
     *                  <p>
     *                  precision = 4，返回天、小时、分钟和秒
     *                  </p>
     *                  <p>
     *                  precision >= 5，返回天、小时、分钟、秒和毫秒
     *                  </p>
     * @return 合适型与当前时间的差
     */
    public static String getFitTimeSpanByNow(String time, int precision) {
        return getFitTimeSpan(getNowTimeString(), time, precision, DEFAULT_PATTERN);
    }

    /**
     * 获取合适型与当前时间的差
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time      时间字符串
     * @param precision 精度
     *                  <p>
     *                  precision = 0，返回null
     *                  </p>
     *                  <p>
     *                  precision = 1，返回天
     *                  </p>
     *                  <p>
     *                  precision = 2，返回天和小时
     *                  </p>
     *                  <p>
     *                  precision = 3，返回天、小时和分钟
     *                  </p>
     *                  <p>
     *                  precision = 4，返回天、小时、分钟和秒
     *                  </p>
     *                  <p>
     *                  precision >= 5，返回天、小时、分钟、秒和毫秒
     *                  </p>
     * @param pattern   时间格式
     * @return 合适型与当前时间的差
     */
    public static String getFitTimeSpanByNow(String time, int precision, String pattern) {
        return getFitTimeSpan(getNowTimeString(), time, precision, pattern);
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param date      Date类型时间
     * @param precision 精度
     *                  <p>
     *                  precision = 0，返回null
     *                  </p>
     *                  <p>
     *                  precision = 1，返回天
     *                  </p>
     *                  <p>
     *                  precision = 2，返回天和小时
     *                  </p>
     *                  <p>
     *                  precision = 3，返回天、小时和分钟
     *                  </p>
     *                  <p>
     *                  precision = 4，返回天、小时、分钟和秒
     *                  </p>
     *                  <p>
     *                  precision >= 5，返回天、小时、分钟、秒和毫秒
     *                  </p>
     * @return 合适型与当前时间的差
     */
    public static String getFitTimeSpanByNow(Date date, int precision) {
        return getFitTimeSpan(getNowTimeDate(), date, precision);
    }

    /**
     * 获取合适型与当前时间的差
     *
     * @param millis    毫秒时间戳
     * @param precision 精度
     *                  <p>
     *                  precision = 0，返回null
     *                  </p>
     *                  <p>
     *                  precision = 1，返回天
     *                  </p>
     *                  <p>
     *                  precision = 2，返回天和小时
     *                  </p>
     *                  <p>
     *                  precision = 3，返回天、小时和分钟
     *                  </p>
     *                  <p>
     *                  precision = 4，返回天、小时、分钟和秒
     *                  </p>
     *                  <p>
     *                  precision >= 5，返回天、小时、分钟、秒和毫秒
     *                  </p>
     * @return 合适型与当前时间的差
     */
    public static String getFitTimeSpanByNow(long millis, int precision) {
        return getFitTimeSpan(System.currentTimeMillis(), millis, precision);
    }

    /**
     * 获取友好型与当前时间的差
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return 友好型与当前时间的差
     * <ul>
     * <li>如果小于1秒钟内，显示刚刚</li>
     * <li>如果在1分钟内，显示XXX秒前</li>
     * <li>如果在1小时内，显示XXX分钟前</li>
     * <li>如果在1小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(String time) {
        return getFriendlyTimeSpanByNow(time, DEFAULT_PATTERN);
    }

    /**
     * 获取友好型与当前时间的差
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 友好型与当前时间的差
     * <ul>
     * <li>如果小于1秒钟内，显示刚刚</li>
     * <li>如果在1分钟内，显示XXX秒前</li>
     * <li>如果在1小时内，显示XXX分钟前</li>
     * <li>如果在1小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(String time, String pattern) {
        return getFriendlyTimeSpanByNow(string2Millis(time, pattern));
    }

    /**
     * 获取友好型与当前时间的差
     *
     * @param date Date类型时间
     * @return 友好型与当前时间的差
     * <ul>
     * <li>如果小于1秒钟内，显示刚刚</li>
     * <li>如果在1分钟内，显示XXX秒前</li>
     * <li>如果在1小时内，显示XXX分钟前</li>
     * <li>如果在1小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(Date date) {
        return getFriendlyTimeSpanByNow(date.getTime());
    }

    /**
     * 获取友好型与当前时间的差
     *
     * @param millis 毫秒时间戳
     * @return 友好型与当前时间的差
     * <ul>
     * <li>如果小于1秒钟内，显示刚刚</li>
     * <li>如果在1分钟内，显示XXX秒前</li>
     * <li>如果在1小时内，显示XXX分钟前</li>
     * <li>如果在1小时外的今天内，显示今天15:32</li>
     * <li>如果是昨天的，显示昨天15:32</li>
     * <li>其余显示，2016-10-15</li>
     * <li>时间不合法的情况全部日期和时间信息，如星期六 十月 27 14:21:20 CST 2007</li>
     * </ul>
     */
    public static String getFriendlyTimeSpanByNow(long millis) {
        long now = System.currentTimeMillis();
        long span = now - millis;
        if (span < 0)
            return String.format("%tc", millis);// U can read http://www.apihome.cn/api/java/Formatter.html to
        // understand it.
        if (span < 1000) {
            return "刚刚";
        } else if (span < ConstUtils.MIN) {
            return String.format("%d秒前", span / ConstUtils.SEC);
        } else if (span < ConstUtils.HOUR) {
            return String.format("%d分钟前", span / ConstUtils.MIN);
        }
        // 获取当天00:00
        long wee = (now / ConstUtils.DAY) * ConstUtils.DAY;
        if (millis >= wee) {
            return String.format("今天%tR", millis);
        } else if (millis >= wee - ConstUtils.DAY) {
            return String.format("昨天%tR", millis);
        } else {
            return String.format("%tF", millis);
        }
    }

    /**
     * 判断是否同一天
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return {@code true}: 是<br>
     * {@code false}: 否
     */
    public static boolean isSameDay(String time) {
        return isSameDay(string2Millis(time, DEFAULT_PATTERN));
    }

    /**
     * 判断是否同一天
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return {@code true}: 是<br>
     * {@code false}: 否
     */
    public static boolean isSameDay(String time, String pattern) {
        return isSameDay(string2Millis(time, pattern));
    }

    /**
     * 判断是否同一天
     *
     * @param date Date类型时间
     * @return {@code true}: 是<br>
     * {@code false}: 否
     */
    public static boolean isSameDay(Date date) {
        return isSameDay(date.getTime());
    }

    /**
     * 判断是否同一天
     *
     * @param millis 毫秒时间戳
     * @return {@code true}: 是<br>
     * {@code false}: 否
     */
    public static boolean isSameDay(long millis) {
        long wee = (System.currentTimeMillis() / ConstUtils.DAY) * ConstUtils.DAY;
        return millis >= wee && millis < wee + ConstUtils.DAY;
    }

    /**
     * 判断是否闰年
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return {@code true}: 闰年<br>
     * {@code false}: 平年
     */
    public static boolean isLeapYear(String time) {
        return isLeapYear(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 判断是否闰年
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return {@code true}: 闰年<br>
     * {@code false}: 平年
     */
    public static boolean isLeapYear(String time, String pattern) {
        return isLeapYear(string2Date(time, pattern));
    }

    /**
     * 判断是否闰年
     *
     * @param date Date类型时间
     * @return {@code true}: 闰年<br>
     * {@code false}: 平年
     */
    public static boolean isLeapYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        return isLeapYear(year);
    }

    /**
     * 判断是否闰年
     *
     * @param millis 毫秒时间戳
     * @return {@code true}: 闰年<br>
     * {@code false}: 平年
     */
    public static boolean isLeapYear(long millis) {
        return isLeapYear(millis2Date(millis));
    }

    /**
     * 判断是否闰年
     *
     * @param year 年份
     * @return {@code true}: 闰年<br>
     * {@code false}: 平年
     */
    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 获取星期
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return 星期
     */
    public static String getWeek(String time) {
        return getWeek(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 获取星期
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 星期
     */
    public static String getWeek(String time, String pattern) {
        return getWeek(string2Date(time, pattern));
    }

    /**
     * 获取星期
     *
     * @param date Date类型时间
     * @return 星期
     */
    public static String getWeek(Date date) {
        return new SimpleDateFormat("EEEE", Locale.getDefault()).format(date);
    }

    /**
     * 获取星期
     *
     * @param millis 毫秒时间戳
     * @return 星期
     */
    public static String getWeek(long millis) {
        return getWeek(new Date(millis));
    }

    /**
     * 获取星期
     * <p>
     * 注意：周日的Index才是1，周六为7
     * </p>
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return 1...5
     */
    public static int getWeekIndex(String time) {
        return getWeekIndex(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 获取星期
     * <p>
     * 注意：周日的Index才是1，周六为7
     * </p>
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 1...7
     */
    public static int getWeekIndex(String time, String pattern) {
        return getWeekIndex(string2Date(time, pattern));
    }

    /**
     * 获取星期
     * <p>
     * 注意：周日的Index才是1，周六为7
     * </p>
     *
     * @param date Date类型时间
     * @return 1...7
     */
    public static int getWeekIndex(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * 获取星期
     * <p>
     * 注意：周日的Index才是1，周六为7
     * </p>
     *
     * @param millis 毫秒时间戳
     * @return 1...7
     */
    public static int getWeekIndex(long millis) {
        return getWeekIndex(millis2Date(millis));
    }

    /**
     * 获取月份中的第几周
     * <p>
     * 注意：国外周日才是新的一周的开始
     * </p>
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return 1...5
     */
    public static int getWeekOfMonth(String time) {
        return getWeekOfMonth(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 获取月份中的第几周
     * <p>
     * 注意：国外周日才是新的一周的开始
     * </p>
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 1...5
     */
    public static int getWeekOfMonth(String time, String pattern) {
        return getWeekOfMonth(string2Date(time, pattern));
    }

    /**
     * 获取月份中的第几周
     * <p>
     * 注意：国外周日才是新的一周的开始
     * </p>
     *
     * @param date Date类型时间
     * @return 1...5
     */
    public static int getWeekOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 获取月份中的第几周
     * <p>
     * 注意：国外周日才是新的一周的开始
     * </p>
     *
     * @param millis 毫秒时间戳
     * @return 1...5
     */
    public static int getWeekOfMonth(long millis) {
        return getWeekOfMonth(millis2Date(millis));
    }

    /**
     * 获取年份中的第几周
     * <p>
     * 注意：国外周日才是新的一周的开始
     * </p>
     * <p>
     * time格式为yyyy-MM-dd HH:mm:ss
     * </p>
     *
     * @param time 时间字符串
     * @return 1...54
     */
    public static int getWeekOfYear(String time) {
        return getWeekOfYear(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 获取年份中的第几周
     * <p>
     * 注意：国外周日才是新的一周的开始
     * </p>
     * <p>
     * time格式为pattern
     * </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 1...54
     */
    public static int getWeekOfYear(String time, String pattern) {
        return getWeekOfYear(string2Date(time, pattern));
    }

    /**
     * 获取年份中的第几周
     * <p>
     * 注意：国外周日才是新的一周的开始
     * </p>
     *
     * @param date Date类型时间
     * @return 1...54
     */
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * 获取年份中的第几周
     * <p>
     * 注意：国外周日才是新的一周的开始
     * </p>
     *
     * @param millis 毫秒时间戳
     * @return 1...54
     */
    public static int getWeekOfYear(long millis) {
        return getWeekOfYear(millis2Date(millis));
    }

    private static final String[] CHINESE_ZODIAC = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};

    /**
     * 获取生肖
     * <p> time格式为yyyy-MM-dd HH:mm:ss </p>
     *
     * @param time 时间字符串
     * @return 生肖
     */
    public static String getChineseZodiac(String time) {
        return getChineseZodiac(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 获取生肖
     * <p> time格式为pattern </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 生肖
     */
    public static String getChineseZodiac(String time, String pattern) {
        return getChineseZodiac(string2Date(time, pattern));
    }

    /**
     * 获取生肖
     *
     * @param date Date类型时间
     * @return 生肖
     */
    public static String getChineseZodiac(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return CHINESE_ZODIAC[cal.get(Calendar.YEAR) % 12];
    }

    /**
     * 获取生肖
     *
     * @param millis 毫秒时间戳
     * @return 生肖
     */
    public static String getChineseZodiac(long millis) {
        return getChineseZodiac(millis2Date(millis));
    }

    /**
     * 获取生肖
     *
     * @param year 年
     * @return 生肖
     */
    public static String getChineseZodiac(int year) {
        return CHINESE_ZODIAC[year % 12];
    }

    private static final String[] ZODIAC = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座",
            "射手座", "魔羯座"};
    private static final int[] ZODIAC_FLAGS = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};

    /**
     * 获取星座
     * <p> time格式为yyyy-MM-dd HH:mm:ss </p>
     *
     * @param time 时间字符串
     * @return 生肖
     */
    public static String getZodiac(String time) {
        return getZodiac(string2Date(time, DEFAULT_PATTERN));
    }

    /**
     * 获取星座
     * <p> time格式为pattern </p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 生肖
     */
    public static String getZodiac(String time, String pattern) {
        return getZodiac(string2Date(time, pattern));
    }

    /**
     * 获取星座
     *
     * @param date Date类型时间
     * @return 星座
     */
    public static String getZodiac(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return getZodiac(month, day);
    }

    /**
     * 获取星座
     *
     * @param millis 毫秒时间戳
     * @return 星座
     */
    public static String getZodiac(long millis) {
        return getZodiac(millis2Date(millis));
    }

    /**
     * 获取星座
     *
     * @param month
     * @param day   日
     * @return 星座
     */
    public static String getZodiac(int month, int day) {
        return ZODIAC[day >= ZODIAC_FLAGS[month - 1] ? month - 1 : (month + 10) % 12];
    }
}
