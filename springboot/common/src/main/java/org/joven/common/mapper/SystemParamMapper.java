/**
 * Project Name: blog project
 * File Name: SystemParamMapper
 * Package Name: org.joven.common.mapper
 * Date: 2020/1/12 0:20
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.mapper;

import org.apache.ibatis.annotations.Param;
import org.joven.common.entity.SystemParamEntity;
import org.joven.common.entity.SystemParamLangEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/12 0:20
 * Version: 1.0
 * Remark:系统参数实现类
 */
@Repository
public interface SystemParamMapper {
    String getSystemParamValue(@Param("systemParamId") String systemParamId);

    SystemParamEntity getSystemParamInfo(@Param("systemParamId") String systemParamId, @Param("locate") String locate);

    List<SystemParamEntity> getSystemParamInfos(@Param("systemParamIds") List<String> systemParamIds,
                                                @Param("locate") String locate);

    /**
     * 通过系统参数跟新其对应的值
     *
     * @param idAndValueMapList 使用map格式 里面使用paramId和paramValue 两个必须的key
     * @return
     */
    int updateSystemValueBySystemIds(@Param("idAndValueMapList") List<Map<String, String>> idAndValueMapList);

    /**
     * 更新对应的多语言
     *
     * @param systemParamLangList 对应的实体类集合
     * @return
     */
    int updateSystemLangByIds(@Param("systemParamLangList") List<SystemParamLangEntity> systemParamLangList);

    int updateSystemLangById(SystemParamLangEntity systemParamLangEntity);

    int batchAddSystemParam2DB(@Param("systemParamEntityList") List<SystemParamEntity> systemParamEntityList);

    int addSystemParam2DB(SystemParamEntity systemParamEntity);

    int deleteSystemParamInfo(@Param("systemParamId") String systemParamId);

    int deleteSystemParamInfoByIds(@Param("systemParamIds") List<String> systemParamIds);

    /**
     * 将已有的系统参数重新启用 即跟新其失效时间
     *
     * @param systemParamMaps 两个必有得key paramId和expDate
     * @return
     */
    int activeInvalidSystemParam(@Param("systemParamMaps") List<Map<String, String>> systemParamMaps);
}
