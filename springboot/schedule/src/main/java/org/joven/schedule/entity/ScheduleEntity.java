/**
 * Project Name: blog project
 * File Name: ScheduleBaseEntity
 * Package Name: org.joven.schedule.entity
 * Date: 2020/1/31 20:59
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.schedule.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * CreateBy Notebook
 * Date: 2020/1/31 20:59
 * Version:
 * Remark:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@TableName(value = "schedule_job", schema = "schedule_user")
public class ScheduleEntity implements Serializable {
    private String id;
    private String taskId;
    private String jobName;
    private String beanName;
    private String cron;
    private String className;
    private Integer status;
    private String description;
}
