package org.joven.schedule.task;


import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class TestClassJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap scheduleJob = jobExecutionContext.getMergedJobDataMap();
        log.debug("TestClassJob 执行 参数:{}", scheduleJob.toString());
        JobDataMap dataMap = jobExecutionContext.getTrigger().getJobDataMap();
        if (null == dataMap || dataMap.size() == 0) {
            dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        }
        log.debug("TestClassJob 参数:{}", JSON.toJSONString(dataMap));
    }
}
