/**
 * Project Name: blog project
 * File Name: SystemController
 * Package Name: org.joven.common.controller
 * Date: 2020/1/5 2:13
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.controller;

import org.joven.base.entity.ResponseBody;
import org.joven.common.entity.SystemParamEntity;
import org.joven.common.entity.SystemParamViewEntity;
import org.joven.common.service.SystemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 2:13
 * Version: 1.0
 * Remark: 获取系统参数的一个服务
 */
@RestController
@RequestMapping(value = "/common/system")
public class SystemParamController {
    /*
    使用构造器注入（常量注入不提倡）必须依赖（主要）
     */
    private SystemParamService systemParamService;

    @Autowired
    public SystemParamController(SystemParamService systemParamService) {
        this.systemParamService = systemParamService;
    }

    @RequestMapping(value = "/getValueWithDefault", method = RequestMethod.POST)
    public String getSystemParamValue(String systemParamId, String defaultValue) {
        return systemParamService.getSystemParamValue(systemParamId, defaultValue);
    }

    @RequestMapping(value = "/getValue", method = RequestMethod.POST)
    public String getSystemParamValue(String systemParamId) {
        return systemParamService.getSystemParamValue(systemParamId);
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public SystemParamViewEntity getSystemParamInfo(String systemParamId) {
        return systemParamService.getSystemParamInfo(systemParamId);
    }

    @RequestMapping(value = "/getInfos", method = RequestMethod.POST)
    public List<SystemParamEntity> getSystemParamInfos(List<String> systemParamIds) {
        return systemParamService.getSystemParamInfos(systemParamIds);
    }

    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public ResponseBody updateSystemParamInfo(SystemParamEntity systemParamEntity) {
        return systemParamService.updateSystemParamInfo(systemParamEntity);
    }

    @RequestMapping(value = "/deletenfo", method = RequestMethod.POST)
    public ResponseBody deleteSystemParamInfo(String systemParamId) {
        return systemParamService.deleteSystemParamInfo(systemParamId);
    }

    @RequestMapping(value = "/add2DB", method = RequestMethod.POST)
    public ResponseBody addSystemParam2DB(SystemParamEntity systemParamEntity) {
        return systemParamService.addSystemParam2DB(systemParamEntity);
    }
}
