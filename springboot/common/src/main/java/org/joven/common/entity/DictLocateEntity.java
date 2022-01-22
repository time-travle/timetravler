/**
 * Project Name: blog project
 * File Name: DictLocateEntity
 * Package Name: org.joven.common.entity
 * Date: 2020/1/5 2:03
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
 * Date: 2020/1/5 2:03
 * Version: 1.0
 * Remark: 多语言实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DictLocateEntity implements Serializable {
    private String parentReationCode;
    private String itemName;
    private String locate;
    private String desc;
}
