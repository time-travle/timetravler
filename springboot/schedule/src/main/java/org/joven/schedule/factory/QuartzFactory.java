package org.joven.schedule.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joven.schedule.entity.QuartzJobEntity;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

import static org.joven.schedule.common.ScheduleConstants.DEFAULT_EXECUTE_CLASS;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL_NAME_BEAN;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL_NAME_ClASS;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL_NAME_JOB;
import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL_PARAM;

/**
 * 定时任务工厂
 */
@Slf4j
public class QuartzFactory {

    /**
     * 获取触发器key
     */
    public static TriggerKey getTriggerKey(QuartzJobEntity jobEntity) {
        String jobGroupName = jobEntity.getGroupName(), jobName = jobEntity.getBeanName();
        Long jobId = jobEntity.getId();
        return StringUtils.isBlank(jobGroupName) ? TriggerKey.triggerKey(jobName + jobId) : TriggerKey.triggerKey(jobName + jobId, jobGroupName);
    }

    /**
     * 获取jobKey
     */
    public static JobKey getJobKey(QuartzJobEntity jobEntity) {
        String jobGroupName = jobEntity.getGroupName(), jobName = jobEntity.getBeanName();
        Long jobId = jobEntity.getId();
        return getJobKey(jobGroupName, jobName, jobId);
    }

    public static JobKey getJobKey(String groupName, String jobName, Long jobId) {
        return StringUtils.isBlank(groupName) ? JobKey.jobKey(jobName + jobId) : JobKey.jobKey(jobName + jobId, groupName);
    }

    /**
     * 创建定时任务
     */
    public static void createJob(Scheduler scheduler, QuartzJobEntity jobEntity) {
        try {
            // 定时任务类需要是job类的具体实现 QuartzJobBean是job的抽象类。
            // 通过className 获得对应的类
            String jobClassString = StringUtils.isBlank(jobEntity.getClassName()) ? DEFAULT_EXECUTE_CLASS : jobEntity.getClassName();
            Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(jobClassString);
            // 构建定时任务信息
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(getJobKey(jobEntity)).build();

            // 放入参数，运行时的方法可以获取
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL, jobEntity);
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL_PARAM, jobEntity.getParams());
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_JOB, jobEntity.getJobName());
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_BEAN, jobEntity.getBeanName());
            jobDetail.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_ClASS, jobEntity.getClassName());

            // 设置定时任务执行方式
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(jobEntity.getCronExpression());
            // 构建触发器trigger
            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(getTriggerKey(jobEntity))
                    .withSchedule(cronScheduleBuilder)
                    .withDescription(jobEntity.getRemark()).build();

            scheduler.scheduleJob(jobDetail, cronTrigger);
            // 任务状态不是1 暂停任务
            if (jobEntity.getStatus() != 1) {
                scheduler.pauseJob(getJobKey(jobEntity));
            }
        } catch (ClassNotFoundException e) {
            log.error("定时任务{}类路径出错：请输入类的绝对路径", jobEntity.getJobName());
        } catch (SchedulerException e) {
            log.error("创建定时任务出错{},请检查配置,信息如下:{}", jobEntity.getJobName(), e.getMessage());
        }
    }

    /**
     * 更新定时任务
     */
    public static void updateJob(Scheduler scheduler, QuartzJobEntity jobEntity) {
        try {
            //获取到对应任务的触发器
            TriggerKey triggerKey = getTriggerKey(jobEntity);
            //设置定时任务执行方式
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(jobEntity.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();
            //重新构建任务的触发器trigger
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            //按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL, jobEntity);
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL_PARAM, jobEntity.getParams());
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_JOB, jobEntity.getJobName());
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_BEAN, jobEntity.getBeanName());
            trigger.getJobDataMap().put(JOB_PARAM_DETAIL_NAME_ClASS, jobEntity.getClassName());
            //重置对应的job
            scheduler.rescheduleJob(triggerKey, trigger);
            // 不是执行状态 暂停任务
            if (jobEntity.getStatus() != 1) {
                scheduler.pauseJob(getJobKey(jobEntity));
            }
        } catch (SchedulerException e) {
            log.error("更新定时任务出错：{},信息如下:{}", jobEntity.getJobName(), e.getMessage());
        }
    }

    /**
     * 删除定时任务
     *
     * @param groupName 分组名
     * @param jobName   任务名
     * @param jobId     任务Id
     */
    public static void deleteJob(Scheduler scheduler, String groupName, String jobName, Long jobId) {
        try {
            scheduler.deleteJob(getJobKey(groupName, jobName, jobId));
        } catch (SchedulerException e) {
            log.error("删除定时任务groupName:{},jobName:{},jobId:{}出错:{}", groupName, jobName, jobId, e.getMessage());
        }
    }

    /**
     * 恢复任务
     *
     * @param groupName 分组名
     * @param jobName   任务名
     * @param jobId     任务Id
     */
    public static void resumeJob(Scheduler scheduler, String groupName, String jobName, Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(groupName, jobName, jobId));
        } catch (SchedulerException e) {
            log.error("重启定时任务groupName:{},jobName:{},jobId:{}出错:{}", groupName, jobName, jobId, e.getMessage());
        }
    }

    /**
     * 停止任务
     *
     * @param groupName 分组名
     * @param jobName   任务名
     * @param jobId     任务Id
     */
    public static void pauseJob(Scheduler scheduler, String groupName, String jobName, Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(groupName, jobName, jobId));
        } catch (SchedulerException e) {
            log.error("停止定时任务groupName:{},jobName:{},jobId:{}出错:{}", groupName, jobName, jobId, e.getMessage());
        }
    }

    /**
     * 立即运行一次定时任务
     */
    public static void runJob(Scheduler scheduler, String groupName, String jobName, Long jobId) {
        try {
            scheduler.triggerJob(getJobKey(groupName, jobName, jobId));
        } catch (SchedulerException e) {
            log.error("运行定时任务groupName:{},jobName:{},jobId:{}出错:{}", groupName, jobName, jobId, e.getMessage());
        }
    }

    /**
     * 立即运行一次定时任务  带入参
     */
    public static void runJob(Scheduler scheduler, QuartzJobEntity jobEntity) {
        //参数
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("JOB_PARAM_DETAIL_DATA", jobEntity);

        try {
            scheduler.triggerJob(getJobKey(jobEntity), dataMap);
        } catch (SchedulerException e) {
            log.error("带入参运行定时任务详细:{}出错:{}", jobEntity, e.getMessage());
        }
    }

    /**
     * 判断任务是不是存在
     */
    public static CronTrigger isJobExistByCronTrigger(Scheduler scheduler, QuartzJobEntity jobEntity) {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(jobEntity));
        } catch (SchedulerException e) {
            return null;
        }
    }

    /**
     * 判断任务是不是存在
     */
    public static JobDetail isJobExistByDetail(Scheduler scheduler, QuartzJobEntity jobEntity) {
        try {
            return scheduler.getJobDetail(getJobKey(jobEntity));
        } catch (SchedulerException e) {
            return null;
        }
    }
}
