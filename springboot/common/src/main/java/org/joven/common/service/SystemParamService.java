/**
 * Project Name: blog project
 * File Name: SystemParamService
 * Package Name: org.joven.common.service
 * Date: 2020/1/12 0:21
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.service;

import org.joven.base.entity.ResponseBody;
import org.joven.common.entity.SystemParamEntity;
import org.joven.common.entity.SystemParamLangEntity;
import org.joven.common.entity.SystemParamViewEntity;

import java.util.List;
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/12 0:21
 * Version: 1.0
 * Remark:
 */
public interface SystemParamService {
    String getSystemParamValue(String systemParamId, String defaultValue);

    String getSystemParamValue(String systemParamId);

    SystemParamViewEntity getSystemParamInfo(String systemParamId);

    List<SystemParamEntity> getSystemParamInfos(List<String> systemParamIds);

    /**
     * 这个方法不暴露出来不做实现
     *
     * @param systemParamEntity
     * @return
     */
    ResponseBody updateSystemParamInfo(SystemParamEntity systemParamEntity);

    ResponseBody deleteSystemParamInfo(String systemParamId);

    ResponseBody deleteSystemParamInfoByIds(List<String> systemParamIds);

    ResponseBody batchAddSystemParam2DB(List<SystemParamEntity> systemParamEntityList);

    ResponseBody addSystemParam2DB(SystemParamEntity systemParamEntity);

    ResponseBody activeInvalidSystemParam(List<Map<String, String>> systemParamMaps);

    ResponseBody updateSystemLangById(SystemParamLangEntity systemParamLangEntity);

    ResponseBody updateSystemLangByIds(List<SystemParamLangEntity> systemParamLangList);

    ResponseBody updateSystemValueBySystemIds(List<Map<String, String>> idAndValueMapList);
}
