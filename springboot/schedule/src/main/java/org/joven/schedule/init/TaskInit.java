package org.joven.schedule.init;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joven.schedule.entity.ScheduleEntity;
import org.joven.schedule.mapper.ScheduleMapper;
import org.joven.schedule.utils.QuartzUtils;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class TaskInit implements CommandLineRunner {
    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private Scheduler scheduler;

    @Override
    public void run(String... args) {
        log.debug("应用启动完成,开始初始化定时任务");
        loadMonitorJobsJob();
    }

    /**
     * 初始化监控任务的任务
     */
    private void loadMonitorJobsJob() {
        List<ScheduleEntity> jobsInDB = scheduleMapper.selectList(null);
        for (ScheduleEntity schedule : jobsInDB) {
            schedule.setId(schedule.getTaskId());
            try {
                CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(TriggerKey.triggerKey(schedule.getJobName()));
                Trigger.TriggerState cronTriggers = scheduler.getTriggerState(TriggerKey.triggerKey(schedule.getJobName()));
                if (cronTrigger == null) {
                    QuartzUtils.createScheduleJob(scheduler, schedule);
                    log.debug("创建监控任务任务:{}", schedule.getJobName());
                } else if (!StringUtils.equals(cronTrigger.getCronExpression(), schedule.getCron())) {
                    log.debug("刷新监控任务任务:{}", schedule.getJobName());
                    QuartzUtils.updateScheduleJob(scheduler, schedule);
                } else if (cronTriggers == Trigger.TriggerState.PAUSED && schedule.getStatus() == 1) {
                    log.debug("重启被挂起监控任务任务:{}", schedule.getJobName());
                    QuartzUtils.resumeScheduleJob(scheduler, schedule.getJobName());
                } else if (schedule.getStatus() != 1) {
                    log.debug("挂起监控任务任务:{}", schedule.getJobName());
                    QuartzUtils.pauseScheduleJob(scheduler, schedule.getJobName());
                } else {
                    log.debug("监控任务任务:{}配置无变更", schedule.getJobName());
                }
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }
}
