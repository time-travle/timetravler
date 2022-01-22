/**
 * Project Name: blog project
 * File Name: DictController
 * Package Name: org.joven.base.controller
 * Date: 2019/11/8 23:24
 * Copyright (c) 2019,All Rights Reserved.
 */
package org.joven.common.controller;

import org.joven.base.entity.ResponseBody;
import org.joven.common.entity.DictInfoEntity;
import org.joven.common.entity.DictItemEntity;
import org.joven.common.service.DictInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * CreateBy Administrator
 * Date: 2019/11/8 23:24
 * Version:1.0
 * Remark: 查询字典的一个服务
 */
@RestController
@RequestMapping(value = "/common/dict")
public class DictInfoController {
    /*
    使用构造器注入（常量注入不提倡）必须依赖（主要）
    */
    private DictInfoService dictInfoService;

    @Autowired
    public DictInfoController(DictInfoService dictInfoService) {
        this.dictInfoService = dictInfoService;
    }

    /**
     * 获取字典code对应的所有的字典项
     *
     * @return
     */
    @RequestMapping(value = "/getItems", method = RequestMethod.POST)
    public DictItemEntity getDictItems(String dictCode, String local) {
        return dictInfoService.getDictItems(dictCode, local);
    }

    /**
     * 获取字典code对应的所有的字典项
     *
     * @return
     */
    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public DictInfoEntity getDictInfo(String dictCode, String local) {
        return dictInfoService.getDictInfo(dictCode, local);
    }

    /**
     * 获取字典code的某一项的信息
     */
    @RequestMapping(value = "/getItemValues", method = RequestMethod.POST)
    public DictItemEntity getDictItemValues(String dictCode, String itemCode) {
        return dictInfoService.getDictItemValues(dictCode, itemCode);
    }

    /**
     * 更新字典对应的值，一般用不到
     */
    @RequestMapping(value = "/updateItem", method = RequestMethod.POST)
    public ResponseBody updateDictItem(DictItemEntity dictItemEntity) {
        return dictInfoService.updateDictItem(dictItemEntity);
    }

    /**
     * 更新字典对应的值，一般用不到
     */
    @RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
    public ResponseBody updateDictInfo(DictInfoEntity dictInfoEntity) {
        return dictInfoService.updateDictInfo(dictInfoEntity);
    }

    /**
     * 向数据库添加字典数据
     */
    @RequestMapping(value = "/addInfo2DB", method = RequestMethod.POST)
    public ResponseBody addDictInfo2DB(DictInfoEntity dictInfoEntity) {
        return dictInfoService.addDictInfo2DB(dictInfoEntity);
    }
}
