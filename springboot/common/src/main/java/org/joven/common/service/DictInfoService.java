/**
 * Project Name: blog project
 * File Name: DictService
 * Package Name: org.joven.common.service
 * Date: 2020/1/5 20:22
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.service;

import org.joven.base.entity.ResponseBody;
import org.joven.common.entity.DictInfoEntity;
import org.joven.common.entity.DictItemEntity;

import java.util.List;
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 20:22
 * Version: 1.0
 * Remark: 字典工具类实现接口
 */
public interface DictInfoService {
    /**
     * 获取字典code对应的所有的字典项
     */
    DictItemEntity getDictItems(String dictCode, String local);

    /**
     * 获取字典code对应的所有的字典信息
     */
    DictInfoEntity getDictInfo(String dictCode, String local);

    /**
     * 获取字典code中华的某一项的信息
     */
    DictItemEntity getDictItemValues(String dictCode, String itemCode);

    /**
     * 更新字典对应的字典项值
     */
    ResponseBody updateDictItem(DictItemEntity dictItemEntity);

    /**
     * 更新字典对应的字典值
     */
    ResponseBody updateDictInfo(DictInfoEntity dictInfoEntity);

    /**
     * 向数据库添加字典数据
     */
    ResponseBody addDictInfo2DB(DictInfoEntity dictInfoEntity);

    /**
     * 将数据字典失效
     */
    ResponseBody invalidateDictInfo(String dictCode);

    /**
     * 将已经失效的字典重新拉起生效
     */
    ResponseBody reactivateDictInfo(List<Map<String, String>> dictCodeAndExpDateMap);
}
