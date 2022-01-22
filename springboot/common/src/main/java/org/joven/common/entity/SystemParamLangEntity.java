/**
 * Project Name: blog project
 * File Name: SystemParamLangEntity
 * Package Name: org.joven.common.entity
 * Date: 2020/1/12 0:13
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * CreateBy Notebook
 * Date: 2020/1/12 0:13
 * Version:1.0
 * Remark:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class SystemParamLangEntity implements Serializable {
    private String id;
    private String relParamId;
    private String locate;
    private String name;
    private String desc;
}