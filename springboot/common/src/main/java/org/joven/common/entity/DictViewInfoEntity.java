/**
 * Project Name: blog project
 * File Name: DictionaryInfoEntity
 * Package Name: org.joven.common.entity
 * Date: 2020/1/5 15:40
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 15:40
 * Version: 1.0
 * Remark: 直接承接字典几个表对应的视图实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DictViewInfoEntity implements Serializable {
    private String dictCode;
    private String dictName;
    private Map<String, String> extMaps;
    private String itemCode;
    private String itemValue;
    private String itemName;
    private String locate;
    private Map<String, String> itemExtMaps;
}
