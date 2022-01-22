package org.joven.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 定时任务
 *
 * @author Joven 18763137197@163.com
 * @since 1.0.0 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("quartz_job")
public class QuartzJobEntity extends BaseEntity {

    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务分组
     */
    private String groupName;
    /**
     * spring bean名称
     */
    private String beanName;
    /**
     * spring class名称
     */
    private String className;
    /**
     * 参数
     */
    private String params;
    /**
     * cron表达式
     */
    private String cronExpression;
    /**
     * 任务状态  0：暂停  1：正常
     */
    private Integer status;
    /**
     * 应用重启时任务是否重启  0：保持  1：重启
     */
    private Integer restartOnAppStart;
    /**
     * 备注
     */
    private String remark;
    /**
     * 更新者
     */
    private Long updater;
    /**
     * 更新时间
     */
    private Date updateDate;
}