package org.joven.schedule.config;

import org.joven.schedule.init.RefreshAutoQuartzJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 使用定时任务监控数据库定时任务配置刷新启动定时任务
 * 使用bena的自动配置 一个刷新任务的任务
 * 弊端若是程序启动慢 有可能会报错 因为加载的时间可能早于应用启动完成
 * 不建议使用
 */
@Configuration
public class SchedulerConfig {
    //指定具体的定时任务类
    @Bean
    public JobDetail refreshQuartzJobDetail() {
        return JobBuilder.newJob(RefreshAutoQuartzJob.class)
                .withIdentity("RefreshAutoQuartzJob")
                .withDescription("定时刷新从class启动的定时任务的任务")
                .storeDurably()//保留存储，也就是说当执行完后，保留Job
                .build();
    }


    @Bean
    public Trigger refreshAutoQuartzJob() {
        // 这里设定执行方式 10分钟自动刷新 定时任务
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/10 * * * ? * ");

        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(refreshQuartzJobDetail())
                .withIdentity("RefreshAutoQuartzJob").withDescription("定时刷新从class启动的定时任务的任务")
                .forJob("RefreshAutoQuartzJob")
                .withSchedule(scheduleBuilder)
                .build();
    }
}

