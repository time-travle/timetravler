package org.joven.schedule.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 标识Id
     */
    private Long id;
    /**
     * 记录创建者
     */
    private String creator;
    /**
     * 记录更新者
     */
    private Date createDate;
}
