/**
 * Project Name: blog project
 * File Name: DictInfoEntity
 * Package Name: org.joven.common.entity
 * Date: 2020/1/5 0:53
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
 * Date: 2020/1/5 0:53
 * Version: 1.0
 * Remark:  字典实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class DictInfoEntity implements Serializable {
    /**
     * 字典code 关联字段
     */
    private String dictCode;
    /**
     * 字典名字
     */
    private String dictName;
    /**
     * 对字典的描述
     */
    private String dictDesc;
    /**
     * 字典的生效时间
     */
    private Date effTime;
    /**
     * 字典的失效时间
     */
    private Date expTime;
    /**
     * 字典是否被手动失效 为1 是表示状态时OK的为0时标识失效 即使在生失效时间之间也是无效的
     */
    private String status;
    /**
     * 对应字典的扩展字段的值
     */
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;


    /**
     * 多语言
     */
    private List<DictLocateEntity> locate;
    /**
     * 字典项
     */
    private List<DictItemEntity> dictItems;

}
