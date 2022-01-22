/**
 * Project Name: blog project
 * File Name: SystemParamEntity
 * Package Name: org.joven.common.entity
 * Date: 2020/1/11 23:56
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * CreateBy Notebook
 * Date: 2020/1/11 23:56
 * Version:1.0
 * Remark: 系统参数对应的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SystemParamEntity implements Serializable {
    private String paramId;
    private String paramName;
    private String paramValue;
    private String paramDesc;
    private Date effDate;
    private Date expDate;

    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;

    private List<SystemParamLangEntity> lang;
}
