/**
 * Project Name: blog project
 * File Name: DictInfoServiceImpl
 * Package Name: org.joven.common.service.impl
 * Date: 2020/1/5 20:23
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.common.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.joven.base.entity.ResponseBody;
import org.joven.common.entity.DictInfoEntity;
import org.joven.common.entity.DictItemEntity;
import org.joven.common.mapper.DictInfoMapper;
import org.joven.common.service.DictInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * CreateBy Notebook
 * Date: 2020/1/5 20:23
 * Version: 1.0
 * Remark: 字典工具类实现类
 */
@Slf4j
@Service("DictInfoService")
public class DictInfoServiceImpl implements DictInfoService {
    /*
    必须的使用构造器注入（变量注入不提倡）必须依赖（主要）
     */
    private DictInfoMapper dictInfoMapper;

    @Autowired
    public DictInfoServiceImpl(DictInfoMapper dictInfoMapper) {
        this.dictInfoMapper = dictInfoMapper;
    }


    @Override
    public DictItemEntity getDictItems(String dictCode, String local) {
        return null;
    }

    @Override
    public DictInfoEntity getDictInfo(String dictCode, String local) {
        return null;
    }

    @Override
    public DictItemEntity getDictItemValues(String dictCode, String itemCode) {
        return null;
    }

    @Override
    public ResponseBody updateDictItem(DictItemEntity dictItemEntity) {
        return null;
    }

    @Override
    public ResponseBody updateDictInfo(DictInfoEntity dictInfoEntity) {
        return null;
    }

    @Override
    public ResponseBody addDictInfo2DB(DictInfoEntity dictInfoEntity) {
        return null;
    }

    @Override
    public ResponseBody invalidateDictInfo(String dictCode) {
        return null;
    }

    @Override
    public ResponseBody reactivateDictInfo(List<Map<String, String>> dictCodeAndExpDateMap) {
        return null;
    }
}
