/**
 * Project Name: blog project
 * File Name: DictLangEntity
 * Package Name: org.joven.common.entity
 * Date: 2020/1/5 1:16
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 1:16
 * Version:1.0
 * Remark:字典项实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class DictItemEntity implements Serializable {
    /**
     * 关联字段
     */
    private String itemId;

    private String dictCode;
    private String itemCode;
    private String itemValue;
    private String itemDesc;
    private String status;

    private String itemExt1;
    private String itemExt2;
    private String itemExt3;
    private String itemExt4;
    private String itemExt5;

    private List<DictLocateEntity> locates;


}
