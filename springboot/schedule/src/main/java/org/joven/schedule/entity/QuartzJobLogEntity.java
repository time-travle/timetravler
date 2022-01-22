package org.joven.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.joven.base.utils.TimeUtil;

import java.util.Date;

/**
 * 定时任务日志
 *
 * @author Joven 18763137197@163.com
 * @since 1.0.0 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("quartz_job_log")
public class QuartzJobLogEntity extends BaseEntity {
    public QuartzJobLogEntity() {
    }

    public QuartzJobLogEntity(Long jobId, String jobName, String beanName,
                              String className, String params) {
        this.beanName = beanName;
        this.jobId = jobId;
        this.className = className;
        this.jobName = jobName;
        this.params = params;
        super.setCreateDate(TimeUtil.getNowTimeDate());
    }

    /**
     * 任务id
     */
    private Long jobId;
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * spring class名称
     */
    private String className;
    /**
     * spring bean名称
     */
    private String beanName;
    /**
     * 参数
     */
    private String params;
    /**
     * 任务状态    0：失败    1：成功
     */
    private Integer status;
    /**
     * 失败信息
     */
    private String error;
    /**
     * 耗时(单位：毫秒)
     */
    private Integer times;
}