package org.joven.schedule.init;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.joven.base.utils.TimeUtil;
import org.joven.schedule.entity.QuartzJobEntity;
import org.joven.schedule.entity.QuartzJobLogEntity;
import org.joven.schedule.mapper.QuartzJobLogMapper;
import org.joven.schedule.utils.SpringContextUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.joven.schedule.common.ScheduleConstants.JOB_PARAM_DETAIL;

/**
 * 配置bean来执行定时任务时 使用默认类来启动 对应的任务
 */
@Slf4j
public class DefaultExecuteJob extends QuartzJobBean {
    @Autowired
    private QuartzJobLogMapper quartzJobLogMapper;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        QuartzJobEntity quartzJobEntity = (QuartzJobEntity) jobExecutionContext.getMergedJobDataMap().get(JOB_PARAM_DETAIL);
        log.debug("默认调度器:DefaultExecuteJobBean 开始执行！{}", quartzJobEntity.getJobName());
        QuartzJobLogEntity quartzJobLogEntity = new QuartzJobLogEntity(quartzJobEntity.getId(),
                quartzJobEntity.getJobName(), quartzJobEntity.getBeanName(),
                quartzJobEntity.getClassName(), quartzJobEntity.getParams());
        Long begin = TimeUtil.getCurrentSystemTime();
        try {

            Object target = SpringContextUtils.getBean(quartzJobEntity.getBeanName());
            Method method = target.getClass().getDeclaredMethod("run", String.class);
            method.invoke(target, quartzJobEntity.getParams());

            quartzJobLogEntity.setTimes((int) (TimeUtil.getCurrentSystemTime() - begin));
            quartzJobLogEntity.setStatus(1);
        } catch (NoSuchBeanDefinitionException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {

            quartzJobLogEntity.setError(ExceptionUtils.getStackTrace(e));
            quartzJobLogEntity.setTimes((int) (TimeUtil.getCurrentSystemTime() - begin));
            quartzJobLogEntity.setStatus(0);
        }
        quartzJobLogMapper.insert(quartzJobLogEntity);

    }
}
