/**
 * Project Name: blog project
 * File Name: ScheduleConstants
 * Package Name: org.joven.schedule.common
 * Date: 2020/1/31 20:59
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.schedule.common;

/**
 * CreateBy Notebook
 * Date: 2020/1/31 20:59
 * Version:
 * Remark:
 */
public class ScheduleConstants {
    /**
     * 默认执行的任务执行类 不配置 class 时
     */
    public static String DEFAULT_EXECUTE_CLASS = "org.joven.schedule.init.DefaultExecuteJob";
    /**
     * 监控定时任务的任务的 携带参数的key
     */
    public static String JOB_PARAM_KEY_M = "JOB_PARAM_KEY_M";
    /**
     * 业务定时任务 jobDetail 携带参数的key
     */
    public static String JOB_PARAM_DETAIL = "JOB_PARAM_DETAIL";
    /**
     * 业务定时任务 jobDetail 中  JobDataMap 携带参数的key
     */
    public static String JOB_PARAM_DETAIL_NAME_JOB = "JOB_PARAM_DETAIL_NAME_JOB";
    public static String JOB_PARAM_DETAIL_NAME_BEAN = "JOB_PARAM_DETAIL_NAME_BEAN";
    public static String JOB_PARAM_DETAIL_NAME_ClASS = "JOB_PARAM_DETAIL_NAME_ClASS";
    public static String JOB_PARAM_DETAIL_PARAM = "JOB_PARAM_DETAIL_PARAM";
}
