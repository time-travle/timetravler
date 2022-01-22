package org.joven.schedule.excel;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import java.util.Date;

/**
 * 定时任务日志
 */
@Data
public class QuartzJobLogExcel {
    @Excel(name = "id")
    private Long id;
    @Excel(name = "任务id")
    private Long jobId;
    @Excel(name = "spring class名称")
    private String className;
    @Excel(name = "spring bean名称")
    private String beanName;
    @Excel(name = "参数")
    private String params;
    @Excel(name = "任务状态    0：失败    1：成功")
    private Integer status;
    @Excel(name = "失败信息")
    private String error;
    @Excel(name = "耗时(单位：毫秒)")
    private Integer times;
    @Excel(name = "创建时间")
    private Date createDate;

}