/**
 * Project Name: blog project
 * File Name: SystemParamServcieImpl
 * Package Name: org.joven.common.service.impl
 * Date: 2020/1/12 0:22
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joven.base.entity.ResponseBody;
import org.joven.common.entity.SystemParamEntity;
import org.joven.common.entity.SystemParamLangEntity;
import org.joven.common.entity.SystemParamViewEntity;
import org.joven.common.mapper.SystemParamMapper;
import org.joven.common.service.SystemParamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/12 0:22
 * Version: 1.0
 * Remark:
 */
@Slf4j
@Service("SystemParamService")
public class SystemParamServiceImpl implements SystemParamService {
    /*
    必须的使用构造器注入（变量注入不提倡）必须依赖（主要）
     */
    private SystemParamMapper systemParamMapper;

    @Autowired
    public SystemParamServiceImpl(SystemParamMapper systemParamMapper) {
        this.systemParamMapper = systemParamMapper;
    }


    /**
     * @param systemParamId 系统参数
     * @param defaultValue  默认值，查询不到时就返回默认值
     * @return 响应
     */
    @Override
    public String getSystemParamValue(String systemParamId, String defaultValue) {
        String systemParamValue = this.getSystemParamValue(systemParamId);
        if (StringUtils.isEmpty(systemParamValue)) {
            log.debug("can't find value, use default value !");
            systemParamValue = defaultValue;
        }
        return systemParamValue;
    }

    @Override
    public String getSystemParamValue(String systemParamId) {
        return systemParamMapper.getSystemParamValue(systemParamId);
    }

    @Override
    public SystemParamViewEntity getSystemParamInfo(String systemParamId) {
        SystemParamEntity resp = systemParamMapper.getSystemParamInfo(systemParamId, "");

        SystemParamViewEntity respView = new SystemParamViewEntity();
        if (null == resp) {
            log.debug("Can't find values return null");
            return null;
        }
        BeanUtils.copyProperties(resp, respView);
        Map<String, String> extMap = new HashMap<>();

        if (StringUtils.isNotEmpty(resp.getExt1())) {
            extMap.put("ext1", resp.getExt1());
        }
        if (StringUtils.isNotEmpty(resp.getExt2())) {
            extMap.put("ext2", resp.getExt2());
        }
        if (StringUtils.isNotEmpty(resp.getExt3())) {
            extMap.put("ext3", resp.getExt3());
        }
        if (StringUtils.isNotEmpty(resp.getExt4())) {
            extMap.put("ext4", resp.getExt4());
        }
        if (StringUtils.isNotEmpty(resp.getExt5())) {
            extMap.put("ext5", resp.getExt5());
        }
        respView.setExtMaps(extMap);
        log.debug("getSystemParamInfo resp is:{}", respView);
        return respView;
    }

    @Override
    public List<SystemParamEntity> getSystemParamInfos(List<String> systemParamIds) {
        return systemParamMapper.getSystemParamInfos(systemParamIds, "");
    }

    @Override
    public ResponseBody updateSystemParamInfo(SystemParamEntity systemParamEntity) {
        // systemParamMapper.updateSystemParamInfo(systemParamEntity);
        return new ResponseBody();
    }

    /**
     * 将参数失效
     *
     * @param systemParamId 参数
     * @return 响应
     */
    @Override
    public ResponseBody deleteSystemParamInfo(String systemParamId) {
        systemParamMapper.deleteSystemParamInfo(systemParamId);
        return new ResponseBody();
    }

    /**
     * 将参数批量失效
     *
     * @param systemParamIds 参数集合
     * @return 响应
     */
    @Override
    public ResponseBody deleteSystemParamInfoByIds(List<String> systemParamIds) {
        systemParamMapper.deleteSystemParamInfoByIds(systemParamIds);
        return new ResponseBody();
    }

    /**
     * 批量向数据可添加参数
     *
     * @param systemParamEntityList 添加数据的集合
     * @return 响应
     */
    @Override
    public ResponseBody batchAddSystemParam2DB(List<SystemParamEntity> systemParamEntityList) {
        systemParamMapper.batchAddSystemParam2DB(systemParamEntityList);
        return new ResponseBody();
    }

    /**
     * 向数据可添加参数
     *
     * @param systemParamEntity 添加的数据
     * @return 响应
     */
    @Override
    public ResponseBody addSystemParam2DB(SystemParamEntity systemParamEntity) {
        systemParamMapper.addSystemParam2DB(systemParamEntity);
        return new ResponseBody();
    }

    /**
     * 将系统参数重新激活
     *
     * @param systemParamMaps 入参
     * @return 响应
     */
    @Override
    public ResponseBody activeInvalidSystemParam(List<Map<String, String>> systemParamMaps) {
        systemParamMapper.activeInvalidSystemParam(systemParamMaps);
        return new ResponseBody();
    }

    /**
     * 更新参数对应的多语言
     *
     * @param systemParamLangEntity 参数
     * @return 响应
     */
    @Override
    public ResponseBody updateSystemLangById(SystemParamLangEntity systemParamLangEntity) {
        systemParamMapper.updateSystemLangById(systemParamLangEntity);
        return new ResponseBody();
    }

    @Override
    public ResponseBody updateSystemLangByIds(List<SystemParamLangEntity> systemParamLangList) {
        systemParamMapper.updateSystemLangByIds(systemParamLangList);
        return new ResponseBody();
    }

    /**
     * 批量更新系统参数对应的值
     *
     * @param idAndValueMapList 入参参数和对应的value
     * @return 响应
     */
    @Override
    public ResponseBody updateSystemValueBySystemIds(List<Map<String, String>> idAndValueMapList) {
        systemParamMapper.updateSystemValueBySystemIds(idAndValueMapList);
        return new ResponseBody();
    }
}
