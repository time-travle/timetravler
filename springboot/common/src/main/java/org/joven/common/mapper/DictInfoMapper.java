/**
 * Project Name: blog project
 * File Name: DictInfoMapper
 * Package Name: org.joven.common.mapper
 * Date: 2020/1/5 20:26
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.mapper;

import org.apache.ibatis.annotations.Param;
import org.joven.common.entity.DictInfoEntity;
import org.joven.common.entity.DictItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 20:26
 * Version: 1.0
 * Remark: 接数据接口文件
 */
@Repository
public interface DictInfoMapper {
    /**
     * 获取字典code对应的所有的字典项
     */
    DictItemEntity getDictItemsByCode(@Param("dictCde") String dictCode, @Param("locate") String locate);

    DictItemEntity getDictItemsByCodes(@Param("dictCdeList") List<String> dictCodes, @Param("locate") String locate);

    /**
     * 获取对应的信息
     *
     * @param dictCode 入参
     * @return 响应
     */
    DictInfoEntity getDictInfo(@Param("dictCde") String dictCode, @Param("locate") String locate);

    /**
     * 获取字典code中华的某一项的信息
     */
    String getDictItemValue(@Param("dictCde") String dictCde, @Param("itemCode") String itemCode);

    /**
     * 失效字典
     *
     * @return 响应
     */
    int invalidDictInfo(@Param("dictCodes") List<String> dictCodes);

    /**
     * 启用已经失效的字典
     *
     * @return 响应
     */
    int reactivateDictInfo(@Param("dictCodes") List<String> dictCodes, @Param("expTime") String expTime);

    /**
     * 更新字典对应的值，一般用不到
     */
    int updateDictItem(DictItemEntity dictItemEntity);

    /**
     * 更新字典信息
     *
     * @param dictInfoEntity 入参
     * @return 响应
     */
    int updateDictInfo(DictInfoEntity dictInfoEntity);

    /**
     * 向数据库添加字典数据
     */
    int addDictInfo2DB(DictInfoEntity dictInfoEntity);
}
