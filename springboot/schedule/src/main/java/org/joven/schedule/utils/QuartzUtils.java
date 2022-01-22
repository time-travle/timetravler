/**
 * Project Name: blog project
 * File Name: ScheduleUtil
 * Package Name: org.joven.schedule.utils
 * Date: 2020/1/31 21:00
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.schedule.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joven.schedule.entity.QuartzJobEntity;
import org.joven.schedule.entity.ScheduleEntity;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

import static org.joven.schedule.common.ScheduleConstants.DEFAULT_EXECUTE_CLASS;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL_NAME_BEAN;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL_NAME_ClASS;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL_NAME_JOB;

/**
 * CreateBy Notebook
 * Date: 2020/1/31 21:00
 * Version:
 * Remark:
 */
@Slf4j
public class QuartzUtils {

    /**
     * 创建定时任务 定时任务创建之后默认启动状态
     *
     * @param scheduler  调度器
     * @param quartzBean 定时任务信息类
     * @throws Exception
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleEntity quartzBean) {
        try {
            //获取到定时任务的执行类  必须是类的绝对路径名称
            //定时任务类需要是job类的具体实现 QuartzJobBean是job的抽象类。
            String jobClassString = StringUtils.isBlank(quartzBean.getClassName()) ? DEFAULT_EXECUTE_CLASS : quartzBean.getClassName();
            Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(jobClassString);

            // 构建定时任务信息
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(JobKey.jobKey(quartzBean.getJobName())).build();
            //放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL, turnToQuartzEntity(quartzBean));
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_JOB, quartzBean.getJobName());
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_BEAN, quartzBean.getBeanName());
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_ClASS, quartzBean.getClassName());
            // 设置定时任务执行方式
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzBean.getCron());
            // 构建触发器trigger
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(TriggerKey.triggerKey(quartzBean.getJobName())).withSchedule(scheduleBuilder).build();

            scheduler.scheduleJob(jobDetail, trigger);
            // 任务状态不是1 暂停任务
            if (quartzBean.getStatus() != 1) {
                scheduler.pauseJob(JobKey.jobKey(quartzBean.getJobName()));
            }
        } catch (ClassNotFoundException e) {
            log.error("定时任务{}类路径出错：请输入类的绝对路径", quartzBean.getJobName());
        } catch (SchedulerException e) {
            log.error("创建定时任务出错{},请检查配置,信息如下:{}", quartzBean.getJobName(), e.getMessage());
        }
    }

    /**
     * 根据任务名称暂停定时任务
     *
     * @param scheduler 调度器
     * @param jobName   定时任务名称
     * @throws SchedulerException
     */
    public static void pauseScheduleJob(Scheduler scheduler, String jobName) {
        JobKey jobKey = JobKey.jobKey(jobName);
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            log.error("停止定时任务jobName:{}出错:{}", jobName, e.getMessage());
        }
    }

    /**
     * 根据任务名称恢复定时任务
     *
     * @param scheduler 调度器
     * @param jobName   定时任务名称
     * @throws SchedulerException
     */
    public static void resumeScheduleJob(Scheduler scheduler, String jobName) {
        JobKey jobKey = JobKey.jobKey(jobName);
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            log.error("重启定时任务jobName:{}出错:{}", jobName, e.getMessage());
        }
    }

    /**
     * 根据任务名称立即运行一次定时任务
     *
     * @param scheduler 调度器
     * @param jobName   定时任务名称
     * @throws SchedulerException
     */
    public static void runOnce(Scheduler scheduler, String jobName) {
        JobKey jobKey = JobKey.jobKey(jobName);
        try {
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            log.error("运行定时任务jobName:{}出错:{}", jobName, e.getMessage());
        }
    }

    /**
     * 更新定时任务
     *
     * @param scheduler  调度器
     * @param quartzBean 定时任务信息类
     * @throws SchedulerException
     */
    public static void updateScheduleJob(Scheduler scheduler, ScheduleEntity quartzBean) {
        try {
            //获取到对应任务的触发器
            TriggerKey triggerKey = TriggerKey.triggerKey(quartzBean.getJobName());
            //设置定时任务执行方式
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzBean.getCron());
            //重新构建任务的触发器trigger
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL, turnToQuartzEntity(quartzBean));
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_JOB, quartzBean.getJobName());
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_BEAN, quartzBean.getBeanName());
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_ClASS, quartzBean.getClassName());
            //重置对应的job
            scheduler.rescheduleJob(triggerKey, trigger);
            // 不是执行状态 暂停任务
            if (quartzBean.getStatus() != 1) {
                scheduler.pauseJob(JobKey.jobKey(quartzBean.getJobName()));
            }
        } catch (SchedulerException e) {
            log.error("更新定时任务quartzBean:{}出错:{}", quartzBean, e.getMessage());
        }
    }

    private static QuartzJobEntity turnToQuartzEntity(ScheduleEntity quartzBean) {
        QuartzJobEntity quartzJob = new QuartzJobEntity();
        quartzJob.setBeanName(quartzBean.getBeanName());
        quartzJob.setCronExpression(quartzBean.getCron());
        quartzJob.setJobName(quartzBean.getJobName());
        quartzJob.setRestartOnAppStart(1);
        quartzJob.setStatus(quartzBean.getStatus());
        quartzJob.setId(Long.valueOf(quartzBean.getTaskId()));
        quartzJob.setRemark(quartzBean.getDescription());
        return quartzJob;
    }

    /**
     * 根据定时任务名称从调度器当中删除定时任务
     *
     * @param scheduler 调度器
     * @param jobName   定时任务名称
     * @throws SchedulerException
     */
    public static void deleteScheduleJob(Scheduler scheduler, String jobName) {
        JobKey jobKey = JobKey.jobKey(jobName);
        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            log.error("删除定时任务jobName:{}出错:{}", jobName, e.getMessage());
        }
    }
}
