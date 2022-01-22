/**
 * Project Name: blog project
 * File Name: SystemParamViewEntity
 * Package Name: org.joven.common.entity
 * Date: 2020/1/12 0:15
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
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/12 0:15
 * Version: 1.0
 * Remark:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SystemParamViewEntity implements Serializable {
    private String paramId;
    private String paramName;
    private String paramValue;
    private String paramDesc;
    private Date effDate;
    private Date expDate;

    private Map<String, String> extMaps;
    private List<SystemParamLangEntity> lang;
}
