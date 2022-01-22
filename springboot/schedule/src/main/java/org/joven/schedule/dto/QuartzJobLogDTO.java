package org.joven.schedule.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 定时任务日志
 *
 * @author Joven 18763137197@163.com
 * @since 1.0.0 2021-07-29
 */
@Data
@ApiModel(value = "定时任务日志")
public class QuartzJobLogDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "任务id")
    private Long jobId;

    @ApiModelProperty(value = "spring class名称")
    private String className;

    @ApiModelProperty(value = "spring bean名称")
    private String beanName;

    @ApiModelProperty(value = "参数")
    private String params;

    @ApiModelProperty(value = "任务状态    0：失败    1：成功")
    private Integer status;

    @ApiModelProperty(value = "失败信息")
    private String error;

    @ApiModelProperty(value = "耗时(单位：毫秒)")
    private Integer times;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;


}