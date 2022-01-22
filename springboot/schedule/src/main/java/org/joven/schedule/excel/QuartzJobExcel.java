package org.joven.schedule.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 定时任务
 */
@Data
public class QuartzJobExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "任务名称")
    private String jobName;
    @Excel(name = "任务分组名称")
    private String groupName;
    @Excel(name = "spring bean名称")
    private String beanName;
    @Excel(name = "spring class名称")
    private String className;
    @Excel(name = "参数")
    private String params;
    @Excel(name = "cron表达式")
    private String cronExpression;
    @Excel(name = "任务状态  0：暂停  1：正常")
    private Integer status;
    @Excel(name = "备注")
    private String remark;
    @Excel(name = "创建者")
    private Long creator;
    @Excel(name = "创建时间")
    private Date createDate;
    @Excel(name = "更新者")
    private Long updater;
    @Excel(name = "更新时间")
    private Date updateDate;

}
