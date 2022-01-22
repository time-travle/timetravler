package org.joven.schedule.init;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joven.schedule.entity.QuartzJobEntity;
import org.joven.schedule.factory.QuartzFactory;
import org.joven.schedule.mapper.QuartzJobMapper;
import org.quartz.CronTrigger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

@Slf4j
public class RefreshAutoQuartzJob extends QuartzJobBean {
    @Autowired
    private QuartzJobMapper quartzJobMapper;
    @Autowired
    private Scheduler scheduler;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.debug("刷新/入定时任务");
        loadJobInQuartzJob();
    }

    /**
     * 初始化定时任务 quartz_Job
     */
    private void loadJobInQuartzJob() {
        List<QuartzJobEntity> quartzJobs = quartzJobMapper.selectList(null);
        for (QuartzJobEntity quartzJob : quartzJobs) {
            try {
                CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(QuartzFactory.getTriggerKey(quartzJob));
                Trigger.TriggerState cronTriggers = scheduler.getTriggerState(QuartzFactory.getTriggerKey(quartzJob));
                if (cronTrigger == null) {
                    QuartzFactory.createJob(scheduler, quartzJob);
                    log.debug("创建任务:{}", quartzJob.getJobName());
                    continue;
                }
                if (!StringUtils.equals(cronTrigger.getCronExpression(), quartzJob.getCronExpression())) {
                    log.debug("刷新任务:{}", quartzJob.getJobName());
                    QuartzFactory.updateJob(scheduler, quartzJob);
                    continue;
                }
                if (cronTriggers == Trigger.TriggerState.PAUSED && quartzJob.getStatus() == 1) {
                    if (quartzJob.getRestartOnAppStart() != 1) {
                        continue;
                    }
                    log.debug("重启被挂起重启任务:{}", quartzJob.getJobName());
                    QuartzFactory.resumeJob(scheduler, quartzJob.getGroupName(), quartzJob.getJobName(), quartzJob.getId());
                    continue;
                }
                if (quartzJob.getStatus() != 1) {
                    log.debug("挂起重启任务:{}", quartzJob.getJobName());
                    QuartzFactory.pauseJob(scheduler, quartzJob.getGroupName(), quartzJob.getJobName(), quartzJob.getId());
                    continue;
                }
                log.debug("任务:{}配置无变更", quartzJob.getJobName());
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }
}
